package com.ch4njun.userservice.infrastructure.mysql.mapper

import com.ch4njun.userservice.domain.entity.User
import com.ch4njun.userservice.infrastructure.mysql.entity.UserJpaEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserEntityMapper {

    fun mapToJpaEntity(user: User): UserJpaEntity
    fun mapToDomainEntity(userJpaEntity: UserJpaEntity): User
}