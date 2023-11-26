package com.ch4njun.userservice.domain.port.out

import com.ch4njun.userservice.domain.entity.User

interface UserPersistencePort {

    fun save(user: User): User
}