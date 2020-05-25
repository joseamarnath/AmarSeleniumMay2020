package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Cr1SnapdealActions {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		//ChromeDriver cdriver = new ChromeDriver();
		
		//disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver cdriver = new ChromeDriver(options);
		
		//maximize the browser
		cdriver.manage().window().maximize();
		cdriver.get("https://www.snapdeal.com/");
		WebElement men = cdriver.findElementByXPath("(//span[@class='catText'])[6]");
		
		//creating an object for Actions class using drvier as paramerter
		Actions builder = new Actions(cdriver);
		
		//mouse hover event
		
		//movetoelement method moves to the middle of the webelement and 
		//perform() method is must for every actions methods
		builder.moveToElement(men).perform();

		Thread.sleep(2000);
		WebElement shirts = cdriver.findElementByXPath("(//span[text()='Shirts'])[2]");
		shirts.click();
		
		Thread.sleep(2000);
		//hovering on first search element
		WebElement firstSearch = cdriver.findElementByXPath("//span[contains(@id,'display-price')]");
		builder.moveToElement(firstSearch).perform();
		
		Thread.sleep(2000);
		cdriver.findElementByXPath("//div[contains(text(),'Quick View')]").click();

		cdriver.close();
	}

}
