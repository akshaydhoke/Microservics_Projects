package com.design.pattern.singleton;
// https://www.geeksforgeeks.org/singleton-design-pattern/

// How to prevent Singleton Pattern from Reflection, Serialization and Cloning? >>
// https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/?ref=ml_lbp

class SuperClass implements Cloneable {
    int i = 10;
 
    @Override
    protected Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }
}

public class Singleton extends SuperClass {
	private static Singleton obj;

	private Singleton() { 

	}
	
	public static Singleton getInstance() {
		if (obj == null) {
			synchronized (Singleton.class) {
				if (obj == null) {
					obj = new Singleton();
				}
			}
		}
		return obj;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return obj;
	}
}
