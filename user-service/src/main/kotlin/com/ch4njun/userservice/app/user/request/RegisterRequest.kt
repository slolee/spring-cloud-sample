package com.ch4njun.userservice.app.user.request

import com.ch4njun.userservice.domain.entity.User
import java.time.LocalDateTime
import java.util.UUID

data class RegisterRequest(
    val email: String,
    val name: String,
    val password: String,
) {

    fun toEntity() = User(
        email = email,
        name = name,
        password = password,
    )
}