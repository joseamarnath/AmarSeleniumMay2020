package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.Fidelity;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass1MergeLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		
		//URL launch
		cdriver.get("http://leaftaps.com/opentaps/control/main");
		
		//Entering login Credentials
		WebElement username = cdriver.findElementByXPath("//input[@id='username']");
		username.sendKeys("demosalesmanager");
		cdriver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		
		//Login button click
		cdriver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		
		//Clicking the link
		cdriver.findElementByXPath("//a[contains(text(),'/SFA')]").click();
		
		//Clicking the Contacts tab
		cdriver.findElementByXPath("//a[text()='Contacts']").click();
		
		//Clicking the Merge Contact
		cdriver.findElementByXPath("//a[text()='Merge Contacts']").click();
		
		//Getting the tile of the window to verify in last step
		String title = cdriver.getTitle();
		
		//Clicking the Widget of From Contact
		cdriver.findElementByXPath("//img[@src='/images/fieldlookup.gif']").click();
		
		//Window Handling
		String windowHandle = cdriver.getWindowHandle();
		Set<String> windowHandles = cdriver.getWindowHandles();
			
		//copying set to list by passing directly to constructor
		List<String> listHandles = new ArrayList<String>(windowHandles);
		
		//getting the FindConact window
		String findContact = listHandles.get(1);
		
		//moving the Find Contact Window
		cdriver.switchTo().window(findContact);
	
		
		//windowHandling(cdriver);
		
		String firstText = cdriver.findElementByXPath("//div[@class='x-grid3-body']//tr[1]/td[1]").getText();
		System.out.println("First Resulting Lead of From Contact: "+firstText);
		cdriver.findElementByXPath("//div[@class='x-grid3-body']//tr[1]/td[1]").click();

		//going back to first window again
		cdriver.switchTo().window(listHandles.get(0));

		//Clicking the Widget of To Contact
		cdriver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();
		
		windowHandling(cdriver);
		
		String secondText = cdriver.findElementByXPath("//div[@class='x-grid3-body']//tr[1]/td[1]").getText();
		System.out.println("First Resulting Lead of To Contact: "+secondText);
		cdriver.findElementByXPath("//div[@class='x-grid3-body']//tr[1]/td[1]").click();
		
		
		//going back to first window again
		cdriver.switchTo().window(listHandles.get(0));
		
		//Clicking the Merge Contact
		cdriver.findElementByXPath("//a[text()='Merge']").click();
		
		TargetLocator switchTo = cdriver.switchTo();
		
		//switching to the alert window
		Alert alert1 = switchTo.alert();
		alert1.accept();
		String title1 = cdriver.getTitle();
		if(title.contentEquals(title1))
		{
			System.out.println("Title Matches");
		}
		else
		{
			System.out.println("Title 1 is: "+title+ " and Title 2 is: "+title1);
		}
		
		cdriver.close();
	}

	public static void windowHandling(WebDriver cdriver)
	{
		//Window Handling
		String windowHandle = cdriver.getWindowHandle();
		Set<String> windowHandles = cdriver.getWindowHandles();
					
		//copying set to list by passing directly to constructor
		List<String> listHandles = new ArrayList<String>(windowHandles);
				
		//getting the second window
		String secondWindow = listHandles.get(1);
				
		//moving the Find Contact Window
		cdriver.switchTo().window(secondWindow);
	}
	
	
	
	
}
