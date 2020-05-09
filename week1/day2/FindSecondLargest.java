package week1.day2;

import java.util.Arrays;

public class FindSecondLargest {

	public static void main(String[] args) 
	{
		int[] data = {3,2,11,4,6,7};
		
		Arrays.sort(data);  // sorting the array in ascending order
		for(int i: data)
		{
			System.out.println(i);
		}
		
		System.out.println(data[data.length-2]); //getting the second largest number from last and printing it
	}

}
