package com.example.orderservice.domain.entity

import java.time.LocalDateTime
import java.util.UUID

class Order(
    val id: String,
    val productId: String,
    val qty: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val userId: String,
    val createdAt: LocalDateTime
) {

    constructor(productId: String, qty: Int, unitPrice: Int, userId: String): this(
        id = UUID.randomUUID().toString(),
        productId = productId,
        qty = qty,
        unitPrice = unitPrice,
        totalPrice = qty * unitPrice,
        userId = userId,
        createdAt = LocalDateTime.now()
    )
}