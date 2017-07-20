package a0_lib;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base_Class {
	
	public WebDriver driver;			public String Browsername = "chrome";
	
	
	
	@BeforeTest
	public void Browsers()
	{
		
		if(Browsername.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			
		} else if(Browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Files/chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
		}

	}
	
	@AfterTest
	public void Browserclose()
	{
		
		driver.quit();
		
	}
	
	
	public static String Autolocator(String LocatorKey)
	{
		String value = null;
		try {
			
			File file = new File("./dataFiles.properties");
		
			FileInputStream fism = new FileInputStream(file);
		
			Properties pi = new Properties();
			
			pi.load(fism);
			
			value = pi.getProperty(LocatorKey);
			
			
			
		} catch (Exception ie1) {
			
			System.out.println("File not found exption : " + ie1);
		}
		
		return value;
		
		
	}
	
	public static void geturl(WebDriver driver, String Url)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get(Url);
		driver.manage().window().maximize();
		//Close the overlay LCF
		try{
		driver.findElement(By.xpath("//a[@class='lcf-close']")).click();
		}catch(Exception ie2){System.out.println(ie2);}
		
	}
	
	public static void navigate_to(WebDriver driver, String Url)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(Url);
		driver.manage().window().maximize();
		
	}
	public static void Overlayclose(WebDriver driver)
	{
		//Close the overlay LCF
		try
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//a[@class='lcf-close']")).click();
		}
			catch(Exception ie2){System.out.println("Overlay is not display");}
	}
	
	
	@AfterMethod
	public void Teardown(ITestResult result)
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			CaptureScreenshot(driver, result.getName());
		}
		
	}
	
	
	public void CaptureScreenshot(WebDriver driver, String Filename)
	{
		try {
			Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("dd_MM-HH_mm");  
		    String strDate= formatter.format(date);  
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File Source = ts.getScreenshotAs(OutputType.FILE);
		
		
			FileUtils.copyFile(Source, new File("./Screenshots/"+strDate+Filename+".png"));
			
			System.out.println("******* Testcase fail Screenshot taken ********");
			
		} catch (Exception ie) {
			
			System.out.println("******* Testcase fail but Screenshot not taken ********");
		}
		
		
	}
	
	public static void implicitlyWaiting(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void Explecit(WebDriver driver, String locatortype, String locator)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		
	}
	
	public static void ExplecitID(WebDriver driver, String locatortype, String locator)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
		
	}
	
	

}
