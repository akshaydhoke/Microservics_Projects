package com.design.pattern.abstractfactory;

public class AndroidDeveloper implements Employee {

	@Override
	public double salary() {
		return 40000;
	}

	@Override
	public void designation() {
       System.out.println("I am Android Developer");
	}

}
