package com.ch4njun.catalogservice.domain.port.out

import com.ch4njun.catalogservice.domain.entity.Catalog

interface CatalogPersistencePort {
    fun findAll(): List<Catalog>
}