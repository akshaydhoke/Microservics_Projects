package com.gc;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) throws Throwable {

		
		String string = new String();
		Test1 test1 = new Test1();
		
		test1.finalize();
		test1.finalize();
		
		test1 = null;
//		string = null;

		System.gc();
		System.out.println("End of gc method");

	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Final method called just beafore GC() ......");
	}

}
