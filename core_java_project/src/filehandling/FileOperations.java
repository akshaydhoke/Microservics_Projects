package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {

	public static void main(String[] args) {

		try {

			File f = new File("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/filehandling/abc.text");
			System.out.println(f.createNewFile());

			System.out.println(f.isFile());
			System.out.println(f.isDirectory());
			System.out.println(f.exists());

			/*FileWriter fw = new FileWriter("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/filehandling/abc.text");

			char[] name = { 'A', 'K', 'S', 'H', 'A', 'Y' };
			fw.write(name);
			fw.flush();
			fw.close();

			FileReader fr = new FileReader(f);
			int i = 0;
			while (i != -1) {
				System.out.println((char) i);
				i = fr.read();
			}*/
			
			BufferedWriter bw= new BufferedWriter(new FileWriter("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/filehandling/abc.text"));
			bw.write("Akshay");
			bw.newLine();
			bw.write("Dhoke");
			bw.flush();
			bw.close();
			
			BufferedReader bf= new BufferedReader(new FileReader("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/filehandling/abc.text"));
			String line=bf.readLine();
			while(line != null) {
				System.out.println(line);
				line=bf.readLine();
			}
			bf.close();
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
