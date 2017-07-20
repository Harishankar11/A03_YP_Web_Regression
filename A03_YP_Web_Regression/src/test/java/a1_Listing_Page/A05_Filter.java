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

public class A05_Filter extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));

		
	}

	@Test(enabled = true, priority = 1, retryAnalyzer = Retrytest.class)
	public void e01_FilterByAttribute() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		// Filter first filter option
		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@id='divFilter']//li[1]//ul[1]/li[1]/label");
		String s1 = driver.findElement(By.xpath("//div[@id='divFilter']//li[1]//ul[1]/li[1]/label")).getText();

		driver.findElement(By.xpath("//div[@id='divFilter']//li[1]//ul[1]/li[1]/label")).click();

		Thread.sleep(3000);
		Explecit(driver, "xpath", "//div[@class='stags appendfilter']/em");

		// Filered value
		String s2 = driver.findElement(By.xpath("//div[@class='stags appendfilter']/em")).getText();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in Attribute Filter");

		Reporter.log("Attribute filter is working fine values are : " + s1 + "\t" + s2, true);

		// Reset button
		Thread.sleep(3000);

		Explecit(driver, "xpath", "//*[text()='RESET']");

		driver.findElement(By.xpath("//*[text()='RESET']")).click();

		Thread.sleep(4000);
		implicitlyWaiting(driver);

		String s3 = driver.getCurrentUrl();

		Assert.assertTrue(!s3.equalsIgnoreCase("filter"), "Issue is Filter reset");

		Reporter.log("Filter RESET link is working fine ", true);

	}

	@Test(enabled = true, priority = 2, retryAnalyzer = Retrytest.class)
	public void e02_FilterByLocality() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,800)");

		// locality filter first value
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text() = 'Locality']/following::li[1]/label");
		String s1 = driver.findElement(By.xpath("//*[text() = 'Locality']/following::li[1]/label")).getText();

		driver.findElement(By.xpath("//*[text() = 'Locality']/following::li[1]/label")).click();

		Thread.sleep(3000);
		Explecit(driver, "xpath", "//div[@class='stags appendfilter']/em");

		// Filered value
		String s2 = driver.findElement(By.xpath("//div[@class='stags appendfilter']/em")).getText();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in Locality filter");

		Reporter.log("Locality filter is working fine values are : " + s1 + "\t" + s2, true);

	}

	@Test(enabled = true, priority = 3, retryAnalyzer = Retrytest.class)
	public void e03_FilterByBrand() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		// Brand filter first value
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[contains(text(), 'Brand')]/following::li[1]/label");

		String s1 = driver.findElement(By.xpath("//*[contains(text(), 'Brand')]/following::li[1]/label")).getText();

		driver.findElement(By.xpath("//*[contains(text(), 'Brand')]/following::li[1]/label")).click();

		Thread.sleep(3000);
		Explecit(driver, "xpath", "//div[@class='stags appendfilter']/em");

		// Filered value
		String s2 = driver.findElement(By.xpath("//div[@class='stags appendfilter']/em")).getText();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in Brand filter");

		Reporter.log("Brand filter is working fine values are : " + s1 + "\t" + s2, true);

	}

	@Test(enabled = true, priority = 4, retryAnalyzer = Retrytest.class)
	public void e04_FilterByCity() throws InterruptedException {

		implicitlyWaiting(driver);
		
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		driver.navigate().to(Autolocator("Indiaurl"));
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");

		// Brand filter first value
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text()='City']/following::li[1]/label");
		String s1 = driver.findElement(By.xpath("//*[text()='City']/following::li[1]/label")).getText();

		driver.findElement(By.xpath("//*[text()='City']/following::li[1]/label")).click();

		Thread.sleep(3000);
		implicitlyWaiting(driver);

		// url
		String s2 = driver.getCurrentUrl();

		Assert.assertTrue(s2.toLowerCase().contains(s1.toLowerCase()), "issue in city filter");

		Reporter.log("India URL: " + Autolocator("Indiaurl"));

		Reporter.log("City filter is working fine values are : " + s1 + "\t" + s2, true);

	}

	@Test(enabled = true, priority = 5, retryAnalyzer = Retrytest.class)
	public void e05_AttributePageFilter() throws InterruptedException {

		implicitlyWaiting(driver);
		
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		driver.navigate().to(Autolocator("Attributeurl"));
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		((JavascriptExecutor) driver).executeScript("scroll(0,900)");

		// Brand filter first value
		Explecit(driver, "xpath", "//div[@class='stags appendfilter']/em");
		String s1 = driver.findElement(By.xpath("//div[@class='stags appendfilter']/em")).getText();

		Assert.assertTrue(s1.toLowerCase().contains(Autolocator("Attributename").toLowerCase()),
				"issue in Attribute page preselected Filter");

		Reporter.log("Attribute page URL: " + Autolocator("Attributeurl"));

		Reporter.log("Attribute page filter is preselected values : " + s1 + "\t" + Autolocator("Attributename"), true);

	}

	@Test(enabled = true, priority = 6, retryAnalyzer = Retrytest.class)
	public void e06_FilterMoreLessLink() throws InterruptedException {

		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		//driver.navigate().to(Autolocator("Url2"));

		// Close the overlay LCF - if need to run this method only enable this
		// block
		//Overlayclose(driver);
		

		((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

		try{  // core
		// Locality filter More
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text() = 'Locality']/following::*[text() = '+ more']");

		driver.findElement(By.xpath("//*[text() = 'Locality']/following::*[text() = '+ more']")).click();
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text() = 'Locality']/following::*[text() = '- less']");

		// Locality filter less
		driver.findElement(By.xpath("//*[text() = 'Locality']/following::*[text() = '- less']")).click();
		
		Reporter.log("Filter more and less button link working fine ", true);
		
		}catch(Exception ie23){ // non core


			Thread.sleep(500);
			List<WebElement> ele = driver.findElements(By.xpath("//*[text()='View all services']"));
			ele.get(0).click();
			
			Thread.sleep(2000);
			
			List<WebElement> ele1 = driver.findElements(By.xpath("//*[text()='Less services']"));
			
			System.out.println(ele1.size());
			
			ele1.get(1).click();
			
			Thread.sleep(1000);
			
			Reporter.log("Filter View all services and Less services button link working fine ", true);
		}

		

	}

}
