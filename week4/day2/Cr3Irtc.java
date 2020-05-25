package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cr3Irtc {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get("https://www.irctc.co.in/nget/train-search");
		cdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		cdriver.findElementByXPath("//button[text()='Ok']").click();
		
		cdriver.findElementByLinkText("FLIGHTS").click();
		Set<String> windowHandles = cdriver.getWindowHandles();
		
		//copying set to list by passing directly to constructor
		List<String> listHandles = new ArrayList<String>(windowHandles);
				
		//getting the second window
		String secondWindow = listHandles.get(1);
				
		//moving the control to second Window
		cdriver.switchTo().window(secondWindow);
	
		Actions builder = new Actions(cdriver);
		WebElement Item1 = cdriver.findElementByXPath("//input[@id='agree']");
		builder.click(Item1).perform();
		
		cdriver.findElementByXPath("//button[text()='Continue ']").click();
		
		
		Thread.sleep(2000);
		
		File source = cdriver.getScreenshotAs(OutputType.FILE);
		
		//providing a path to store under my project in a new folder with a filename
		File target = new File("./screenshots/week4/Flights.png");
		
		//now we should copy the source into target
		//we have a dependency for this to be defined in pom.xml called commons-io
		FileUtils.copyFile(source, target);
		
		cdriver.close();
	}

}
