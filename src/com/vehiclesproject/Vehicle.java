package com.vehiclesproject;

public abstract class Vehicle {
	private int numOfDoors;
	private int numOfWheels;
	private int topSpeed;
	private String transmissionType;

	public Vehicle(int numOfDoors, int numOfWheels, int topSpeed, String transmissionType) {
		this.numOfDoors = numOfDoors;
		this.numOfWheels = numOfWheels;
		this.topSpeed = topSpeed;
		this.transmissionType = transmissionType;
	}

	protected abstract String getModel();

	protected abstract void displayInfo();

	protected abstract double getPrice();

	public int getNumOfDoors() {
		return numOfDoors;
	}

	public int getNumOfWheels() {
		return numOfWheels;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	
	
	

}
