package Utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Toast {
	AndroidDriver driver;
	StaticFunctionality staticfunction=new StaticFunctionality();
	@BeforeMethod
	public void setUp() throws IOException {
//		System.setProperty("webdriver.chrome.driver", "‪D:\\chromedriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertyFile.get("DEVICENAME","andriod"));
		caps.setCapability(MobileCapabilityType.UDID,PropertyFile.get("udid","andriod")); //Give Device ID of your mobile phone
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyFile.get("PLATFORMNAME","andriod"));
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertyFile.get("PLATFORMVERSION","andriod"));
		caps.setCapability("appPackage", PropertyFile.get("APPPACKAGE","andriod"));
		caps.setCapability("appActivity", PropertyFile.get("APPMAINACTIVITY","andriod"));
		
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	
			driver = new AndroidDriver<AndroidElement>(new URL(PropertyFile.get("andriodurl","andriod")), caps);
			
	}

		@Test(priority = 1)
		public void Browser() throws Exception {
			notification();
			driver.findElementByAccessibilityId("Alarm").click();
			driver.findElementByXPath("//android.view.ViewGroup[@content-desc='8:30 AM Alarm']/android.widget.Switch").click();
			WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
			 String text = toastView.getAttribute("text");
			 System.out.println(text);
			
//			captureScreenshot("C:\\HaudAPI\\CombineFramework\\Andriodscreenshot");
		System.out.println("webapp is opened");

		}
		
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	public static String filePath;
	public String captureScreenshot(String path) {
        File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);	
	try {
		filePath=path+"\\toastmessage1.png";
		FileUtils.copyFile(scrFile,  new File(filePath));
	} catch (IOException e) {
			e.printStackTrace();
	}
	return filePath;
}
	public void notification() throws InterruptedException {
		  driver.openNotifications();
	    Thread.sleep(2000);
		   List<MobileElement> allnotifications = driver.findElements(By.id("android:id/title"));
		   System.out.println("no of notifications " + allnotifications.size());
		 
		   for (MobileElement webElement : allnotifications) {
		       System.out.println(webElement.getText());
		       if(webElement.getText().contains("Appium Settings")){
		          System.out.println("Notification found");
		          break;
		   }
		      
		   }
		   driver.navigate().back();
		   }
}
