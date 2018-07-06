package com.akshay.designPattern;

class Computer {

	// Mandatory Parameter
	private int ram;
	private int hdd;

	// optional Parameter
	private boolean isBluetoothEnable;
	private boolean isWiFiEnable;

	public static class ComputerBuilder {

		// Mandatory Parameter
		private int ram;
		private int hdd;

		// optional Parameter
		private boolean isBluetoothEnable;
		private boolean isWiFiEnable;

		public ComputerBuilder(int ram, int hdd) {
			this.ram = ram;
			this.hdd = hdd;
		}

		public ComputerBuilder setBluetoothEnable(boolean isBluetoothEnable) {
			this.isBluetoothEnable = isBluetoothEnable;
			return this;
		}

		public ComputerBuilder setWiFiEnable(boolean isWiFiEnable) {
			this.isWiFiEnable = isWiFiEnable;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}

	}

	public Computer(ComputerBuilder computerBuilder) {
		this.ram = computerBuilder.ram;
		this.hdd = computerBuilder.hdd;
		this.isBluetoothEnable = computerBuilder.isBluetoothEnable;
		this.isWiFiEnable = computerBuilder.isWiFiEnable;
	}

	public int getRam() {
		return ram;
	}

	public int getHdd() {
		return hdd;
	}

	public boolean isBluetoothEnable() {
		return isBluetoothEnable;
	}

	public boolean isWiFiEnable() {
		return isWiFiEnable;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ram : " + this.ram + " , hdd : " + this.hdd + " ";
	}

}

// Builder pattern solves the issue with large number of optional parameters and
// inconsistent state by providing a way to build the object step-by-step and
// provide a method that will actually return the final Object.
public class BuilderDesignPattern {

	public static void main(String[] args) {
		Computer computer = new Computer.ComputerBuilder(3, 500).setBluetoothEnable(true).setWiFiEnable(false).build();
		System.out.println(computer);
	}

}
