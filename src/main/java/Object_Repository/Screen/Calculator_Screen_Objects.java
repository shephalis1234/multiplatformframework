package Object_Repository.Screen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Browser.Driver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Calculator_Screen_Objects extends Driver {
	
	
	@FindBy( id  = "com.android.calculator2:id/digit_1")
    private AndroidElement one ;
	
	@AndroidFindBy( uiAutomator  = "new UiSelector().text(\"2\")")
    private AndroidElement two ;
	
	@AndroidFindBy( uiAutomator  = "new UiSelector().text(\"3\")")
    private WebElement three ;
	
	@AndroidFindBy( uiAutomator  = "new UiSelector().text(\"4\")")
    private WebElement four ;
	
	@AndroidFindBy( uiAutomator  = "new UiSelector().text(\"5\")")
    private WebElement five ;
	
	@AndroidFindBy( uiAutomator  = "new UiSelector().text(\"+\")")
    private WebElement plus ;
	
	@AndroidFindBy( uiAutomator  = "new UiSelector().text(\"=\")")
    private WebElement equals ;
	
	@AndroidFindBy( uiAutomator  = "new UiSelector().resourceId(\"com.android.calculator2:id/result\")")
    private WebElement result ;
	
	 public Calculator_Screen_Objects() {
		 PageFactory.initElements(new AppiumFieldDecorator(andrioddriver), this);	       
		
	    }
	public String addition() throws Exception {
	one.click();
	plus.click();
		two.click();
		equals.click();
		String results= result.getText();
		return results;
	}
	
}
