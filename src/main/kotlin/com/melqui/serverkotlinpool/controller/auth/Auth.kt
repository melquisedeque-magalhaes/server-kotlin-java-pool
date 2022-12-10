package com.melqui.serverkotlinpool.controller.auth

import com.melqui.serverkotlinpool.dto.authDTO
import com.melqui.serverkotlinpool.services.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.Collections
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class Auth(private var authService: AuthService) {
    @PostMapping
    fun sigInAndSignUp(@RequestBody @Valid authDTO: authDTO): Any? {
        try {
            val token = authService.auth(authDTO.access_token)

            return Collections.singletonMap("token",token)
        }catch (err: ResponseStatusException) {
            return ResponseEntity.status(err.status).body(err.message)
        }
    }
}