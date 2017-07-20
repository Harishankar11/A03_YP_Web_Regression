package a0_lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Commonmethods extends Base_Class {
	
	public static void Click_element(WebDriver driver, String LocatorType, String LocatorValue)
	{
	
		switch(LocatorType)
		{
		case "id":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id(LocatorValue)).click();
			break;
		case "name":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.name(LocatorValue)).click();
			break;
		case "xpath":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(LocatorValue)).click();
			break;
		case "cssSelector":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(LocatorValue)).click();
			break;
		case "linkText":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.linkText(LocatorValue)).click();
			break;
		case "className":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.className(LocatorValue)).click();
			break;
		case "partialLinkText":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.partialLinkText(LocatorValue)).click();
			break;
		case "tagName":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.tagName(LocatorValue)).click();
			break;
		
		}
		
	}
	
	public static String Get_element(WebDriver driver, String LocatorType, String LocatorValue)
	{
		String s1 = null;
		
		switch(LocatorType)
		{
		case "id":
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			s1 = driver.findElement(By.id(LocatorValue)).getText();
			break;
		}
		case "name":
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			s1 = driver.findElement(By.name(LocatorValue)).getText();
			break;
		}
		case "xpath":
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			s1 = driver.findElement(By.xpath(LocatorValue)).getText();
			break;
		}
		case "cssSelector":
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			s1 = driver.findElement(By.cssSelector(LocatorValue)).getText();
			break;
		}
		case "linkText":
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			s1 = driver.findElement(By.linkText(LocatorValue)).getText();
			break;
		}
		case "className":
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			s1 = driver.findElement(By.className(LocatorValue)).getText();
			break;
		}
		case "partialLinkText":
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			s1 = driver.findElement(By.partialLinkText(LocatorValue)).getText();
			break;
		}
		case "tagName":
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			s1 = driver.findElement(By.tagName(LocatorValue)).getText();
			break;
		}
		}
		
		return s1;
		
	}
	
	
	
	public static void SendKey_element(WebDriver driver, String LocatorType, String LocatorValue, String Sendkeyvalue)
	{
	
		switch(LocatorType)
		{
		case "id":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id(LocatorValue)).sendKeys(Sendkeyvalue);
			break;
		case "name":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.name(LocatorValue)).sendKeys(Sendkeyvalue);
			break;
		case "xpath":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(LocatorValue)).sendKeys(Sendkeyvalue);
			break;
		case "cssSelector":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(LocatorValue)).sendKeys(Sendkeyvalue);
			break;
		case "linkText":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.linkText(LocatorValue)).sendKeys(Sendkeyvalue);
			break;
		case "className":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.className(LocatorValue)).sendKeys(Sendkeyvalue);
			break;
		case "partialLinkText":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.partialLinkText(LocatorValue)).sendKeys(Sendkeyvalue);
			break;
		case "tagName":
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.tagName(LocatorValue)).sendKeys(Sendkeyvalue);
			break;
		
		}
		
	}


}
