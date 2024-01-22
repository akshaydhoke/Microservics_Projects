package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.*;


class CardDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private int card;
	private long token;
	private String name;

	CardDetails() {
	}

	public CardDetails(int card, Long token, String name) {
		super();
		this.card = card;
		this.token = token;
		this.name = name;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	};

	@Override
	public String toString() {
		return "CardDetails [card=" + card + ", token=" + token + ", name=" + name + "]";
	}
}

public class WriterReader {

	public static void main(String[] args) {
		
		List<CardDetails> cardDetails = Arrays.asList(
			new CardDetails(12345,420000001l,"kiran"),
			new CardDetails(12346,420000001l,"Akshay"),	
			new CardDetails(12347,420000001l,"Vijay")	,
			new CardDetails(12347,420000001l,"Prakash")	

		);
		
		List<CardDetails> cardDetails2 = Arrays.asList(
				new CardDetails(12348,420000001l,"kiran"),
				new CardDetails(12349,420000001l,"Akshay"),	
				new CardDetails(12350,420000001l,"Vijay")	,
				new CardDetails(12350,420000001l,"Prakash")	

			);

		try {
			File f1 = new File("/home/adhoke/Music/Practice_workspace/StringProject/src/filehandling/File1");
			File f2 = new File("/home/adhoke/Music/Practice_workspace/StringProject/src/filehandling/File2");
			File f3 = new File("/home/adhoke/Music/Practice_workspace/StringProject/src/filehandling/File3");

/*
			// Write objects to file1
			BufferedWriter wtr = new BufferedWriter(new FileWriter(f1));
			
			for (CardDetails cd : cardDetails) {
				wtr.write(cd.getCard() + "," + cd.getToken() + "," + cd.getName() +"\n");
			}
			
			// Write objects to file2
			BufferedWriter wtr2 = new BufferedWriter(new FileWriter(f2));

			for (CardDetails cd2 : cardDetails2) {
				wtr2.write(cd2.getCard() + "," + cd2.getToken() + "," + cd2.getName() +"\n");
			}

			wtr.close();
			wtr2.close();
			
			*/

//			Reading Files::
			
			BufferedReader enBr = new BufferedReader(new FileReader(f1));
			BufferedReader frBr = new BufferedReader(new FileReader(f2));

			List<String> readAllFiles=new ArrayList<>();
			while (true) {
				String partOne = enBr.readLine();
				String partTwo = frBr.readLine();

				if (partOne == null || partTwo == null) {
					break;
				}
				readAllFiles.add(partOne);
				readAllFiles.add(partTwo);

			}
			
            List<String> ll=new ArrayList<>();
            
            System.out.println(readAllFiles);
			
			for (String s1 : readAllFiles) {
				String[] s5 = s1.replace(" ", ",").split(",");
				for (String s6 : s5) {
					ll.add(s6);
				}
			}
			
			System.out.println(">>>"+ ll);
			
			List<CardDetails> cdList=new ArrayList<>();
			for (int i = 0; i < ll.size(); i+=3) {
				cdList.add(new CardDetails(Integer.parseInt(ll.get(i)),Long.parseLong(ll.get(i+1)),ll.get(i+2)));
			}
			
			System.out.println(cdList);
			
			
//			 Write Non-duplicate objects to file3 :: 
			
			BufferedWriter wtr3 = new BufferedWriter(new FileWriter(f3));
			
//			Non-duplicate ::
			
			for (int i = 0; i < cdList.size(); i++) {
				boolean dup = false;
				for (int j = 0; j < cdList.size(); j++) {
					if (i != j && cdList.get(i).getCard() == cdList.get(j).getCard()) {
						dup = true;
						break;
					}
				}
				if (!dup) {
					System.out.println(cdList.get(i));
					wtr3.write(cdList.get(i).getCard() + "," + cdList.get(i).getToken() + "," + cdList.get(i).getName() +"\n");
				}
			}
			
			wtr3.close();
			
//			Remove duplicate data ::
			
//			List<CardDetails> unique = cdList.stream().distinct().collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingInt(CardDetails::getCard))),ArrayList::new));	
//			System.err.println(unique);
			
            

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
