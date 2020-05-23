package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ass2SortingUsingCollection {

	public static void main(String[] args) {
	
		List<String> val = new ArrayList<String>(); 
		val.add("HCL");
		val.add("Wipro");
		val.add("Aspire Systems");
		val.add("CTS");
//		val.add("100%");
//		val.add("30%");
//		val.add("80%");
//		val.add("80%");
		
		Collections.sort(val);
		
		System.out.println("Size is "+val.size());
	
		
		for (int i=(val.size()-1);i>=0;i--) {
			
			System.out.println(val.get(i));
		}

	}

}
