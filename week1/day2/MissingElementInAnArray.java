package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) 
	{
		int[] arr = {22,21,23,24,25,26,28};
		
		Arrays.sort(arr);
		
		int temp = arr[0];
		
		for(int i=0;i < arr.length;i++)
		{
			//System.out.println(i);
			
			if((i+temp)!=arr[i])
			{
				System.out.println(i+temp);
				break;
				
			}
			
		}
		
	}

}
