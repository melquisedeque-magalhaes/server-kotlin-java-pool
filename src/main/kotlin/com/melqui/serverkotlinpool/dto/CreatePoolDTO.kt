package com.melqui.serverkotlinpool.dto

import javax.validation.constraints.NotEmpty

data class CreatePoolDTO(
    @field: NotEmpty
    val name: String
)
