package com.ch4njun.userservice.infrastructure.mysql.adaptor

import com.ch4njun.userservice.domain.entity.User
import com.ch4njun.userservice.domain.port.out.UserPersistencePort
import com.ch4njun.userservice.infrastructure.mysql.mapper.UserEntityMapper
import com.ch4njun.userservice.infrastructure.mysql.repository.UserJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserPersistenceAdaptor(
    private val userJpaRepository: UserJpaRepository,
    private val userEntityMapper: UserEntityMapper
) : UserPersistencePort {

    override fun save(user: User): User {
        return userEntityMapper.mapToJpaEntity(user)
            .let { userJpaRepository.save(it) }
            .let { userEntityMapper.mapToDomainEntity(it) }
    }

    override fun findAll(): List<User> {
        return userJpaRepository.findAll()
            .map { userEntityMapper.mapToDomainEntity(it) }
    }

    override fun findById(userId: String): User? {
        return userJpaRepository.findByIdOrNull(userId)
            ?.let { userEntityMapper.mapToDomainEntity(it) }
    }
}