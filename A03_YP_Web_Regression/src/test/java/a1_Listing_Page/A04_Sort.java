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

public class A04_Sort extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));

		
	}

	@Test(enabled = true, priority = 1, retryAnalyzer = Retrytest.class)
	public void d01_SortOptions() throws InterruptedException {
		int a = 0;
		implicitlyWaiting(driver);

		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		Overlayclose(driver);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		((JavascriptExecutor) driver).executeScript("scroll(0,400)");

		Thread.sleep(1000);

		// Score *********************

		// sort button
		Explecit(driver, "xpath", "//div[@class='sort-by']/div/a");

		driver.findElement(By.xpath("//div[@class='sort-by']/div/a")).click();

		ExplecitID(driver, "id", "strbyraking");

		driver.findElement(By.id("strbyraking")).click();

		Thread.sleep(5000);
		Explecit(driver, "xpath", "//span[@class='sulekha-score']/strong");

		// taking first page all the sulekha score
		List<WebElement> s1 = driver.findElements(By.xpath("//span[@class='sulekha-score']/strong"));

		// condition after sulekha score order descending
		System.out.println(s1.size());
		double s5 = 10;
		for (WebElement s2 : s1) {

			String s3 = s2.getText();

			System.out.println(s3);

			double s4 = Double.parseDouble(s3);

			if (s5 >= s4) {
				s5 = s4;

			} else {
				System.out.println("Issue in sort option Sulekha score");
				a++;
			}

		}
		Reporter.log("Sort option by Sulekha working fine", true);

		// Rating *********************

		// sort button
		Thread.sleep(2000);
		Explecit(driver, "xpath", "//div[@class='sort-by']/div/a");

		driver.findElement(By.xpath("//div[@class='sort-by']/div/a")).click();

		Thread.sleep(2000);

		Explecit(driver, "xpath", "//ol[@id='divV8Businesslist']/li[1]//h3/a");
		// Save the first business name
		String t1 = driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//h3/a")).getText();

		Thread.sleep(500);
		ExplecitID(driver, "id", "strbyrate");
		// Rating option
		driver.findElement(By.id("strbyrate")).click();

		Thread.sleep(2000);
		Explecit(driver, "xpath", "//ol[@id='divV8Businesslist']/li[1]//h3/a");
		// Save the second business name
		String t2 = driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//h3/a")).getText();

		// verify first business should not match
		if (!t1.equalsIgnoreCase(t2)) {
			Reporter.log("Sort option by Rating working fine", true);

		} else {
			Reporter.log("Issue in sort option Sulekha Rating", true);
			a++;
		}

		// Default *********************

		// sort button
		implicitlyWaiting(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='sort-by']/div/a")).click();
		Thread.sleep(500);
		ExplecitID(driver, "id", "srtbydefault");
		Thread.sleep(3000);

		// Rating option
		driver.findElement(By.id("srtbydefault")).click();
		Thread.sleep(3000);

		// Save the second business name
		String t3 = driver.findElement(By.xpath("//ol[@id='divV8Businesslist']/li[1]//h3/a")).getText();
		Thread.sleep(500);
		// verify first business should not match
		if (!t2.equalsIgnoreCase(t3)) {
			Reporter.log("Sort option by Default working fine", true);

		} else {
			Reporter.log("Issue in sort option Default ", true);
			a++;
		}

		if (a >= 1) {
			Assert.fail();
		}

	}

}
