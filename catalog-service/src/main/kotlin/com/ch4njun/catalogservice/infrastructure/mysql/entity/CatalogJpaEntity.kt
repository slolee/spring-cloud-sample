package com.ch4njun.catalogservice.infrastructure.mysql.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime

@Entity
@Table(name = "catalog")
class CatalogJpaEntity(

    @Column(name = "catalog_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val productId: Long,
    val productName: String,
    val stock: Int,
    val unitPrice: Int,

    @Column(columnDefinition = "timestamp")
    @ColumnDefault("CURRENT_TIMESTAMP")
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
}