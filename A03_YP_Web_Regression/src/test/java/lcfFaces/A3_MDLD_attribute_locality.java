package lcfFaces;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excelReader.dynamicdata;
import lib.Commonform;
import lib.Retry;


public class A3_MDLD_attribute_locality extends Commonform {
	
	@Test(retryAnalyzer=Retry.class)
	public void MDLD_attribute_locality() throws InterruptedException
	
	{
		

		String name = this.getClass().getSimpleName();
		
		System.out.println(name);
		
		dynamicdata obj1 = new dynamicdata();
		
		String url= obj1.urlpicker(name);
		
		String locality = "Anna Salai";
		//String url="http://www.sulekha.com/residential-cleaning-services/"+locality+"-chennai";
		String Attribute = "true";
		
		driver.get(url);
		
		//Verify pre-selection
		
		String sr1 = driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[1]")).getAttribute("data-selected");
		System.out.println("Pre-selected attribute class name : "+sr1);
		String sr2 = driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[1]")).getText();
		System.out.println("Pre-selected attribute value : "+sr2);
		
		SoftAssert assersion = new SoftAssert();
		
		assersion.assertTrue(sr1.equalsIgnoreCase(Attribute), " preselection is not working");
		
		driver.findElement(By.xpath("//div[contains(@class, 'form-group') and contains(@class, 'active')]//li[1]")).click();
		
		Reporter.log(url, true);
		
		commonforms();
		
		//locality
		
		String sr3 = driver.findElement(By.xpath("//div[contains(@class, 'LCFLocalityMain')]")).getText();
		System.out.println("Pre-selected locality : "+sr3);
				
		assersion.assertTrue(sr3.equalsIgnoreCase(locality), "Error is preselection locality is not matched");
						
		contactinfo();
		
		OTP();
		
		ThankorDash();
		
		assersion.assertAll();
		
		
	}

}
