package com.ch4njun.catalogservice.infrastructure.mysql.adaptor

import com.ch4njun.catalogservice.domain.entity.Catalog
import com.ch4njun.catalogservice.domain.port.out.CatalogPersistencePort
import com.ch4njun.catalogservice.infrastructure.mysql.mapper.CatalogEntityMapper
import com.ch4njun.catalogservice.infrastructure.mysql.repository.CatalogJpaRepository
import org.springframework.stereotype.Component

@Component
class CatalogPersistenceAdaptor(
    private val catalogJpaRepository: CatalogJpaRepository,
    private val catalogEntityMapper: CatalogEntityMapper
) : CatalogPersistencePort {

    override fun findAll(): List<Catalog> {
        return catalogJpaRepository.findAll()
            .map { catalogEntityMapper.mapToDomainEntity(it) }
    }
}