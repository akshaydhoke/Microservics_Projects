package com.design.pattern.abstractfactory;

public class Client {
	public static void main(String[] args) {

		Employee e1 = new EmployeeFactory().getEmployee(new JavaDeveloperFactory());
		e1.designation();
		System.out.println(e1.salary());

		Employee e2 = new EmployeeFactory().getEmployee(new AndroidDeveloperFactory());
		e2.designation();
		System.out.println(e2.salary());

	}
}
