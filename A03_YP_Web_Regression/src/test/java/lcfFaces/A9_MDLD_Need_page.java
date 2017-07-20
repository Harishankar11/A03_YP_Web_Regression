package lcfFaces;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A9_MDLD_Need_page extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_Need_page() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		//String url="http://www.sulekha.com/commercial-vehicle-driver-services-n/chennai";
		
		
		driver.get(url);
		
		Reporter.log(url, true);
		
		
		String s1 = driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]")).getAttribute("class");
				
		
		Assert.assertTrue(s1.contains("firstchild"), "issue in ");
		
		Reporter.log("Link land on need page" + s1 , true);
		
		commonforms();
		
		Singlelocality();
		
		
		contactinfo();
		

		OTP();
		
		ThankorDash();
		
	}

}
