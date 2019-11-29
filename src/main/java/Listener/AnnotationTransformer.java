package Listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import Utils.TestUtils;

public class AnnotationTransformer implements IAnnotationTransformer{
	int count=0;

	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		
		try {
			if(count==0) {
				TestUtils.getRunStatus();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		for(int i=0;i<TestUtils.testCases.size();i++) {
			if(testMethod.getName().equalsIgnoreCase(TestUtils.testCases.get(i)))
			{	
				annotation.setDataProvider("dataProviderForIterations");								//sets the dataprovider to all the test methods
				annotation.setDataProviderClass(TestUtils.class);
				annotation.setRetryAnalyzer(RetryFailedTestCases.class); 								//sets the retry analyser for all the test cases
				annotation.setPriority(Integer.parseInt(TestUtils.priority.get(i)));					
				annotation.setDescription(TestUtils.testDescription.get(i)); 							
				annotation.setInvocationCount(Integer.parseInt(TestUtils.invocationCount.get(i)));		
				if(TestUtils.runStatus.get(i).equalsIgnoreCase("no")) {
					annotation.setEnabled(false);														
					break;
				}
			} 
		}

		count++;
	}

	
}

