package com.innerclasses;

// static inner classes:

class Outer2 {

	static class Inner2 {

		static void innerMethod() {
			System.out.println("In static inner method");
		}
	}

}

public class StaticInnerClasses {

	public static void main(String[] args) {

		Outer2.Inner2.innerMethod();
	}

}
