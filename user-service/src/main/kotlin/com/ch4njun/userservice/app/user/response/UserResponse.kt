package com.ch4njun.userservice.app.user.response

import com.ch4njun.userservice.domain.entity.User
import java.time.LocalDateTime

data class UserResponse(
    val userId: String,
    val email: String,
    val name: String,
    val orders: List<UserOrderResponse>
) {
    companion object {
        // TODO : Orders 전달받아서 세팅
        fun from(user: User) = UserResponse(
            userId = user.id,
            email = user.email,
            name = user.name,
            orders = emptyList()
        )
    }
}

data class UserOrderResponse(
    val productId: String,
    val qty: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val createdAt: LocalDateTime,
    val orderId: String
)