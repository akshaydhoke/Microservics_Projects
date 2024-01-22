package com.design.pattern.builder;

// Builder Design Pattern:
// While creating Object then Object may contain attribute then the following problems are created as
// 1) We have to pass many arguments to create Object.
// 2) Some parameters might be Optional
// 3) Factory class takes all responsibility to create Object but Object creation is very heavy then we should go for Builder design pattern.

// Builder design pattern create Object step by step and return the Object with the desired output.

public class Client {
	public static void main(String[] args) {

		Computer c1 = new Computer.ComputerBuilder("500 GB", "2 GB").setGraphicsCardEnabled(true)
				.setBluetoothEnabled(false).build();

		System.out.println(
				c1.getHDD() + ":" + c1.getRAM() + ":" + c1.isBluetoothEnabled() + ":" + c1.isGraphicsCardEnabled());

	}

}
