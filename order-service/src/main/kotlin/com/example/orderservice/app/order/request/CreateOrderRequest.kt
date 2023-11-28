package com.example.orderservice.app.order.request

import com.example.orderservice.domain.entity.Order

data class CreateOrderRequest(
    val productId: String,
    val qty: Int,
    val unitPrice: Int,
    val userId: String
) {

    fun toEntity() = Order(
        productId = productId,
        qty = qty,
        unitPrice = unitPrice,
        userId = userId
    )
}