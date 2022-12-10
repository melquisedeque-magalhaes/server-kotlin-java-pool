package com.melqui.serverkotlinpool.services

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

import org.springframework.stereotype.Service
import java.util.*
import javax.servlet.http.HttpServletRequest

@Service
class TokenAuthenticationService {
    // EXPIRATION_TIME = 10 dias
    val EXPIRATION_TIME: Long = 860000000
    val SECRET = "MySecret"
    val TOKEN_PREFIX = "Bearer"
    val HEADER_STRING = "Authorization"
    fun addAuthentication(name: String, avatarUrl: String): String {
        return Jwts.builder()
            .setSubject(name + avatarUrl)
            .setExpiration(Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS512, SECRET)
            .compact()
    }

    fun getAuthentication(request: HttpServletRequest): String? {
        val token = request.getHeader(HEADER_STRING)

        println(token)

        if (token != null) {
            // faz parse do token
            val user = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .body
                .subject
            if (user != null) {
                return user
            }
        }
        return null
    }
}