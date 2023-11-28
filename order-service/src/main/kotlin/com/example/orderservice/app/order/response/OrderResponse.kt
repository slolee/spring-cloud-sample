package com.example.orderservice.app.order.response

import com.example.orderservice.domain.entity.Order
import java.time.LocalDateTime

data class OrderResponse(
    val orderId: String,
    val productId: String,
    val qty: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val createdAt: LocalDateTime
) {

    companion object {
        fun from(order: Order) = OrderResponse(
            orderId = order.id,
            productId = order.productId,
            qty = order.qty,
            unitPrice = order.unitPrice,
            totalPrice = order.totalPrice,
            createdAt = order.createdAt
        )
    }
}