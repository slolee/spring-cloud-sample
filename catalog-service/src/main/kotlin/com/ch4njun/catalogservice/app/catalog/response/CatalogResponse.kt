package com.ch4njun.catalogservice.app.catalog.response

import com.ch4njun.catalogservice.domain.entity.Catalog
import java.time.LocalDateTime

data class CatalogResponse(
    val productId: String,
    val productName: String,
    val unitPrice: Int,
    val stock: Int,
    val createdAt: LocalDateTime
) {

    companion object {
        fun from(catalog: Catalog) = CatalogResponse(
            productId = catalog.productId,
            productName = catalog.productName,
            unitPrice = catalog.unitPrice,
            stock = catalog.unitPrice,
            createdAt = catalog.createdAt
        )
    }
}