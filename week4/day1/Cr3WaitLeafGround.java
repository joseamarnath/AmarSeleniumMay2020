package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cr3WaitLeafGround {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		
		//maximize the browser
		cdriver.manage().window().maximize();
		cdriver.get("http://www.leafground.com/pages/disapper.html");
		
		//explicit wait 
		WebDriverWait ewait = new WebDriverWait(cdriver, 30);
		ewait.until(ExpectedConditions.invisibilityOf(cdriver.findElementById("btn")));
		String txt = cdriver.findElementByXPath("//strong[contains(text(),'you can do it!')]").getText();
		System.out.println(txt);
		cdriver.close();
	}

}
