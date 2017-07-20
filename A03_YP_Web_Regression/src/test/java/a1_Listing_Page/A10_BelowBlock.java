package a1_Listing_Page;

import java.util.ArrayList;
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

public class A10_BelowBlock extends Commonmethods {

	@BeforeMethod
	public void url() {
		navigate_to(driver, Autolocator("Url1"));

		
	}

	@Test(enabled = true, priority = 1, retryAnalyzer = Retrytest.class)
	public void j01_RecentEnquiries() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,4200)");

		// Recent Enquiries
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[contains(text(), 'Recent Enquiries')]");

		String s1 = driver.findElement(By.xpath("//*[contains(text(), 'Recent Enquiries')]")).getText();

		Assert.assertTrue(s1.contains("Recent Enquiries on"), "issue in Recent Enquiries");

		Reporter.log("Recent Enquiries block is avaliable in listing working fine " + s1, true);
	}

	@Test(enabled = true, priority = 2, retryAnalyzer = Retrytest.class)
	public void j02_Blogs() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,4200)");

		// Blogs
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[contains(text(), 'Useful')]");

		String s1 = driver.findElement(By.xpath("//*[contains(text(), 'Useful')]")).getText();

		// Blogs
		Assert.assertTrue(s1.contains("Useful"), "issue in Useful tips or Blogs");

		Reporter.log("Blogs is available block is avaliable in listing" + s1, true);

	}

	@Test(enabled = true, priority = 3, retryAnalyzer = Retrytest.class)
	public void j03_ViewBlogsReadMoreBlogs() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,4200)");

		// View Blog(s) link
		Thread.sleep(500);
		Explecit(driver, "xpath", "//*[text()='View Blog(s)']");

		driver.findElement(By.xpath("//*[text()='View Blog(s)']")).click();

		String s2 = driver.getCurrentUrl();

		driver.navigate().back();

		((JavascriptExecutor) driver).executeScript("scroll(0,4200)");

		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@id='discussion']//li[1]//*[text()='Read More']");

		// Read More
		driver.findElement(By.xpath("//div[@id='discussion']//li[1]//*[text()='Read More']")).click();

		String s3 = driver.getCurrentUrl();

		// View Blog(s) link
		Assert.assertTrue(s2.contains("/blogs"), "issue in Blogs urls ");

		Reporter.log("Read More links working fine working fine  " + s2, true);

		// Read More
		Assert.assertTrue(s3.contains("blogs"), "issue in Read more link ");

		Reporter.log("View links working fine working fine " + s3, true);

	}

	@Test(enabled = true, priority = 4, retryAnalyzer = Retrytest.class)
	public void j04_FAQBlogs() throws InterruptedException {
		implicitlyWaiting(driver);

		driver.navigate().to(Autolocator("url4"));
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		try {
			Overlayclose(driver);
		} catch (Exception ie) {
		}

		((JavascriptExecutor) driver).executeScript("scroll(0,4200)");

		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@class='faq block-space']");

		// FAZ heading
		String s1 = driver.findElement(By.xpath("//div[@class='faq block-space']//h2")).getText();

		Reporter.log(" FAQ block is avaliable in listing the heading of FAQ is :  " + s1, true);

	}

	@Test(enabled = true, priority = 5, retryAnalyzer = Retrytest.class)
	public void j05_FooterLinks() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,4200)");

		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@class='footer-main']");

		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='footer-main']//a"));

		for (WebElement s1 : ele) {

			String s2 = s1.getText();
			String s3 = s1.getAttribute("href");

			/*
			 * s1.click();
			 * 
			 * String s2 = s1.getText(); String s3 = s1.getAttribute("href");
			 * System.out.println(s2 +" \t "+ s3); driver.navigate().back();
			 */

			String t1 = "About us 	 http://www.sulekha.com/collateral/aboutus	"
					+ "Contact us 	 http://www.sulekha.com/collateral/contactus	"
					+ "Meet our users 	 http://www.sulekha.com/collateral/testimonial"
					+ "	Media coverage 	 http://www.sulekha.com/collateral/press	"
					+ "Ads / commercials 	 http://www.sulekha.com/collateral/ads	"
					+ "Advertise on Sulekha 	 http://www.sulekha.com/collateral/advertise	"
					+ "Terms & conditions 	 http://www.sulekha.com/collateral/terms	"
					+ "Privacy policy 	 http://www.sulekha.com/collateral/privacy	"
					+ "Copyright policy 	 http://www.sulekha.com/collateral/collateralpolicy	"
					+ "Bangalore 	 https://www.sulekha.com/bangalore"
					+ "	Chennai 	 https://www.sulekha.com/chennai	" + "Delhi 	 https://www.sulekha.com/delhi	"
					+ "Mumbai 	 https://www.sulekha.com/mumbai" + "	Hyderabad 	 https://www.sulekha.com/hyderabad"
					+ "	Pune 	 https://www.sulekha.com/pune	" + "Kolkata 	 https://www.sulekha.com/kolkata"
					+ "	Ahmedabad 	 https://www.sulekha.com/ahmedabad"
					+ "	Gurgaon 	 https://www.sulekha.com/gurgaon"
					+ "	Faridabad 	 https://www.sulekha.com/faridabad"
					+ "	Ghaziabad 	 https://www.sulekha.com/ghaziabad" + "	Noida 	 https://www.sulekha.com/noida"
					+ "	Greater Noida 	 https://www.sulekha.com/greaternoida" + "	More cities 	 null	"
					+ "Austin 	 http://us.sulekha.com/austin-metro-area"
					+ "	Atlanta 	 http://us.sulekha.com/atlanta-metro-area"
					+ "	Bay Area 	 http://us.sulekha.com/bay-area	"
					+ "Boston 	 http://us.sulekha.com/boston-metro-area	"
					+ "Chicago 	 http://us.sulekha.com/chicago-metro-area"
					+ "	Los Angeles 	 http://us.sulekha.com/los-angeles-metro-area	"
					+ "New Jersey 	 http://us.sulekha.com/new-jersey-area	"
					+ "New York 	 http://us.sulekha.com/new-york-metro-area"
					+ "	Toronto 	 http://us.sulekha.com/toronto-metro-area	"
					+ "Property 	 http://property.sulekha.com/	"
					+ "Rentals 	 http://property.sulekha.com/rentals"
					+ "	Home services 	 https://www.sulekha.com/home-services/chennai"
					+ "	Office services 	 https://www.sulekha.com/business-services/chennai	"
					+ " Products 	 http://www.sulekha.com/products     https://www.sulekha.com/products	"
					+ " Education 	 https://www.sulekha.com/education-training/chennai	 ";

			if (s2.contains("More cities")) {
				driver.findElement(By.xpath("//*[text()='More cities']")).click();

				Thread.sleep(500);
				Explecit(driver, "xpath", "//a[@class='sdialog-x']");

				driver.findElement(By.xpath("//a[@class='sdialog-x']")).click();
				Thread.sleep(2000);

			} else {
				Assert.assertTrue(t1.contains(s2));
				Assert.assertTrue(t1.contains(s3));
			}

			Reporter.log(s2 + " \t " + s3, true);

		}

	}

	@Test(enabled = true, priority = 6, retryAnalyzer = Retrytest.class)
	public void j06_SocialMedia() throws InterruptedException {
		implicitlyWaiting(driver);
		Reporter.log("URL : "+driver.getCurrentUrl(),true);
		// Close the overlay LCF - if need to run this method only enable this
		// block
		// Overlayclose(driver);

		((JavascriptExecutor) driver).executeScript("scroll(0,4200)");

		Thread.sleep(500);
		Explecit(driver, "xpath", "//div[@class='social-icons']/a[1]");

		for (int i = 1; i <= 7; i++) {

			String s2 = driver.findElement(By.xpath("//div[@class='social-icons']/a[" + i + "]")).getAttribute("title");

			driver.findElement(By.xpath("//div[@class='social-icons']/a[" + i + "]")).click();

			ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windowHandles.get(1));

			String s1 = driver.getCurrentUrl();

			driver.close();

			driver.switchTo().window(windowHandles.get(0));

			String s3 = "https://twitter.com/sulekhadotcom, https://www.facebook.com/Sulekhadotcom, https://www.pinterest.com/sulekhadotcom/, https://plus.google.com/+sulekha, https://www.youtube.com/c/sulekha, https://www.linkedin.com/company/sulekha.com, https://www.instagram.com/sulekhaindia/, ";

			Reporter.log(s2 + " = " + s1, true);

			Assert.assertTrue(s3.contains(s1), "Error in social media links");

		}
	}

}
