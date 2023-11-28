package com.ch4njun.catalogservice.app.catalog

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/health_check")
    fun status(): String {
        return "It's Working in Catalog Service."
    }
}