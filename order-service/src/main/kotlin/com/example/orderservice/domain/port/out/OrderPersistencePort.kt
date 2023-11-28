package com.example.orderservice.domain.port.out

import com.example.orderservice.domain.entity.Order

interface OrderPersistencePort {

    fun save(order: Order): Order
    fun findById(orderId: String): Order?
    fun findAllByUserId(userId: String): List<Order>
}