package com.ch4njun.userservice.app.user.controller

import com.ch4njun.userservice.app.user.request.RegisterRequest
import com.ch4njun.userservice.app.user.response.RegisterResponse
import com.ch4njun.userservice.app.user.response.UserResponse
import com.ch4njun.userservice.app.user.service.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class UserController(
    private val userService: UserService,
    @Value("\${greeting.message}") val message: String
) {

    @GetMapping("/welcome")
    fun welcome() = message

    @PostMapping("/user")
    fun register(@RequestBody req: RegisterRequest): RegisterResponse {
        return userService.register(req)
    }

    @GetMapping("/users")
    fun retrieveAllUsers(): List<UserResponse> {
        return userService.retrieveAllUsers()
    }

    @GetMapping("/user/{userId}")
    fun retrieveUser(@PathVariable userId: String): UserResponse {
        return userService.retrieveUserInfo(userId)
    }
}