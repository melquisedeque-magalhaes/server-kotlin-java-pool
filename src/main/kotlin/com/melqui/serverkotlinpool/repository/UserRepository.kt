package com.melqui.serverkotlinpool.repository

import com.melqui.serverkotlinpool.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository: CrudRepository<User, String> {
    fun findByGoogleId(googleId: String): Optional<User>
}