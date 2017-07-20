package a1_Listing_Page;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import a0_lib.Commonmethods;
import a0_lib.Retrytest;

public class A02_TopBlocks extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));

		
	}

	@Test(priority = 1, enabled = true, retryAnalyzer = Retrytest.class)

	public void b01_Breadcrumb_Link() throws InterruptedException {

		implicitlyWaiting(driver);

		// Close the overlay LCF
		Overlayclose(driver);
		
		Reporter.log("URL : "+driver.getCurrentUrl(),true);

		// First breadcrumb locator
		Thread.sleep(500);
		Explecit(driver, "xpath", Autolocator("Breadcrumb1"));

		String s1 = Get_element(driver, "xpath", Autolocator("Breadcrumb1"));

		Click_element(driver, "xpath", Autolocator("Breadcrumb1"));

		// First breadcrumb link page h1 tag
		Thread.sleep(500);
		Explecit(driver, "xpath", Autolocator("Headingtag"));

		String s2 = Get_element(driver, "xpath", Autolocator("Headingtag"));

		driver.navigate().back();

		Thread.sleep(500);
		Explecit(driver, "xpath", Autolocator("Breadcrumb2"));

		// second breadcrumb locator
		String s3 = Get_element(driver, "xpath", Autolocator("Breadcrumb2"));

		Click_element(driver, "xpath", Autolocator("Breadcrumb2"));

		// second breadcrumb link page h1 tag
		Thread.sleep(500);
		Explecit(driver, "xpath", Autolocator("Headingtag"));

		String s4 = Get_element(driver, "xpath", Autolocator("Headingtag"));

		driver.navigate().back();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "Breadcrumb 1 link is incorrect");

		Assert.assertTrue(s4.toLowerCase().contains(s3.toLowerCase()), "Breadcrumb 2 link is incorrect");

		Reporter.log("Breadcrumb link navigation working fine ", true);

	}

	@Test(priority = 2, enabled = true, retryAnalyzer = Retrytest.class)

	public void b02_TnC_LCForm() throws InterruptedException {
		implicitlyWaiting(driver);

		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		// TnC locators
		Thread.sleep(500);
		Explecit(driver, "xpath", Autolocator("TnC"));

		Click_element(driver, "xpath", Autolocator("TnC"));
		Thread.sleep(2000);
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		Thread.sleep(2000);
		String s2 = driver.getCurrentUrl();
		System.out.println(s2);
		Assert.assertTrue(s2.contains("collateral"), "T&C apply link is incorrect navigation");

		Reporter.log("T&C apply link working fine, URL is : " + s2, true);

	}

	@Test(priority = 3, enabled = true, retryAnalyzer = Retrytest.class)

	public void b03_BusinessReviewTab() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);

		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		Thread.sleep(500);
		Explecit(driver, "xpath", Autolocator("TopReviews"));

		Click_element(driver, "xpath", Autolocator("TopReviews"));

		Thread.sleep(3000);

		implicitlyWaiting(driver);

		String s1 = Get_element(driver, "cssSelector", Autolocator("AverageRating"));

		Thread.sleep(500);
		Explecit(driver, "xpath", Autolocator("BusinessListings"));

		Click_element(driver, "xpath", Autolocator("BusinessListings"));

		Thread.sleep(3000);
		implicitlyWaiting(driver);

		String s2 = Get_element(driver, "cssSelector", Autolocator("Sortbutton"));

		Assert.assertTrue(s1.contains("Average"));

		Assert.assertTrue(s2.contains("SORT"));

		Reporter.log("Business Listings and Top Reviews working fine ", true);

	}

}
