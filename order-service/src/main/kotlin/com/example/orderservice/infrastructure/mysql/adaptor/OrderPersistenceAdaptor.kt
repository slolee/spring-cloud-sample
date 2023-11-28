package com.example.orderservice.infrastructure.mysql.adaptor

import com.example.orderservice.domain.entity.Order
import com.example.orderservice.domain.port.out.OrderPersistencePort
import com.example.orderservice.infrastructure.mysql.mapper.OrderEntityMapper
import com.example.orderservice.infrastructure.mysql.repository.OrderJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class OrderPersistenceAdaptor(
    private val orderJpaRepository: OrderJpaRepository,
    private val orderEntityMapper: OrderEntityMapper
) : OrderPersistencePort {

    override fun save(order: Order): Order {
        return orderEntityMapper.mapToJpaEntity(order)
            .let { orderJpaRepository.save(it) }
            .let { orderEntityMapper.mapToDomainEntity(it) }
    }

    override fun findById(orderId: String): Order? {
        return orderJpaRepository.findByIdOrNull(orderId)
            ?.let { orderEntityMapper.mapToDomainEntity(it) }
    }

    override fun findAllByUserId(userId: String): List<Order> {
        return orderJpaRepository.findAll()
            .map { orderEntityMapper.mapToDomainEntity(it) }
    }
}