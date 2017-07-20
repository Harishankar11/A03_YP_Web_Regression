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

public class B2_LeftBlock extends Commonmethods {

	String profileurl = "https://www.sulekha.com/goodwill-domestic-packers-movers-iso-certified-sudhama-nagar-bangalore-contact-address";

	@BeforeMethod
	public void url() {
		navigate_to(driver, profileurl);

	}

	@Test(priority = 1, enabled = true, retryAnalyzer = Retrytest.class)
	public void b1_ReviewLink() throws InterruptedException {
		implicitlyWaiting(driver);

		Reporter.log("URL: " + profileurl, true);

		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@class='float-left']/a");

		// Review link
		driver.findElement(By.xpath("//div[@class='float-left']/a")).click();

		// Photo link
		Boolean s1 = driver.findElement(By.xpath("//*[text()='Photos']")).isDisplayed();

		Assert.assertTrue(s1, "Issue in Review link ");

		Reporter.log("Review link working fine " + s1, true);

	}

	@Test(priority = 2, enabled = true, retryAnalyzer = Retrytest.class)
	public void b2_TnClink() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(500);

		// TnC link

		String s1 = driver.findElement(By.cssSelector(".icon-virtual")).getAttribute("href");

		Thread.sleep(1000);

		Assert.assertTrue(s1.contains("/collateral/terms.aspx#lcf") || s1.contains("/collateral/terms#lcf"),
				"T&C apply link is incorrect navigation");

		Reporter.log("T&C apply link working fine " + s1, true);

	}

	@Test(priority = 3, enabled = true, retryAnalyzer = Retrytest.class)
	public void b3_GetDirection() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(500);

		// Get Directions

		driver.findElement(By.linkText("Get Directions")).click();

		Thread.sleep(2000);
		// Getting "Get Direction" text in the popup
		String s3 = driver.findElement(By.id("getdirectionmap")).getText();

		// Map Close button
		driver.findElement(By.xpath("//div[@id='divmap']/a")).click();

		System.out.println(s3);

		Assert.assertTrue(s3.contains("DIRECTION"), "Get Direction is not working properly");

		Reporter.log("Get Direction is functionality is working fine, Thank you popup heading text : " + s3, true);

	}

	@Test(priority = 4, enabled = true, retryAnalyzer = Retrytest.class)
	public void b4_WebSiteLink() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		// Web site link
		Thread.sleep(3000);
		String s1 = driver.findElement(By.xpath("//span[@class='ellips']")).getText();

		driver.findElement(By.xpath("//span[@class='ellips']")).click();

		Thread.sleep(3000);

		ArrayList<String> windowhendle = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(windowhendle.get(1));

		String s2 = driver.getCurrentUrl();

		Assert.assertTrue(s1.contains(s2), "issue in WebSite link ");

		Reporter.log("WebSite link is navigation working fine : " + s1 + s2, true);

		driver.close();

		driver.switchTo().window(windowhendle.get(0));
	}

	@Test(priority = 5, enabled = true, retryAnalyzer = Retrytest.class)
	public void b5_ReportError() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		// Report dropdown
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text()='Report']");
		driver.findElement(By.xpath("//*[text()='Report']")).click();
		// Report error
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text()='Report Error']");
		driver.findElement(By.xpath("//*[text()='Report Error']")).click();
		// Report popup other button
		Thread.sleep(3000);
		Explecit(driver, "xpath", "//label[@for='other-error']");

		driver.findElement(By.xpath("//label[@for='other-error']")).click();

		driver.findElement(By.xpath("//textarea[@class='error-other']")).sendKeys("ignore automation testing ");
		// Report error popup No option
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text()='No']");
		driver.findElement(By.xpath("//*[text()='No']")).click();
		// Report error submit button
		Thread.sleep(500);
		Explecit(driver, "xpath", "//button[@class='btn-s save-report']");
		driver.findElement(By.xpath("//button[@class='btn-s save-report']")).click();

		Thread.sleep(1000);
		Explecit(driver, "xpath", "//div[@class='report-error']//h3");

		String s1 = driver.findElement(By.xpath("//div[@class='report-error']//h3")).getText();

		Reporter.log("Report error is working fine : " + s1, true);

		Assert.assertTrue(s1.contains("Thank you"), "issue in submit the report error");

	}

	@Test(priority = 6, enabled = true, retryAnalyzer = Retrytest.class)
	public void b6_ReportComplaint() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		// Report dropdown
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text()='Report']");
		driver.findElement(By.xpath("//*[text()='Report']")).click();

		// Report Complaint
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text()='Report Complaint']");
		driver.findElement(By.xpath("//*[text()='Report Complaint']")).click();
		// Name
		Thread.sleep(2000);
		Explecit(driver, "xpath", "//div[@class='report-complaint']//input[@id='txtName']");

		driver.findElement(By.xpath("//div[@class='report-complaint']//input[@id='txtName']")).sendKeys("Hari");
		// Mobile
		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@class='report-complaint']//input[@id='txtMobile']");

		driver.findElement(By.xpath("//div[@class='report-complaint']//input[@id='txtMobile']")).sendKeys("9380835000");
		// Text box
		Thread.sleep(500);
		Explecit(driver, "xpath", "//textarea[@class='textareacounter']");

		driver.findElement(By.xpath("//textarea[@class='textareacounter']"))
				.sendKeys("ignore automation testing from sulekha");

		// Send
		Thread.sleep(500);
		Explecit(driver, "xpath", "//button[@class='btn-p btn-ss send-complaint']");

		driver.findElement(By.xpath("//button[@class='btn-p btn-ss send-complaint']")).click();
		// OTP
		Thread.sleep(500);
		Explecit(driver, "xpath", "//input[@class='txt-otp']");

		driver.findElement(By.xpath("//input[@class='txt-otp']")).sendKeys("999999");

		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@class='success-message']/h4");

		String s1 = driver.findElement(By.xpath("//div[@class='success-message']/h4")).getText();

		Reporter.log("Report Complaint is working fine : " + s1, true);

		Assert.assertTrue(s1.contains("Thank you"), "issue in submit the report complaint");

	}

	@Test(priority = 7, enabled = true, retryAnalyzer = Retrytest.class)
	public void b7_PhotoLink() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		// Photo links
		driver.findElement(By.xpath("//li[1]/figure/img")).click();

		Thread.sleep(1000);
		Explecit(driver, "xpath", "//div[@id='sgallerystock']/a[2]");
		// Photo next button
		driver.findElement(By.xpath("//div[@id='sgallerystock']/a[2]")).click();

		Thread.sleep(1000);
		Explecit(driver, "xpath", "//div[@id='sgallerystock']/a[1]");
		// Photo prev button
		driver.findElement(By.xpath("//div[@id='sgallerystock']/a[1]")).click();

		Thread.sleep(1000);
		Explecit(driver, "xpath", "//div[@id='sgallerystock']/span");

		WebElement ele = driver.findElement(By.xpath("//div[@id='sgallerystock']/span"));

		ele.click();

		Reporter.log("Photo links are working fine in listing tuple : ", true);

	}

	@Test(priority = 8, enabled = true, retryAnalyzer = Retrytest.class)
	public void b8_AlsoListed() throws InterruptedException {
		implicitlyWaiting(driver);

		driver.navigate().to("https://www.sulekha.com/js-home-services-saidapet-chennai-contact-address");
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");
		// Also listed

		WebElement ele = driver
				.findElement(By.xpath("//*[contains(text(), 'Also Listed in')]/following::li[1]/span/a"));

		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[contains(text(), 'Also Listed in')]/following::li[1]/span/a");

		String s1 = ele.getText();
		System.out.println(s1);

		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();

		ArrayList<String> windowhandle = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowhandle.get(1));

		String s2 = driver.findElement(By.xpath("//h1")).getText();

		Assert.assertTrue(s2.contains(s1), "issue is also list link");

		Reporter.log("Also listed link is working fine : " + s2, true);

	}

}
