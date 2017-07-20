package lcfFaces;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;



public class C2_SearchLCF_AjexSelect extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void SearchLCF_AjexSelect() throws InterruptedException
	
	{

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="https://www.sulekha.com/ac-services/chennai";
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		Overlayclose(driver);
		
		Thread.sleep(500);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='search-wrap']/div[2]/input")).sendKeys("packers");
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-wrap']//li[1]/a")));
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='search-wrap']//li[1]/a")).click();
		
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement ele = driver.findElement(By.id("lcfframe"));
		
		driver.switchTo().frame(ele);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti1']")));
		
		Thread.sleep(2000);
		
		
		commonforms();
		
		
		contactinfo();
		
		
		OTP();
		
		ThankorDash();
		
	}

}
