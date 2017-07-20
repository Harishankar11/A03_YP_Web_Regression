package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Commonform extends Commonmethod {
	
	
	public void commonforms()
	{
		
		for(int i=1;i<=8;i++)
		{
			try{	
				 
				WebDriverWait wait = new WebDriverWait(driver, 15);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]")));
				
				WebElement ele = driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]"));
				
				ele.isDisplayed();
				
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				// check radio / check box
				String type = driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[1]/input")).getAttribute("type");
				
				
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				// Click on first attribute value
				String data = driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[1]/label")).getText();
				
				driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[1]/label")).click();
				
				Reporter.log("Selected Attribute : "+ data, true);
				
				Reporter.log("Check box / Radio  : "+ type, true);
				
				Thread.sleep(3000);
				
				Nextbutton(type);
				
				Thread.sleep(1000);
				

				
			}catch(Exception ie1)
			{
				i = i-1;
				Reporter.log("Total form count : "+i,true);
				break;
				
			}

		
		}
	}
	
	
	public void Nextbutton(String type) throws InterruptedException
	{
		
		if(type.equalsIgnoreCase("checkbox"))
		{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		Thread.sleep(500);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-p.btn-next.btnmdld")));
		Thread.sleep(500);
			
		driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();
		
		Thread.sleep(1000);
		
		} else {
		
		Thread.sleep(1000);
		
		}
		
	}
	

}
