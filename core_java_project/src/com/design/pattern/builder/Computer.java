package com.design.pattern.builder;
// https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java

public class Computer {

	private String HDD;
	private String RAM;
	// optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;

	public Computer(ComputerBuilder computerBuilder) {
		HDD = computerBuilder.HDD;
		RAM = computerBuilder.RAM;
		this.isGraphicsCardEnabled = computerBuilder.isGraphicsCardEnabled;
		this.isBluetoothEnabled = computerBuilder.isBluetoothEnabled;
	}

	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	static class ComputerBuilder {

		private String HDD;
		private String RAM;
		// optional parameters
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;

		ComputerBuilder(String hdd, String ram) {
			this.HDD = hdd;
			this.RAM = ram;
		}

		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}

	}
}