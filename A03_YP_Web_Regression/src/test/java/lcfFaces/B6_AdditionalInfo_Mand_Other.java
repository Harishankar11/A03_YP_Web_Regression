package lcfFaces;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;

public class B6_AdditionalInfo_Mand_Other extends Commonform {

	@Test(retryAnalyzer = Retry.class)
	public void AdditionalInfo_Mand_Other() throws InterruptedException

	{

		String name = this.getClass().getSimpleName();

		System.out.println(name);

		dynamicdata obj1 = new dynamicdata();

		String url = obj1.urlpicker(name);

		// String url="http://www.sulekha.com/packers-and-movers/chennai";

		driver.get(url);

		Reporter.log(url, true);

		commonforms();

		// back
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector(".btn-t.btn-back")).click();

		// back
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector(".btn-t.btn-back")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Select multi select attribute
		String d1 = driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[4]/label")).getText();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[4]/label")).click();

		Reporter.log("Selected Other attribute : " + d1, true);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Next
		driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();
		Thread.sleep(2000);
		// calendar question

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		String d2 = driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[3]/label")).getText();

		Reporter.log("Selected Date schedule attribute : " + d2, true);

		driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[3]/label")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		String d3 = driver.findElement(By.xpath("//td[@class='today day']")).getText();

		Reporter.log("Selected Date : " + d3, true);

		driver.findElement(By.xpath("//td[@class='today day']")).click();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Next
		driver.findElement(By.cssSelector(".btn-p.btn-next.btnmdld")).click();

		contactinfo();

		addinfo();

		OTP();

		ThankorDash();

	}

}
