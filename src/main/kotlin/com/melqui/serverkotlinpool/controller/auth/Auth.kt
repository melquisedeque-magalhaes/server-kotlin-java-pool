package com.melqui.serverkotlinpool.controller.auth

import com.melqui.serverkotlinpool.dto.authDTO
import com.melqui.serverkotlinpool.services.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class Auth(private var authService: AuthService) {
    @PostMapping
    fun sigInAndSignUp(@RequestBody @Valid authDTO: authDTO): Any {
           return authService.auth(authDTO.access_token)
    }
}