package com.melqui.serverkotlinpool.services

import com.melqui.serverkotlinpool.model.User
import com.melqui.serverkotlinpool.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private var userRepository: UserRepository) {
    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun profile(id: String): Optional<User> {
        return userRepository.findById(id)
    }
}