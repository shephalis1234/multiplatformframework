package Test.Screen;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;

public class saucelabnative {
	 public static final String USERNAME = "shephalis1234";
	  public static final String ACCESS_KEY = "c5c01258-ab8a-482f-8ce1-c73bab86803c";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	 
	  public static void main(String[] args) throws Exception {
	 
//	    DesiredCapabilities capabilities = new DesiredCapabilities();
//	    capabilities.setCapability("browserName", "");

	    
	    DesiredCapabilities caps = DesiredCapabilities.android();
	    caps.setCapability("appiumVersion", "1.13.0");
	    caps.setCapability("deviceName","Samsung Galaxy S6 GoogleAPI Emulator");
	    caps.setCapability("deviceOrientation", "portrait");
	    caps.setCapability("platformVersion","8.0");
	    caps.setCapability("platformName","Android");
//	    caps.setCapability("app","http://mycorp.intranet/myapp.apk");
//	    caps.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
	    caps.setCapability("automationName", "uiautomator2");
	    caps.setCapability("browserName", "");
//	    caps.setCapability("app", "sauce-storage:WhatsApp.apk");
//	    caps.setCapability("app", "http://saucelabs.com/example_files/ContactManager.apk");
//	    caps.setCapability("appPackage", "com.android.messaging");
//		caps.setCapability("appActivity", "com.android.messaging.ui.conversationlist.ConversationListActivity");
	    
	    caps.setCapability("app", "sauce-storage:CRM_v1.16_apkpure.com.apk");
	    AndroidDriver driver = new AndroidDriver<WebElement>(new URL(URL), caps);
//	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	    driver.get("https://zapier.com/blog/best-free-crm/");
////	    driver.findElementByXPath("//*[@placeholder='Search 1,500+ apps']").sendKeys("you");
////	    driver.findElementByXPath("//a[text()='Sign Up']").click();
//	    driver.findElementByXPath("//span[text()='Menu']").click();
//	    driver.findElementByXPath("//span[text()='Log In']").click();
//	    driver.findElementByXPath("//input[@placeholder='Email']").sendKeys("shep.shidhi456@gmail.com");
//	    driver.findElementByXPath("//span[text()='Continue']").click();
//	    driver.findElementByXPath("//input[@placeholder='Password']").sendKeys("minni@#45");
//	    driver.findElementByXPath("//span[text()='Continue']").click();
//	     driver.openNotifications();
//	    System.out.println(driver.getContext());
	    
	   
	 
//	    driver.quit();
	  }
	}
