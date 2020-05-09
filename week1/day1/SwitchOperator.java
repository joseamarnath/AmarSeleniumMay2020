package week1.day1;

public class SwitchOperator {
	

	public static void main(String[] args) {
		
		int num1 = 31;
		int num2 = 28;
		String operations = "Mod";
		int result;
		
		switch (operations) {
		case "Add":
			result = num1+num2; 
			System.out.println(result);
			break;

		case "Mul":
			result = num1*num2;
			System.out.println(result);
			break;

		case "Mod":
			result = num1%num2; 
			System.out.println(result);
			break;

		default:
			System.out.println("Invalid Input");
			break;
		}

	}

}
