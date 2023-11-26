package com.ch4njun.userservice.app.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/health_check")
    fun status(): String {
        return "It's Working in User Service."
    }
}