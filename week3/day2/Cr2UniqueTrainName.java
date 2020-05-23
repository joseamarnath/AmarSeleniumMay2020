package week3.day2;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cr2UniqueTrainName {

	public static void main(String[] args) throws InterruptedException 
	{
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get("https://erail.in/");

	
		//clearing values from
		cdriver.findElementById("txtStationFrom").clear();
		cdriver.findElementById("txtStationFrom").sendKeys("Pune Jn");
		cdriver.findElementById("txtStationFrom").sendKeys(Keys.TAB);
		
		//clearing values desti
		cdriver.findElementById("txtStationTo").clear();
		cdriver.findElementById("txtStationTo").sendKeys("Bangalore Cant");
		cdriver.findElementById("txtStationTo").sendKeys(Keys.TAB);
	
		//cdriver.findElementById("buttonFromTo").click();
		
		Thread.sleep(2000);
		//unchecking the sort checkbox
		boolean flag = cdriver.findElementById("chkSelectDateOnly").isEnabled();
		if(flag==true)
		{
			System.out.println("Checkbox was enabled and its getting unchecked now");
			cdriver.findElementById("chkSelectDateOnly").click();
			
		}
		else
		{
			System.out.println("Checkbox is uncheked by default");
		}		
		Thread.sleep(2000);
		
		//Getting the Train Name column xpath to find the size of rows
		java.util.List<WebElement> rows =  cdriver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]");
		System.out.println("no of rows is "+rows.size());
		int j =2;
		List<String> col1 = new ArrayList<String>();
		
		//Getting and printing the train names alone from the table
		for(int i=1;i<=rows.size();i++)
		{
			String trainName = cdriver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td["+j+"]").getText();
			col1.add(trainName);
			//System.out.println(trainName);
		}
		
		//Collections.sort(col1);
		
		for (String temp : col1) {
			System.out.println("the Values from list is: " +temp);
		}
		
		
		
		Set<String> setValues = new TreeSet<String>();
		
		setValues.addAll(col1);
		System.out.println("The Unique Train Vaues are:");
		for (String temp1 : setValues) {
			
			System.out.println(temp1);
		}
		
		System.out.println("LIST size is: "+col1.size());
		System.out.println("SET size is: "+setValues.size());
		cdriver.close();
				
	}

}
