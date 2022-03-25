package com.mutantes.mutantesgateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MutantesGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/mutantes-db/**")
                        .filters(f -> f.rewritePath("/mutantes-db/(?<segment>.*)", "/mutantes-db-api/${segment}"))
                        .uri("lb://mutantes-db-api"))
                .route(r -> r.path("/mutantes/**")
                        .filters(f -> f.rewritePath("/mutantes/(?<segment>.*)", "/mutantes-api/${segment}"))
                        .uri("lb://mutantes-api"))
                .build();
    }
}
