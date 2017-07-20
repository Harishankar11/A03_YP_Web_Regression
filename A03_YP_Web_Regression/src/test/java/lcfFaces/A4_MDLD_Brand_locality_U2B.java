package lcfFaces;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A4_MDLD_Brand_locality_U2B extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_Brand_locality_U2B() throws InterruptedException
	
	{
		
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/projector-repair-services/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		commonforms();
		
		
		//back
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector(".btn-t.btn-back")).click();
		
		//back
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector(".btn-t.btn-back")).click();
		
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Select multi select attribute
		String d1 = driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[2]/label")).getText();
		
		driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[2]/label")).click();
		
		Reporter.log("U2B attribute selected : "+d1, true);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Next
		driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();
		
		Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Next
		driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();
		
		
		Multilocality();
	
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
		
		
		
		
		
	}

}
