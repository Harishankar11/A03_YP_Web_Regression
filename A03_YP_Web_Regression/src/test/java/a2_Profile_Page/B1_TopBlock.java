package a2_Profile_Page;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import a0_lib.Commonmethods;
import a0_lib.Retrytest;

public class B1_TopBlock extends Commonmethods {

	String profileurl = "https://www.sulekha.com/js-home-services-saidapet-chennai-contact-address";

	@BeforeMethod
	public void url() {
		navigate_to(driver, profileurl);

	}

	@Test(priority = 1, enabled = true, retryAnalyzer = Retrytest.class)
	public void a1_Breadcrumb() throws InterruptedException {
		implicitlyWaiting(driver);

		
		
		driver.navigate().to("https://www.sulekha.com/elite-packers-movers-perungudi-chennai-contact-address");
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(500);
		Explecit(driver, "xpath", "//ol[@class='breadcrumb']//li[1]//a");

		String s1 = driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[1]//a")).getText();

		driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[1]//a")).click();

		// First breadcrumb link page h1 tag
		Thread.sleep(500);
		Explecit(driver, "xpath", "//h1");

		String s2 = driver.findElement(By.xpath("//h1")).getText();

		driver.navigate().back();

		Thread.sleep(500);
		Explecit(driver, "xpath", "//ol[@class='breadcrumb']//li[2]//a");

		// second breadcrumb locator
		String s3 = driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[2]//a")).getText();

		driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[2]//a")).click();
		// second breadcrumb link page h1 tag
		Thread.sleep(500);
		Explecit(driver, "xpath", "//h1");

		String s4 = driver.findElement(By.xpath("//h1")).getText();

		driver.navigate().back();

		Thread.sleep(500);
		Explecit(driver, "xpath", "//ol[@class='breadcrumb']//li[3]//a");

		// Third breadcrumb locator
		String s5 = driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[3]//a")).getText();

		driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[3]//a")).click();
		// Third breadcrumb link page h1 tag
		Thread.sleep(500);
		Explecit(driver, "xpath", "//h1");

		String s6 = driver.findElement(By.xpath("//h1")).getText();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "Breadcrumb 1 link is incorrect");

		Assert.assertTrue(s4.toLowerCase().contains(s3.toLowerCase()), "Breadcrumb 2 link is incorrect");

		Assert.assertTrue(s6.toLowerCase().contains(s5.toLowerCase()), "Breadcrumb 2 link is incorrect");

		Reporter.log("Breadcrumb links navigation working fine ", true);

	}

	@Test(priority = 2, enabled = true, retryAnalyzer = Retrytest.class)
	public void a2_VerifiedIcon() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		try {
			Thread.sleep(500);
			Explecit(driver, "xpath", "//span[@class='bus-verified']");

			// Verify icon
			Boolean s1 = driver.findElement(By.xpath("//span[@class='bus-verified']")).isDisplayed();

			Assert.assertTrue(s1, "Verified business is not display");

			Reporter.log("Verified icon is display in the profile page " + s1, true);

		}
		// check the second biz if fails
		catch (Exception ie) {
			driver.navigate().to("https://www.sulekha.com/power-cooling-systems-shenoy-nagar-chennai-contact-address");
			Reporter.log("URL : "+driver.getCurrentUrl(),true);
			Explecit(driver, "xpath", "//span[@class='bus-verified']");

			// Verify icon
			Boolean s1 = driver.findElement(By.xpath("//span[@class='bus-verified']")).isDisplayed();

			Reporter.log("Verified icon is display in the profile page ", true);

			Assert.assertTrue(s1, "Verified business is not display");
		}

	}

	@Test(priority = 3, enabled = true, retryAnalyzer = Retrytest.class)
	public void a3_PaidBadge() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		try {
			Thread.sleep(500);
			Explecit(driver, "xpath", "//h1//preceding::span[3]");

			// Paid icon
			Boolean s1 = driver.findElement(By.xpath("//h1//preceding::span[3]")).isDisplayed();

			Assert.assertTrue(s1, "Paid badge is not display");

			Reporter.log("Paid badge icon is display in the profile page " + s1, true);

		}
		// check the second biz if fails
		catch (Exception ie) {
			driver.navigate().to("https://www.sulekha.com/power-cooling-systems-shenoy-nagar-chennai-contact-address");
			Reporter.log("URL : "+driver.getCurrentUrl(),true);
			Thread.sleep(500);
			Explecit(driver, "xpath", "//h1//preceding::span[3]");

			// Paid icon
			Boolean s1 = driver.findElement(By.xpath("//h1//preceding::span[3]")).isDisplayed();

			Assert.assertTrue(s1, "Paid badge is not display");

			Reporter.log("Paid badge icon is display in the profile page " + s1, true);
		}

	}

	@Test(priority = 4, enabled = true, retryAnalyzer = Retrytest.class)
	public void a4_OwnThisListing() throws InterruptedException {
		implicitlyWaiting(driver);

		try {
			driver.navigate()
					.to("https://www.sulekha.com/international-packing-moving-co-chintadripet-chennai-contact-address");
			Reporter.log("URL : "+driver.getCurrentUrl(),true);
			try {
				driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();
			} catch (Exception ie) {
			}

			Thread.sleep(500);
			Explecit(driver, "xpath", "//*[text()='Own this listing']");

			// OwnThisListing icon
			driver.findElement(By.xpath("//*[text()='Own this listing']")).click();

			ArrayList<String> getWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(getWindow.get(1));

			Thread.sleep(2000);
			String s1 = driver.getCurrentUrl();

			Reporter.log("Own listing link is working fine in the profile page " + s1, true);

			Assert.assertTrue(s1.contains("business-owners"), "Own listing link is not working");

		}
		// check the second biz if fails
		catch (Exception ie2) {
			driver.navigate()
					.to("https://www.sulekha.com/goel-cargo-packers-movers-madhavaram-chennai-contact-address");
			Reporter.log("URL : "+driver.getCurrentUrl(),true);
			try {
				driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();
			} catch (Exception ie1) {
			}

			Thread.sleep(500);
			Explecit(driver, "xpath", "//*[text()='Own this listing']");

			// OwnThisListing icon
			driver.findElement(By.xpath("//*[text()='Own this listing']")).click();

			ArrayList<String> getWindow = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(getWindow.get(1));

			Thread.sleep(3000);
			String s1 = driver.getCurrentUrl();

			Reporter.log("Own listing link is working fine in the profile page " + s1, true);

			Assert.assertTrue(s1.contains("business-owners"), "Own listing link is not working");

		}

	}

}
