package com.example.orderservice.app.order.controller

import com.example.orderservice.app.order.request.CreateOrderRequest
import com.example.orderservice.app.order.response.CreateOrderResponse
import com.example.orderservice.app.order.service.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping("/order")
    fun createOrder(@RequestBody req: CreateOrderRequest): CreateOrderResponse {
        return orderService.order(req)
    }
}