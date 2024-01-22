package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://www.geeksforgeeks.org/stream-flatmap-java-examples/

//IntflatMap >> 
//https://www.geeksforgeeks.org/intstream-flatmapintfunction-mapper-java/?ref=rp




public class StreamMapExp {
	public static void main(String[] args) {

//   printing list values :
		
     List<String> intValues= Arrays.asList("1.2","1.3","1.4","1.5");
     intValues.stream().flatMap(s-> Stream.of(s)).forEach(System.out::println);
     
//   printing stream values of charAt [1] of each element:
     
     List<String> stringValues = Arrays.asList("Google", "GFG","Geeks", "gfg");
     stringValues.stream().flatMap(str->Stream.of(str.charAt(1))).forEach(System.out::println);;
     
//   multiple list into single stream:
     
     List<Integer> intList=Arrays.asList(10,20,30,40,50);
     
     List<Integer> intList2=Arrays.asList(60,70,80,90,100);
     
     List<Integer> intList3=Arrays.asList(110,110,120,130);
     
     List<List<Integer>> finalList=Arrays.asList(intList,intList2,intList3);
     
     List<Integer> outputList= finalList.stream().flatMap(list->list.stream()).collect(Collectors.toList());
     
     System.out.println(outputList);

//    IntStream flatMap(IntFunction mapper) >>
     System.out.println("---------------------- IntStream()  --------------------------------------");
     
     IntStream intStream = IntStream.of(100,200,300,400,500);
     
     intStream.flatMap(num->IntStream.of(num*10)).forEach(System.out::println);
     
     
     

     
     
     
		
	}
}
