package com.vehiclesproject;

public class Truck extends Vehicle implements IDisplayInfo {
	private String make;
	private String model;
	private int year;
	private double price;
	private boolean used;

	public Truck(int numOfDoors, int numOfWheels, int topSpeed, String transmissionType, String make, String model,
			int year, double price, boolean used) {
		super(numOfDoors, numOfWheels, topSpeed, transmissionType);
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.used = used;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public double getPrice() {
		return price;
	}

	public String getUsed() {
		return used ? "Used" : "New";
	}

	public void displayInfo() {
		System.out.println("Info: \n" + "	Make: " + getMake() + "\n" + "	Model: " + getModel() + "\n" + "	Year: "
				+ getYear() + "\n" + "	Price: " + getPrice() + "\n " + "	New: " + getUsed() + "\n "
				+ "	Doors: " + super.getNumOfDoors() + "\n" + "	Wheels: " + super.getNumOfWheels() + "\n"
				+ "	Top Speed: " + super.getTopSpeed());
	}

}
