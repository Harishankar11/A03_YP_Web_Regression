package a2_Profile_Page;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import a0_lib.Commonmethods;
import a0_lib.Retrytest;

public class B4_RightBlock extends Commonmethods {

	String profileurl = "https://www.sulekha.com/js-home-services-saidapet-chennai-contact-address";

	@BeforeMethod
	public void url() {
		navigate_to(driver, profileurl);

	}

	@Test(priority = 1, enabled = true, retryAnalyzer = Retrytest.class)
	public void d1_SavetoPhone() throws InterruptedException {
		implicitlyWaiting(driver);

		Reporter.log("URL: " + profileurl, true);

		Thread.sleep(500);
		ExplecitID(driver, "id", "txtName");

		// Name
		driver.findElement(By.id("txtName")).sendKeys("Hari");
		// Mobile
		driver.findElement(By.id("txtMobile")).sendKeys("9380835000");

		driver.findElement(By.id("btnSavetoPhonePopup")).click();

		Thread.sleep(2000);
		ExplecitID(driver, "id", "txtvcode");
		// OTP
		driver.findElement(By.id("txtvcode")).sendKeys("999999");

		// verify
		driver.findElement(By.xpath("//div[@class='verify-number']/button")).click();

		Thread.sleep(4000);
		Explecit(driver, "xpath", "//div[@id='divProfileER']");

		String s1 = driver.findElement(By.xpath("//div[@id='divProfileER']")).getText();

		Assert.assertTrue(s1.contains("Thank you"), "issue in Save to phone");

		Reporter.log("Save to phone is working fine : " + s1, true);

	}

	@Test(priority = 2, enabled = true, retryAnalyzer = Retrytest.class)
	public void d2_FreeProfileGetQuote() throws InterruptedException {
		implicitlyWaiting(driver);

		driver.navigate().to("https://www.sulekha.com/anand-electricals-saidapet-chennai-contact-address");
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		try {

			Explecit(driver, "xpath", "//a[@class='sdialog-x']");
			// Close
			driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();
		} catch (Exception ie) {
		}

		Thread.sleep(500);
		Explecit(driver, "xpath", "//button[@class='btn-p']");

		// Getquote
		driver.findElement(By.xpath("//button[@class='btn-p']")).click();

		Thread.sleep(3000);
		// Explecit(driver, "xpath", "//a[@class='sdialog-x']");
		// Close
		WebElement ele = driver.findElement(By.xpath("//div[@class='sdialog']//a"));

		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();

		Reporter.log("Free profile GET QUOTE link is working fine ", true);

	}

	@Test(priority = 3, enabled = true, retryAnalyzer = Retrytest.class)
	public void d3_TollfreeNo() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(500);

		((JavascriptExecutor) driver).executeScript("scroll(0,100)");

		Thread.sleep(3000);
		Explecit(driver, "xpath", "//div[@class='ads-business']");

		driver.findElement(By.xpath("//div[@class='ads-business']/a")).click();
		
		Thread.sleep(3000);
		
		ArrayList<String> Windowhendles = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(Windowhendles.get(1));

		String s1 = driver.getCurrentUrl();

		Assert.assertTrue(s1.contains("business-owners"), "issue in Help and feedback url");

		Reporter.log("Toll free number link navigation is working fine, URL is : " + s1, true);

		driver.close();

		driver.switchTo().window(Windowhendles.get(0));

	}

	/*@Test(priority = 4, enabled = true, retryAnalyzer = Retrytest.class)
	public void d4_AddyourBusiness() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(500);

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		Thread.sleep(1000);
		Explecit(driver, "xpath", "//a[@title='Add your business for free']");

		driver.findElement(By.xpath("//a[@title='Add your business for free']")).click();

		Thread.sleep(3000);

		ArrayList<String> Windowhendles = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(Windowhendles.get(1));

		String s1 = driver.getCurrentUrl();

		Assert.assertTrue(s1.contains("business-owners"), "issue in Help and feedback url");

		Reporter.log("Add your business link navigation is working fine, URL is : " + s1, true);

		driver.close();

		driver.switchTo().window(Windowhendles.get(0));

	}*/

	@Test(priority = 5, enabled = true, retryAnalyzer = Retrytest.class)
	public void d5_HelpFeedback() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(1000);

		// Next button
		driver.findElement(By.xpath("//span[@class='help-icon']/img")).click();

		Thread.sleep(500);

		Explecit(driver, "xpath", "//*[text()='Feedback']");

		driver.findElement(By.xpath("//*[text()='Feedback']")).click();
		
		Thread.sleep(3000);
		
		ArrayList<String> Windowhendles = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(Windowhendles.get(1));

		String s1 = driver.getCurrentUrl();

		Assert.assertTrue(s1.contains("collateral/contactus"), "issue in Help and feedback url");

		Reporter.log("Help and Feedback link is working fine, URL is : " + s1, true);

		driver.close();

		driver.switchTo().window(Windowhendles.get(0));

	}

	@Test(priority = 6, enabled = true, retryAnalyzer = Retrytest.class)
	public void d6_BacktoTop() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

		Thread.sleep(1000);

		Explecit(driver, "xpath", "//a[@class='back-to-top']");

		// BacktoTop button
		driver.findElement(By.xpath("//a[@class='back-to-top']")).click();
		Thread.sleep(2000);
		Reporter.log("Back to top link is working fine ", true);

	}

}
