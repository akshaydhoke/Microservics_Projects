package com.javanew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

interface NamesInterface {

//	default List<String> fetchInitialData() {
//
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass()
//				.getResourceAsStream("/home/adhoke/Music/Practice_workspace/StringProject/src/com/javanew/index")))) {
//			return namesList(br);
//		} catch (Exception e) {
//			System.out.println("Exception in fetchInitialData() " + e);
//			return null;
//		}
//	}

//	private List<String> namesList(BufferedReader br) throws IOException {
//
//		List<String> names = new ArrayList<String>();
//		String name;
//		while ((name = br.readLine()) != null) {
//			names.add(name);
//		}
//		return names;
//	}
}

class TestingNames implements NamesInterface {

}

public class PrivateInterfaceExp {
	public static void main(String[] args) {

		TestingNames testingNames=new TestingNames();
	}

}
