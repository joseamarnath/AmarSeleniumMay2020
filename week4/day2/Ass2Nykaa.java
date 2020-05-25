package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ass2Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get("https://www.nykaa.com/");
		cdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//explicit wait is particularly for one webelement when there is a delay
		WebDriverWait ewait = new WebDriverWait(cdriver, 30);
		
		Actions builder = new Actions(cdriver);
		
		
		WebElement brands = ewait.until(ExpectedConditions.visibilityOf(cdriver.findElementByXPath("//a[text()='brands']")));
		builder.moveToElement(brands).perform();;
		
		WebElement popular = cdriver.findElementByXPath("//a[text()='Popular']");
		builder.moveToElement(popular).perform();;
		
		
		WebElement lorealParis = cdriver.findElementByXPath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']");
		builder.moveToElement(lorealParis).click().perform();
		
		//Window Handling
		String windowHandle = cdriver.getWindowHandle();
		Set<String> windowHandles = cdriver.getWindowHandles();
					
		//copying set to list by passing directly to constructor
		List<String> listHandles = new ArrayList<String>(windowHandles);
		
		//getting the loreal paris window
		String lorealWindow = listHandles.get(1);
		
		//moving the Loreal Paris Window
		cdriver.switchTo().window(lorealWindow);
		
		String title = cdriver.getTitle();
		if(title.contains("L'Oreal Paris"))
		{
			System.out.println("Title Matches");
		}
		else
		{
			System.out.println("Title not matching:"+title);
		}
		
		cdriver.switchTo().window(listHandles.get(0));
		
		cdriver.close();
		
		cdriver.switchTo().window(lorealWindow);
		
//		//switching to alert popup
//		TargetLocator switchTo = cdriver.switchTo();
//		Thread.sleep(5000);
//		Alert alert1 = switchTo.alert();
//		alert1.dismiss();

		//clicking the Sort by dropdown arrow
		cdriver.findElementByXPath("//i[@class='fa fa-angle-down']").click();
		
		//Selecting Customer Top Rated Option
		cdriver.findElementByXPath("(//div[@class='control__indicator radio'])[4]").click();
	
		Thread.sleep(2000);
		//clicking on category:
		//ewait.until(ExpectedConditions.visibilityOf(cdriver.findElementByXPath("(//div[@class='brd-sep'])[1]"))).click();
		cdriver.findElementByXPath("(//div[@class='brd-sep'])[1]").click();		
		
		//selecting the shampoo checkbox
		cdriver.findElementByXPath("(//span[contains(text(),'Shampoo ')])[1]/following-sibling::div").click();
		
		//clicking on the first listed product
		WebElement firstProduct = cdriver.findElementByXPath("(//div[@class='m-content__product-list__title'])[1]");
		firstProduct.click();
		
		windowHandling(cdriver);
		
		cdriver.findElementByXPath("(//button)[1]").click();
		
		cdriver.findElementByXPath("//div[@class='AddBagIcon']").click();
		cdriver.findElementByXPath("//span[text()='Proceed']").click();
		
		String errMsg = cdriver.findElementByXPath("//div[@class='popup-error']").getText();
		System.out.println("Error Mesasge is: "+errMsg);
		
		cdriver.close(); //closing the current shopping card window
		
		cdriver.close(); // closing the previous window
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
				
		//moving the second  Window
		cdriver.switchTo().window(secondWindow);
	}

}
