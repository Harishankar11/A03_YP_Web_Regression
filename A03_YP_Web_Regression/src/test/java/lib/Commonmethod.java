package lib;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Function;

import a0_lib.Base_Class;

public class Commonmethod extends Base_Class{
	
		
		/*
		 * LOCALITY XPATH
		 * 
		try{
		String sr1 = driver.findElement(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']")).getText();
		System.out.println(sr1+"First");
		}catch(Exception ie){}
		
		try{
		String sr2 = driver.findElement(By.xpath("//div[contains(@class, 'form-group')][@data-type='loca']/div/div[1]")).getText();
		System.out.println(sr2+"second");
		}catch(Exception ie){}
		
		locality selection
		//div[@class='lcf-loc']//div[@class='sl-menu sl-has-search']//li[3]
		//div[@class='lcf-loc']//div[@class='sl-menu sl-has-done sl-has-search']//li[3]/label
		//div[@class='lcf-loc']//div[@class='sl-menu sl-has-done sl-has-search']//li[3]
		*/
	
	public static void Overlayclose(WebDriver driver)
	{
		//Close the overlay LCF
		try
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//a[@class='lcf-close']")).click();
		}
			catch(Exception ie2){System.out.println("Overlay is not display");}
	}
	
	
		public void Singlelocality() throws InterruptedException
		{
			
				Thread.sleep(2000);
			
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				WebDriverWait wait = new WebDriverWait(driver, 15);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'LCFLocalityMain')]")));
				
				
				driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]")).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'LCFLocalityMain')]//li[2]")));
				
				String r1 = driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]//li[2]")).getText();
				
				driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]//li[2]")).click();
				

				String r2 = driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]")).getText();
				
				Reporter.log("Selected locality : "+r1, true);
				//Reporter.log("Selected locality : "+r2, true);
				
				Assert.assertTrue(r1.equalsIgnoreCase(r2), "Selected localtiy is mismatch");
			
		}
	
		public void Multilocality() throws InterruptedException
		{
				
			
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				WebDriverWait wait = new WebDriverWait(driver, 20);
				
				Thread.sleep(2000);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'LCFLocalityMain')]")));
				
				driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]")).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'LCFLocalityMain')]//li[3]")));
				//option 1
				String r1 = driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]//li[3]")).getText();
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]//li[3]")).click();
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				//option 2
				
				String r3 = driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]//li[4]")).getText();
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]//li[4]")).click();
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				Reporter.log("Selected locality : "+r1+", "+r3, true);
				
				//done
				
				driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]//a[@class='sl-done']")).click();
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				String r2 = driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]")).getText();
				
				
				Assert.assertTrue(r2.contains(r1), "Selected localtiy is mismatch");
			
				Reporter.log("Multi locality selected : "+r2, true);
		}
	
	
		
	
		public void contactinfo() throws InterruptedException
		{
			Thread.sleep(2000);
			
			String name ="Hari"; String Mobileno = "9380835000";
			
			//User Mobile
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			WebDriverWait wait = new WebDriverWait(driver, 25);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".txtlcfmob")));
			
			
			driver.findElement(By.cssSelector(".txtlcfmob")).clear();
			driver.findElement(By.cssSelector(".txtlcfmob")).sendKeys(Mobileno);
			
			//User Name
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(".txlcftname")).clear();
			driver.findElement(By.cssSelector(".txlcftname")).sendKeys(name);
			
			//Email
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(".txtlcfmail")).clear();
			Thread.sleep(1000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-p.btn-next.btnmdld")));
			
			driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();
			
			Thread.sleep(3000);
			
			Reporter.log("Note: Contact info vaules are filled");
		
			
		}
		
		
		public void addinfo() throws InterruptedException
		{
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			
			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".additionalinfo.mandtrue")));
			
			driver.findElement(By.cssSelector(".additionalinfo.mandtrue")).sendKeys("I want best service");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-p.btn-next.btnmdld")));
			
			Thread.sleep(500);
			
			driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();
			
			Reporter.log("Additional info text entered ", true);
			
			Thread.sleep(2000);
			
			
		}
		
		
		public void OTP() throws InterruptedException
		{
			 String OTP ="999999";
			//OTP 
			 WebDriverWait wait = new WebDriverWait(driver, 30);
			 
			 Thread.sleep(4000);
			 
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".verf-code")));
			 
			 Thread.sleep(500);
				 
			 WebElement ele = driver.findElement(By.cssSelector(".verf-code"));
			 
			 ele.isDisplayed();
			 
			driver.findElement(By.cssSelector(".verf-code")).sendKeys(OTP);
			
			Reporter.log("Note: OTP vaule is filled");
		}
		
		public void ThankorDash() throws InterruptedException 
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			try{
				
			//Thank content contain thank word
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".lcf-listing.success-message>h4")));
			String thank = driver.findElement(By.cssSelector(".lcf-listing.success-message>h4")).getText();
			
			if(thank.contains("Thank"))
			{
				
				Reporter.log("Lead posted and thank you message is display", true);
				
			} else {
				
				Reporter.log("====Thank you message is not capture====", true);
				
			}}catch(Exception ie1){
				
				System.out.println(ie1.getMessage());
				
			}
			
			Thread.sleep(2000);
			
			//Dashboard url contain Dashboard text
			int i;
			
			for(i=1;i<10;i++){
				
			String dashurl = driver.getCurrentUrl();
			
			if(dashurl.contains("dashboard"))
			{
				
				Reporter.log("LCF to Dashboard navgation is succesful", true);
				
				break;
				
			}else {
				
				Thread.sleep(4000);
			}
			if(i==9)
			{
			Reporter.log("==== LCF submission not landed on Dashboard ===", true);
			driver.findElement(By.id("Hari"));//Failing the test case after condition is true
			}
			}
			
		}
		
		public void leadmatch() throws Throwable
		{
			  
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(60, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			     @Override
				public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.id("btnUpdatestatus"));
			     }
			   });
			   System.out.println("WebElement is displayed"+element.isDisplayed());
			
			
		}
		
	}

