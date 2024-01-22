package com.design.pattern.prototype;

// https://www.geeksforgeeks.org/prototype-design-pattern/

// Prototype Design Pattern :
// The concept is to copy an existing object rather than creating a new instance from scratch, something that may include costly operations.
// This approach saves costly resources and time, especially when object creation is a heavy process.

public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {

		NetworkConnection connectionObj1 = new NetworkConnection();
		connectionObj1.setIp("192.168.49.99");
		connectionObj1.setNetworkNmae("V-LAN");

		System.out.println(connectionObj1.getIp() + ":" + connectionObj1.getNetworkNmae());
		System.out.println(connectionObj1.getLoadObject());

		NetworkConnection connectionObj2 = (NetworkConnection) connectionObj1.clone();
		System.out.println(connectionObj2);
		System.out.println(connectionObj2.getLoadObject());

	}

}
