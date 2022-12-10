package com.melqui.serverkotlinpool.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="users")
data class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String? = null,

    @Column(unique = true)
    val googleId: String,

    @Column
    val name: String,

    @Column
    val email: String,

    @Column
    val avatarUrl: String,

    @Column
    val createdAt: LocalDateTime? = LocalDateTime.now()
)