package week4.day1;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Cr2MovebyLocation {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		
		//maximize the browser
		cdriver.manage().window().maximize();
		cdriver.get("https://jqueryui.com/sortable/");
		
		cdriver.switchTo().frame(0);
	
		WebElement Item1 = cdriver.findElementByXPath("//li[text()='Item 1']");
		WebElement Item4= cdriver.findElementByXPath("//li[text()='Item 4']");

		Actions builder = new Actions(cdriver);
		
		//finding the corordinates of Item4
		Point locationI4 = Item4.getLocation();
		int i4X = locationI4.getX();
		int i4Y = locationI4.getY();
		System.out.println(i4X+" "+i4Y);
		
		
		//moving item1 to item 4 location
		
	}

}
