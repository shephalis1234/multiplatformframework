package Test.Screen;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser.Driver;
import Object_Repository.Screen.Calculator_Screen_Objects;
import Object_Repository.Screen.Hybrid_Screen_Object;
import Utils.PropertyFile;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class hybridapp extends Driver {
	

public static Hybrid_Screen_Object hybridscreen;
		@BeforeMethod
		public void setUp() throws IOException {
			application("andriod","andriod");
			hybridscreen= new	Hybrid_Screen_Object ();
		}

			@Test(priority = 1)
			public void verifyAddition() throws Exception {
				hybridscreen.LoginProcedure() ;
			System.out.println("result is pass");

			}
			
		@AfterMethod
		public void tearDown() {
		andrioddriver.quit();
		}





		}
