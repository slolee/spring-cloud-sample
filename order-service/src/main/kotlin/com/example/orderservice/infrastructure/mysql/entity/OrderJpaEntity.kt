package com.example.orderservice.infrastructure.mysql.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime

@Entity
@Table(name = "my_order")
class OrderJpaEntity(

    @Id @Column(name = "order_id")
    val id: String,

    val productId: String,
    val qty: Int,
    val unitPrice: Int,
    val totalPrice: Int,

    val userId: String,

    @Column(columnDefinition = "timestamp")
    @ColumnDefault("CURRENT_TIMESTAMP")
    val createdAt: LocalDateTime
) {
}