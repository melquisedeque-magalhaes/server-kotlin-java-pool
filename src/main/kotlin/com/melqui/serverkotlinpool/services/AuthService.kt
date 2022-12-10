package com.melqui.serverkotlinpool.services

import com.melqui.serverkotlinpool.dto.UserGoogleResponse
import com.melqui.serverkotlinpool.model.User
import com.melqui.serverkotlinpool.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*


@Service
class AuthService(
    private var userRepository: UserRepository,
    private var userService: UserService,
    private var tokenAuthenticationService: TokenAuthenticationService
) {
    fun auth(accessToken: String): Any {
        try {
            val accessTokenComplete:String = "Bearer $accessToken"

            // create a client
            val client: HttpClient = HttpClient.newHttpClient();

            // create a request
            val request: HttpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/oauth2/v2/userinfo"))
                .GET()
                .header("Authorization", accessTokenComplete)
                .header("Content-Type", "application/json")
                .build()

            // use the client to send the request
            val response = client.send(request, HttpResponse.BodyHandlers.ofString())

            if(response.statusCode() == 401){
                throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token invalido tente novamente!")
            }

            val userParseList =response.body().split(",", ":").map{value -> value.trim()}

            val userParse = UserGoogleResponse(
                id = userParseList[1],
                email = userParseList[3],
                name = userParseList[7],
                picture = """https:${userParseList[14]}"""
            )

            val user: Optional<User> = userRepository.findByGoogleId(userParse.id)

            if(user.isEmpty){
                val newUser = User(
                    googleId = userParse.id,
                    name = userParse.name,
                    email = userParse.email,
                    avatarUrl = userParse.picture,
                )

                userService.createUser(newUser)

            }

            return tokenAuthenticationService.addAuthentication(userParse.name, userParse.picture)


        }catch(err: ResponseStatusException) {
           throw ResponseStatusException(err.status, err.message)
        }
    }
}
