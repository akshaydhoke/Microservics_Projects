package com.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Person implements Externalizable {
	String name;
	int i;
	int j;

	public Person() {
		System.out.println("Default contructor called");
	}

	public Person(String name, int i, int j) {
		this.name = name;
		this.i = i;
		this.j = j;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(i);

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = (String) in.readObject();
		i=in.readInt();

	}

}

public class ExternalizationDemo {
	public static void main(String[] args) {

		try {
			
			Person person=new Person("Akshay", 12, 20);

			FileOutputStream fos = new FileOutputStream("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/com/serialization/file.txt");
			ObjectOutputStream oos=new  ObjectOutputStream(fos);
			oos.writeObject(person);
			
			FileInputStream fis=new FileInputStream("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/com/serialization/file.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			Person personRead =(Person)ois.readObject();
			System.out.println(personRead.i + ":"+personRead.j+":"+personRead.name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
