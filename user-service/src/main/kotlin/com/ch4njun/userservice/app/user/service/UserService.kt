package com.ch4njun.userservice.app.user.service

import com.ch4njun.userservice.app.user.request.RegisterRequest
import com.ch4njun.userservice.app.user.response.RegisterResponse
import com.ch4njun.userservice.domain.entity.User
import com.ch4njun.userservice.domain.port.out.UserPersistencePort
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userPersistencePort: UserPersistencePort,
    private val passwordEncoder: PasswordEncoder
) {

    fun create(req: RegisterRequest): RegisterResponse {
        val user = req.toEntity()
        user.encodePassword(passwordEncoder)
        return userPersistencePort.save(user)
            .let { RegisterResponse.from(it) }
    }

    fun retrieveAll(): List<User> {
        return userPersistencePort.findAll()
    }
}