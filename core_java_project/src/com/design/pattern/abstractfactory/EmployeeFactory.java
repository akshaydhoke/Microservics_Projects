package com.design.pattern.abstractfactory;

public class EmployeeFactory {

	Employee getEmployee(EmployeeAbstractFactory empFactory) {
		return empFactory.createEmployee();
	}
}
