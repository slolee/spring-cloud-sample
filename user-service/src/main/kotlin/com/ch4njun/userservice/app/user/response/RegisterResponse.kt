package com.ch4njun.userservice.app.user.response

import com.ch4njun.userservice.domain.entity.User

data class RegisterResponse(
    val userId: String,
    val name: String
) {

    companion object {
        fun from(user: User) = RegisterResponse(
            userId = user.id,
            name = user.name
        )
    }
}