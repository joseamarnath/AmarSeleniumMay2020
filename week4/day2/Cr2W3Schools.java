package week4.day2;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cr2W3Schools {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		
		//maximize the browser
		cdriver.manage().window().maximize();
		cdriver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		cdriver.switchTo().frame("iframeResult");  //clicking by frame index
		
		cdriver.findElementByXPath("//button[text()='Try it']").click();
		
		TargetLocator switchTo = cdriver.switchTo();
		Alert alert = switchTo.alert();
		alert.sendKeys("Amar");
		String txt = 	alert.getText();
		System.out.println("Prompt alert Text after Input : "+alert.getText());

		alert.accept();
		
		String txt2 = cdriver.findElementByXPath("//p[@id='demo']").getText();
		System.out.println(txt2);
		if(txt2.contains("Amar"))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("Failed");
		}
		
		Thread.sleep(2000);
		cdriver.switchTo().defaultContent();
		cdriver.close();
	}

}
