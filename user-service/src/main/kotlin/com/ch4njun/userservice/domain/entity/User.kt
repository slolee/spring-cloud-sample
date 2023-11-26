package com.ch4njun.userservice.domain.entity

import java.time.LocalDateTime
import java.util.*

data class User(
    val id: String = UUID.randomUUID().toString(),
    val email: String,
    val name: String,
    val password: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)