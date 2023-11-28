package com.ch4njun.catalogservice.infrastructure.mysql.repository

import com.ch4njun.catalogservice.infrastructure.mysql.entity.CatalogJpaEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CatalogJpaRepository : CrudRepository<CatalogJpaEntity, Long> {
}