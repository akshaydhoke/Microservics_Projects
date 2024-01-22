package com.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student {
	int id;
	String name;
	float fees;

	public Student(int id, String name, float fees) {
		this.id = id;
		this.name = name;
		this.fees = fees;
	}

	public float getFees() {
		return fees;
	}
}

public class JavaStreamExample {
	public static void main(String[] args) {

		List<Student> productsList = new ArrayList<Student>();

		// Adding Products
		productsList.add(new Student(1, "HP Laptop", 25000f));
		productsList.add(new Student(2, "Dell Laptop", 30000f));
		productsList.add(new Student(3, "Lenevo Laptop", 28000f));
		productsList.add(new Student(4, "Sony Laptop", 28000f));
		productsList.add(new Student(5, "Apple Laptop", 90000f));
		
//		Using old technique:
		List<Float> studentPriceList = new ArrayList<Float>();
		for (Student std : productsList) {
			if (std.fees < 30000) {
				studentPriceList.add(std.fees); 
			}
		}
		System.out.println(" Normal List :: "+ studentPriceList);
		
//		Filtering >>
//		Using stream filter() method ::
		
	    List<Float> stdList=productsList.stream().filter(s-> s.fees<30000).map(s->s.fees).collect(Collectors.toList());
	    System.out.println(" Using stream() Function :: "+ stdList);
	    
//        Stream.of("apple","mango","orange").filter(x->x.matches("^[aeiou].*")).forEach(System.out::print);   
	    
//	    Iterating list using forEach ::
	    
	    productsList.stream().filter(i->i.fees==30000f).forEach(l->System.out.println(" SAME PRICE NAMES :: "+l.name));
	    
//	    reduce() Function in stream Api::
	    
	    Float reducePriceFloat= productsList.stream().map(j -> j.fees).reduce(0.0f,(sum, num)-> (sum+num));
	    System.out.println(" reducePriceFloat  value:: "+ reducePriceFloat);
	    
	   Float reduceFloat= productsList.stream().map(k-> k.fees).reduce(0f,Float::sum);
	   System.out.println(" reduceFloat value :: "+ reduceFloat);
	   
//	   Using counting sum of fees of price ::
	   
	   Double totalPrice= productsList.stream().collect(Collectors.summingDouble(p->p.fees));
	   System.out.println(" TotalPrice :: " + totalPrice);
	   
//	   Using stream Api max and min function getting max/min value :: 
	   
	   Student minValueStudent=productsList.stream().min((std1,std2)->std1.fees>std2.fees?1:-1).get();
	   System.out.println(" MIN VALUE ::"+ minValueStudent.fees);
	   
	   Student maxValueStudent=productsList.stream().max((std1,std2)->std1.fees>std2.fees?1:-1).get();
	   System.out.println(" MAX VALUE ::"+ maxValueStudent.fees);

//	   Using count function ::
	   
	   Long countValue= productsList.stream().filter(c-> c.fees>25000f).count();
	   System.out.println(" COUNT VALUE IS ::"+ countValue);
	   
//	   List convert into Set ::
	   
	   Set<Float> setList= productsList.stream().filter(fe->fe.fees>28000f).map(fe->fe.fees).collect(Collectors.toSet());
	   System.out.println(" LIST OF SET IS :: "+ setList);
	   
//	  Using Method referances :: 
	   
	   List<Float> streamList = productsList.stream().filter(ff->ff.fees>28000f).map(Student::getFees).collect(Collectors.toList());
	   System.out.println(" LIST OF FEES USING METHOD REFERANCE :: "+ streamList);
	   
//	   List convert into Map ::
	   
	  Map<Integer,String> mapList= productsList.stream().collect(Collectors.toMap(iD->iD.id, n->n.name));
	  System.out.println(" LIST OF MAP IS :: "+ mapList);
	  
	  System.out.println("------------------  Truncating Stream  -------------------");
//	  Truncating Stream [ limit, skip ] >>
//	  Stream<T> limit(long maxSize)
//	  Stream<T> skip(long n)
	  
//	  limit :
	  Stream<Integer> limitStream=Stream.of(1,2,3,4,5);
	  List<Integer> limitList=limitStream.filter(x->x%2==0).limit(2).collect(Collectors.toList());
      System.out.println("limit :: "+ limitList);
      
//    skip:
	 Stream<Integer> limitStream2=Stream.of(1,2,3,4,5);
     List<Integer> skipList = limitStream2.filter(x->x%2==0).skip(0).collect(Collectors.toList());
     System.out.println("skip :: "+ skipList);

//   Consuming Stream [ forEach, peek] >>
//   Stream<T> peek(Consumer<? super T> action)
//   void forEach(Consumer<? super T> action)

	 System.out.println("------------------  Consuming Stream  -------------------");
     
     Stream<Integer> consumerList=Stream.of(1,4,-3,2,9,10);
//     consumerList.filter(x->x%2==0).forEach(System.out::println);
     
//     consumerList.filter(x->x%2==0).forEachOrdered(System.out::println);
     
     consumerList.filter(x->x%2==0).peek(System.out::println).toArray();
 
	  System.out.println("------------------  File Related Stream Api  -------------------");

//    Files: 
//	  For more info >> file1.
	  
		try {
			List<String> words=Files.lines(Paths.get("/home/adhoke/Music/Practice_workspace/StringProject/src/com/java8/file1"))
			.filter(line->!line.startsWith("D"))
			.map(String::toUpperCase)
			.collect(Collectors.toList());
			
			System.out.println(words);

		} catch (IOException e) {
			System.out.println("Exceptions in Files of Stream ");
			e.printStackTrace();
		}
		
//		Matching: 
//		anyMatch: Returns true
	  System.out.println("------------------  Matching Stream Api  -------------------");
	
	  System.out.println("anyMatch : "+ Stream.of(1,2,3,4,5).anyMatch(x->x%2==0));
	  System.out.println("allMatch : " + Stream.of(1,2,3,4,5).allMatch(x->x%2==0));
	  System.out.println("noneMatch : " + Stream.of(1,2,3,4,5).noneMatch(x->x%2==0));

//	  Finding element: 
//	  Optional<T> findFirst()     Optional<T> findAny()
	  System.out.println("------------------  Finding element Stream Api  -------------------");
	  
	  System.out.println("findAny : "+ Stream.of(1,2,3,4,5).filter(i->i%2==0).findAny().orElse(0));
	  
	  System.out.println("findFirst :" + Stream.of(10,20,30,40).map(e->e*2).findFirst().get());
	  
//	  Stream Reduction :
	  System.out.println("------------------  Reduction Stream Api  -------------------");
	  
      OptionalInt reduceValue = IntStream.range(1, 5).reduce((a,b)-> a+b);
      System.out.println(" OptionalInt : "+ reduceValue);
      
      int reduceValue2 = IntStream.range(1, 5).reduce(0,(a,b)-> a+b);
      System.out.println(" int : "+ reduceValue2);
      
      int reducedParams = Stream.of(1, 2, 3)
    		  .reduce(100, (a, b) -> a + b, (a, b) -> {
    		     System.out.println("combiner was called");
    		     return a + b;
    		  });
      
      System.out.println("FILL IMPLEMENTATION : "+ reducedParams);
      
      int streamIntValue = Stream.iterate(1, v -> v+3).filter(i->i%5==0).findAny().get();
      System.out.println("Stream iterator : "+ streamIntValue);
      
      System.out.println("******************* fibonacci series ******************************8");      
      
   // Generating fibonacci numbers of a given length
      
      Stream.iterate(new int[] { 0, 1 }, a -> {
          int next = a[0] + a[1];
          a[0] = a[1];
          a[1] = next;
          return a;
      }).limit(10).map(a -> a[0]).forEach(res->System.out.print(" "+ res));
      System.out.println();

//      Output: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
      
	  
	}
}
 