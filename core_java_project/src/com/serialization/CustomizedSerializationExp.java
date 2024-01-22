package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//http://java.scjp.jobs4times.com/serial.htm

import java.io.Serializable;

class Account implements Serializable {

	String name = "Akshay";
	transient String pwd = "Dhoke";

	private void writeObject(ObjectOutputStream oos) throws Exception {
		oos.defaultWriteObject();
		String epwd = "123" + pwd;
		oos.writeObject(epwd);
	}

	private void readObject(ObjectInputStream ois) throws Exception {
		ois.defaultReadObject();
		String epwd = (String) ois.readObject();
		pwd = epwd.substring(3);
	}

}

public class CustomizedSerializationExp {
	public static void main(String[] args) {
		try {

			Account account=new Account();
			
			FileOutputStream fos = new FileOutputStream("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/com/serialization/file.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(account);
			
			FileInputStream fis=new FileInputStream("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/com/serialization/file.txt");
			ObjectInputStream ois= new ObjectInputStream(fis);
			Account acc=(Account)ois.readObject();
			System.out.println(acc.name +"------------"+ acc.pwd);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
