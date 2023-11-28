package com.example.orderservice.infrastructure.mysql.repository

import com.example.orderservice.infrastructure.mysql.entity.OrderJpaEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderJpaRepository : CrudRepository<OrderJpaEntity, String> {
}