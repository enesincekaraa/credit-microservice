package com.incekara.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRoute(RouteLocatorBuilder builder){
        return builder.routes().route(p -> p.path("/get").filters(f->f.addRequestHeader("MyHeader","MyURI")
                .addRequestParameter("Param","MyValue"))
                .uri("http://httpbin.org:80"))
                .route(p->p.path("/low-interest/**")
                        .uri("lb://low-interest"))
                .route(p->p.path("/high-interest/**")
                        .uri("lb://high-interest"))
                .route(p->p.path("/credit-service-feign/**")
                        .uri("lb://credit-service"))
                .route(p->p.path("/credit-service-feign-high/**")
                        .uri("lb://credit-service")).build();
    }
}
