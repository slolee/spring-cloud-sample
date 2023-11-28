package com.example.orderservice.app.order.service

import com.example.orderservice.app.order.request.CreateOrderRequest
import com.example.orderservice.app.order.response.CreateOrderResponse
import com.example.orderservice.app.order.response.OrderResponse
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

    fun retrieveOrderInfo(orderId: String): OrderResponse {
        return orderPersistencePort.findById(orderId)
            ?.let { OrderResponse.from(it) }
            ?: throw RuntimeException("찾을 수 없는 주문정보입니다. (orderId=$orderId)")
    }

    fun retrieveAllOrdersByUser(userId: String): List<OrderResponse> {
        return orderPersistencePort.findAllByUserId(userId)
            .map { OrderResponse.from(it) }
    }
}