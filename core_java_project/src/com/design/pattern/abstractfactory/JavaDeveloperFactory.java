package com.design.pattern.abstractfactory;

public class JavaDeveloperFactory extends EmployeeAbstractFactory {

	@Override
	Employee createEmployee() {
		return new JavaDeveloper();
	}

}
