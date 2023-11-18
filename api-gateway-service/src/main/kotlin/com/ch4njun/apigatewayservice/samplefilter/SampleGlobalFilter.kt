package com.ch4njun.apigatewayservice.samplefilter

import mu.KotlinLogging
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class SampleGlobalFilter : GlobalFilter, Ordered {

    private val logger = KotlinLogging.logger { }

    override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
        val request = exchange.request
        val response = exchange.response

            logger.info { "Custom PRE Global Filter : request_id -> ${request.id}" }
        return chain.filter(exchange).then(Mono.fromRunnable {
            logger.info { "Custom POST Global Filter : response_code -> ${response.statusCode}" }
        })
    }

    override fun getOrder(): Int {
        return -1
    }
}