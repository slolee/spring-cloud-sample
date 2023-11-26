package com.ch4njun.userservice.infrastructure.mysql.adaptor

import com.ch4njun.userservice.domain.entity.User
import com.ch4njun.userservice.domain.port.out.UserPersistencePort
import com.ch4njun.userservice.infrastructure.mysql.mapper.UserEntityMapper
import com.ch4njun.userservice.infrastructure.mysql.mapper.UserEntityMapperImpl
import com.ch4njun.userservice.infrastructure.mysql.repository.UserJpaRepository
import org.springframework.stereotype.Repository

@Repository
class UserPersistenceAdaptor(
    private val userJpaRepository: UserJpaRepository
) : UserPersistencePort {

    private val userEntityMapper: UserEntityMapper = UserEntityMapperImpl()

    override fun save(user: User): User {
        return userEntityMapper.toJpaEntity(user)
            .let { userJpaRepository.save(it) }
            .let { userEntityMapper.toDomainEntity(it) }
    }
}