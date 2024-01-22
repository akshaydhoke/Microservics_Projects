package com.immutableClass;

// Immutable Class

final public class Student {

	private final int stdId;
	private final String stdName;
	private final Address address;

	// Normal case :
	// public Student(int stdId, String stdName) {
	// this.stdId = stdId;
	// this.stdName = stdName;
	// }

	public Student(int stdId, String stdName, Address address) {
		this.stdId = stdId;
		this.stdName = stdName;
		this.address = address;
	}
	
//	public Address getAddress() {
//		return address;
//	}
	
//  Copy Object Approch 2 : 
//	public Address getAddress() {
//		return new Address(address.getCity(), address.getCountry());
//	}
	
//  Copy Contructor Approch 3 : 
//	public Address getAddress() {
//		return new Address(address);
//	}
	
//  getInstance() Approch 4 : 
	public Address getAddress() {
		return address.getInstance(address);
	}

	public int getStdId() {
		return stdId;
	}

	public String getStdName() {
		return stdName;
	}
	
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", address=" + address + "]";
	}

}
