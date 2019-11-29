package Test.Screen;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser.Driver;
import Object_Repository.Screen.Calculator_Screen_Objects;
import Utils.PropertyFile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebApp  {
	RemoteWebDriver driver;
	@BeforeMethod
	public void setUp() throws MalformedURLException {
////		System.setProperty("webdriver.chrome.driver", "‪D:\\chromedriver.exe");
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertyFile.get("DEVICENAME"));
//		caps.setCapability(MobileCapabilityType.UDID,PropertyFile.get("udid")); //Give Device ID of your mobile phone
//		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyFile.get("PLATFORMNAME"));
//		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertyFile.get("PLATFORMVERSION"));
////		caps.setCapability("appPackage", PropertyFile.get("APPPACKAGE"));
////		caps.setCapability("appActivity", PropertyFile.get("APPMAINACTIVITY"));
//		
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//	
//			driver = new RemoteWebDriver(new URL(PropertyFile.get("andriodurl")), caps);
//			driver.get("https://www.google.co.in/");
	}

		@Test(priority = 1)
		public void Browser() throws Exception {
			
		System.out.println("webapp is opened");

		}
		
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
}