package week4.day2;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ass3ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get("https://dev60453.service-now.com/");
		cdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		cdriver.findElementByXPath("//iframe[@title='Main Content']");
		
		cdriver.switchTo().frame(0);
		
		cdriver.findElementById("user_name").sendKeys("admin");;
		cdriver.findElementById("user_password").sendKeys("India@123");
		cdriver.findElementById("sysverb_login").click();
		
		
		String title = cdriver.getTitle();
		System.out.println(title);
		
		//Entering change in filter texbox
		cdriver.findElementByXPath("//input[@id='filter']").sendKeys("Change");
		
		//explicit wait is particularly for one webelement when there is a delay
		WebDriverWait ewait = new WebDriverWait(cdriver, 30);
		
		//clicking the All link
		ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='All'])[4]"))).click();
		//cdriver.findElementByXPath("(//div[text()='All'])[4]").click();
		
		Thread.sleep(2000);
		//cdriver.switchTo().frame("gsft_main");
		ewait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		
		//clicking the new button
		//cdriver.findElementById("sysverb_new").click();
		String btn = ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='sysverb_new']"))).getText();
		System.out.println(btn);
		WebElement element1 = cdriver.findElementByXPath("//button[@id='sysverb_new']");
		ewait.until(ExpectedConditions.elementToBeClickable(element1)).click();
	
		
		//Selecting Normal
		cdriver.findElementByXPath("//a[contains(text(),'Normal:')]").click();
		
		//capturing the CHange Request Number
		String chgeReqNo = cdriver.findElementByXPath("//input[@id='change_request.number']").getAttribute("value").toString();
		//String chgeReqNo = cdriver.findElementByXPath("(//span[text()='Number']/following::input)[2]").getText();
		
		System.out.println("Request Number is: "+chgeReqNo);
		//Entering the description (mandatory field)
		cdriver.findElementById("change_request.short_description").sendKeys("Assignment 3 on ServiceNow");
		
		//clicking on Submit Request
		cdriver.findElementById("sysverb_insert").click();
		
		
		Thread.sleep(2000);
		//cdriver.switchTo().frame("gsft_main");
		//ewait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		//cdriver.findElementByXPath("(//input[@placeholder='Search'])[1]").sendKeys(chgeReqNo,Keys.ENTER);
		WebElement search = cdriver.findElementByXPath("(//input[@placeholder='Search'])[2]");
		System.out.println(search.getText());
		//ewait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(search));
		
		cdriver.findElementByXPath("(//input[@placeholder='Search'])[2]").sendKeys(chgeReqNo,Keys.ENTER);
		
		Thread.sleep(2000);
		String verify = cdriver.findElementByXPath("//a[text()='"+chgeReqNo+"']").getText();
		
		System.out.println(verify);
		if(verify.contentEquals(chgeReqNo))
		{
			System.out.println("Change Request Number is verified");
		}
		else
		{
			System.out.println("Change Request number is not Verified");
		}
		
		//moving again back to main content from inside a frame
		cdriver.switchTo().defaultContent();
		
		//cdriver.switchTo().defaultContent();
		cdriver.close();
	}

}
