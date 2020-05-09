package week1.day2;

import java.util.Arrays;

public class PrintDuplicatesArray {

	public static void main(String[] args) 
	{
	
		//int[] arr = {21,13, 14, 13, 14,14};
		int[] arr = {21,14,12,13,11,15,22,18,16,17,20,18,17,20,24,16,24};
		Arrays.sort(arr);
		//System.out.println("len: "+arr.length);
		/*
		 * for(int k=0;k<arr.length;k++) { System.out.println(arr[k]); }
		 */
		int getLen = arr.length;
		
		int count=1;
		
		for(int i=0;i<arr.length;i++)
		{
			
			for(int j=i+1;j<getLen;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
					//System.out.println(arr[j]);
				}
				
			}
				if(count>1)
					System.out.println("Number: " +arr[i]+" has been duplicated "+count+ " times.");
					count = 1;
		}
		
	}

}
