package com.collectorsmethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java8.PredicateFunctionExp;

public class ProductData {

	public static void main(String[] args) {

		String productDataString ="3%1F1%1FMCC%1F10000000000000000000138704482339%1F%1F%1F%1F511360XXXXXX1037%1F19.19%1F%1F%1F%1F%1F%1D3%1F1%1FMCC%1F10000000000000000000138704482339%1F%1F%1F%1F511360XXXXXX1037%1F19.19%1F%1F%1F%1F%1F%1D4%1F1%1FMCC%1F10000000000000000000138704482339%1F%1F%1F%1F511360XXXXXX1037%1F19.19%1F%1F%1F%1F%1F%1D5%1F1%1FMCC%1F10000000000000000000138704512341%1F%1F%1F%1F511360XXXXXX1037%1F19.19%1F%1F%1F%1F%1F%1D6%1F1%1FMCC%1F10000000000000000000138704512341%1F%1F%1F%1F511360XXXXXX1037%1F19.19%1F%1F%1F%1F%1F%1D";
		
		String[] ptrStrings = productDataString.split("%1D");
		List<String[]> string = new ArrayList<>(ptrStrings.length);
		for (int i = 0; i < ptrStrings.length; i++) {
			string.add(ptrStrings[i].split("%1F"));
		}

		if(checkIds(string)){
			System.out.println("Tender Id is Duplicate");
		}else {
			System.out.println("Tender Id is Unique");
		}
	
		
//		try {
//			if(tenderPermission(productDataString)){
//				System.out.println("Tender Id is Duplicate");
//			}else {
//				System.out.println("Tender Id is Unique");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private static boolean checkIds(List<String[]> lists) {
		boolean flag = false;
		List<String> list = new ArrayList<>();
		List<String> items = new ArrayList<>();

		for (int j = 0; j < lists.size(); j++) {
			for (String s : lists.get(j)) {
				list.add(s);
			}
		}

		int j = 0;
		for (int i = 0; i < lists.size(); i++) {
			items.add(list.get(j));
			j = j + 9;
		}

		System.out.println(items);

		for (int first = 0; first < items.size(); first++) {
			for (int second = first + 1; second < items.size(); second++) {
				if (items.get(first).equals(items.get(second))) {
					System.out.println("Duplicate : " +  items.get(first));
					List duplicateList=Arrays.asList("2","3");
					if( duplicateList.contains(items.get(first))){
						return true;
					}
				}
			}
		}

		return flag;
	}
	
    public static boolean tenderPermission(String s) {
        String st = s;
        String[] str = st.split("%1D");
        ArrayList<String> al = new ArrayList<String>();
        for (int i = 0; i <= str.length - 1; i++) {
            String[] str2 = str[i].split("%1F");
            
            al.add(str2[0]);
        }
        
        System.out.println(al);
        
        int id2 = 0, id3 = 0;
        for (String arl : al) {
            if (arl.contains("2")) {
                id2++;
            }
            if (arl.contains("3")) {
                id3++;
            }
        }
        if (id2 > 1 || id3 > 1) {
            return false;
        } else
            return true;
    }
}
