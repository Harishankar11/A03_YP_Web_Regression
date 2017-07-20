package a1_Listing_Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import a0_lib.Commonmethods;
import a0_lib.Retrytest;

public class A06a_Listing_Tuple extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));

		
	}

	@Test(enabled = true, priority = 1, retryAnalyzer = Retrytest.class)
	public void f08_Photolink() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		Overlayclose(driver);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		Thread.sleep(1000);

		List<WebElement> s1 = driver.findElements(By.xpath("//div[@id='listingtabcontent']//img"));

		for (WebElement s2 : s1) {
			s2.click();

			Thread.sleep(1000);
			Explecit(driver, "xpath", "//div[@id='sgallerystock']/a[2]");
			// Photo next button
			driver.findElement(By.xpath("//div[@id='sgallerystock']/a[2]")).click();

			Thread.sleep(1000);
			Explecit(driver, "xpath", "//div[@id='sgallerystock']/a[1]");
			// Photo prev button
			driver.findElement(By.xpath("//div[@id='sgallerystock']/a[1]")).click();

			Thread.sleep(1000);
			Explecit(driver, "xpath", "//div[@id='sgallerystock']/span");

			WebElement ele = driver.findElement(By.xpath("//div[@id='sgallerystock']/span"));

			ele.click();

			Reporter.log("Photo links are working fine in listing tuple : ", true);

			break;

		}

	}

	@Test(enabled = true, priority = 2, retryAnalyzer = Retrytest.class)
	public void f09_SavetoPhone() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		Thread.sleep(1000);

		Explecit(driver, "xpath", "//ol[@id='divV8Businesslist']/li[1]//button[1]");

		// Save to phone
		driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//button[1]")).click();

		Thread.sleep(2000);

		ExplecitID(driver, "id", "txtName");
		// Name
		driver.findElement(By.id("txtName")).sendKeys("Hari");
		
		Thread.sleep(500);

		ExplecitID(driver, "id", "txtMobile");
		// Mobile no
		driver.findElement(By.id("txtMobile")).sendKeys("9380835000");
		
		Thread.sleep(500);

		ExplecitID(driver, "id", "btnSavetoPhonePopup");
		// save button
		driver.findElement(By.id("btnSavetoPhonePopup")).click();

		Thread.sleep(1000);

		Explecit(driver, "xpath", "//input[@class='txt-otp']");
		// OTP
		driver.findElement(By.xpath("//input[@class='txt-otp']")).sendKeys("999999");
		Thread.sleep(3000);

		Explecit(driver, "xpath", "//*[contains(text(), 'Thank you')]");

		String s2 = driver.findElement(By.xpath("//*[contains(text(), 'Thank you')]")).getText();

		Thread.sleep(1000);

		Explecit(driver, "xpath", "//div[@id='divSTP']/a");

		// popup close button
		driver.findElement(By.xpath("//div[@id='divSTP']/a")).click();

		Thread.sleep(1000);

		Assert.assertTrue(s2.contains("Thank you"), "Save to function is not working properly");

		Reporter.log("Save to phone functionality is working fine, Thank you popup heading text : " + s2, true);

	}

	@Test(enabled = true, priority = 3, retryAnalyzer = Retrytest.class)
	public void f10_SENDSMS() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		Thread.sleep(1000);
		Explecit(driver, "xpath", "//ol[@id='divV8Businesslist']/li[1]//button[2]");
		// SendSMS
		driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//button[2]")).click();

		Thread.sleep(2000);
		ExplecitID(driver, "id", "txtName");

		// Name
		driver.findElement(By.id("txtName")).clear();
		driver.findElement(By.id("txtName")).sendKeys("Hari");
		
		Thread.sleep(500);
		ExplecitID(driver, "id", "txtMobile");
		// Mobile no
		driver.findElement(By.id("txtMobile")).clear();
		driver.findElement(By.id("txtMobile")).sendKeys("9380835000");
		
		Thread.sleep(500);
		ExplecitID(driver, "id", "txtcomments");
		// Add info
		driver.findElement(By.id("txtcomments")).sendKeys("Need address");
		
		Thread.sleep(500);
		Explecit(driver, "xpath", "//button[@class='btn-p smsSave']");
		// save button
		driver.findElement(By.xpath("//button[@class='btn-p smsSave']")).click();

		Thread.sleep(1000);
		Explecit(driver, "xpath", "//input[@class='txt-otp']");
		// OTP
		driver.findElement(By.xpath("//input[@class='txt-otp']")).sendKeys("999999");
		Thread.sleep(1000);
		Explecit(driver, "xpath", "//*[contains(text(), 'Thank you')]");

		String s2 = driver.findElement(By.xpath("//*[contains(text(), 'Thank you')]")).getText();
		Thread.sleep(1000);

		Explecit(driver, "xpath", "//div[@id='divSTSMS']/a");

		// popup close button
		driver.findElement(By.xpath("//div[@id='divSTSMS']/a")).click();

		Thread.sleep(1000);

		implicitlyWaiting(driver);

		Assert.assertTrue(s2.contains("Thank you"), "Save to function is not working properly");

		Reporter.log("Send SMS functionality is working fine, Thank you popup heading text : " + s2, true);

	}

	@Test(enabled = true, priority = 4, retryAnalyzer = Retrytest.class)
	public void f11_GetQuote() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		Thread.sleep(1000);
		implicitlyWaiting(driver);

		// Getquote
		driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//button[3]")).click();

		Thread.sleep(3000);
		implicitlyWaiting(driver);

		driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();

		Reporter.log("Get quote Popup is opened ", true);

	}

	@Test(enabled = true, priority = 5, retryAnalyzer = Retrytest.class)
	public void f12_GetDirection() throws InterruptedException {

		implicitlyWaiting(driver);
		
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		Thread.sleep(1000);

		driver.navigate().to(Autolocator("Url3"));

		Thread.sleep(1000);
		
		Reporter.log("URL : "+driver.getCurrentUrl(),true);

		driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//*[text()='Get Directions']")).click();

		Thread.sleep(1000);
		// Getting "Get Direction" text in the popup
		String s3 = driver.findElement(By.id("getdirectionmap")).getText();

		// Map Close button
		driver.findElement(By.xpath("//div[@id='divmap']/a")).click();

		System.out.println(s3);

		Assert.assertTrue(s3.contains("DIRECTION"), "Get Direction is not working properly");

		Reporter.log("Get Direction is functionality is working fine, Thank you popup heading text : " + s3, true);

	}

	@Test(enabled = true, priority = 6, retryAnalyzer = Retrytest.class)
	public void f13_ViewReview() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		Thread.sleep(1000);

		List<WebElement> s1 = driver.findElements(By.xpath("//*[text()='View Reviews']"));

		for (WebElement s2 : s1) {
			s2.click();

			Thread.sleep(1000);

			implicitlyWaiting(driver);
			// Photo next button
			driver.findElement(By.xpath("//*[text()='Show less']")).click();

			break;

		}

		Reporter.log("Review show less and more functionality is working fine ", true);

	}

}
