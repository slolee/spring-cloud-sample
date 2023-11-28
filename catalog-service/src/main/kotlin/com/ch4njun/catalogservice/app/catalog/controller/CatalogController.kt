package com.ch4njun.catalogservice.app.catalog.controller

import com.ch4njun.catalogservice.app.catalog.response.CatalogResponse
import com.ch4njun.catalogservice.app.catalog.service.CatalogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class CatalogController(
    private val catalogService: CatalogService
) {

    @GetMapping("/catalogs")
    fun retrieveAllCatalogs(): List<CatalogResponse> {
        return catalogService.retrieveAllCatalogs()
    }
}