package com.innerclasses;

// Anonymous inner classes:

// Its working with classes and interfaces

class OuterClass {

	void show() {
		System.out.println("In OuterClass show() method");
	}
}

interface Interface {
	void display();
}

public class AnonymousInnerClasses {

	static OuterClass outerClass = new OuterClass() {
		void show() {
			super.show();
			System.out.println("Inner in anonymous class method");
		};
	};

	static Interface interface1 = new Interface() {

		public void display() {
			System.out.println("Inner in anonymous interface method");
		};
	};

	public static void main(String[] args) {

		outerClass.show();

		System.out.println("*****************************");

		interface1.display();

	}

}
