package com.immutableClass;
// selenium express

public class ImmutableClassExp {
	public static void main(String[] args) {

		// Mutable Case :
		// Student std = new Student(1, "Akshay");
		// System.out.println(std.getStdId() + " : " + std.getStdName());

		// Mutable Case1:

/*		Address address = new Address("Amravati", "India");
		Student student = new Student(1, "Akshay", address);
		System.out.println(student);

		address.setCity("Akola");
		address.setCountry("India");
		System.out.println(student);*/

		// Immutable Copy-Obj Case2:
		
		Address address = new Address("Amravati", "India");
		Student student = new Student(1, "Akshay", address);
		System.out.println("Address1 : "+ address.hashCode());
		System.out.println(student);

		Address address2 = student.getAddress();
		address2.setCity("Akola");
		address2.setCountry("India");
		
		System.out.println("Address2 : "+ address2.hashCode());
		System.out.println(student);

	}
}
