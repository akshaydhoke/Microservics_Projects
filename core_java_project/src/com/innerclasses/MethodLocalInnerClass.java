package com.innerclasses;
// https://java.scjp.jobs4times.com/inner.htm
// https://www.geeksforgeeks.org/inner-class-java/

// Method local inner classes:

/* Method local inner class can’t be marked as private, protected, static, and transient .
 *  but can be marked as abstract and final, but not both at the same time.
*/

class Outer1 {
	
	void methodLocal() {
		System.out.println("In methodLocal() method");
	    int a=100;
		int x = 99;
		class Inner {
			void innerMethod() {
				System.out.println("x : " + x);
				System.out.println("a : " + a);
			}
		}
		Inner inner = new Inner();
		inner.innerMethod();
	}
}

public class MethodLocalInnerClass {
	public static void main(String[] args) {

		Outer1 outer1 = new Outer1();
		outer1.methodLocal();
	}

}
