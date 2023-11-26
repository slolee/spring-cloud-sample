package com.ch4njun.userservice.app.user.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class UserController(
    @Value("\${greeting.message}") val message: String
) {

    @GetMapping("/welcome")
    fun welcome() = message
}