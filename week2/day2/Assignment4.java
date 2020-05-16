package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
			
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		
		//maximize the browser
		cdriver.manage().window().maximize();
		
		//URL launch
		cdriver.get("http://leaftaps.com/opentaps/control/main");
		
		//findElementById returns a webelement and we store the value in an variable of Webelement type and then perform the action
		WebElement username = cdriver.findElementByXPath("//input[@id='username']");  //using ID locator am locating the webelement
		username.sendKeys("demosalesmanager");
		
		//Performing action directly instead of storing in a variable of webelement type
		cdriver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		
		//button click
		cdriver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		
		//Clicking the link
		cdriver.findElementByXPath("//a[contains(text(),'/SFA')]").click();
		
		//clicking on lead
		cdriver.findElementByXPath("//a[contains(text(),'ead')]").click();
		
		//clicking on find lead
		cdriver.findElementByXPath("//a[text()='Find Leads']").click();
		
		Thread.sleep(5000);
		
		//clicking on the Email link
		cdriver.findElementByXPath("//span[text()='Email']").click();
		
		//entering the phone number value as 7
		cdriver.findElementByXPath("//input[@name='emailAddress']").sendKeys("a");
		
		Thread.sleep(2000);
		
		//Clicking on Find Leads button
		cdriver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		//capturing the first resulting lead
		String name = cdriver.findElementByXPath("(//a[@class='linktext'])[6]").getText();
		System.out.println("Lead Value is "+name);
		
		//clicking the first resulting lead
		cdriver.findElementByXPath("(//a[@class='linktext'])[4]").click();
		
		Thread.sleep(2000);;
		//deleting the found lead.
		cdriver.findElementByXPath("//a[text()='Duplicate Lead']").click();
		System.out.println("element Duplicated");
		
		String title = cdriver.getTitle();
		if(title.contains("Duplicate Lead"))
		{
			System.out.println("Title verification passed");
			System.out.println("Title is "+title);
		}
		else
		{
			System.out.println("Title verification failed since tile value is "+title);
		}
		
		Thread.sleep(2000);
		//clicking on create lead button
		cdriver.findElementByXPath("//input[@class='smallSubmit']").click();
		
		Thread.sleep(2000);
		//Getting value of Name
		String duplicateName = cdriver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
			
		//verifying the name between actual lead and duplicated lead.
		if(duplicateName.equals(name))
		{
			System.out.println("Name is matching");
		}
		
		else {
			
			System.out.println("duplicate name is: "+duplicateName);
			System.out.println("Name is "+name);
		}
	}

}
