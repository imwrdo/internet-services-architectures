package org.example.lab_2;

import org.example.lab_2.entities.Vehicle;
import org.example.lab_2.entities.VehicleType;
import org.example.lab_2.sevices.vehicle.VehicleService;
import org.example.lab_2.sevices.vehicleType.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {
    private final VehicleService vehicleService;
    private final VehicleTypeService vehicleTypeService;
    @Autowired
    public Runner(VehicleService vehicleService, VehicleTypeService vehicleTypeService) {
        this.vehicleService = vehicleService;
        this.vehicleTypeService = vehicleTypeService;
    }

    @Override
    public void run(String... args) {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the vehicle service:\nType help to get help");
        while(isRunning){
            System.out.println("> ");
            String command = scanner.nextLine();
            switch(command){
                case "exit" -> isRunning = false;
                case "help" ->{
                    System.out.println("List of possible commands:");
                    System.out.println("exit - to close the application");
                    System.out.println("help - to display this message");
                    System.out.println("lvt - to display all vehicle types");
                    System.out.println("lv - to display all vehicles");
                    System.out.println("dv - to add a new vehicle");
                    System.out.println("dvt - to add a new vehicle type");
                    System.out.println("dv - to delete a vehicle");
                    System.out.println("dvt - to delete a vehicle type");
                }
                case "lvt" -> vehicleTypeService.findAll().forEach(System.out::println);
                case "lv" -> vehicleService.findAll().forEach(System.out::println);
                case "av" -> {
                    System.out.println("Enter vehicles brand: ");
                    String vehicleBrand = scanner.nextLine();
                    if(vehicleBrand.isEmpty()) {
                        System.out.println("Vehicle brand cannot be empty");
                        break;
                    }

                    System.out.println("Enter vehicle's year of production: ");
                    String yearOfProduction = scanner.nextLine();
                    if(yearOfProduction.isEmpty()) {
                        System.out.println("Year of production cannot be empty");
                        break;
                    }
                    if(!yearOfProduction.matches("\\d+")) {
                        System.out.println("Year of production must be a number");
                        break;
                    }
                    int age = Integer.parseInt(yearOfProduction);
                    if(age <= 0) {
                        System.out.println("Age must be greater than 0");
                        break;
                    }

                    System.out.println("Enter vehicle type profession (choose a number): ");
                    List<VehicleType> p = vehicleTypeService.findAll();
                    for(int i = 0; i < p.size(); i++) {
                        System.out.println((i+1) + ". " + p.get(i).getName());
                    }
                    String choiceString = scanner.nextLine();
                    if(choiceString.isEmpty()) {
                        System.out.println("vehicle type choice cannot be empty");
                        break;
                    }
                    if(!choiceString.matches("\\d+")) {
                        System.out.println("vehicle type choice must be a number");
                        break;
                    }
                    int choice = Integer.parseInt(choiceString)-1;
                    if(choice < 0 || choice >= p.size()) {
                        System.out.println("Invalid vehicle type choice");
                        break;
                    }

                    vehicleService.create(Vehicle.builder()
                            .brand(vehicleBrand)
                            .yearOfProduction(age)
                            .vehicleType(p.get(choice))
                            .build());
                    System.out.println("Character added successfully");


                }
                case "avt" ->{
                    System.out.println("Enter vehicle type: ");
                    String name = scanner.nextLine();
                    if(name.isEmpty()) {
                        System.out.println("Name cannot be empty");
                        break;
                    }

                    System.out.println("Enter year of invention: ");
                    String yearsString = scanner.nextLine();
                    if(yearsString.isEmpty()) {
                        System.out.println("Years of experience cannot be empty");
                        break;
                    }
                    if(!yearsString.matches("-?[0-9]+")) {
                        System.out.println("Years of experience must be a number");
                        break;
                    }
                    int years = Integer.parseInt(yearsString);
                    if(years <= 0) {
                        System.out.println("Years of experience must be greater than 0");
                        break;

                    }
                    System.out.println("Enter vehicle type: ");
                    String engine = scanner.nextLine();
                    boolean ans = false;
                    if(engine.isEmpty()) {
                        System.out.println("Name cannot be empty");
                        break;
                    }
                    if(engine.equals("yes")){
                        ans = true;
                    }else{
                        System.out.println("Just type yes/no");
                    }

                    vehicleTypeService.create(VehicleType.builder()
                            .name(name)
                            .yearOfInvention(years)
                            .hasEngine(ans)
                            .build());
                    System.out.println("Profession added successfully");
                }
                case "dv" -> {
                    System.out.println("Select vehicle to delete (choose a number): ");
                    List<Vehicle> c = vehicleService.findAll();
                    for(int i = 0; i < c.size(); i++) {
                        System.out.println((i+1) + ". " + c.get(i).getBrand());
                    }

                    String choiceString = scanner.nextLine();
                    if(choiceString.isEmpty()) {
                        System.out.println("Vehicle choice cannot be empty");
                        break;
                    }
                    if(!choiceString.matches("-?[0-9]+")) {
                        System.out.println("Vehicle choice must be a number");
                        break;
                    }
                    int choice = Integer.parseInt(choiceString)-1;
                    if(choice < 0 || choice >= c.size()) {
                        System.out.println("Invalid vehicle choice");
                        break;
                    }

                    vehicleService.delete(c.get(choice).getId());
                    System.out.println("Vehicle deleted successfully");
                }

                case "dvt" -> {
                    System.out.println("Select profession to delete (choose a number): ");
                    List<VehicleType> p = vehicleTypeService.findAll();
                    for(int i = 0; i < p.size(); i++) {
                        System.out.println((i+1) + ". " + p.get(i).getName());
                    }

                    int choice = Integer.parseInt(scanner.nextLine())-1;
                    if(choice <= 0 || choice >= p.size()) {
                        System.out.println("Invalid profession choice");
                        break;
                    }

                    vehicleTypeService.delete(p.get(choice).getId());
                    System.out.println("Profession deleted successfully");
                }
                default -> System.out.println("Invalid command. If you need help, type 'help'");
            }
        }

    }
}