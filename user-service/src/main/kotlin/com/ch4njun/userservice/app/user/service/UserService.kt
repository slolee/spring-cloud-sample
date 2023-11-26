package com.ch4njun.userservice.app.user.service

import com.ch4njun.userservice.app.user.request.RegisterRequest
import com.ch4njun.userservice.domain.port.out.UserPersistencePort
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userPersistencePort: UserPersistencePort
) {

    fun createUser(req: RegisterRequest) {
        val user = req.toEntity()
        userPersistencePort.save(user)
    }
}