package com.melqui.serverkotlinpool.services

import com.melqui.serverkotlinpool.dto.CreatePoolDTO
import com.melqui.serverkotlinpool.model.Pool
import com.melqui.serverkotlinpool.repository.PoolRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PoolServices(private var poolRepository: PoolRepository) {
    fun create(createPoolDTO: CreatePoolDTO) {

        val codeGenerate:String = UUID.randomUUID().toString()

        poolRepository.save(Pool(title = createPoolDTO.name, code = codeGenerate))
    }
}