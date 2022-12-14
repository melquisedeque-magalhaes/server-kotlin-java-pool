package com.melqui.serverkotlinpool.services

import com.melqui.serverkotlinpool.dto.CreatePoolDTO
import com.melqui.serverkotlinpool.model.Pool
import com.melqui.serverkotlinpool.repository.PoolRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PoolServices(private var poolRepository: PoolRepository) {
    fun create(createPoolDTO: CreatePoolDTO): String {

        val codeGenerate:String = UUID.randomUUID().toString()

        val newPool = poolRepository.save(Pool(title = createPoolDTO.title, code = codeGenerate))

        return newPool.code
    }

    fun list(): MutableIterable<Pool> {
        return poolRepository.findAll()
    }

}