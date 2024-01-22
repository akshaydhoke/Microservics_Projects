package com.design.pattern.abstractfactory;

public class AndroidDeveloperFactory extends EmployeeAbstractFactory {

	@Override
	Employee createEmployee() {
		return new AndroidDeveloper();
	}

}
