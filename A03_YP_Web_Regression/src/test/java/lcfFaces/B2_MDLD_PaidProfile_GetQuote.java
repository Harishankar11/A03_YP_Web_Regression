package lcfFaces;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class B2_MDLD_PaidProfile_GetQuote extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_PaidProfile_GetQuote() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		
		//String url="http://www.sulekha.com/vls-logistic-supply-chain-service-isanpur-ahmedabad-contact-address#popup";
		
		
		driver.get(url);
		
		Reporter.log(url, true);

		// Proceed button
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//*[text()='proceed']")).click();

		Thread.sleep(2000);
				
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
		WebElement ele = driver.findElement(By.id("lcfframe"));
				
		driver.switchTo().frame(ele);
		
		
		commonforms();
		
		try{Singlelocality();}catch(Exception ie){}
		
		
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
	}

}
