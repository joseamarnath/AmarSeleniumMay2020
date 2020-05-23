package week3.day2;

import java.awt.List;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class WeekAss3ClearTrip {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		
		//create an object to disable notification in chrome
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get("https://www.cleartrip.com/");
		
		//implicit wait time 
		cdriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		cdriver.findElementById("RoundTrip").click();
		
		cdriver.findElementById("FromTag").sendKeys("Chennai");
		cdriver.findElementById("FromTag").sendKeys(Keys.TAB);
		
		cdriver.findElementById("ToTag").sendKeys("New York");
		cdriver.findElementById("ToTag").sendKeys(Keys.TAB);
	
		cdriver.findElementByXPath("//input[@id='DepartDate']").sendKeys("Fri, 22 May, 2020");
		cdriver.findElementByXPath("//input[@id='DepartDate']").sendKeys(Keys.TAB);
		
		
		cdriver.findElementByXPath("//input[@id='ReturnDate']").click();
		cdriver.findElementByXPath("//a[text()='15']").click();
		Thread.sleep(1000);
		
		WebElement adults = cdriver.findElementByXPath("//select[@name='adults']");
		Select dd1 = new Select(adults);
		dd1.selectByVisibleText("2");

		
		WebElement child = cdriver.findElementByXPath("//select[@id='Childrens']");
		Select dd2 = new Select(child);
		dd2.selectByVisibleText("1");
	
		WebElement infants = cdriver.findElementByXPath("//select[@id='Infants']");
		Select dd3 = new Select(infants);
		dd3.selectByVisibleText("1");
				
		cdriver.findElementByXPath("//a[@id='MoreOptionsLink']").click();
				
		WebElement classDd = cdriver.findElementByXPath("//select[@id='Class']");
		Select dd4= new Select(classDd);
		dd4.selectByVisibleText("Premium Economy");
		Thread.sleep(2000);

		WebElement pAirline = cdriver.findElementByXPath("//input[@id='AirlineAutocomplete']");
		pAirline.sendKeys("Emirates",Keys.TAB);
		Thread.sleep(1000);
					
		cdriver.findElementByXPath("//input[@id='SearchBtn']").click();
		Thread.sleep(4000);
					
		String msgDisplayed = cdriver.findElementByXPath("//div[@class='warningMessage']/h2").getText();
		System.out.println(msgDisplayed);
		
		cdriver.close();

	}

}
