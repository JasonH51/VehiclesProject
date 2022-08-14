package com.vehiclesproject;

import java.util.ArrayList;

public class Storage<T extends Vehicle & IDisplayInfo> {
	private ArrayList<T> storeOfVehicles = new ArrayList<T>();

	public boolean add(T vehicle) {
		if (storeOfVehicles.contains(vehicle)) {
			return false;
		} else {
			storeOfVehicles.add(vehicle);
			return true;
		}
	}

	public boolean remove(T vehicle) {
		if (storeOfVehicles.contains(vehicle)) {
			return storeOfVehicles.remove(vehicle);
		} else {
			return false;
		}
	}

	public void displayInventory() {
		for (T vehicle : storeOfVehicles) {
			vehicle.displayInfo();
		}
	}

	private int index(String model) {
		int index = -1;
		for (T vehicle : storeOfVehicles) {
			if (vehicle.getModel().equalsIgnoreCase(model)) {
				index = storeOfVehicles.indexOf(vehicle);
				break;
			}
		}
		return index;
	}

	public T getVehicle(String model) {
		int index = index(model);
		if (index >= 0) {
			return storeOfVehicles.get(index);
		} else {
			return null;
		}
	}
}
