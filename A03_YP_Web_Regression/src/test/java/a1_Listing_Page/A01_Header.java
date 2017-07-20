package a1_Listing_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import a0_lib.Commonmethods;
import a0_lib.Retrytest;

public class A01_Header extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));
	}

	@Test(priority = 1, enabled = true, retryAnalyzer = Retrytest.class)

	public void a01_Cityfilter() throws InterruptedException {

		implicitlyWaiting(driver);
		// Close the overlay LCF
		Overlayclose(driver);
		// Close the overlay LCF
		// locating city header
		
		Reporter.log("URL : "+driver.getCurrentUrl(),true);

		String s1 = Get_element(driver, "xpath", Autolocator("HeaderCity_Xpath"));

		Reporter.log("Current city name : " + s1, true);

		Explecit(driver, "xpath", Autolocator("HeaderCity_Xpath"));

		Click_element(driver, "xpath", Autolocator("HeaderCity_Xpath"));

		// Change city in header
		Thread.sleep(1000);

		Explecit(driver, "xpath", Autolocator("HeaderCity1_Xpath"));

		String s2 = Get_element(driver, "xpath", Autolocator("HeaderCity1_Xpath"));

		Click_element(driver, "xpath", Autolocator("HeaderCity1_Xpath"));

		Reporter.log("Selected city name : " + s2, true);
		Thread.sleep(1000);

		// getting url after change the city

		String s3 = driver.getCurrentUrl();

		// Verify changed city it append in the url

		Assert.assertTrue(s3.contains(s2.toLowerCase()), "City page not redirecting");

		Reporter.log("City drop down is working fine", true);

	}

	@Test(priority = 2, enabled = true, retryAnalyzer = Retrytest.class)

	public void a02_Search() throws InterruptedException {
		implicitlyWaiting(driver);

		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		String s3 = "packers";
		
		Reporter.log("URL : "+driver.getCurrentUrl(),true);

		// search
		Thread.sleep(500);
		Explecit(driver, "xpath", Autolocator("Search_xpath"));

		SendKey_element(driver, "xpath", Autolocator("Search_xpath"), s3);

		Thread.sleep(2000);

		Explecit(driver, "xpath", Autolocator("Search_Result"));
		// Clicking drop down result

		String s1 = Get_element(driver, "xpath", Autolocator("Search_Result"));

		Click_element(driver, "xpath", Autolocator("Search_Result"));

		Reporter.log("Selected values : " + s1, true);

		Thread.sleep(2000);
		Explecit(driver, "xpath", Autolocator("Close_xpath"));

		// LCF Close button
		Click_element(driver, "xpath", Autolocator("Close_xpath"));

		Thread.sleep(3000);

		String s2 = driver.getCurrentUrl();

		// Verify changed city it append in the url

		Assert.assertTrue(s2.contains(s3.toLowerCase()), "LCF close navigation is not working");

		Reporter.log("Header Search functionality is working fine, the current url is : " + s2, true);

	}

	@Test(priority = 3, enabled = true, retryAnalyzer = Retrytest.class)

	public void a03_BusniessOwner_DownloadApp() throws InterruptedException {
		implicitlyWaiting(driver);

		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		// Header Business owner
		Click_element(driver, "xpath", Autolocator("Business_Owner"));

		String s1 = driver.getCurrentUrl();

		driver.navigate().back();

		Thread.sleep(500);
		Explecit(driver, "xpath", Autolocator("DownloadApp"));

		// Download app owner
		Click_element(driver, "xpath", Autolocator("DownloadApp"));

		String s2 = driver.getCurrentUrl();

		driver.navigate().back();
		Thread.sleep(1000);

		Assert.assertTrue(s1.contains("business"), "Business owner link issue");

		Assert.assertTrue(s2.contains("app"), "Download App link issue");

		Reporter.log("Business Owner url working fine : " + s1, true);

		Reporter.log("Download App url working fine : " + s2, true);

	}

	@Test(priority = 4, enabled = true, retryAnalyzer = Retrytest.class)

	public void a04_Signin_SignOut() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);

		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

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
		Thread.sleep(3000);
		ExplecitID(driver, "id", Autolocator("passwordid"));
		SendKey_element(driver, "id", Autolocator("passwordid"), Autolocator("password"));

		// Click signin button
		Thread.sleep(3000);
		ExplecitID(driver, "id", Autolocator("siginbuttonid"));
		Click_element(driver, "id", Autolocator("siginbuttonid"));

		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		// Click login name
		Explecit(driver, "xpath", Autolocator("signout"));

		Click_element(driver, "xpath", Autolocator("signout"));
		Thread.sleep(2000);

		// Click Dashboard link
		Click_element(driver, "xpath", Autolocator("dashboard"));

		String s2 = driver.getCurrentUrl();

		Assert.assertTrue(s2.contains("dashboard"), "Header Dashboard link is working");

		// Click login name
		Thread.sleep(2000);
		Explecit(driver, "xpath", Autolocator("signout"));

		Click_element(driver, "xpath", Autolocator("signout"));
		Thread.sleep(2000);
		
		Explecit(driver, "xpath", Autolocator("logout"));
		// Click logout button
		Click_element(driver, "xpath", Autolocator("logout"));

		String s1 = driver.getCurrentUrl();

		Assert.assertTrue(s1.equalsIgnoreCase("https://www.sulekha.com/"),
				"Header Sign in and signout button have issue");

		Reporter.log("Header Sign in link navigation is working fine ", true);
		Reporter.log("Header Dashboard link navigation is working fine ", true);
		Reporter.log("Header Sign out link navigation is working fine ", true);

	}

}
