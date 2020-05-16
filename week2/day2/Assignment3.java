package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

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
				
				//clicking on the Phone link
				cdriver.findElementByXPath("//span[text()='Phone']").click();
				
				//entering the phone number value as 7
				cdriver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("7");
				
				Thread.sleep(2000);
				
				//Clicking on Find Leads button
				cdriver.findElementByXPath("//button[text()='Find Leads']").click();
				
				Thread.sleep(2000);
				//capturing the first resulting lead
				String leadValue = cdriver.findElementByXPath("(//a[@class='linktext'])[4]").getText();
				System.out.println("Lead Value is "+leadValue);
				
				//clicking the first resulting lead
				cdriver.findElementByXPath("(//a[@class='linktext'])[4]").click();
				
				Thread.sleep(2000);;
				//deleting the found lead.
				cdriver.findElementByXPath("//a[text()='Delete']").click();
				System.out.println("element Deleted");
				
				//clicking on find lead
				cdriver.findElementByXPath("//a[text()='Find Leads']").click();
				
				Thread.sleep(2000);
				//entering the captured first resulting value in the Lead ID
				cdriver.findElementByXPath("//input[@name='id']").sendKeys(leadValue);
				
				//Clicking on Find Leads button
				cdriver.findElementByXPath("//button[text()='Find Leads']").click();
				
				Thread.sleep(2000);
				boolean result = cdriver.findElementByXPath("//div[text()='No records to display']").isDisplayed();
				if(result==true)
				{
					System.out.println("Test case passed");
				}
				
				cdriver.close();
	}

}
