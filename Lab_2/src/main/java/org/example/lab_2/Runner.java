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
        showPokemon();
        System.out.println("Welcome to the vehicle service:\nType help to get help");
        while(isRunning){
            System.out.print("^_^ > ");
            String command = scanner.nextLine();
            switch(command){
                case "exit" -> isRunning = false;
                case "help" ->showHelp();
                case "svt" -> showAllVehicleTypes();
                case "sv" -> showAllVehicles();
                case "av" -> addVehicle(scanner);
                case "avt" ->addVehicleType(scanner);
                case "dv" -> deleteVehicle(scanner);
                case "dvt" -> deleteVehicleType(scanner);
                default -> showError();
            }
        }

    }
    public void addVehicle(Scanner scanner) {
        System.out.println("Enter vehicles brand: ");
        String vehicleBrand = scanner.nextLine();
        if(vehicleBrand.isEmpty()) {
            System.out.println("Vehicle brand cannot be empty");
            return;
        }
        System.out.println("Enter vehicle's year of production: ");
        String yearOfProduction = scanner.nextLine();
        if(yearOfProduction.isEmpty()) {
            System.out.println("Year of production cannot be empty");
            return;
        }
        if(!yearOfProduction.matches("\\d+")) {
            System.out.println("Year of production must be a number");
            return;
        }
        int age = Integer.parseInt(yearOfProduction);
        if(age <= 0) {
            System.out.println("Age must be greater than 0");
            return;
        }
        System.out.println("Enter vehicle type (choose a number): ");
        List<VehicleType> p = vehicleTypeService.findAll();
        for(int i = 0; i < p.size(); i++) {
            System.out.println((i+1) + ". " + p.get(i).getName());
        }
        String choiceString = scanner.nextLine();
        if(choiceString.isEmpty()) {
            System.out.println("vehicle type choice cannot be empty");
            return;
        }
        if(!choiceString.matches("\\d+")) {
            System.out.println("vehicle type choice must be a number");
            return;
        }
        int choice = Integer.parseInt(choiceString)-1;
        if(choice < 0 || choice >= p.size()) {
            System.out.println("Invalid vehicle type choice");
            return;
        }
        vehicleService.create(Vehicle.builder()
                .brand(vehicleBrand)
                .yearOfProduction(age)
                .vehicleType(p.get(choice))
                .build());
        System.out.println("Character added successfully");
    }
    public void showHelp(){
        System.out.println("List of possible commands:");
        System.out.println("exit - to close the application");
        System.out.println("help - to display this message");
        System.out.println("svt - to display all vehicle types");
        System.out.println("sv - to display all vehicles");
        System.out.println("av - to add a new vehicle");
        System.out.println("avt - to add a new vehicle type");
        System.out.println("dv - to delete a vehicle");
        System.out.println("dvt - to delete a vehicle type");
    }
    public void showAllVehicleTypes(){
        vehicleTypeService.findAll().forEach(System.out::println);
    }
    public void showAllVehicles(){
        vehicleService.findAll().forEach(System.out::println);
    }
    public void addVehicleType(Scanner scanner) {
        System.out.println("Enter vehicle type: ");
        String name = scanner.nextLine();
        if(name.isEmpty()) {
            System.out.println("Vehicle type cannot be empty");
            return;
        }
        System.out.println("Enter year of invention: ");
        String yearsString = scanner.nextLine();
        if(yearsString.isEmpty()) {
            System.out.println("Year of invention cannot be empty");
            return;
        }
        if(!yearsString.matches("-?[0-9]+")) {
            System.out.println("Year of invention must be a number");
            return;
        }
        int years = Integer.parseInt(yearsString);
        if(years <= 0) {
            System.out.println("Year of invention must be greater than 0");
            return;
        }
        System.out.println("Enter vehicle type: ");
        String engine = scanner.nextLine();
        boolean ans = false;
        if(engine.isEmpty()) {
            System.out.println("Engine cannot be empty");
            return;
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
        System.out.println("Vehicle type added successfully");
    }
    public void deleteVehicle(Scanner scanner) {
        System.out.println("Select vehicle to delete (choose a number): ");
        List<Vehicle> c = vehicleService.findAll();
        for(int i = 0; i < c.size(); i++) {
            System.out.println((i+1) + ". " + c.get(i).getBrand());
        }
        String choiceString = scanner.nextLine();
        if(choiceString.isEmpty()) {
            System.out.println("Vehicle choice cannot be empty");
            return;
        }
        if(!choiceString.matches("-?[0-9]+")) {
            System.out.println("Vehicle choice must be a number");
            return;
        }
        int choice = Integer.parseInt(choiceString)-1;
        if(choice < 0 || choice >= c.size()) {
            System.out.println("Invalid vehicle choice");
            return;
        }
        vehicleService.delete(c.get(choice).getId());
        System.out.println("Vehicle deleted successfully");
    }
    public void deleteVehicleType(Scanner scanner) {
        System.out.println("Select vehicle type to delete (choose a number): ");
        List<VehicleType> p = vehicleTypeService.findAll();
        for(int i = 0; i < p.size(); i++) {
            System.out.println((i+1) + ". " + p.get(i).getName());
        }
        int choice = Integer.parseInt(scanner.nextLine())-1;
        if(choice <= 0 || choice >= p.size()) {
            System.out.println("Invalid vehicle type choice");
            return;
        }
        vehicleTypeService.delete(p.get(choice).getId());
        System.out.println("Vehicle type deleted successfully");
    }
    public void showError(){
        System.out.println("Nie rob tak! If you need help, type 'help'");
    }
    public void showPokemon(){
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
