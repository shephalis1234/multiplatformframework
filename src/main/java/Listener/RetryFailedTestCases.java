package Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import Utils.PropertyFile;

public class RetryFailedTestCases implements IRetryAnalyzer{

	int counter=0;
	int limit=Integer.parseInt(PropertyFile.get("NoOfRetries"));

	public boolean retry(ITestResult result) {
		if(counter<limit) {
			counter++;
			return true;
		}
		return false;
	}

	

}
