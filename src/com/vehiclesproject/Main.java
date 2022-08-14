package com.vehiclesproject;

import java.util.Scanner;

public class Main {

	private static Scanner s = new Scanner(System.in);

	private static Storage<Car> carStore = new Storage<Car>();
	private static Storage<Truck> truckStore = new Storage<Truck>();

	private static int currentStore;

	public static void main(String[] args) {
		Car car = new Car(4, 4, 200, "Automatic", "Honda", "Fit", 2020, 22000.00, true);
		Car car1 = new Car(2, 4, 254, "Manual", "Kia", "EV6", 2022, 41400.00, false);
		Car car2 = new Car(4, 4, 156, "Automatic", "Nissan", "Sentra SV", 2019, 17995.00, true);

		Truck truck = new Truck(4, 4, 230, "Automatic", "Ford", "F-150", 2021, 61499d, true);
		Truck truck1 = new Truck(4, 4, 200, "Automatic", "GMC", "Hummer EV", 2022, 108700.00, false);
		Truck truck2 = new Truck(4, 4, 200, "Automatic", "Nissan", "Frontier", 2022, 28690.00, true);

		carStore.add(car);
		carStore.add(car1);
		carStore.add(car2);

		truckStore.add(truck);
		truckStore.add(truck1);
		truckStore.add(truck2);

		boolean exit = false;

		printMenu();

		while (!exit) {
			System.out.println("Please choose from the menu. Press 1 to see the menu again.");
			int input = s.nextInt();
			s.nextLine();

			switch (input) {
			case 1:
				printMenu();
				break;
			case 2:
				pickStore();
				break;
			case 3:
				displayStoreInv();
				break;
			case 4:
				getInfo();
				break;
			case 5:
				if (buyVehicle()) {
					exit = true;
				}
				break;
			}
		}
	}

	private static boolean buyVehicle() {
		System.out.println("Enter the model of the vehicle you would like to buy.");
		String model = s.nextLine();
		Vehicle vehicle = getStore().getVehicle(model);
		if (vehicle != null) {
			System.out.println("Is this the vehicle you would like to buy? Type Yes or No");
			vehicle.displayInfo();
			String response = s.nextLine();
			if (response.equalsIgnoreCase("yes")) {
				System.out.println("That will be " + vehicle.getPrice());
				return true;
			} else if(response.equalsIgnoreCase("no")) {
				System.out.println("Returning to menu.");
				return false;
			} else {
				System.out.println("I do not recognize this response, please try again.");
				return false;
			}
		} else {
			System.out.println("Sorry we could not find this vehicle in our inventory.");
			return false;
		}
	}

	private static void getInfo() {
		System.out.println("Enter the model of the vehicle you'd like to see.");
		String model = s.nextLine();

		Vehicle vehicle = getStore().getVehicle(model);

		if (vehicle != null) {
			vehicle.displayInfo();
		} else {
			System.out.println("Sorry we could not find this vehicle in our inventory.");
		}

	}

	private static void displayStoreInv() {
		getStore().displayInventory();
	}

	private static void pickStore() {
		System.out.println("Press 1 for Car Store \n" + "Press 2 for Truck Store");
		int store = s.nextInt();
		s.nextLine();
		if (store == 1 || store == 2) {
			currentStore = store;
		} else {
			System.out.println("You must pick either 1 or 2.");
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends Vehicle & IDisplayInfo> Storage<T> getStore() {
		if (currentStore == 1) {
			return (Storage<T>) carStore;
		} else {
			return (Storage<T>) truckStore;
		}
	}

	private static void printMenu() {
		System.out.println("Menu: \n" + "	1 - Show menu \n" + "	2 - Choose store of Vehicles \n"
				+ "	3 - Display Stores Inventory \n" + "	4 - Display Info of Vehicle \n"
				+ "	5 - Purchese Vehicle! \n" + "	6 - Quit program");
	}

}
