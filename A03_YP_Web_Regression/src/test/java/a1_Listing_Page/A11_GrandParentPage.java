package a1_Listing_Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import a0_lib.Commonmethods;
import a0_lib.Retrytest;

public class A11_GrandParentPage extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, "https://www.sulekha.com/business-services");

	}

	@Test(enabled = true, priority = 1, retryAnalyzer = Retrytest.class)
	public void k01_CategoryLinks() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Recent Enquiries
		Thread.sleep(500);

		List<WebElement> ele = driver.findElements(By.xpath("//ul[@class='saccordion']//a"));

		for (WebElement s1 : ele) {

			String s2 = s1.getText();

			s1.click();

			String s3 = driver.findElement(By.xpath("//h1")).getText();

			Assert.assertTrue(s3.contains(s2), "issue in category link navigation");

			Reporter.log("Grand Parent Page Category link navigation working fine : " + s3, true);

			break;

		}

	}

	@Test(enabled = true, priority = 2, retryAnalyzer = Retrytest.class)
	public void k02_CityLinks() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Recent Enquiries
		Thread.sleep(500);

		String s1 = driver.findElement(By.xpath("//ul[@id='detail-State']/li[1]/a")).getText();

		driver.findElement(By.xpath("//ul[@id='detail-State']/li[1]/a")).click();

		Thread.sleep(1000);

		String s2 = driver.getCurrentUrl();

		Assert.assertTrue(s2.contains(s1.toLowerCase()), "issue in city link navigation");

		Reporter.log("Grand Parent Page City link navigation working fine : " + s2, true);
	}

	@Test(enabled = true, priority = 3, retryAnalyzer = Retrytest.class)
	public void k03_LocalityLinks() throws InterruptedException {
		implicitlyWaiting(driver);
		
		driver.navigate().to("https://www.sulekha.com/business-services/chennai");
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Recent Enquiries
		Thread.sleep(500);

		String s1 = driver.findElement(By.xpath("//ul[@id='detail-State']/li[1]/a")).getText();

		driver.findElement(By.xpath("//ul[@id='detail-State']/li[1]/a")).click();

		Thread.sleep(1000);

		String s2 = driver.getCurrentUrl();

		Assert.assertTrue(s2.contains(s1.toLowerCase()), "issue in Locality link navigation");

		Reporter.log("Grand Parent Page Locality link navigation working fine : " + s2, true);
	}

}
