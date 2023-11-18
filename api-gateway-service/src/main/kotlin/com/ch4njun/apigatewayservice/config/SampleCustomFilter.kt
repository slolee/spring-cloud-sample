package com.ch4njun.apigatewayservice.config

import mu.KotlinLogging
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class SampleCustomFilter : AbstractGatewayFilterFactory<Any>() {

    private val logger = KotlinLogging.logger { }

    override fun apply(config: Any?) = GatewayFilter { exchange, chain ->
        val request = exchange.request
        val response = exchange.response

        logger.info { "Custom PRE Filter : request_id -> ${request.id}" }
        chain.filter(exchange).then(Mono.fromRunnable {
            logger.info { "Custom POST Filter : response_code -> ${response.statusCode}" }
        })
    }
}