package com.innerclasses;
// https://www.geeksforgeeks.org/inner-class-java/
// Inner Classes ;

class Outer {

	int i = 10;

	class Inner {

		void innerMethod() {
			System.out.println("Inner Method");
		}
	}

}

public class InnerClassesExp {

	public static void main(String[] args) {
		
		Outer.Inner obj=new Outer().new Inner();
		
		obj.innerMethod();
	}
}
