package com.array.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Testdat {

	public static void main(String[] args) {
		
		

		String[] mulitShippingData = null;
        String shippingData = null;
        List<String[]> multiShippingListNew = new ArrayList<>();

            shippingData = "%7ETom%7E%7ESmith%7E92 CROWFOOT TERR NW%7E%7E%7ECALGARY%7EAB%7ET3G 4J8%7EUGRD%7E%7ECA%7E123-456-7890%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E%7E";
            multiShippingListNew.add(Arrays.stream(shippingData.split("%7E",-1)).map(String::trim).toArray(String[]::new));
            
            
            for (int i = 0; i < multiShippingListNew.size(); i++) {
                mulitShippingData = multiShippingListNew.get(i);
                
                
            }
            
            for(String j:mulitShippingData) {
            System.out.println( "SHIPPING_EMAIL_ID : " + j);
            }
            
            
		
	}

}
