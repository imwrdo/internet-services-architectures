package com.example.VehicleService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehicleServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(VehicleServiceApplication.class, args);
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
	}
