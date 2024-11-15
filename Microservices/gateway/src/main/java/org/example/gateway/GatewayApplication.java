package org.example.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    private final String VehiclesAPIUrl;
    private final String VehicleTypesAPIUrl;

    public GatewayApplication(@Value("${gateway.vehicleapi}") String vehiclesAPIUrl, @Value("${gateway.vehicletypesapi}") String vehicleTypesAPIUrl) {
        VehiclesAPIUrl = vehiclesAPIUrl;
        VehicleTypesAPIUrl = vehicleTypesAPIUrl;
    }
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("vehicleTypes", route -> route.path("/types/", "/types/{uuid}/").uri(VehicleTypesAPIUrl))
                .route("vehicles", route -> route.path("/vehicles/", "/vehicles/{uuid}/", "/genres/{uuid}/games/").uri(VehiclesAPIUrl))
                .build();

    }
}
