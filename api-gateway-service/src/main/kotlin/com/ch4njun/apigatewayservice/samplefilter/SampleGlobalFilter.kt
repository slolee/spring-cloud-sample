package com.ch4njun.apigatewayservice.samplefilter

import mu.KotlinLogging
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class SampleGlobalFilter : AbstractGatewayFilterFactory<SampleGlobalFilter.Config>() {

    data class Config(
        val baseMessage: String,
        val isPreLogging: Boolean,
        val isPostLogging: Boolean
    )

    private val logger = KotlinLogging.logger { }

    override fun apply(config: Config) = GatewayFilter { exchange, chain ->
        val request = exchange.request
        val response = exchange.response

        logger.info { "Base Message : ${config.baseMessage}" }
        if (config.isPreLogging) {
            logger.info { "Custom PRE Global Filter : request_id -> ${request.id}" }
        }
        chain.filter(exchange).then(Mono.fromRunnable {
            if (config.isPostLogging) {
                logger.info { "Custom POST Global Filter : response_code -> ${response.statusCode}" }
            }
        })
    }
}