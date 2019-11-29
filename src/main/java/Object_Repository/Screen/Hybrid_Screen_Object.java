package Object_Repository.Screen;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Browser.Driver;
import Test.Screen.Hybrid_Home_Screen;
import Utils.StaticFunctionality;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class Hybrid_Screen_Object extends Driver {
	StaticFunctionality staticfunction=new StaticFunctionality();
	
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Username\")")
    private AndroidElement username ;
	
	@AndroidFindBy ( uiAutomator = "new UiSelector().text(\"Password\")")
    private AndroidElement password ;
	
	@AndroidFindBy( id  = "nextbtn")
    private AndroidElement nextbtn ;
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"LOGIN\")")
    private AndroidElement sign ;
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Confirm Password\")")
    private AndroidElement confirmpassword ;
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"ALLOW\")")
    private AndroidElement allow ;
	
	
	 public Hybrid_Screen_Object() {
		 PageFactory.initElements(new AppiumFieldDecorator(andrioddriver), this);	       
		
	    }
	public HybridHomeScreenObject LoginProcedure() throws Exception {
		
		staticfunction.keyboard();
//		username.sendKeys("d");
		username.sendKeys("shephali");
		password.sendKeys("minni@#45");
		sign.click();
	Thread.sleep(500);
		 staticfunction.notification();
//		staticfunction.captureScreenshot("C:\\HaudAPI\\CombineFramework\\Andriodscreenshot");
		 WebElement toastView = driver.findElement(By.xpath("//android.widget.Toast[1]"));
		 String text = toastView.getAttribute("name");
		 System.out.println(text);
		System.out.println(andrioddriver.getContext());
		

	return new HybridHomeScreenObject();
		}
}
