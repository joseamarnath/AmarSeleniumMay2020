package week1.day1;

import cucumber.api.Result;

public class Factorial 
{

	Factorial f = new Factorial();
	
	public static void main(String[] args) 
	{
		int inputNumber=6;
		int fact=1;
		
		for(int i=inputNumber;i>=1;i--)
		{

			//System.out.println("value ofI is " +i);
			//System.out.println("value of Fact is " +fact);
			fact = i*fact;
			//System.out.println("Result: " +fact);
		}
		
		//System.out.println(inputNumber);
		System.out.println("Factorial of " +inputNumber+ " is " +fact);

	}

}
