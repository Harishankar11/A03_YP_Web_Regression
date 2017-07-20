package a1_Listing_Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import a0_lib.Commonmethods;
import a0_lib.Retrytest;

public class A08_ReviewBlock extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));

		
	}

	@Test(enabled = true, priority = 1, retryAnalyzer = Retrytest.class)
	public void h01_ReviewPagination() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		Overlayclose(driver);

		// top review button
		driver.findElement(By.xpath("//*[text()='Top Reviews']")).click();

		Thread.sleep(500);
		ExplecitID(driver, "id", "reviewnextPage");
		// Next button
		driver.findElement(By.id("reviewnextPage")).click();

		Thread.sleep(4000);

		ExplecitID(driver, "id", "reviewprevPage");
		// previous button
		driver.findElement(By.id("reviewprevPage")).click();

		Reporter.log("Review Next and Prev button is working fine", true);

	}

	@Test(enabled = true, priority = 2, retryAnalyzer = Retrytest.class)
	public void h02_ReviewHelpful() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		// top review button
		driver.findElement(By.xpath("//*[text()='Top Reviews']")).click();

		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@class='review-button']/button");
		// Helpful
		driver.findElement(By.xpath("//div[@id='top-reviews']//li[1]//div[@class='review-button']/button")).click();

		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@id='top-reviews']//li[1]//div[@class='row']/span");
		// Thank you message
		String s1 = driver.findElement(By.xpath("//div[@id='top-reviews']//li[1]//div[@class='row']/span")).getText();

		if (s1.contains("Thank you")) {
			Reporter.log("Review Helpful button is working fine : " + s1, true);

		} else if (s1.contains("Sorry. You")) {
			Reporter.log("Review Helpful button is working fine : " + s1, true);

		} else {

			Assert.fail();

		}

	}

	@Test(enabled = true, priority = 3, retryAnalyzer = Retrytest.class)
	public void h03_ReviewMoreLink() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		// top review button
		driver.findElement(By.xpath("//*[text()='Top Reviews']")).click();

		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@class='review-button']/button");

		// more
		List<WebElement> s1 = driver.findElements(By.xpath("//div[@id='top-reviews']//*[text()='more']"));
		Thread.sleep(2000);
		
		for (WebElement s2 : s1) {
			s2.click();

			Reporter.log("Review More button is working fine  ", true);

			break;

		}

		// less
		/*
		 * Explecit(driver, "xpath",
		 * "//div[@id='top-reviews']//li[2]//*[text()='less']");
		 * driver.findElement(By.xpath(
		 * "//div[@id='top-reviews']//li[2]//*[text()='less']")).click();
		 */

	}

}
