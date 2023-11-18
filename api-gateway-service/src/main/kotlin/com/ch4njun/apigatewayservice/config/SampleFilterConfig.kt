package com.ch4njun.apigatewayservice.config

import com.ch4njun.apigatewayservice.samplefilter.SampleCustomFilter
import com.ch4njun.apigatewayservice.samplefilter.SampleGlobalFilter
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SampleFilterConfig {

    @Bean
    fun gatewayRoutes(
        builder: RouteLocatorBuilder,
        globalFilter: SampleGlobalFilter,
        customFilter: SampleCustomFilter
    ) = builder.routes {
        route {
            filters {
                filter(
                    globalFilter.apply(
                        SampleGlobalFilter.Config(
                            baseMessage = "ch4njun base message",
                            isPreLogging = true,
                            isPostLogging = false
                        )
                    )
                )
            }
            path("/first-service/**")
            filters {
                addRequestHeader("first-service-request", "first-request-header")
                addResponseHeader("first-service-response", "first-response-header")
                filter(customFilter.apply(Any()))
            }
            uri("http://localhost:8080")
        }
    }
}