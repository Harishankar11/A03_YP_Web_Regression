package lib;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int minretrytest = 0;
	int maxretrytest = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(minretrytest<maxretrytest)
		{
			System.out.println("Test case retrying ...........   :  " + result.getName());
			
			minretrytest++;
			
			return true;
		}
		
		return false;
		
	}
	
	

}