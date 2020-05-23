package week3.day2;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cr2ErailSort {

	public static void main(String[] args) throws InterruptedException 
	{
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		cdriver.manage().window().maximize();
		cdriver.get("https://erail.in/");

	
		//clearing values from
		cdriver.findElementById("txtStationFrom").clear();
		cdriver.findElementById("txtStationFrom").sendKeys("Pune Jn");
		cdriver.findElementById("txtStationFrom").sendKeys(Keys.TAB);
		
		//clearing values desti
		cdriver.findElementById("txtStationTo").clear();
		cdriver.findElementById("txtStationTo").sendKeys("Bangalore Cant");
		cdriver.findElementById("txtStationTo").sendKeys(Keys.TAB);
	
		//cdriver.findElementById("buttonFromTo").click();
		
		Thread.sleep(3000);
		//unchecking the sort checkbox
		boolean flag = cdriver.findElementById("chkSelectDateOnly").isEnabled();
		if(flag==true)
		{
			System.out.println("Checkbox was enabled and its getting unchecked now");
			cdriver.findElementById("chkSelectDateOnly").click();
			
		}
		else
		{
			System.out.println("Checkbo is uncheked");
		}		
		Thread.sleep(3000);
		
		//Getting the Train Name column xpath to find the size
		java.util.List<WebElement> rows =  cdriver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]");
		System.out.println("no of rows is "+rows.size());
		int j =2;
		
		//printing the train names alone
		for(int i=1;i<=rows.size();i++)
			{
				String col1 = cdriver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td["+j+"]").getText();
				System.out.println(col1);
			}
	}

}
