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

public class B5_BelowBlock extends Commonmethods {

	String profileurl = "https://www.sulekha.com/js-home-services-saidapet-chennai-contact-address";

	@BeforeMethod
	public void url() {
		navigate_to(driver, profileurl);

	}

	@Test(priority = 1, enabled = true, retryAnalyzer = Retrytest.class)
	public void e1_ProceedLink() throws InterruptedException {
		implicitlyWaiting(driver);
	

		Reporter.log("URL: " + profileurl, true);

		Thread.sleep(500);

		// Proceed button
		driver.findElement(By.xpath("//*[text()='proceed']")).click();

		Thread.sleep(1000);
		Explecit(driver, "xpath", "//a[@class='sdialog-x']");
		// Close
		driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();

		Thread.sleep(1000);

		Reporter.log("Proceed Link is working fine : ", true);

	}

	@Test(priority = 2, enabled = true, retryAnalyzer = Retrytest.class)
	public void e2_FindOtherGetquoteLink() throws InterruptedException {
		implicitlyWaiting(driver);

		Reporter.log("URL: " + profileurl, true);

		Thread.sleep(500);

		((JavascriptExecutor) driver).executeScript("scroll(0,1300)");
		Thread.sleep(1000);
		// Proceed button
		List<WebElement> ele = driver.findElements(By.xpath("//*[text()='get quotes']"));

		for (WebElement s1 : ele) {
			Thread.sleep(2000);
			s1.click();

			Thread.sleep(2000);
			Explecit(driver, "xpath", "//a[@class='sdialog-x']");
			// Close
			driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();

			break;
		}

		Reporter.log("Get quote Link is working fine : ", true);

	}

	@Test(priority = 3, enabled = true, retryAnalyzer = Retrytest.class)
	public void e3_FindOtherProfileLink() throws InterruptedException {
		implicitlyWaiting(driver);

		Reporter.log("URL: " + profileurl, true);

		Thread.sleep(500);

		((JavascriptExecutor) driver).executeScript("scroll(0,1300)");
		Thread.sleep(1000);
		// Proceed button
		List<WebElement> ele = driver.findElements(By.xpath("//div[contains(@class, 'releated-service')]//a"));

		for (WebElement s1 : ele) {
			Thread.sleep(2000);

			String s2 = s1.getText();

			s1.click();

			Thread.sleep(2000);

			try {

				Explecit(driver, "xpath", "//a[@class='sdialog-x']");
				// Close
				driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();
			} catch (Exception ie) {
			}

			String s3 = driver.findElement(By.xpath("//h1")).getText();

			Assert.assertTrue(s3.toLowerCase().contains(s2.toLowerCase()), "issue in find other business link");

			Reporter.log("Get quote Link is working fine : " + s2 + s3, true);

			break;
		}

	}

	@Test(priority = 4, enabled = true, retryAnalyzer = Retrytest.class)
	public void e04_QuickLinks() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		((JavascriptExecutor) driver).executeScript("scroll(0,1500)");

		// Quick links

		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text()='Quick Links']/following::a[4]");

		String s1 = driver.findElement(By.xpath("//*[text()='Quick Links']/following::a[4]")).getText();

		driver.findElement(By.xpath("//*[text()='Quick Links']/following::a[4]")).click();

		// Attribute page heading
		Thread.sleep(500);
		Explecit(driver, "xpath", "//h1");

		String s2 = driver.findElement(By.xpath("//h1")).getText();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in Quick links navigation");

		Reporter.log("Quick links navigation is working fine " + s2, true);
	}

	@Test(priority = 5, enabled = true, retryAnalyzer = Retrytest.class)
	public void e05_ByLocality() throws InterruptedException {

		String s1 = null;

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		((JavascriptExecutor) driver).executeScript("scroll(0,1700)");

		// By locality tab
		Thread.sleep(1000);
		Explecit(driver, "xpath", "//*[text()='By Locality']");

		driver.findElement(By.xpath("//*[text()='By Locality']")).click();

		// By locality
		try { // non core
			Thread.sleep(500);
			Explecit(driver, "xpath", "//div[@class='locality active']//li[2]");

			s1 = driver.findElement(By.xpath("//div[@class='locality active']//li[2]")).getText();

			driver.findElement(By.xpath("//div[@class='locality active']//li[2]")).click();
		} catch (Exception ie3) { // core

			Thread.sleep(500);
			Explecit(driver, "xpath", "//div[@class='ByLocality active']//li[2]");

			s1 = driver.findElement(By.xpath("//div[@class='ByLocality active']//li[2]")).getText();

			driver.findElement(By.xpath("//div[@class='ByLocality active']//li[2]")).click();
		}
		// Attribute page heading
		Thread.sleep(500);
		Explecit(driver, "xpath", "//h1");

		String s2 = driver.findElement(By.xpath("//h1")).getText();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in Localtiy links navigation");

		Reporter.log("By Localtiy links navigation is working fine " + s2, true);
	}

	@Test(priority = 6, enabled = true, retryAnalyzer = Retrytest.class)
	public void e6_ByCity() throws InterruptedException {
		String s1 = null;

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		((JavascriptExecutor) driver).executeScript("scroll(0,1700)");

		// By City tab
		Thread.sleep(1000);
		Explecit(driver, "xpath", "//*[text()='By City']");

		driver.findElement(By.xpath("//*[text()='By City']")).click();

		// By City
		try {// non core
			Thread.sleep(500);
			Explecit(driver, "xpath", "//div[@class='city active']//li[2]");

			s1 = driver.findElement(By.xpath("//div[@class='city active']//li[2]")).getText();

			driver.findElement(By.xpath("//div[@class='city active']//li[2]")).click();
		} catch (Exception ie6) {// core
			Thread.sleep(500);
			Explecit(driver, "xpath", "//div[@class='ByCity active']//li[2]");

			s1 = driver.findElement(By.xpath("//div[@class='ByCity active']//li[2]")).getText();

			driver.findElement(By.xpath("//div[@class='ByCity active']//li[2]")).click();
		}
		// Attribute page heading
		Thread.sleep(500);
		Explecit(driver, "xpath", "//h1");

		String s2 = driver.findElement(By.xpath("//ol[@class='breadcrumb']/li[3]")).getText();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in city links navigation");

		Reporter.log("By city links navigation is working fine " + s2, true);
	}

}
