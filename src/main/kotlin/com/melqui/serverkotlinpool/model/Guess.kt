package com.melqui.serverkotlinpool.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="guess")
data class Guess (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String? = null,

    @Column
    val firstTeam: Int,

    @Column
    val secondTeam: Int,
)