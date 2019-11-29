package Test.Screen;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browser.Driver;
import Object_Repository.Screen.Calculator_Screen_Objects;


public class Calculator_Test extends Driver {
	Calculator_Screen_Objects Calculator_Object;

	
@BeforeMethod
public void setUp() throws IOException {
	application("andriod","andriod");
	Calculator_Object = new Calculator_Screen_Objects();
}

	@Test(priority = 1)
	public void verifyAddition() throws Exception {
	String result =	Calculator_Object.addition();
		Assert.assertEquals(result, "3");
		Assert.assertSame(result, "3", "result is passed");
	System.out.println("result is pass");

	}
	
@AfterMethod
public void tearDown() {
andrioddriver.quit();
}





}
