package com.litmus7.rental;
import java.util.Scanner;

import com.litmus7.rental.dto.*;
import com.litmus7.rental.service.VehicleService;

public class VehicleApp {
	public static void main(String[] args) {
		VehicleService service=new VehicleService();
		System.out.println("Loading Available Vehicles from the file......");
		service.loadVehicles("src/Sample Vehicles.txt");
		Scanner sc=new Scanner(System.in);
		boolean exit=false;
		while (!exit) {
            System.out.println("\n-- Vehicle Rental System --");
            System.out.println("1. Display All Vehicles");
            System.out.println("2. Display Available Vehicles");
            System.out.println("3. Add New Vehicle");
            System.out.println("4. Rent a Vehicle");
            System.out.println("5. Return a Vehicle");
            System.out.println("6. Calculate Rental Price of Vehicle");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("\nAll Vehicles : ");
                    service.displayAllVehicles();
                    break;

                case 2:
                    System.out.println("\nAvailable Vehicles : ");
                    service.displayAvailableVehicles();
                    break;

                case 3:
                	System.out.println("Enter Vehicle type - Car or Bike");
                    String type=sc.nextLine();
                    
                    if(type.equals("Car")) {
                    	System.out.print("Brand : ");
                        String brand = sc.nextLine();
                        System.out.print("Model : ");
                        String model = sc.nextLine();
                        System.out.print("Rental Price per Day : ");
                        double price = sc.nextDouble();
                        System.out.print("Number of Doors : ");
                        int numberOfDoors = sc.nextInt();
                        System.out.print("Is Automatic - True OR False : ");
                        boolean isAutomatic = Boolean.parseBoolean(sc.nextLine());

                        
                        Car car=new Car(brand,model,price,numberOfDoors,isAutomatic);
                        service.addVehicle(car);
                        
                    } else if (type.equals("Bike")) {
                        System.out.print("Brand : ");
                        String brand = sc.nextLine();
                        System.out.print("Model : ");
                        String model = sc.nextLine();
                        System.out.print("Rental Price per day : ");
                        double price = sc.nextDouble();
                        System.out.print("Has Gear - True or False : ");
                        boolean hasGear = sc.nextBoolean();
                        System.out.print("Engine Capacity : ");
                        int engineCapacity = sc.nextInt();

                        Bike bike = new Bike(brand, model, price, hasGear, engineCapacity);
                        service.addVehicle(bike);
                    } else {
                        System.out.println("Invalid Vehicle type!!!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Brand : ");
                    String rentBrand = sc.nextLine();
                    System.out.print("Model : ");
                    String rentModel = sc.nextLine();
                    boolean rented = service.rentVehicle(rentBrand, rentModel);
                    if (rented) {
                        System.out.println("Successful");
                    } else {
                        System.out.println("Vehicle not available");
                    }
                    break;

                case 5:
                    System.out.print("Brand : ");
                    String returnBrand = sc.nextLine();
                    System.out.print("Model : ");
                    String returnModel = sc.nextLine();
                    boolean returned = service.returnVehicle(returnBrand, returnModel);
                    if (returned) {
                        System.out.println("Successful");
                    } else {
                        System.out.println("Vehicle not rented");
                    }
                    break;

                case 6:
                    double total = service.calculateRent();
                    System.out.println("Rental Price of Vehicle : " + total);
                    break;

                case 0:
                    exit = true;
                    System.out.println("Thank you!!");
                    break;

                default:
                    System.out.println("Invalid input !!");
            }
        }

        sc.close();
	}

}
