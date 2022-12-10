package com.melqui.serverkotlinpool.repository

import com.melqui.serverkotlinpool.model.Guess
import com.melqui.serverkotlinpool.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GuessRepository: CrudRepository<Guess, String> {
}