package com.example.orderservice.infrastructure.mysql.mapper

import com.example.orderservice.domain.entity.Order
import com.example.orderservice.infrastructure.mysql.entity.OrderJpaEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface OrderEntityMapper {

    fun mapToJpaEntity(order: Order): OrderJpaEntity
    fun mapToDomainEntity(orderJpaEntity: OrderJpaEntity): Order
}