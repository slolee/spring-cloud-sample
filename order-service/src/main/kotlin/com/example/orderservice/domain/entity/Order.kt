package com.example.orderservice.domain.entity

import java.time.LocalDateTime

class Order(
    val id: String,
    val productId: String,
    val qty: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val userId: String,
    val createdAt: LocalDateTime
) {
}