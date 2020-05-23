package week3.day2;

import java.awt.List;
import java.util.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WeekAss1WebTable {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get("http://leafground.com/pages/table.html");
		
		
		//to get the number of rows from a table and also storing the column one values in a list
		java.util.List<WebElement> rows = cdriver.findElementsByXPath("//table[@id='table_id']//td[1]");
		System.out.println("no of rows is "+rows.size());
				
		//to get the number of columns from a table and also storing the column 2 values in a list
		java.util.List<WebElement> cols = cdriver.findElementsByXPath("//table[@id='table_id']//tr[2]/td");
		System.out.println("number of columns is "+cols.size());
		
		//storing the percentage column in a list of type weblement
		java.util.List<WebElement> percentage = cdriver.findElementsByXPath("//table[@id='table_id']//tr/td[2]");
		java.util.List<Integer> perList = new ArrayList<Integer>();
		
		// Printing the progress value of 'Learn to interact with Elements'
		for(int i=0;i<rows.size();i++)
		{
				
			if(rows.get(i).getText().contentEquals("Learn to interact with Elements"))
			{
			
				System.out.println("The Percentage of "+rows.get(i).getText()+" is: "+percentage.get(i).getText());
			
			}
			
		}
		
		
		//copying from list of webelement type to List Array
		//Removing the Percentage symbol so that its easy to sort else collections sort is not working
		//Precentage is removed by string functions
		for (int i =0; i<rows.size(); i++) 
		{
			
			//Storing the list value into a string 
			String b = percentage.get(i).getText();
			//replacing the percentage symbol inorder to sort it easily
			String c = b.replace("%", "");
			//converting string to integer inorder to sort the collections in min to high order
			Integer d = Integer.parseInt(c); 
			//adding the integer value to the Integer List (string list will not sort properly)
			perList.add(d);
		}
		System.out.println("The List after removing percentage symbol: "+perList);
				
		
		//sorting the array list
		Integer minValue = Collections.min(perList);
		System.out.println("Minum Value is: "+minValue);

		//Clicking the vital task for the minimum progress value
		for (int i = 2; i <= rows.size(); i++) 
		{
			
		  for (int j = 1; j <= cols.size(); j++) 
		  {
			  String Text = cdriver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td["+j+"]").getText();
			  if (Text.contains(minValue.toString())) 
			  {
				  //Check the vital task Checkbox
				  cdriver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td/input").click();
			  }
				
		  }
		}
		

//		System.out.println("Printing all values from table");
//		for(int i=2;i<=rows.size();i++)
//		{
//			java.util.List<WebElement> cells = cdriver.findElementsByXPath("//table[@id='table_id']//tr["+i+"]/td");
//			for(int j=1;j<=cells.size();j++)
//			{
//				String text1 = cdriver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td["+j+"]").getText();
//				System.out.println(text1+" ");
//			}
//				System.out.println();
//					
//		}
		
		//closing a browser
		cdriver.close();

	}

}
