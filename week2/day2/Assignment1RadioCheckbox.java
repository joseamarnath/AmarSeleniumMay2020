package week2.day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1RadioCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Assignment1RadioCheckbox obj = new Assignment1RadioCheckbox();
		obj.radiobuttonpage();
		obj.checkboxpage();
		//Questions:
			
		//Radio button page
			//1. how to get the checkbox text values?
			//2. if I use the List for FindElementsByClass it shows error due to return type.
	}
	
	public void radiobuttonpage()
	{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
				ChromeDriver cdriver = new ChromeDriver();
				
				//maximize the browser
				cdriver.manage().window().maximize();
				
				cdriver.get("http://leafground.com/pages/radio.html");
				
		
				//do you enjoy your class
				cdriver.findElementById("yes").click();
				
				//identifying the default enabled radio button
				System.out.println();
				System.out.println("Below is for verifying the default selection radio button");
				List<WebElement> nofradio = cdriver.findElementsByName("news");
				System.out.println("No of Radio Buttons: "+nofradio.size());
				boolean status = false;
						
				for(int i=0;i<nofradio.size();i++)
				{
					
					status = nofradio.get(i).isSelected();
					
					if(status==true)
					{
						System.out.println("i value is:" +i+ " boolean status is: " +status);
						//String val = nofradio.get(i).getText();
						//String val = nofradio.get(i).getAttribute("value");
						//System.out.println("value of that checkbox "+val );
						System.out.println("The " +(i+1)+" radio button is selected");
					}
					
					//System.out.println("Value of I is:" +i+ " value of status is: " +status);
					//System.out.println(nofradio.get(i));
				}
					
				
				//selecting age group if choice was not selected
				System.out.println();
				System.out.println("Below is for Age group selection");
				
						List<WebElement> nofradio1 = cdriver.findElementsByName("age");
						System.out.println("No of Radio Buttons: "+nofradio1.size());
						boolean status1 = false;
						int count=0;
						
						for(int i=0;i<nofradio1.size();i++)
						{
					
							status = nofradio1.get(i).isSelected();
							if(status==true)
							{
							 count++;
							}
						}
						System.out.println("count value is "+count);
						if(count>0)
						{
							System.out.println("Nothing to select, since option is already selected");
						}
						else
						{
							nofradio.get(0).click();  //selecting the first option if nothing is selected
						}
						cdriver.quit();
	}
	
	public void checkboxpage()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");  
		ChromeDriver cdriver = new ChromeDriver();
		
		//maximize the browser
		cdriver.manage().window().maximize();
		
		cdriver.get("http://leafground.com/pages/checkbox.html");
		
		//Select the Languages you know
		
		//cdriver.findElementByXPath("//div[text()='Java']").click();  //Since text is not in any tag, text based xpath will not work
		//cdriver.findElementByXPath("//div[text()='SQL']").click();
		cdriver.findElementByXPath("(//input[@type='checkbox'])[1]").click();
		cdriver.findElementByXPath("(//input[@type='checkbox'])[2]").click();
		
		//Confirm if checkbox is selected
		boolean confirm = cdriver.findElementByXPath("(//input[@type='checkbox'])[6]").isSelected();
		if(confirm==true)
		{
			System.out.println("The checbox "+cdriver.findElementByXPath("(//div[@class='example']/div)[6]").getText()+ " is selected");
		}
		
		//Deslect if the checkbox is checked
		boolean confirm1 = cdriver.findElementByXPath("(//input[@type='checkbox'])[7]").isSelected();
		boolean confirm2 = cdriver.findElementByXPath("(//input[@type='checkbox'])[8]").isSelected();
		if(confirm1==false)
		{
			cdriver.findElementByXPath("(//input[@type='checkbox'])[7]").click();
			
		}
		else if(confirm2==false)
		{
			cdriver.findElementByXPath("(//input[@type='checkbox'])[8]").click();
		}
		else
		{
			System.out.println("Both checkbox "+cdriver.findElementByXPath("(//input[@type='checkbox'])[7]").getText()+ " and " +cdriver.findElementByXPath("(//input[@type='checkbox'])[8]").getText()+ " are selected.");
		}
		
		
		//Select all the below checkboxes
		
		List<WebElement> lang1 = cdriver.findElementsByXPath("(//div[@class='example'])[4]/div");
		String status;
		System.out.println("Total No of Checkobox to DIV Block 4: "+lang1.size());
		for(int i=0;i<lang1.size();i++ )
		{
			status = lang1.get(i).getText();
			System.out.println(status);
			cdriver.findElementByXPath("(//input[@type='checkbox'])["+(i+9)+"]").click();
		}
		
		
		/*
		 * //enabling all checkbox in that page List<WebElement> lang =
		 * cdriver.findElementsByXPath("//div[@class='example']/div"); String str;
		 * System.out.println("Total No of Checkobox in InnerBlock: "+lang.size());
		 * for(int i=0;i<lang.size();i++ ) { str = lang.get(i).getText();
		 *  //System.out.println(str); lang.get(i).click(); }
		 */
		cdriver.quit();
	}
	
}

