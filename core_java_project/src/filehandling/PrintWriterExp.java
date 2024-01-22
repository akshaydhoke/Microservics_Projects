package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExp {

	public static void main(String[] args) {

		try {
			
			BufferedWriter bw=new BufferedWriter(new FileWriter("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/filehandling/abc.text"));
			PrintWriter out=new PrintWriter(bw);
			out.println(100);
			out.println("Akshay");
			out.println("Software Developer");
			out.close();
			bw.close();
//			System.out.println("File1 data save successfully");
			
		    BufferedWriter bw2	= new BufferedWriter(new FileWriter("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/filehandling/abc2.text"));
			PrintWriter out2=new PrintWriter(bw2);
			out2.println(200);
			out2.println(300);
			out2.println("Aurus Inc Pune");
			out2.close();
			bw2.close();
//			System.out.println("File2 data save successfully");
			
			
			BufferedReader br = new BufferedReader(new FileReader("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/filehandling/abc.text"));
			BufferedReader br2 = new BufferedReader(new FileReader("/home/adhoke@offaurusinc.com/eclipse-workspace/StringProject/src/filehandling/abc2.text"));

			String line1 = br.readLine();
			String line2 = br2.readLine();
			
			while (line1 != null || line2 != null) {
				if(line1 != null) {
				System.out.println(line1);
				line1 = br.readLine();
				}
				
				if(line2 !=null) {
					System.out.println(line2);
					line2 = br2.readLine();
				}
			}
			
			br.close();
			br2.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
