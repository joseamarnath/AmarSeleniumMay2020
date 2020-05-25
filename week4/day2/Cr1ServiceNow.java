package week4.day2;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cr1ServiceNow {

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
		
		cdriver.switchTo().defaultContent();
		cdriver.close();
	}

}
