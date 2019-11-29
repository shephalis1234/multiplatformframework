package Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Reporting.Extent_Reporting;





public class ElementUtils {
	public static WebDriver driver = null;

	public boolean isElementPresentByXpath( WebElement Element_Name) throws InterruptedException
	{
		try
		{
			Extent_Reporting.Log_Pass(Element_Name+" Exist",Element_Name+" Exist");
		}
		catch(Throwable t)
		{
			//Log.error("Element not Found -->"+t.getMessage());
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			return false;
		}
		return true;
	}

	
	public void clickButtonID(WebElement Element_Name) throws Exception
	{
		try
		{
		
			Element_Name.click();
			Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
		}
		catch(Throwable t)
		{
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	public void clickButton(WebElement Element_Name) throws Exception
	{
		try
		{
			//webButton.click();
			Element_Name.sendKeys(Keys.ENTER);
			Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
		}
		catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	
	public void inputText(WebElement Element_Name, String value) throws Exception
	{
		try
		{
			highlightElement(Element_Name);
			Element_Name.clear();
			Element_Name.sendKeys(value);
			Extent_Reporting.Log_Pass(Element_Name+" Entered",value + " entered in "+ Element_Name);
		}
		 catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	public static void highlightElement(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
	}

	

	
	
	public void enterText(String ObjectxPath, String sValue,WebElement Element_Name) throws Exception {
		Actions actions = new Actions((WebDriver) Element_Name);
		try
		{
			actions.moveToElement(Element_Name);
			actions.click();
			actions.sendKeys(sValue);
			actions.build().perform();
			Extent_Reporting.Log_Pass(Element_Name+" Entered",sValue + " entered in "+ Element_Name);
			
		}  catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	

	public void selectCheckBox(WebElement Element_Name) throws Exception
	{
		try
		{
			
		Element_Name.click();
			Extent_Reporting.Log_Pass(Element_Name+" checkbox clicked",Element_Name+" checkbox clicked");
		}  catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	public void selectRadio(WebElement Element_Name) throws Exception
	{
		try
		{
			Element_Name.click();
			Extent_Reporting.Log_Pass(Element_Name+" radiobutton clicked",Element_Name+" radiobutton clicked");
		}  catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist",driver);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public String getInputTextValue(WebElement Element_Name) throws Exception
	{
		try
		{
			Extent_Reporting.Log_Pass(Element_Name+" exist",Element_Name+" has "+ Element_Name.getText().trim());
			return Element_Name.getText();
		}
		 catch(Throwable t)
			{ 
               Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
				t.printStackTrace();
				throw new Exception("Element Not Present");
			}
	}
	
	

	
	public void selectDropBoxValue(WebElement Element_Name, String value) throws Exception
	{
		try
		{Element_Name.click();
			Select select = new Select(Element_Name);
			//select.selectByVisibleText(value);
		//	Thread.sleep(500);
			select.selectByValue(value);
			Extent_Reporting.Log_Pass(Element_Name+" selected with "+value,Element_Name+" selected with "+value);
		}
		catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}
	
	
	

	public int getDropBoxSize(WebElement Element_Name) throws Exception
	{
		try
		{
			Select select = new Select(Element_Name);
			Extent_Reporting.Log_Pass(Element_Name+" dropbox size is "+select.getOptions().size(),Element_Name+" dropbox size is "+select.getOptions().size());
			return select.getOptions().size();
		}
		catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}



	

	public int getTotalTableCell(WebDriver driver,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			Extent_Reporting.Log_Pass(Element_Name+" table size is "+driver.findElements(By.xpath(ObjectxPath)).size(),Element_Name+" table size is "+driver.findElements(By.xpath(ObjectxPath)).size());
			return driver.findElements(By.xpath(ObjectxPath)).size();
		}
		catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public int getElementsSize(WebDriver driver,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			Extent_Reporting.Log_Pass(Element_Name+" element size is "+driver.findElements(By.xpath(ObjectxPath)).size(),Element_Name+" element size is "+driver.findElements(By.xpath(ObjectxPath)).size());
			return driver.findElements(By.xpath(ObjectxPath)).size();
		}
		catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}


	public int getElementCount(WebElement Element_Name) throws Exception
	{
		int count=0;

		try
		{
			Element_Name.getSize();
			Extent_Reporting.Log_Pass(Element_Name+" element count "+count,Element_Name+" element size is "+count);
		}
		catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		return count;
	}

	public boolean isElementDisplayed(WebElement Element_Name) throws Exception
	{
		boolean flag=false;
		try
		{
			if(Element_Name.isDisplayed())
			{	Extent_Reporting.Log_Pass(Element_Name +" is displayed ", Element_Name +" is displayed ");
				flag = true;
			}
		}
		catch(Throwable e)
		{
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			flag=false;
			e.printStackTrace();
			flag = false;
			throw new Exception("Element Not Present");
			
		}
		return flag;

	}
	
	
	public void mouseHoverAction_3(WebDriver driver,String mainElementXP, String subElementXP,String subSubElementXP,String Element_Name) throws Exception{
        try
        {
			Actions action = new Actions(driver);
			WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
			action.moveToElement(mainElement).perform();
			WebElement subElement = driver.findElement(By.xpath(subElementXP));
			action.moveToElement(subElement).perform();
			WebElement subSubElement = driver.findElement(By.xpath(subSubElementXP));
			action.moveToElement(subSubElement);
			action.click();
			action.perform();
			LogStatus.info("Click action is performed on the selected Product Type");
			Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type"+Element_Name,"Click action is performed on the selected Product Type"+Element_Name);
	     }
        catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	
	
	public void mouseHoverAction(WebDriver driver,String mainElementXP,String Element_Name) throws Exception{
      try
      {
		Actions action = new Actions(driver);
		WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
		action.moveToElement(mainElement).clickAndHold().build().perform();
		action.release().perform();
	//action.perform();
		LogStatus.info("Click action is performed on the selected Product Type");
		Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type"+Element_Name,"Click action is performed on the selected Product Type"+Element_Name);
    }
   catch(Throwable t)
	{ 
		LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
		t.printStackTrace();
		throw new Exception("Element Not Present");
	}
	}
	
	public void mouseHoverAction(WebDriver driver,String mainElementXP, String subElementXP,String subSubElementXP, String subBesideElementXP,String Element_Name) throws Exception{
    try
    {
		Actions action = new Actions(driver);
		WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
		action.moveToElement(mainElement).perform();
		WebElement subElement = driver.findElement(By.xpath(subElementXP));
		action.moveToElement(subElement).perform();
		WebElement subSubElement = driver.findElement(By.xpath(subSubElementXP));
		action.moveToElement(subSubElement).perform();
		WebElement subBesideElement = driver.findElement(By.xpath(subBesideElementXP));
		action.moveToElement(subBesideElement).perform();
		action.click();
		action.perform();
		LogStatus.info("Click action is performed on the selected Product Type");
		Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type"+Element_Name,"Click action is performed on the selected Product Type"+Element_Name);
    }
   catch(Throwable t)
	{ 
		LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
		t.printStackTrace();
		throw new Exception("Element Not Present");
	}
	}
	
	public void selectclass(WebDriver driver,WebElement parent,String elementToSelect,String Element_Name) throws Exception{
        try
        {
		Select dropdown = new Select(parent);
		dropdown.selectByVisibleText(elementToSelect);
		Extent_Reporting.Log_Pass("selected "+elementToSelect,"selected "+elementToSelect+"in "+parent);
        }
       catch(Throwable t)
    	{ 
    		LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
    		t.printStackTrace();
    		throw new Exception("Element Not Present");
    	}
    	

	}
	
	
	public void getWindowHandle(WebDriver driver , String title) throws InterruptedException {
		int cnt=0;
		int l=0;
		do
		{
		
		Set<String> handles = driver.getWindowHandles();

		String[] browser =	handles.toArray(new String[0]);
		System.out.println("Number of browsers opened are"
				+ browser.length);
		for (int i=0; i<handles.size();i++) {
		            try
		            {
					driver.switchTo().window(browser[i]);
					System.out.println(driver.getTitle());
					if(driver.getTitle().contains(title)){
						System.out.println(driver.getTitle()+"found");
						driver.getWindowHandle();
						cnt=1;
						break;
					  }
		            }
            
			catch(Throwable t)
			{
				System.out.println("Browser not opened");
			}

		}

		if (cnt==1)
		{
			break;
		}
		if(l==20)
		{
			break;
		}
		Thread.sleep(500);
		l=l+1;
		}while(true);
		

	} 
	
	
	public void waitForElementVisible(WebDriver driver, String element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		} catch (NoSuchWindowException e) {
		} catch (InvalidElementStateException e) {
		} catch (TimeoutException te) {
		} catch (NoSuchElementException e) {
		} catch (WebDriverException we) {
		}
	}
	
	public void waitForElementClickable(WebDriver driver, String element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		} catch (NoSuchWindowException e) {
		} catch (InvalidElementStateException e) {
		} catch (TimeoutException te) {
		} catch (NoSuchElementException e) {
		} catch (WebDriverException we) {
		}
	}
	
	public void waitForTextPresent(WebDriver driver, String text) throws InterruptedException {
		try {
			Thread.sleep(2000);
			long timer = 0;
			while (isTextPresent(driver, text) == false && timer < Long.valueOf("30000")) {
				Thread.sleep(500);
				timer += 5000;
			}
		} catch (NoSuchWindowException e) {
		}
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt("60"), TimeUnit.SECONDS);
	}

	
	public boolean isTextPresent(WebDriver driver, String text) {
		boolean flag = false;
		try {
			flag = driver.findElement(By.xpath("//*[contains(.,'" + text + "')]")).isDisplayed();
		} catch (NoSuchElementException e) {
			return flag;
		} catch (NoSuchWindowException e) {
			return flag;
		}
		return flag;
	}
	
	public void getTableData(WebDriver driver , String xpath)
	{
		// Grab the table 
		WebElement table = driver.findElement(By.xpath(xpath)); 

		// Now get all the TR elements from the table 
		List<WebElement> allRows = table.findElements(By.tagName("tr")); 

		// And iterate over them, getting the cells 
		for (WebElement row : allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 

		    // Print the contents of each cell
		    for (WebElement cell : cells) { 
		        System.out.println(cell.getText());
		    }
		}
	}
	
	
	//Function for fetching the value from the object when value attribute is not present.
	public String getObjectValue(WebDriver driver,WebElement webElement) {
        JavascriptExecutor e = (JavascriptExecutor) driver;
        return (String) e.executeScript(String.format("return $('#%s').val();", webElement.getAttribute("id")));
	}
	
	public String getObjectValueClass(WebDriver driver,WebElement webElement) {
        JavascriptExecutor e = (JavascriptExecutor) driver;
        return (String) e.executeScript(String.format("return $('#%s').val();", webElement.getAttribute("class")));
	}
	
	/*public void doubleClick(WebDriver driver,WebElement myElemment) throws InterruptedException
	{
		if(isElementPresentByXpath(driver, myElemment))
		{
		Actions action = new Actions(driver);
		action.moveToElement(myElemment);
		Thread.sleep(2000);
		action.doubleClick();
		//action.doubleClick(myElemment);
		action.build().perform();
		}
		else
		{
			throw new Exception("selectDropBoxValue() --- >Element Not Present");
		}
	}
	 */
	
	
	public Alert waitforAlertPresent(WebDriver driver) throws InterruptedException {
		int i = 0;
		Alert alert = null;
		while (i++ < 30) {
			try {
				alert = driver.switchTo().alert();
				return alert;
			} catch (NoAlertPresentException e) {
				Thread.sleep(1000);
				continue;
			}
		}
		return alert;
	}
	public void waitForPopUp(WebDriver driver, String b) throws InterruptedException {
		Thread.sleep(3000);
		try {
			selectPopUp(driver, b);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (NoSuchWindowException e1) {
		} catch (Exception e) {
		}
	}
	
	public void selectPopUp(WebDriver driver, String arg) {
		boolean flag = false;
		try {
			for (int i = 0; i < 2 && flag == false; i++) {
				Set<String> pops = driver.getWindowHandles();
					Iterator<String> it = pops.iterator();
					if (pops.size() > 1) {
						System.out.println("No of Windows " + pops.size());
						for (int j = 0; j < pops.size() && flag == false; j++) {
							String popupHandle = it.next().toString();
							if (driver.switchTo().window(popupHandle).getTitle().contains(arg)) {
								driver.switchTo().window(popupHandle);
								flag = true;
							}
						}flag = true;
						pops.clear();
					}
			}
		} catch (NoSuchWindowException e) {
			System.out.println("Not able to Navigate to Window " + arg);
		} catch (Exception e) {
		}
	}
	
	public void checkUsingJavaScript(WebDriver driver, String obj,String ObjectName ) throws InterruptedException {
		try
		{
		WebElement element = null;
		if(obj.startsWith("id")){
			element = driver.findElement(By.id(obj.split("id:")[1]));	
		}else if(obj.startsWith("name")){
			element = driver.findElement(By.name(obj.split("name:")[1]));
		}else{
			element = driver.findElement(By.xpath(obj));
		}
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Extent_Reporting.Log_Pass(ObjectName+" clicked", ObjectName+" Ciicked");
		}
		catch(Throwable t)
		{
		
			LogStatus.fail(ObjectName+" Not Present", ObjectName+" Not Present");
			t.printStackTrace();
			new Exception(ObjectName+" not present");
		}
	}


	public void waitForFrameAndSwitch(WebDriver driver , String frameName) {
		WebDriverWait wait = new WebDriverWait(driver,60);
		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		
	}
	
	public void waitForElementVisible(WebDriver driver, String element,String Element_Name) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		} 
		 catch (Throwable we) {
			 we.printStackTrace();
			 LogStatus.fail(Element_Name+"Not visible", Element_Name+"Not visible");
		}
	}
public void Javascriptexecutor_forClick(WebDriver driver , String frameName,String XpathObject,String ObjectName) throws Throwable {
	waitForPageToLoad(driver);
	waitForFrameAndSwitch(driver, frameName);
	waitForPageToLoad(driver);
	waitForElementVisible(driver, XpathObject,ObjectName);
	try
	{
			WebElement e=driver.findElement(By.xpath(XpathObject));
	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			
			js.executeScript("arguments[0].click();", e);
			Extent_Reporting.Log_Pass(ObjectName+" clicked", ObjectName+" Ciicked");
			js=null;
			e=null;
	}
	catch(Throwable t)
	{
	
		LogStatus.fail(ObjectName+" Not Present", ObjectName+" Not Present");
		t.printStackTrace();
		new Exception(ObjectName+" not present");
	}

	
}

public void clickLinkBypartialLinkText(WebDriver screenName,String linkText,String Element_Name) throws Exception
{
    try
	{
		WebElement webButton = screenName.findElement(By.partialLinkText(linkText));
		webButton.click();
		Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
	}
    catch(Throwable t)
	{ 
		LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
		t.printStackTrace();
		throw new Exception("Element Not Present");
	}
}
public void clickLinkBypartialLinkTextIfExist(WebDriver screenName,String linkText,String Element_Name) throws Exception
{
    try
	{
		WebElement webButton = screenName.findElement(By.partialLinkText(linkText));
		webButton.click();
		Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
	}
    catch(Throwable t)
	{ 
	//	LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
		//t.printStackTrace();
		//throw new Exception("Element Not Present");
	}
}

public void clickLinkByLinkTextIfExist(WebDriver screenName,String linkText,String Element_Name) throws Exception
{
    try
	{
		WebElement webButton = screenName.findElement(By.linkText(linkText));
		webButton.click();
		Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
	}
    catch(Throwable t)
	{ 
		
	}
}

public boolean  CheckifExist(WebDriver driver, String element) {
	try {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		waitForPageToLoad(driver);
		return true;
		
	} catch (NoSuchWindowException e) {
		System.out.println("not exist");
		waitForPageToLoad(driver);
		return false;
	} catch (InvalidElementStateException e) {
		waitForPageToLoad(driver);
		return false;
	} catch (TimeoutException te) {
		waitForPageToLoad(driver);
		return false;
	} catch (NoSuchElementException e) {
		waitForPageToLoad(driver);
		return false;
	} catch (WebDriverException we) {
		waitForPageToLoad(driver);
		return false;
	}
}


	public boolean checkElementClickable(WebDriver driver,String Objedct_xpath, WebElement element_name) throws InterruptedException {
	try {
		
	    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Objedct_xpath)));
		Extent_Reporting.Log_Pass(element_name+" Element is clickable", element_name+" Element is clickable");
		waitForPageToLoad(driver);
		return true;
	} catch (Throwable e) {
		waitForPageToLoad(driver);
		LogStatus.fail(element_name+" Element is not clickable", element_name+" Element is not clickable");
		return false;
	} 
	
	
	}

	
	public void WaitUntilExist(WebDriver driver,String Element)
	{
		RemovewaitForPageToLoad(driver);
		int i=1;
		do
		{
			
			//System.out.println("loop "+i);
			try
			{
				driver.findElement(By.xpath(Element));
			//	System.out.println("Element found Exiting ");
				break;
			}
			catch(Throwable t)
			{
			//	System.out.println("Element not found");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i=i+1;
			if (i==50)
			{
				break;
			}
			
		}while(true);
		waitForPageToLoad(driver);
	}
	public void RemovewaitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt("0"), TimeUnit.SECONDS);
	}
	public void Waituntilsiappear(WebDriver driver,String Element)
	{
		RemovewaitForPageToLoad(driver);
		do
		{
			try
			{
				driver.findElement(By.xpath(Element));
			}
			catch(Throwable t)
			{
				break;
			}
			
			
			
		}while(true);
		waitForPageToLoad(driver);
	}
	/*
	driver.switchTo().defaultContent();
	
	 frames=driver.findElements(By.tagName("iframe"));
	 for (int i=0;i<frames.size();i++)
	 {
		 System.out.println(frames.get(i).getAttribute("id"));
		 
		 driver.switchTo().frame(frames.get(i));
		 Thread.sleep(1000);
		
			try{
				//action.Clickbtn(driver, RandomSearchIDradio, "RandomSearchIDradio");
				//break;
				driver.findElement(By.xpath(claimsubmisionpage_label));
				System.out.println("claimsubmisionpage_label Element Identified");
				break;
			}
			catch(Throwable t)
			{
				
			}
		 
		 
		 driver.switchTo().defaultContent();
		 Thread.sleep(1000);
		 frames=driver.findElements(By.tagName("iframe"));
	 }
	*/
	public boolean isElementEnabled(WebDriver driver,String xpath,String Element_Name)
	{
		boolean flag=false;
		try
		{
			if(driver.findElement(By.xpath(xpath)).isEnabled())
			{	Extent_Reporting.Log_Pass(Element_Name +" is Enabled ", Element_Name +" is Enabled ");
				flag = true;
			}
		}
		catch(Throwable e)
		{
			Extent_Reporting.Log_Pass(Element_Name +" is not Exists ", Element_Name +" is not Exists ");
			flag = false;
		}
		return flag;

	}
	public void clickButtonwithEnterKeytwice(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
			//webButton.click();
			webButton.sendKeys(Keys.ENTER);
			webButton.sendKeys(Keys.ENTER);
			Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
		}
		catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	
	
	public void Javascriptexecutor_InputText(WebDriver driver ,WebElement Element_name) throws Throwable {
		waitForPageToLoad(driver);
		//waitForFrameAndSwitch(driver, frameName);
		try
		{			
			//WebElement e=driver.			
			JavascriptExecutor js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='email@domain.com';$(arguments[0]).trigger('change');" , Element_name);			
				Extent_Reporting.Log_Pass(Element_name+" clicked1", Element_name+" Ciicked");
				js=null;
				Element_name=null;
		}
		catch(Throwable t)
		{
		
			LogStatus.fail(Element_name+" Not Present", Element_name+" Not Present");
			t.printStackTrace();
			new Exception(Element_name+" not present");
		}

		
	}
	
	
	public boolean WaitUntilNumberofWindowHandleOpen(WebDriver driver,int n) throws InterruptedException {
		
		String[] browser;
		int i=1;
		int cnt=0;
		do
		{
			Set<String> handles = driver.getWindowHandles();

			 browser =	handles.toArray(new String[0]);
			System.out.println("Number of browsers opened are"+ browser.length);
			Thread.sleep(500);
			
			if(browser.length==n) 
			{
				cnt=1;
				break;
			}
			if (i==20)
			{
			cnt=1;
			break;
			}
			
		}while(true);
		if (cnt==1)
		{
			return true;
			
		}
		else
		{
			return false;
		}
		

	} 
	

	
	
	
	
	public void clickDropDown(WebElement Element_Name) throws Exception
	{
		try
		{
			Element_Name.click();
			Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
		}
		catch(Throwable t)
		{ 
			LogStatus.fail(Element_Name+" does not Exist",Element_Name+" does not Exist");
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	


	  public void MouseClick(WebElement element) throws AWTException
	    {
	    	  Robot bot = new Robot();
	    	   int x=element.getLocation().getX();
	    	   int y=element.getLocation().getY();
	    	   System.out.println(x+" "+y);
	    	    bot.mouseMove(x+8, y+70);    
	    	    bot.mousePress(InputEvent.BUTTON1_MASK);
	    	    bot.mouseRelease(InputEvent.BUTTON1_MASK);
	    }

	
	
	
	public void analyzeLog(WebDriver ScreenName) {
        LogEntries logEntrie = ScreenName.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntrie) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel()+ " " + entry.getMessage());
            //do something useful with the data
        }
    }
	
}


