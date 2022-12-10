package com.melqui.serverkotlinpool.dto

import javax.validation.constraints.NotEmpty

data class AuthDTO(
    @field: NotEmpty
    val access_token: String
)

data class UserGoogleResponse(
    val id: String,
    val email: String,
    val name: String,
    val picture: String,
)
