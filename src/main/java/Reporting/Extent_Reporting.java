package Reporting;

import com.relevantcodes.extentreports.LogStatus;


public class Extent_Reporting {
	
	public static String testCaseName;
	public static String stepName;
	public static String message;
	

    public static void Log_Pass( String stepName, String passMessage) 
    {
        Report_Setup.test.log(LogStatus.PASS, stepName, passMessage);
    }
    public static void Log_Fail(String stepName, String failMessage, Throwable e) {
        String stacktrace = null;
        if (null != e) {
            stacktrace = e.toString();
        }
        Report_Setup.test.log(LogStatus.FAIL, stepName, failMessage);
    }
    public static void Log_Fail( String stepName, String failMessage) {
        Log_Fail(stepName, failMessage);
    }
    public static void startLog(String testCaseName, String stepName, String message) {
    	
    	Extent_Reporting.testCaseName = testCaseName;
    	Extent_Reporting.stepName = stepName;
    	Extent_Reporting.message = message;

    	
    }
}
