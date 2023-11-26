package com.ch4njun.userservice.infrastructure.mysql.repository

import com.ch4njun.userservice.infrastructure.mysql.entity.UserJpaEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository : CrudRepository<UserJpaEntity, String> {

}