package com.design.pattern.abstractfactory;

public class JavaDeveloper implements Employee {

	@Override
	public double salary() {
		return 35000;
	}

	@Override
	public void designation() {
		System.out.println("I am Java Developer");
	}

}
