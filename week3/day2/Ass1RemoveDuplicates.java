package week3.day2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ass1RemoveDuplicates {

	public static void main(String[] args) 
	{
		String input = "PayPal India";
		char[] chArr = input.toCharArray();
		
		Set<Character> charSet = new LinkedHashSet<Character>(); 
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		
		System.out.println(chArr);
		
//		Iterate character array and add it into charSet
//		if the character is already in the charSet then, add it to the dupCharSet
		for (Character temp : chArr) 
		{
			if(!charSet.add(temp)) 
			{
				dupCharSet.add(temp);
			}
		}
		
		//duplicate values gets stored in dupcharset and distinct values gets stored in charSet
		System.out.println("Printing duplicate values");
		for (Character temp : dupCharSet) 
		{
			System.out.println(temp);
		}

		//duplicate values
		System.out.println("Printing distinct values which are in charSET values");
		for (Character temp : charSet) 
		{
			System.out.println(temp);
		}

		//matching record set will get removed
		charSet.removeAll(dupCharSet);
		
		for (Character distinct : charSet) {
			if(distinct!= ' ')
			{
			 System.out.print(distinct);
			}
		}
		
	}

}
