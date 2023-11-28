package com.ch4njun.catalogservice.infrastructure.mysql.mapper

import com.ch4njun.catalogservice.domain.entity.Catalog
import com.ch4njun.catalogservice.infrastructure.mysql.entity.CatalogJpaEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CatalogEntityMapper {

    fun mapToJpaEntity(catalog: Catalog): CatalogJpaEntity
    fun mapToDomainEntity(catalogJpaEntity: CatalogJpaEntity): Catalog
}