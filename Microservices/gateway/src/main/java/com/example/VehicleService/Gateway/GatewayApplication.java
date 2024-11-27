package com.example.VehicleService.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
	private final String vehicleServiceURL;
	private final String vehicleTypeServiceURL;

	public GatewayApplication(
		@Value("${duck.vehicle-service.url}") String vehicleURL,
		@Value("${duck.vehicleType-service.url}") String vehicleTypeURL
	){
		this.vehicleServiceURL = vehicleURL;
		this.vehicleTypeServiceURL = vehicleTypeURL;
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣷⡀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣄⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣆⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣶⣤⣙⣿⣿⣾⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠻⣿⣿⡿⠿⠿⠿⠿⠗⠶⠶⠶⠤⢤⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⠖⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠓⠦⣤⣤⢤⡞⢦⠀⠀⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⢦⡀⠈⢧⡀⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⢀⣄⢀⣴⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣦⠀⠱⣄⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⣾⠈⠉⠀⠻⡷⠀⠀⣠⠖⠚⠉⠉⠉⠉⠓⢦⡀⠀⠀⠀⠀⠀⡤⠚⠉⠉⠉⠉⠑⠢⣄⠀⠈⢧⠀⠈⢳⡀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⢰⠇⠀⠀⠀⠀⡇⢠⡞⠀⠀⠀⠀⢀⡀⠀⠀⠀⢹⠀⠀⠀⠀⢸⠁⠀⠀⡤⠀⠀⠀⠀⠈⣇⠀⠸⡆⠀⠀⢻⡄⠀\n" +
				"⠀⠀⠀⠀⢠⡏⠀⠀⠀⠀⠀⡇⠸⡇⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠀⠀⠀⠀⠈⠣⣀⠀⠀⠀⠀⠀⠀⣠⠇⠀⠀⡇⠀⠀⠀⢿⠀\n" +
				"⠀⠀⠀⢀⡞⠀⠀⠀⠀⠀⠀⡇⠀⠙⠲⢤⣀⣀⣀⣀⠤⠖⠋⠀⣀⡴⠚⠓⠢⣄⡈⠙⠒⠒⠒⠒⠋⠁⠀⠀⢸⠃⠀⠀⠀⢸⡆\n" +
				"⠀⠀⠀⣼⠁⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠴⠚⢥⡀⠀⠀⠀⡀⠙⠓⠒⠶⠦⢤⡄⠀⠀⣠⡏⠀⠀⠀⠀⢸⡇\n" +
				"⠀⠀⢰⡇⠀⠀⠀⠀⠀⠀⠀⢻⠀⠀⢀⣤⠶⠒⠚⠋⠉⠁⠀⠀⠀⠁⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⣇⢀⡴⠋⠀⠀⠀⠀⠀⣸⠃\n" +
				"⠀⠀⢸⠃⠀⠀⠀⠀⠀⠀⠀⢸⣧⡀⠀⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠻⣄⠀⠀⠀⠀⠀⢀⡟⠀\n" +
				"⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠘⡏⠉⠳⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⡄⠀⠀⢀⡾⠁⠀\n" +
				"⠀⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡀⣠⠞⠀⠀⠀\n" +
				"⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⢠⡇⠀⠸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡿⢻⡏⠀⠀⠀⠀\n" +
				"⠀⠀⠀⢻⡀⠀⠀⠀⠀⠀⢀⡾⠁⠀⠀⠹⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⠟⠁⠀⢷⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠙⠦⣤⣄⣀⠀⠘⠁⠀⠀⠀⠀⠀⠙⠲⠦⣤⣄⣀⣀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣤⠴⠚⠉⠀⠀⠀⠀⠈⣇⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡀⠀⠀\n" +
				"⣠⣀⣀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀\n" +
				"⢳⡀⠈⠙⠲⢤⣼⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠇⠀⠀\n" +
				"⠀⠙⢦⡀⠀⠀⠘⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡿⠀⠀⠀\n" +
				"⠀⠀⠀⠙⠶⣄⡀⠈⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡾⠁⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠈⠙⠲⢤⣹⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⣳⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⢾⡋⠀⠀⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠊⠁⠀⠈⠙⠲⠦⣤⣄⣀⣀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣤⠴⠖⠛⠉⠀⠀⠉⠳⣄⠀⠀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⢀⡔⠁⠀⠀⢀⠀⠀⠀⠀⢀⠀⠀⠈⢻⠉⠉⠉⠉⠉⠉⢹⠉⠉⠀⠀⡀⠀⠀⠀⠀⢠⡀⠀⠈⢧⡀⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠟⠒⠒⠒⠛⠙⣄⠀⣀⡴⠛⠳⢤⣀⡀⣧⠀⠀⠀⠀⠀⢸⡀⣀⣠⠴⠛⠦⣄⠀⢀⡏⠉⠙⠒⠶⠇⠀⠀⠀\n" +
				"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠁⠀⠀⠀⠀⠀⠉⠉⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⠈⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀");
	}

	@Bean
	public RouteLocator router(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("vehicleTypes", route -> route
				.path("/api/vehicleTypes", "/api/vehicleTypes/{uuid}")
				.uri(vehicleTypeServiceURL)
			)
			.route("vehicles", route -> route
				.path("/api/vehicles", "/api/vehicles/{uuid}", "/api/vehicleTypes/{uuid}/vehicles")
				.uri(vehicleServiceURL)
			)
			.build();
	}
}
