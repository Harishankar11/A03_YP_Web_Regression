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


public class B1_MDLD_FreeProfile_GetQuote extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_FreeProfile_GetQuote() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="https://www.sulekha.com/gopalakrishna-driving-school-kelambakkam-chennai-contact-address";
		
		
		driver.get(url);
		
		Reporter.log(url, true);

		try {

			Explecit(driver, "xpath", "//a[@class='sdialog-x']");
			// Close
			driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();
		} catch (Exception ie) {
		}

		Thread.sleep(500);
		Explecit(driver, "xpath", "//button[@class='btn-p']");

		// Getquote
		driver.findElement(By.xpath("//button[@class='btn-p']")).click();
		
		Thread.sleep(2000);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti1']")));
		
		driver.findElement(By.xpath("//label[@for='smulti1']")).click();
		
		Thread.sleep(2000);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement ele = driver.findElement(By.id("lcfframe"));
		
		driver.switchTo().frame(ele);
		
		commonforms();
		
		Singlelocality();
		
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
	}

}
