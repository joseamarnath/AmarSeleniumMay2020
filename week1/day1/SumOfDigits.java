package week1.day1;

public class SumOfDigits 
{
	public static void main(String[] args) 
	{
		int inputNumber = 555;
		int sum = 0;
		
		do 
		{
			int remainder = inputNumber%10;
			System.out.println("remainder is: "+remainder);
			
			inputNumber = inputNumber/10;
			System.out.println("Quotient is "+inputNumber);
			
			sum = sum+remainder;
			System.out.println("Sum is: "+sum);
			
			
		}while(inputNumber!=0);
		
	}

}
