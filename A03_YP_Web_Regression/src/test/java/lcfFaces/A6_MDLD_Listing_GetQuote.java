package lcfFaces;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A6_MDLD_Listing_GetQuote extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_Listing_GetQuote() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/transporters/chennai?q=Transporter#popup";
		
		driver.get(url); Reporter.log(url, true);
		
		Overlayclose(driver);
		Thread.sleep(1000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("scroll(0,900)");
		
		try{driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();}catch(Exception ie34){}
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Getquote
		driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//button[3]")).click();

		Thread.sleep(2000);

		Reporter.log("Get quote Popup is opened ", true);
		
		WebElement ele = driver.findElement(By.id("lcfframe"));
		
		driver.switchTo().frame(ele);
		
		Thread.sleep(1000);
		
		commonforms();
		
		Singlelocality();
	
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
		
		
		
		
		
	}

}
