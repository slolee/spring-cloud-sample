package com.example.orderservice.app.order.service

import com.example.orderservice.app.order.request.CreateOrderRequest
import com.example.orderservice.app.order.response.CreateOrderResponse
import com.example.orderservice.domain.port.out.OrderPersistencePort
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderPersistencePort: OrderPersistencePort
) {

    fun order(req: CreateOrderRequest): CreateOrderResponse {
        val order = req.toEntity()
        return orderPersistencePort.save(order)
            .let { CreateOrderResponse.from(it) }
    }
}