package Utils;


import org.apache.xml.dtm.Axis;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebDriver;

import Browser.Driver;
import Reporting.Extent_Reporting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Andriod_Element_Action   {
	public static AndroidDriver driver = null;
	
	public void inputText(WebElement Element_Name, String value) throws Exception
	{
		try
		{
			Element_Name.clear();
			Element_Name.sendKeys(value);
			Extent_Reporting.Log_Pass(Element_Name+" Entered",value + " entered in "+ Element_Name);
		}
		 catch(Throwable t)
		{ 
			 Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	public void clickElement(WebElement Element_Name) throws Exception
	{
		try
		{
			Element_Name.click();
			
			Extent_Reporting.Log_Pass(Element_Name+" is clicked", " clicked "+ Element_Name);
		}
		 catch(Throwable t)
		{ 
			 Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	public void pressKey(AndroidDriver driver,KeyEvent event, WebElement Element_Name) throws Exception
	{
		try
		{
			
			driver.pressKey(event);
			Extent_Reporting.Log_Pass(Element_Name+" Entered",event + " pressed key "+ Element_Name);
		}
		 catch(Throwable t)
		{ 
			 Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	public void isDeviceLocked(AndroidDriver driver) throws Exception
	{
		try
		{
			
			driver.isDeviceLocked();
			unlockDevice(driver);
			Extent_Reporting.Log_Pass("Device is locked", "Device is locked");
		}
		 catch(Throwable t)
		{ 
			 Extent_Reporting.Log_Fail("Device is not Locked"," Device is not Locked");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	public void unlockDevice(AndroidDriver driver) throws Exception
	{
		driver.unlockDevice();
		Extent_Reporting.Log_Pass("Device is unlocked", "Device is unlocked");

			}
	public void getKeyBoard(AndroidDriver driver) throws Exception
	{
		driver.getKeyboard();
		Extent_Reporting.Log_Pass("Keyboard is Displayed", "Keyboard is Displayed");

			}
	public void hideKeyBoard(AndroidDriver driver) throws Exception
	{
		driver.hideKeyboard();
		Extent_Reporting.Log_Pass("Keyboard is hide", "Keyboard is hide");

			}

	public void isKeyboardShown(AndroidDriver driver) throws Exception
	{
		try
		{
			
			driver.isKeyboardShown();
			
			Extent_Reporting.Log_Pass("Keyboard is shown", "Keyboard is shown");
		}
		 catch(Throwable t)
		{ 
			 Extent_Reporting.Log_Fail("Keyboard is not shown","Keyboard is not shown");
			t.printStackTrace();
			throw new Exception("Keyboard is not shown");
		}
		
	}
	public void openNotification(AndroidDriver driver) throws Exception
	{
		driver.openNotifications();
		Extent_Reporting.Log_Pass("Notification is Displayed", "Notification is Displayed");

			}
	public void getDeviceTime(AndroidDriver driver) throws Exception
	{
		driver.getDeviceTime();
		Extent_Reporting.Log_Pass("DeviceName is Displayed", "DeviceName is Displayed");

			}
	public void getCurrentLocation(AndroidDriver driver) throws Exception
	{
		driver.location();
		Extent_Reporting.Log_Pass("Location is Displayed", "Location is Displayed");

			}
	public void setCurrentLocation(AndroidDriver driver, double x,double y, double z ) throws Exception
	{
		Location location = new Location(x, y, z);

		driver.setLocation(location);

		Extent_Reporting.Log_Pass("Location is Displayed", "Location is Displayed");

			}
	public void rotateLandscapeMode(AndroidDriver driver) throws Exception
	{
		driver.rotate(ScreenOrientation.LANDSCAPE);
		Extent_Reporting.Log_Pass("Rotation is Displayed", "Rotation is Displayed");

			}
	public void rotatePorttraitMode(AndroidDriver driver) throws Exception
	{
		driver.rotate(ScreenOrientation.PORTRAIT);

		Extent_Reporting.Log_Pass("Rotation is Displayed", "Rotation is Displayed");

			}
	public void activateApp(AndroidDriver driver, String AppId) throws Exception
	{
		driver.activateApp(AppId);

		Extent_Reporting.Log_Pass("App is Activated", "App is Activated");

			}
	public void installApp(AndroidDriver driver, String appPath) throws Exception
	{
		driver.installApp(appPath);
		Extent_Reporting.Log_Pass("App is installed", "App is installed");

			}
	public void isAppInstalled(AndroidDriver driver, String bundleId) throws Exception
	{
		try
		{
			
			driver.isAppInstalled(bundleId);
			
			Extent_Reporting.Log_Pass("App is installed", "App is installed");
		}
		 catch(Throwable t)
		{ 
			 Extent_Reporting.Log_Fail("App is not installed","App is not installed");
			t.printStackTrace();
			throw new Exception("App is not installed");
		}
		
	}
	public  boolean singleTap(AndroidDriver driver, WebElement onElement) throws Exception
	{
		
		try
		{
			TouchActions action = new TouchActions(driver);
		
		action.singleTap(onElement).perform();
		Extent_Reporting.Log_Pass("Tap is Performed", "Tap is Performed");
		}
		catch(Throwable t)
		{
			//Log.error("Element not Found -->"+t.getMessage());
			Extent_Reporting.Log_Fail(onElement+" does not Exist",onElement+" does not Exist");
			t.printStackTrace();
			return false;
		}
		return true;
}
	public  boolean doubleTap(AndroidDriver driver, WebElement onElement) throws Exception
	{
		
		try
		{
			TouchActions action = new TouchActions(driver);
		
		action.doubleTap(onElement).perform();
		Extent_Reporting.Log_Pass("Tap is Performed", "Tap is Performed");
		}
		catch(Throwable t)
		{
			//Log.error("Element not Found -->"+t.getMessage());
			Extent_Reporting.Log_Fail(onElement+" does not Exist",onElement+" does not Exist");
			t.printStackTrace();
			return false;
		}
		return true;
}
	public void longpressElement(AndroidDriver driver,KeyEvent event) throws Exception
	{
		try
		{
			
			driver.pressKey(event);
			Extent_Reporting.Log_Pass(event+" Entered",event + " pressed key "+ event);
		}
		 catch(Throwable t)
		{ 
			 Extent_Reporting.Log_Fail(event+" does not Exist",event+" does not Exist");
			t.printStackTrace();
			throw new Exception("KeyEvent Not Present");
		}
		}
	public  boolean scroll(AndroidDriver driver, int x, int y) throws Exception
	{
		
		try
		{
			TouchActions action = new TouchActions(driver);
		
		action.scroll(x, y).perform();
		Extent_Reporting.Log_Pass("Scroll is Performed", "scroll is Performed");
		}
		catch(Throwable t)
	{
			//Log.error("Element not Found -->"+t.getMessage());
			Extent_Reporting.Log_Fail("x and y axis does not Exist","x and y axis does not Exist");
			t.printStackTrace();
			return false;
		}
		return true;
}
	public  boolean scrollUptoWebelemnt(AndroidDriver driver, int x, int y, WebElement element) throws Exception
	{
		
		try
		{
			TouchActions action = new TouchActions(driver);
		
		action.scroll(element,x, y).perform();
		Extent_Reporting.Log_Pass("Scroll is Performed", "scroll is Performed");
		}
		catch(Throwable t)
	{
			//Log.error("Element not Found -->"+t.getMessage());
			Extent_Reporting.Log_Fail(element+"does not Exist",element+"does not Exist");
			t.printStackTrace();
			return false;
		}
		return true;
}
	
}
	
	

