package com.melqui.serverkotlinpool.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="pool")
data class Pool (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column
    val title: String,

    @Column(unique = true)
    val code: String,

    @Column
    val createdAt: LocalDateTime? = LocalDateTime.now()
)