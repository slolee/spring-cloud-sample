package com.ch4njun.apigatewayservice.samplefilter

import mu.KotlinLogging
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

private val logger = KotlinLogging.logger { }

@Component
class SampleCustomFilter : AbstractGatewayFilterFactory<SampleCustomFilter.Config>(Config::class.java) {

    data class Config(
        val isPreLogging: Boolean = true,
        val isPostLogging: Boolean = true
    )

    override fun apply(config: Config) = GatewayFilter { exchange, chain ->
        val request = exchange.request
        val response = exchange.response

        if (config.isPreLogging) {
            logger.info { "Custom PRE Filter : request_id -> ${request.id}" }
        }
        chain.filter(exchange).then(Mono.fromRunnable {
            if (config.isPostLogging) {
                logger.info { "Custom POST Filter : response_code -> ${response.statusCode}" }
            }
        })
    }
}