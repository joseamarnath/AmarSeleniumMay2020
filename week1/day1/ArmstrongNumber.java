package week1.day1;

public class ArmstrongNumber {

	public static void main(String[] args) {
		
		int input = 153;  
		int calculated = 0; 
		int remainder; 
		int original; 
		
		original = input;
	
		while (input > 0 )
		{
			remainder = input % 10;
			System.out.println("Remainder: "+remainder);
			input = input / 10;
			System.out.println("Quotient: "+input);
			calculated = calculated + (remainder*remainder*remainder);
			System.out.println("Calculated: "+calculated);
			//break;
		}
		if(calculated==original)
		{
			System.out.println("this is an armstrong number");
		}
		else
			System.out.println("Not an Armstrong");

	}

}
