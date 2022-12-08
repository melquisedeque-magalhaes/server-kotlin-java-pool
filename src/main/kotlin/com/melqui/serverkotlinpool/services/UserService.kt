package com.melqui.serverkotlinpool.services

import com.melqui.serverkotlinpool.model.User
import com.melqui.serverkotlinpool.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private var userRepository: UserRepository) {
    fun createUser(user: User): User {
        return userRepository.save(user)
    }
}