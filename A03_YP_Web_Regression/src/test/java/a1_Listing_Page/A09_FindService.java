package a1_Listing_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import a0_lib.Commonmethods;
import a0_lib.Retrytest;

public class A09_FindService extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));

	
	}

	@Test(enabled = true, priority = 1, retryAnalyzer = Retrytest.class)
	public void i01_QuickLinks() throws InterruptedException {
		String s1 = null;

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,4300)");

		// Quick links
		try {// non core
			Thread.sleep(500);
			Explecit(driver, "xpath", "//div[@class='stabs-panel']//div[contains(@class, 'active')]//li[1]/a");

			s1 = driver.findElement(By.xpath("//div[@class='stabs-panel']//div[contains(@class, 'active')]//li[1]/a"))
					.getText();

			driver.findElement(By.xpath("//div[@class='stabs-panel']//div[contains(@class, 'active')]//li[1]/a"))
					.click();

		} catch (Exception ie7) // core
		{
			Thread.sleep(2000);
			Explecit(driver, "xpath", "//div[@class='QuickLinks active']//li[1]");

			s1 = driver.findElement(By.xpath("//div[@class='QuickLinks active']//li[1]")).getText();

			driver.findElement(By.xpath("//div[@class='QuickLinks active']//li[1]")).click();
		}
		// Attribute page heading
		Thread.sleep(500);
		Explecit(driver, "xpath", "//h1");

		String s2 = driver.findElement(By.xpath("//h1")).getText();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in Quick links navigation");

		Reporter.log("Quick links navigation is working fine " + s2, true);
	}

	@Test(enabled = true, priority = 2, retryAnalyzer = Retrytest.class)
	public void i02_ByLocality() throws InterruptedException {
		String s1 = null;

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,4300)");

		// By locality tab
		Thread.sleep(1000);
		Explecit(driver, "xpath", "//*[text()='By Locality']");

		driver.findElement(By.xpath("//*[text()='By Locality']")).click();

		// By locality
		try { // core
			
			Thread.sleep(3000);
			Explecit(driver, "xpath", "//div[@class='ByLocality active']//li[2]");

			s1 = driver.findElement(By.xpath("//div[@class='ByLocality active']//li[2]")).getText();

			driver.findElement(By.xpath("//div[@class='ByLocality active']//li[2]")).click();
			
		} catch (Exception ie3) { // non core

			Thread.sleep(3000);
			Explecit(driver, "xpath", "//div[@class='locality active']//li[2]");

			s1 = driver.findElement(By.xpath("//div[@class='locality active']//li[2]")).getText();

			driver.findElement(By.xpath("//div[@class='locality active']//li[2]")).click();
		}
		// Attribute page heading
		Thread.sleep(3000);
		Explecit(driver, "xpath", "//h1");

		String s2 = driver.findElement(By.xpath("//h1")).getText();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in Localtiy links navigation");

		Reporter.log("By Localtiy links navigation is working fine " + s2, true);
	}

	@Test(enabled = true, priority = 3, retryAnalyzer = Retrytest.class)
	public void i03_ByCity() throws InterruptedException {

		String s1 = null;

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,4300)");

		// By City tab
		Thread.sleep(2000);
		Explecit(driver, "xpath", "//*[text()='By City']");

		driver.findElement(By.xpath("//*[text()='By City']")).click();

		// By City
		try {// core
			
			Thread.sleep(2000);
			Explecit(driver, "xpath", "//div[@class='ByCity active']//li[2]");

			s1 = driver.findElement(By.xpath("//div[@class='ByCity active']//li[2]")).getText();

			driver.findElement(By.xpath("//div[@class='ByCity active']//li[2]")).click();
			
		} catch (Exception ie6) {// non core

			Thread.sleep(2000);
			Explecit(driver, "xpath", "//div[@class='city active']//li[2]");

			s1 = driver.findElement(By.xpath("//div[@class='city active']//li[2]")).getText();

			driver.findElement(By.xpath("//div[@class='city active']//li[2]")).click();
		}
		// Attribute page heading
		Thread.sleep(2000);
		Explecit(driver, "xpath", "//h1");

		String s2 = driver.findElement(By.xpath("//ol[@class='breadcrumb']/li[3]")).getText();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in city links navigation");

		Reporter.log("By city links navigation is working fine " + s2, true);
	}

	@Test(enabled = true, priority = 4, retryAnalyzer = Retrytest.class)
	public void i04_ViewMoreCities() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,4300)");

		// By City tab
		Thread.sleep(1000);
		Explecit(driver, "xpath", "//*[text()='By City']");

		driver.findElement(By.xpath("//*[text()='By City']")).click();

		// By View More Cities
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text()='View More Cities >>']");

		driver.findElement(By.xpath("//*[text()='View More Cities >>']")).click();

		String s1 = driver.getCurrentUrl();

		Reporter.log("View More Cities links navigation is working fine " + s1, true);

		Assert.assertTrue(s1.toLowerCase().contains("/all-cities"), "issue in city links navigation");

	}

	@Test(enabled = true, priority = 5, retryAnalyzer = Retrytest.class)
	public void i05_RelatedServices() throws InterruptedException {

		try {

			implicitlyWaiting(driver);
			Reporter.log("URL : "+driver.getCurrentUrl(),true);
			/*
			 * driver.navigate().to(
			 * "https://www4.sulekha.com/pest-control-services/chennai");
			 * 
			 * //Close the overlay LCF - if need to run this method only enable
			 * this block Overlayclose(driver);
			 */

			((JavascriptExecutor) driver).executeScript("scroll(0,4300)");

			// By City tab
			Thread.sleep(1000);
			Explecit(driver, "xpath", "//*[text()='Related Services']");

			driver.findElement(By.xpath("//*[text()='Related Services']")).click();

			// By View More Cities
			Thread.sleep(500);
			Explecit(driver, "xpath", "//div[@class='RelatedServices active']//li[1]");

			String s1 = driver.findElement(By.xpath("//div[@class='RelatedServices active']//li[1]")).getText();

			driver.findElement(By.xpath("//div[@class='RelatedServices active']//li[1]")).click();

			Thread.sleep(500);
			Explecit(driver, "xpath", "//h1");

			String s2 = driver.findElement(By.xpath("//h1")).getText();

			Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in Related service links navigation");

			Reporter.log("Related service links navigation is working fine " + s2, true);

		} catch (Exception ie1) {
			System.out.println("Related service tab is not avaliable in the category");
		}

	}

}
