package Test.Page;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.testData1;

public class Third {
	   @Test(dataProvider="testData")
	   public void userTest(testData1 testData) {
	       //Test code goes here
		   System.out.println(testData);
	   }
	

	 
	   @DataProvider(name="testData")
	   public static Object[][] userTestData (testData1 testData) {           
	       //Code to read from file/xml
	       testData1 testData1 = new testData1();
	       testData1.setUsername("C:/HaudAPI/CombineFramework/third.xml");
	       testData1.setPassword("C:/HaudAPI/CombineFramework/third.xml");

	       return new Object[][] {{testData1}};
	   }
	}
