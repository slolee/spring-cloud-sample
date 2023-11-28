package com.ch4njun.catalogservice.app.catalog.service

import com.ch4njun.catalogservice.app.catalog.response.CatalogResponse
import com.ch4njun.catalogservice.domain.port.out.CatalogPersistencePort
import org.springframework.stereotype.Service

@Service
class CatalogService(
    private val catalogPersistencePort: CatalogPersistencePort
) {

    fun retrieveAllCatalogs(): List<CatalogResponse> {
        return catalogPersistencePort.findAll()
            .map { CatalogResponse.from(it) }
    }
}