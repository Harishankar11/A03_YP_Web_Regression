package a1_Listing_Page;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import a0_lib.Commonmethods;
import a0_lib.Retrytest;

public class A07_Middle_block extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));

		
	}

	@Test(enabled = true, priority = 1, retryAnalyzer = Retrytest.class)
	public void g01_Pagination() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);

		// Close the overlay LCF - if need to run this method only enable this
		// block
		Overlayclose(driver);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,3400)");

		Thread.sleep(1000);

		Explecit(driver, "xpath", "//li[@id='nextPage']");

		// Next button
		driver.findElement(By.xpath("//li[@id='nextPage']")).click();

		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("scroll(0,3400)");

		Thread.sleep(3000);

		Explecit(driver, "xpath", "//li[@id='prevPage']");

		// preview

		driver.findElement(By.xpath("//li[@id='prevPage']")).click();

		Reporter.log("Next and Prev button is working fine", true);

	}

	@Test(enabled = true, priority = 2, retryAnalyzer = Retrytest.class)
	public void g02_HelpFeedback() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		Thread.sleep(1000);

		// Next button
		driver.findElement(By.xpath("//span[@class='help-icon']/img")).click();

		Thread.sleep(500);

		Explecit(driver, "xpath", "//*[text()='Feedback']");

		driver.findElement(By.xpath("//*[text()='Feedback']")).click();

		ArrayList<String> Windowhendles = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(Windowhendles.get(1));

		String s1 = driver.getCurrentUrl();

		Assert.assertTrue(s1.contains("collateral/contactus"), "issue in Help and feedback url");

		Reporter.log("Help and Feedback link is working fine, URL is : " + s1, true);

		driver.close();

		driver.switchTo().window(Windowhendles.get(0));

	}

	@Test(enabled = true, priority = 3, retryAnalyzer = Retrytest.class)
	public void g03_BacktoTop() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,3200)");

		Thread.sleep(1000);

		Explecit(driver, "xpath", "//a[@class='back-to-top']");

		// BacktoTop button
		driver.findElement(By.xpath("//a[@class='back-to-top']")).click();

		Reporter.log("Back to top link is working fine ", true);

	}

	
	@Test(enabled = true, priority = 4, retryAnalyzer = Retrytest.class)
	public void g04_AddyourBusiness() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,2200)");

		Thread.sleep(4000);

		ExplecitID(driver, "id", "Addyourbusiness");

		driver.findElement(By.id("Addyourbusiness")).click();

		Thread.sleep(3000);

		ArrayList<String> Windowhendles = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(Windowhendles.get(1));

		String s1 = driver.getCurrentUrl();

		Assert.assertTrue(s1.contains("business-owners"), "issue in Help and feedback url");

		Reporter.log("Add your business link navigation is working fine, URL is : " + s1, true);

		driver.close();

		driver.switchTo().window(Windowhendles.get(0));
	}
	
	
	/*@Test(enabled = true, priority = 5, retryAnalyzer = Retrytest.class)
	public void g05_TollFreeNumber() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,2200)");

		Thread.sleep(1000);
		ExplecitID(driver, "id", "AdvertisewithSulekha");

		driver.findElement(By.id("AdvertisewithSulekha")).click();

		ArrayList<String> Windowhendles = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(Windowhendles.get(1));

		String s1 = driver.getCurrentUrl();

		Assert.assertTrue(s1.contains("business-owners"), "issue in Help and feedback url");

		Reporter.log("Toll free number link navigation is working fine, URL is : " + s1, true);

		driver.close();

		driver.switchTo().window(Windowhendles.get(0));

	}*/


}
