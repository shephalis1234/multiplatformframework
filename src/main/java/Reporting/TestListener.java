package Reporting;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

	ExtentTest test;
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
//		test = ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
//		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.fail(ExtentTestManager.message);
		StringWriter sw = new StringWriter(); 
		result.getThrowable().printStackTrace(new PrintWriter(sw)); 
		String stacktrace = sw.toString(); // Write the stack trace to extent reports test.log(LogStatus.INFO, "<span class='label failure'>" + result.getName() + "</span>", "<pre>Stacktrace:\n" + stacktrace + "</pre>");
		boolean b = sw.toString().contains("openqa");
		System.out.println("bool " + b);
		ExtentTestManager.fail("<div class='test-heading heading' style='font-weight:bolder; font-size: 15px; color:red;'>"+((b == false)?sw.toString().substring(0,sw.toString().indexOf("\n")+1):sw.toString().substring(0,sw.toString().indexOf("}")+1))+"</div><br /><span class='label failure'>" + result.getName() + "</span>,<pre>Stacktrace:\n" + stacktrace + "</pre>");		
		ExtentTestManager.fail(result.getThrowable().getMessage());
		//test.log(Status.ERROR, /*ExceptionUtils.getStackTrace(result.getThrowable())*/ stacktrace);
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
//		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}
}
