package com.collectorsmethod;

import java.security.Identity;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//https://medium.com/swlh/java-collectors-and-its-20-methods-2fc422920f18

public class CollectorsProgram {

	public static void main(String[] args) {

		System.out.println("------------------------ 1 -------------------------------------");

		/*
		 * 1. Creating list: toList() It is used to accumulate elements into a list. It
		 * will create a new list (It will not change the current list).
		 */

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 6);
		List<Integer> list= integers.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println("toList() >>>>"+ list); // output: [1,4,9,16,25,36,36]

		System.out.println("-------------------------- 2 -----------------------------------");
		
		/*
		 * 2. Creating set: toSet() It is used to accumulate elements into a set, It
		 * will remove all the duplicate entries.
		 */
		List<Integer> set = Arrays.asList(1,2,3,4,5,6,6);
		Set<Integer> setIntegers= set.stream().map(x -> x*x).collect(Collectors.toSet()); 
		System.out.println("toSet() >>>>"+ setIntegers); // output: [1,4,9,16,25,36,36]

		System.out.println("-------------------------- 3 -----------------------------------");

		/*
		 * 3. Creating specific collection: toCollection() We can accumulate data in any
		 * specific collection as well.
		 */
		List<Integer> list1= Arrays.asList(1,2,3,4,5,6,6);
	    LinkedList<Integer>toCollectionList=list.stream().filter(x-> x>3).collect(Collectors.toCollection(LinkedList::new));
		System.out.println("toCollection() >>>>"+ toCollectionList); // output: [1,4,9,16,25,36,36]

		System.out.println("-------------------------- 4 -----------------------------------");
		
		/*
		 * 4. Counting elements: Counting() It will return the number of elements
		 * present in the computed collection.
		 */
		
		List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,6);
		Long CountingList = list2.stream().filter(x -> x <4).collect(Collectors.counting());
		System.out.println("Counting() >>>> "+ CountingList); // output: 3

		
		System.out.println("------------------------- 5 ------------------------------------");

		/*
		 * 5. Finding minimum/max value: minBy() and maxBy() It will return the minimum value present in
		 * a list.
		 */

		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,6);
		List<String> stringList = Arrays.asList("alpha","beta","gamma");
//		Natural Order ::
		
		int minValueInt=intList.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
		System.out.println( " min value from Integer List >>>> " + minValueInt);
		
		String stringMinValue=stringList.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
		System.out.println( " min value from String List >>>> " + stringMinValue);

//		Reverse Order ::
		
		int maxValueInt=intList.stream().collect(Collectors.minBy(Comparator.reverseOrder())).get();
		System.out.println( " Max value from Integer List >>>> " + maxValueInt);
		
		String stringMaxValue=stringList.stream().collect(Collectors.minBy(Comparator.reverseOrder())).get();
		System.out.println( " Max value from String List >>>> " + stringMaxValue);
		
		System.out.println("--------------------------- 6 ----------------------------------");

		int maxIntgerValue=intList.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
		System.out.println( " Using maxBy() value from Integer List >>>> " + maxIntgerValue);
		
		System.out.println("---------------------------- 7 ---------------------------------");

//		7. Partitioning a list: partitioningBy()
//		It is used for partitioning a list into 2 lists and adding it to the map, 
		
		List<String> ll = Arrays.asList("a","alpha","beta","gamma");
        Map<Boolean,List<String>> partitionList = ll.stream().collect(Collectors.partitioningBy(x -> x.length()>2));		

		System.out.println( " partitioningBy() uses >>>> " + partitionList);

		System.out.println("---------------------------- 8 ---------------------------------");

		/*
		 * 8. Creating unmodifiable list: toUnmodifiableList() It is used to create a
		 * read-only list. Any try to make a change in this unmodifiable list will
		 * result in UnsupportedOperationException.
		 */
		
		List<String> l3 = Arrays.asList("alpha","beta","gamma");
//		List<String> collect2 = l3.stream().collect(Collectors.toUnmodifiableList()); // output: ["alpha","beta","gamma"]

				
	    List<String> strings = Arrays.asList("alpha","beta","gamma","alpha");
//		Set<String> readOnlySet = strings.stream().sorted().collect(Collectors.toUnmodifiableSet());  // output: ["alpha","beta","gamma"]

		System.out.println("---------------------------- 9 ---------------------------------");

		/*
		 * 9. Joining elements: joining() Collectors can be used to create a string by
		 * joining all the elements of a collection, with or without any delimiter,
		 * suffix, and prefix.
		 */
//		distinct()  ==> It removes duplicate from the stream
		
		List<String> l4 = Arrays.asList("alpha","beta","gamma");
		
