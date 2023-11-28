package com.example.orderservice.app.order.response

import com.example.orderservice.domain.entity.Order
import java.time.LocalDateTime

data class CreateOrderResponse(
    val orderId: String,
    val productId: String,
    val totalPrice: Int,
    val createdAt: LocalDateTime
) {

    companion object {
        fun from(order: Order) = CreateOrderResponse(
            orderId = order.id,
            productId = order.productId,
            totalPrice = order.totalPrice,
            createdAt = order.createdAt
        )
    }
}