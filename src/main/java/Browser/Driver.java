package Browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utils.Andriod_Element_Action;
import Utils.PropertyFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class Driver {
	
		public static WebDriver driver;
		public static AndroidDriver andrioddriver;
	public	static AppiumDriverLocalService service;
	    static String service_url;
		public void application(String webappplication, String property) throws IOException{
			if(webappplication.equals("webapp")) {
			String browserName = PropertyFile.get("browser",property);
			
			if(browserName.equals("chrome")){
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(); 
				driver.get(PropertyFile.get("url",property));
				driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			}
			else if(browserName.equals("FF")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(); 
				driver.get(PropertyFile.get("url",property));
				driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			}
				else if(browserName.equals("IE")){
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver(); 
					driver.get(PropertyFile.get("url", property));
					driver.manage().window().maximize();
	                driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
				}
			}

			else if(webappplication.equals("andriod")){
//				File appDir = new File("src\\main\\java\\Test\\Screen\\");
//				File app = new File(appDir, "Zoho CRM Sales Marketing_v3.3.54_apkpure.com.apk");
//				 service = AppiumDriverLocalService.buildDefaultService();
//				 service.start();
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertyFile.get("DEVICENAME",property));
				caps.setCapability(MobileCapabilityType.UDID,PropertyFile.get("udid",property)); //Give Device ID of your mobile phone
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyFile.get("PLATFORMNAME",property));
				caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertyFile.get("PLATFORMVERSION",property));
				caps.setCapability("appPackage", PropertyFile.get("APPPACKAGE",property));
				caps.setCapability("appActivity", PropertyFile.get("APPMAINACTIVITY",property));
//				caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
//caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

				try {
					andrioddriver = new AndroidDriver<MobileElement>(new URL(PropertyFile.get("andriodurl",property)), caps);
//					andrioddriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

					andrioddriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//					andrioddriver.get("https://www.google.co.in/");
//					System.out.println(andrioddriver.getContext());
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}	}
			else if(webappplication.equals("webservices")){
		RestAssured.baseURI = PropertyFile.get("BaseURL",property);
		RequestSpecification httpRequest = RestAssured.given(); //resource url
		
		
	}
	}
}
	
