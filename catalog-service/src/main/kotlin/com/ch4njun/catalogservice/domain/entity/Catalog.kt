package com.ch4njun.catalogservice.domain.entity

import java.time.LocalDateTime

class Catalog(
    val id: Long,
    val productId: Long,
    val productName: String,
    val stock: Int,
    val unitPrice: Int,
    val createdAt: LocalDateTime
) {
}