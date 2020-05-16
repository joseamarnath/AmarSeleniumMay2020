package week2.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

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
				
				//clicking on first resulting lead and clicking the same
				cdriver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
				
				Thread.sleep(5000);
				//get the title of the page
				String title = cdriver.getTitle();
				System.out.println("Title is "+title);
				
				//clicking on Edit button
				//Clicking the link
				cdriver.findElementByXPath("//a[text()='Edit']").click();
				
				//Updating the existing company name
				cdriver.findElementByXPath("//input[@id='updateLeadForm_companyName']").clear();
				cdriver.findElementByXPath("//input[@id='updateLeadForm_companyName']").sendKeys("CompanyName Updated");
				
				//Clicking on Update button
				cdriver.findElementByXPath("//input[@class='smallSubmit']").click();
				
				//Verify if the udpated name is existing
				String cName = cdriver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
				System.out.println("Updated COmpany name is "+cName);
				if(cName.contains("CompanyName Updated"))
				{
					System.out.println("Company name is matching");
				}
				else
				{
					System.out.println("Company name is NOT matching");
				}
				cdriver.close();
	}

}
