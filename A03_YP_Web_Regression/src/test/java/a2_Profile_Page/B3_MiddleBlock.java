package a2_Profile_Page;

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

public class B3_MiddleBlock extends Commonmethods {

	String profileurl = "https://www.sulekha.com/js-home-services-saidapet-chennai-contact-address";

	@BeforeMethod
	public void url() {
		navigate_to(driver, profileurl);

	}

	@Test(priority = 1, enabled = true, retryAnalyzer = Retrytest.class)
	public void c1_ServiceOfferMoreLink() throws InterruptedException {
		implicitlyWaiting(driver);

		Reporter.log("URL: " + profileurl, true);

		Thread.sleep(500);

		// ServiceOffer More link link
		driver.findElement(By.xpath("//*[text()='More »']")).click();

		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[contains(@class, 'serviceoffered')]/a");

		driver.findElement(By.xpath("//div[contains(@class, 'serviceoffered')]/a")).click();

		Reporter.log("ServiceOffer More link working fine ", true);

	}

	@Test(priority = 2, enabled = true, retryAnalyzer = Retrytest.class)
	public void c2_AboutMoreLink() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(500);

		// ServiceOffer More link link
		driver.findElement(By.xpath("//div[contains(@class, 'bus-about')]//a")).click();

		Thread.sleep(500);
		Explecit(driver, "xpath", "//button[contains(@class, 'sdialog-close')]");

		driver.findElement(By.xpath("//button[contains(@class, 'sdialog-close')]")).click();

		Reporter.log("About  More link working fine ", true);

	}

	@Test(priority = 3, enabled = true, retryAnalyzer = Retrytest.class)
	public void c3_ReviewPagination() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		// Next
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text()='NEXT']");

		driver.findElement(By.xpath("//*[text()='NEXT']")).click();
		// Prev
		Thread.sleep(1000);
		Explecit(driver, "xpath", "//*[text()='PREV']");

		driver.findElement(By.xpath("//*[text()='PREV']")).click();

		Thread.sleep(2000);

		String s1 = driver.findElement(By.xpath("//*[text()='NEXT']/preceding::strong[1]")).getText();

		Assert.assertTrue(s1.equalsIgnoreCase("Page 1"), "error in review pagination");

		Reporter.log("Review paginantion is working fine " + s1, true);

	}

	@Test(priority = 4, enabled = true, retryAnalyzer = Retrytest.class)
	public void c4_WriteReviews() throws InterruptedException {
		implicitlyWaiting(driver);
		// test business
		driver.navigate().to("https://www.sulekha.com/category-king-locality9-ypcity-contact-address");
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Sign in
		Thread.sleep(500);
		Explecit(driver, "xpath", Autolocator("Signin"));

		Click_element(driver, "xpath", Autolocator("Signin"));

		// frame
		WebElement ele = driver.findElement(By.id(Autolocator("Singiniframeid")));

		driver.switchTo().frame(ele);
		Thread.sleep(2000);
		ExplecitID(driver, "id", Autolocator("Mobilenoid"));
		// Send mobile no
		SendKey_element(driver, "id", Autolocator("Mobilenoid"), Autolocator("Mobileno"));

		// Send password
		Thread.sleep(2000);
		ExplecitID(driver, "id", Autolocator("passwordid"));
		SendKey_element(driver, "id", Autolocator("passwordid"), Autolocator("password"));

		// Click signin button
		Thread.sleep(1000);
		ExplecitID(driver, "id", Autolocator("siginbuttonid"));
		Click_element(driver, "id", Autolocator("siginbuttonid"));

		driver.switchTo().defaultContent();

		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		// Write Reviews

		Thread.sleep(3000);
		Explecit(driver, "xpath", "//*[text()='Write Reviews']");

		driver.findElement(By.xpath("//*[text()='Write Reviews']")).click();

		Thread.sleep(2000);
		Explecit(driver, "xpath", "//button[4]");

		driver.findElement(By.xpath("//button[4]")).click();

		driver.findElement(By.id("txtreviewShortDesc")).sendKeys("Good service provider keep up you good work");

		Thread.sleep(500);

		driver.findElement(By.id("postreview")).click();

		Thread.sleep(2000);
		Explecit(driver, "xpath", "//span[contains(@class, 'reviewsuccess')]");

		String s1 = driver.findElement(By.xpath("//span[contains(@class, 'reviewsuccess')]")).getText();

		Reporter.log("Write Reviews functionality is working fine " + s1, true);

		Assert.assertTrue(s1.contains("Thank you for your rating"), "error in Write a review function");

	}

	@Test(priority = 5, enabled = true, retryAnalyzer = Retrytest.class)
	public void c5_ReviewMoreLesslink() throws InterruptedException {
		implicitlyWaiting(driver);
		// test business
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		String s1 = null;

		for (int i = 1; i <= 5; i++) {
			try {
				driver.findElement(By.xpath("//*[text()='Read Reviews']/following::*[text()='more']")).isDisplayed();
				s1 = "true";
			} catch (Exception ie) {
				s1 = "false";
			}

			if (s1.equals("false")) {
				// Next
				Thread.sleep(1000);
				Explecit(driver, "xpath", "//*[text()='NEXT']");

				driver.findElement(By.xpath("//*[text()='NEXT']")).click();

			}
			if (s1.equals("true")) {
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[text()='Read Reviews']/following::*[text()='more']")).click();

				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[text()='Read Reviews']/following::*[text()='less']")).click();

				Reporter.log("Reviews more and less button is working fine ", true);

				break;
			}

		}
	}

	@Test(priority = 6, enabled = true, retryAnalyzer = Retrytest.class)
	public void c6_ReviewMoreLesslink() throws InterruptedException {
		implicitlyWaiting(driver);
		// test business
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		List<WebElement> ele = driver.findElements(By.xpath("//*[text()='Helpful']"));

		for (WebElement s1 : ele) {
			Thread.sleep(1000);
			s1.click();

			Thread.sleep(500);
			Explecit(driver, "xpath", "//span[contains(@class, 'vote')]");
			// Thank you message
			String s2 = driver.findElement(By.xpath("//span[contains(@class, 'vote')]")).getText();

			if (s2.contains("Thank you")) {
				Reporter.log("Review Helpful button is working fine : " + s2, true);

			} else if (s2.contains("Sorry. You")) {
				Reporter.log("Review Helpful button is working fine : " + s2, true);

			} else {

				Assert.fail();

			}

			break;
		}

	}

}
