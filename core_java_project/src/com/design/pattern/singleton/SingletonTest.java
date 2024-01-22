package com.design.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class SingletonTest {
	public static void main(String[] args) throws Exception {

		// Reflection Api: enums are used because java ensures internally that the enum
		// value is instantiated only once
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = null;

		Constructor[] constructors = Singleton.class.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			obj2 = (Singleton) constructor.newInstance();
		}
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		// Serialization : Overcome serialization issue:- To overcome this issue, we have to implement the method readResolve() method. 

	/*	Singleton instance1 = Singleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/com/design/pattern/singleton/file1.txt"));
		out.writeObject(instance1);
		out.close();

		// deserialize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/com/design/pattern/singleton/file1.txt"));

		Singleton instance2 = (Singleton) in.readObject();
		in.close();

		System.out.println("instance1 hashCode:- " + instance1.hashCode());
		System.out.println("instance2 hashCode:- " + instance2.hashCode());*/
		
// Overcome Cloning issue: To overcome this issue, override clone() method and throw an exception from clone method that is CloneNotSupportedException.
		
	  Singleton cloneObj= Singleton.getInstance();
	  Singleton cloneObj2 = (Singleton) cloneObj.clone();
	  
	  System.out.println("********** Cloning Exps *************");
	  System.out.println(cloneObj.hashCode());
	  System.out.println(cloneObj2.hashCode());

	}

}
