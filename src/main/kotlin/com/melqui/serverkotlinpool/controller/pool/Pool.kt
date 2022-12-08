package com.melqui.serverkotlinpool.controller.pool

import com.melqui.serverkotlinpool.dto.CreatePoolDTO
import com.melqui.serverkotlinpool.services.PoolServices
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("pools")
class Pool(private var poolService: PoolServices) {
    @PostMapping
    fun createPool(@RequestBody @Valid createPoolDTO: CreatePoolDTO) {
        poolService.create(createPoolDTO)
    }
}