//		String joiningList =l4.stream().distinct().collect(Collectors.joining(","));

		String joiningList =l4.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(",","[","]"));

		System.out.println( " joining() mehod >>>> " + joiningList);

		System.out.println("---------------------------- 10 ---------------------------------");

		/*
		 * 10. Averaging long: averagingLong() averagingInt() averagingDouble()
		 * 
		 * Finds the average value of a collection of long values.
		 * 
		 * NOTE: It will return a Double value, not a long value.
		 */

		List<Long> longValues = Arrays.asList(100l,200l,300l);
		Double d1 = longValues.stream().collect(Collectors.averagingLong(x -> x * 2)); // output: 400.0

		System.out.println( " averagingLong() mehod >>>> " + d1);

		System.out.println("---------------------------- 11 ---------------------------------");

		/*
		 * 11. Creating Map: toMap() Creates a map from the values of a collection.
		 */

		List<String> l5 = Arrays.asList("alpha","beta","gamma");
		Map<String,Integer> map = l5.stream().collect(Collectors.toMap(Function.identity(),String::length));  // output: {alpha=5, beta=4, gamma=5}
		System.out.println( " toMap() mehod >>>> " + map);

		System.out.println("---------------------------- 12 ---------------------------------");

		
		/* 12. Handling duplicates entries of the list while creating a map */

		List<String> l6 = Arrays.asList("alpha","beta","gamma","beta");
		Map<String, Integer> duplicateList=l6.stream().collect(Collectors.toMap(Function.identity(), String :: length, (i1,i2)-> i1));
		System.out.println(" Handling duplicates >>> " + duplicateList);
		
		System.out.println("---------------------------- 13 ---------------------------------");

//		13. Summing Integers: summingInt()
		
//		String ::
		List<String> strList = Arrays.asList("alpha","beta","gamma");
		
	    int sumString = stringList.stream().collect(Collectors.summingInt(String::length));

		System.out.println(" Sum of String >>> " + sumString);
		
//		Integer ::
		
		List<Integer> intList1 = Arrays.asList(1,2,3,4,5,6,6);
        int sumInteger= intList1.stream().collect(Collectors.summingInt(x->x));
		System.out.println(" Sum of Integer >>> " + sumInteger);

//		Double ::
		
		List<Double>  doubleValues = Arrays.asList(1.1,2.0,3.0,4.0,5.0,5.0);
		double doubleList=doubleValues.stream().collect(Collectors.summingDouble(x->x));
		System.out.println(" Sum of Double >>> " + doubleList);
		
//		Long ::
		List<Long> longValues1 = Arrays.asList(100l,200l,300l);
		Long longList = longValues1.stream().collect(Collectors.summingLong(x->x));
		System.out.println(" Sum of Long Values >>> " + longList);

		System.out.println("---------------------------- 14 ---------------------------------");
		
		/*
		 * 14. Summarizing Integer: summarizingInt() It gives all the major arithmetic
		 * operation values of the values present in the collection like the average of
		 * all values, minimum value, maximum values, count, and sum of all values.
		 */
		
		/*
		 * Class IntSummaryStatistics. A state object for collecting statistics such as
		 * count, min, max, sum, and average.
		 */		
		List<Integer> integers2 = Arrays.asList(1,2,3,4,5,6,6);
		IntSummaryStatistics status =integers2.stream().collect(Collectors.summarizingInt(x->x));
        System.out.println(" summarizingInt() >>>> " + status);
        System.out.println(" Count :: "+ status.getCount());
        System.out.println(" Max value  :: "+ status.getMax());
        System.out.println(" Average :: "+ status.getAverage());
        System.out.println(" Sum of Integer :: "+ status.getSum());

		System.out.println("---------------------------- 15 ---------------------------------");

		/*
		 * 15. GroupingBy method: groupingBy() GroupingBy() is an advance method to
		 * create a map out of any other collection
		 */
		
		List<String> list7 = Arrays.asList("alpha","beta","gamma");
		
	    Map<Integer, List<String>> mapList=list7.stream().collect(Collectors.groupingBy(String :: length));
        System.out.println(" Map List >>>>   "+ mapList);
        
        Map<Object, List<String>> mapList2= list7.stream().collect(Collectors.groupingBy(String :: length, Collectors.toCollection(LinkedList::new)));
        System.out.println(" Map LinkedList List >>>>   "+ mapList2);

        List<String> list8= Arrays.asList("geeks", "for","akshay", "geeks","akshay");
        Map<Object, Long> mapList8 =list8.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.println(" Map count repeated List >>>>   "+ mapList8);

		
        

				
	}
}
