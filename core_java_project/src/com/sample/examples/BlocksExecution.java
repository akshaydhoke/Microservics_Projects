package com.sample.examples;

class Demo {

	static int variable;

	static {
		variable = 20;
		System.out.println(" IN Demo STATIC BLOCK ");
	}

	{
		System.out.println(" IN Demo INSTANCE INITIALIZER BLOCK ");
	}

	Demo() {
		System.out.println(" IN Demo CONTRUCTOR Demo() ");
	}

}

public class BlocksExecution extends Demo {

	static int variable;

	static {
		variable = 10;
		System.out.println(" IN BlocksExecution STATIC BLOCK ");
	}

	{
		System.out.println(" IN BlocksExecution INSTANCE INITIALIZER BLOCK ");
	}

	BlocksExecution() {
		System.out.println(" IN CONTRUCTOR BlocksExecution() ");
	}

	public static void main(String[] args) {

		System.out.println(" IN MAIN METHOD ");

		Demo obj = new BlocksExecution();
		
//		BlocksExecution obj2 = new BlocksExecution();


		 System.out.println(" STATIC VARIABLE : " + obj.variable);

	}

}
