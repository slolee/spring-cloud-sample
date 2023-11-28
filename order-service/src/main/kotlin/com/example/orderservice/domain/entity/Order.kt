package com.example.orderservice.domain.entity

import util.mapstruct.Default
import java.time.LocalDateTime
import java.util.*

class Order @Default constructor(
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