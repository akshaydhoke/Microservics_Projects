package com.immutableClass;

public class Address {

	private String city;
	private String country;

	public Address(String city, String country) {
		this.city = city;
		this.country = country;
	}

	// Copy Contructor :
	public Address(Address address) {
		this(address.getCity(), address.getCountry());
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + "]";
	}
	
	public Address getInstance(Address address) {
		return new Address(city, country);
	}

}
