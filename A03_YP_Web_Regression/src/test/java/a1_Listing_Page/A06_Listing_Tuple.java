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

public class A06_Listing_Tuple extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));

		
	}

	@Test(enabled = true, priority = 1, retryAnalyzer = Retrytest.class)
	public void f01_ProfileLink() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		// Listing tuple link
		Thread.sleep(500);
		Explecit(driver, "xpath", "//ol[@id='divV8Businesslist']/li[1]//h3/a");
		String s1 = driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//h3/a")).getText();

		driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//h3/a")).click();

		// profile page heading tag
		Thread.sleep(2000);
		Explecit(driver, "xpath", "//h1");
		String s2 = driver.findElement(By.xpath("//h1")).getText();

		s1 = s1.substring(0, 6);

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "Issue in listing profile link");

		Reporter.log("Listing tuple profile link is working fine ", true);
	}

	@Test(enabled = true, priority = 2, retryAnalyzer = Retrytest.class)
	public void f02_Verifytickmark() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		// Listing tuple verified business
		List<WebElement> ele = driver.findElements(By.xpath("//span[@class='bus-verified']"));

		int s1 = ele.size();
		Reporter.log("listing page total verified business count : " + s1 + " out of 10 business", true);

	}

	@Test(enabled = true, priority = 3, retryAnalyzer = Retrytest.class)
	public void f03_PaidBadge() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		String s1 = driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//h3/a/preceding::span[1]"))
				.getAttribute("class");

		Reporter.log("listing page sulekha badge is display the first business badge name is : " + s1, true);

	}

	@Test(enabled = true, priority = 4, retryAnalyzer = Retrytest.class)
	public void f04_ReviewListingtoProfile() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		// Rating image in listing page second tuple
		Thread.sleep(500);
		Explecit(driver, "xpath", "//ol[@id='divV8Businesslist']/li[1]/following::span[3]");
		String s1 = driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]/following::span[3]"))
				.getAttribute("class");

		// Review count in Listing page second tuple
		String s2 = driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]/following::a[2]")).getText();

		// listing profile link
		driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]/following::a[1]")).click();

		Thread.sleep(1000);
		Explecit(driver, "xpath", "//div[@class='float-left']/span");

		// Rating image in Profile page second tuple
		String s3 = driver.findElement(By.xpath("//div[@class='float-left']/span")).getAttribute("class");

		// Review count in Profile page second tuple
		String s4 = driver.findElement(By.xpath("//div[@class='float-left']/a")).getText();

		Assert.assertTrue(s1.toLowerCase().contains(s3.toLowerCase()), "issue in rating compare");

		Assert.assertTrue(s2.toLowerCase().equalsIgnoreCase(s4.toLowerCase()), "issue in review compare");

		Reporter.log("Rating is working fine in listing and profile value is " + s1 + "\t" + s3, true);

		Reporter.log("Review is working fine in listing and profile value is " + s2 + "\t" + s4, true);

	}

	@Test(enabled = true, priority = 5, retryAnalyzer = Retrytest.class)
	public void f05_ScoreListingtoProfile() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		// Sulekha score in listing page second tuple

		Thread.sleep(500);

		Explecit(driver, "xpath", "//ol[@id='divV8Businesslist']/li[1]/following::span[4]/strong");

		String s1 = driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]/following::span[4]/strong"))
				.getText();

		// listing profile link
		driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]/following::a[1]")).click();

		Thread.sleep(500);

		Explecit(driver, "xpath", "//span[@class='sulekha-score']/strong");

		// Sulekha score in profile page
		String s2 = driver.findElement(By.xpath("//span[@class='sulekha-score']/strong")).getText();

		Assert.assertTrue(s1.equals(s2), "issue in sulekha score listing and profile page");

		Reporter.log("Sulekha score is matching listing and profile page : " + s1 + "\t" + s2, true);

	}

	@Test(enabled = true, priority = 6, retryAnalyzer = Retrytest.class)
	public void f06_TnCLink() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		Thread.sleep(2000);
		// Explecit(driver, "xpath",
		// "//ol[@id='divV8Businesslist']//a[@class='icon-virtual']");

		List<WebElement> ele = driver.findElements(By.xpath("//ol[@id='divV8Businesslist']//a[@class='icon-virtual']"));

		System.out.println(ele.size());

		for (WebElement s2 : ele)

		{
			Thread.sleep(3000);

			String s4 = s2.getAttribute("href");

			Reporter.log("T&C apply link working fine, URL is : " + s4, true);

			Assert.assertTrue(s4.contains("/collateral/terms.aspx#lcf") || s4.contains("/collateral/terms#lcf"),
					"T&C apply link is incorrect navigation");

			break;
		}

	}

	@Test(enabled = true, priority = 7, retryAnalyzer = Retrytest.class)
	public void f07_AboutMoreLessLink() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		//Overlayclose(driver);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		Thread.sleep(1000);

		Explecit(driver, "xpath", "//*[text()='more']");

		List<WebElement> s1 = driver.findElements(By.xpath("//*[text()='more']"));

		for (WebElement s2 : s1) {
			s2.click();

			/*
			 * Thread.sleep(2000);
			 * 
			 * Explecit(driver, "xpath", "//*[text()='less']");
			 * 
			 * WebElement ele =
			 * driver.findElement(By.xpath("//*[text()='less']"));
			 * 
			 * ele.click();
			 */

			Reporter.log("About more link is working fine in listing tuple : ", true);

			break;

		}

	}

}
