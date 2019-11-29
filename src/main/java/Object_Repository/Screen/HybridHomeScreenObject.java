package Object_Repository.Screen;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Browser.Driver;
import Utils.StaticFunctionality;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HybridHomeScreenObject extends Driver{
	StaticFunctionality stf=new StaticFunctionality();

	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Campaigns\")")
    private AndroidElement Campaigns ;
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Manage campaigns\")")
    private AndroidElement Managecampaigns ;
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Add campaigns\")")
    private AndroidElement Addcampaigns ;
	
	@AndroidFindBy( uiAutomator = "new UiSelector().description(\"Open navigation drawer\")")
    private AndroidElement settingdot ;
	
	
	public HybridHomeScreenObject() {
		 PageFactory.initElements(new AppiumFieldDecorator(andrioddriver), this);	       
		
	    }
	public CampaignScreen_Object home() throws InterruptedException {
		settingdot.click();
		Addcampaigns.click();
return new CampaignScreen_Object();
	}
	
}
