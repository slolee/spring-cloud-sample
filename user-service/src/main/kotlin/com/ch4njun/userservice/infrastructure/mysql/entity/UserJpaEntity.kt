package com.ch4njun.userservice.infrastructure.mysql.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "my_user")
class UserJpaEntity(

    @Id
    val id: String,
    val email: String,
    val name: String,
    val password: String,
    val createdAt: LocalDateTime
) {

}