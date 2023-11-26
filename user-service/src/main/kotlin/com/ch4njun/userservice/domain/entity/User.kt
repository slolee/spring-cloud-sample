package com.ch4njun.userservice.domain.entity

import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime
import java.util.*

class User(
    val id: String = UUID.randomUUID().toString(),
    val email: String,
    val name: String,
    var password: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {

    fun encodePassword(passwordEncoder: PasswordEncoder) {
        this.password = passwordEncoder.encode(this.password)
    }
}