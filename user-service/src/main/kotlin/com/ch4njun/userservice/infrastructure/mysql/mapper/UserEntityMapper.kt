package com.ch4njun.userservice.infrastructure.mysql.mapper

import com.ch4njun.userservice.domain.entity.User
import com.ch4njun.userservice.infrastructure.mysql.entity.UserJpaEntity
import org.mapstruct.Mapper

@Mapper
interface UserEntityMapper {

    fun toJpaEntity(user: User): UserJpaEntity
    fun toDomainEntity(jpaEntity: UserJpaEntity): User
}