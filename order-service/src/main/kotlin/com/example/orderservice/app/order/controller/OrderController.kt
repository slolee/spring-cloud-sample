package com.example.orderservice.app.order.controller

import com.example.orderservice.app.order.request.CreateOrderRequest
import com.example.orderservice.app.order.response.CreateOrderResponse
import com.example.orderservice.app.order.response.OrderResponse
import com.example.orderservice.app.order.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping("/{userId}/order")
    fun createOrder(@RequestBody req: CreateOrderRequest, @PathVariable userId: String): CreateOrderResponse {
        req.userId = userId
        return orderService.order(req)
    }

    @GetMapping("/order/{orderId}")
    fun retrieveOrderInfo(@PathVariable orderId: String): OrderResponse {
        return orderService.retrieveOrderInfo(orderId)
    }

    @GetMapping("{userId}/orders")
    fun retrieveAllOrdersByUser(@PathVariable userId: String): List<OrderResponse> {
        return orderService.retrieveAllByUser(userId)
    }
}