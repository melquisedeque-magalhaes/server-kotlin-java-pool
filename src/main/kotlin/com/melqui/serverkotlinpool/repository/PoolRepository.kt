package com.melqui.serverkotlinpool.repository

import com.melqui.serverkotlinpool.model.Pool
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PoolRepository: CrudRepository<Pool, String> {}