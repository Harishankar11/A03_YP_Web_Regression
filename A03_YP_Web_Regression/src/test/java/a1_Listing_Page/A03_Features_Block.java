package a1_Listing_Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import a0_lib.Commonmethods;
import a0_lib.Retrytest;

public class A03_Features_Block extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));

	}

	@Test(priority = 1, enabled = true, retryAnalyzer = Retrytest.class)
	public void c01_Feature_ProfileLink() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		Overlayclose(driver);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		Thread.sleep(3000);
		Explecit(driver, "xpath", "//div[@id='LeftPanel']/ul/li/h3");

		// Feature total count
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='LeftPanel']/ul/li/h3"));

		for (int i = 1; i <= ele.size();) {

			// Get text Business
			Thread.sleep(3000);
			Explecit(driver, "xpath", "//div[@id='LeftPanel']/ul/li[" + i + "]/h3/a");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String s1 = driver.findElement(By.xpath("//div[@id='LeftPanel']/ul/li[" + i + "]/h3/a")).getText();

			// Click business name
			Thread.sleep(2000);
			Explecit(driver, "xpath", "//div[@id='LeftPanel']/ul/li[" + i + "]/h3/a");
			driver.findElement(By.xpath("//div[@id='LeftPanel']/ul/li[" + i + "]/h3/a")).click();

			Thread.sleep(500);
			Explecit(driver, "xpath", "//h1");

			// verify with profile header with feature business name
			String s2 = driver.findElement(By.xpath("//h1")).getText();

			Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in feature link");
			Reporter.log("Feature profile link is working fine " + s1 + s2, true);

			break;

		}

	}

	@Test(priority = 2, enabled = true, retryAnalyzer = Retrytest.class)
	public void c02_Feature_ReviewLink() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		//Overlayclose(driver);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		Thread.sleep(3000);
		Explecit(driver, "xpath", "//div[@id='LeftPanel']/ul/li/h3");
		// Feature total count
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='LeftPanel']/ul/li/h3"));

		for (int i = 1; i <= ele.size();) {
			Thread.sleep(3000);
			Explecit(driver, "xpath", "//div[@id='LeftPanel']/ul/li[" + i + "]/following::div[@class='rating']/a");
			// Click on review link
			driver.findElement(By.xpath("//div[@id='LeftPanel']/ul/li[" + i + "]/following::div[@class='rating']/a"))
					.click();

			Thread.sleep(500);
			Explecit(driver, "xpath", "//div[@id='bizreviews']/h2");

			// verify link land on profile page and focus on review block
			String s2 = driver.findElement(By.xpath("//div[@id='bizreviews']/h2")).getText();

			Assert.assertTrue(s2.toLowerCase().contains("Ratings & Reviews".toLowerCase()), "review link issue");

			Reporter.log("Feature Review link is working fine " + s2, true);

			break;

		}

	}

	@Test(priority = 3, enabled = true, retryAnalyzer = Retrytest.class)
	public void c03_Feature_SENDSMS() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		Thread.sleep(2000);
		Explecit(driver, "xpath", "//div[@id='LeftPanel']//li/h3");
		// Feature total count
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='LeftPanel']//li/h3"));

		for (int i = 1; i <= ele.size();) {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// Click on SEND SMS button
			driver.findElement(By.xpath("//div[@id='LeftPanel']/ul/li[" + i + "]/button[1]")).click();
			Thread.sleep(2000);
			Explecit(driver, "xpath", "//div[@class='sdialog-title']");

			// Get text Send SMS header
			String s1 = driver.findElement(By.xpath("//div[@class='sdialog-title']")).getText();

			Assert.assertTrue(s1.toLowerCase().contains("Send SMS".toLowerCase()), "review link issue");
			Reporter.log("Send SMS link is working fine " + s1, true);

			break;

		}

	}

	@Test(priority = 4, enabled = true, retryAnalyzer = Retrytest.class)
	public void c04_GetQuote() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		Thread.sleep(2000);
		Explecit(driver, "xpath", "//div[@id='LeftPanel']//li/h3");
		// Feature total count
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='LeftPanel']//li/h3"));

		for (int i = 1; i <= ele.size();) {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// Click on SEND SMS button
			driver.findElement(By.xpath("//div[@id='LeftPanel']/ul/li[" + i + "]/button[2]")).click();
			Thread.sleep(2000);
			Explecit(driver, "xpath", "//a[@class='sdialog-x']");

			// Close the get quote popup
			driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();

			// Verification this test case close button if popup is not open
			// testcase get fail

			Reporter.log("Get Qoute link is working fine ", true);

			break;

		}

	}

	@Test(priority = 5, enabled = true, retryAnalyzer = Retrytest.class)
	public void c05_Photo() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		Thread.sleep(2000);
		Explecit(driver, "xpath", "//div[@id='LeftPanel']//li/h3");
		// Feature total count
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='LeftPanel']//li/h3"));

		for (int i = 1; i <= ele.size();) {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			// Click on SEND SMS button
			driver.findElement(By.xpath("//div[@id='LeftPanel']/ul/li[" + i + "]//figure/img")).click();
			Thread.sleep(2000);
			Explecit(driver, "xpath", "//span[@class='sgallery-x']");

			// Close the get quote popup
			driver.findElement(By.xpath("//span[@class='sgallery-x']")).click();

			// Verification this test case close button if popup is not open
			// testcase get fail

			Reporter.log("Photo link is working fine ", true);

			break;

		}

	}

}
