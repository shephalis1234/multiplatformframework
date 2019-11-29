package Object_Repository.Screen;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.support.PageFactory;

import Browser.Driver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CampaignScreen_Object extends Driver{
	
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Campaign Name\")")
    private AndroidElement campaignname ;
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Tags\")")
    private AndroidElement tag ;
	
	@AndroidFindBy( id = "com.getmeashop.crm:id/etTagname")
    private AndroidElement tagname ;
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"ADD\")")
    private AndroidElement add ;
	
	@AndroidFindBy(id="com.getmeashop.crm:id/next")
    private AndroidElement next ;
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Edit to add/change contacts\")")
    private AndroidElement addcontact ;
       
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Edit to add/change emails\")")
    private AndroidElement addemail ;
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Enter message\")")
    private AndroidElement entermessage ;
	
	@AndroidFindBy( uiAutomator = "new UiSelector().text(\"Body\")")
    private AndroidElement body ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Subject\")")
	private AndroidElement subject ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"NOW\")")
	private AndroidElement now ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"LATER\")")
	private AndroidElement later ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"FINISH\")")
	private AndroidElement finish ;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"2019\")")
	private AndroidElement year ;
	 
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/prev\")")
	private AndroidElement prev ;
	
	@AndroidFindBy(id = "android:id/next")
	private AndroidElement nextone ;
	
	public CampaignScreen_Object() {
		 PageFactory.initElements(new AppiumFieldDecorator(andrioddriver), this);	       

	}
	public void Deal() throws ParseException {
		
		campaignname.sendKeys("shephalisingh");
		next.click();
		addcontact.sendKeys("9090909090");
		addemail.sendKeys("dsd@gmail.com");
		next.click();
		entermessage.sendKeys("this is good for us");
		subject.sendKeys("ds@gmail.com");
		body.sendKeys("yes");
		next.click();
		later.click();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal1 = Calendar.getInstance();
		String year1=dateFormat.format(cal1);----
		System.out.println(dateFormat.format(cal1));
		String year ="01-09-2018";
		
		DateFormat formatter = new SimpleDateFormat("year");
		 Date date = (Date)formatter.parse(year.toString()); 
		Calendar  cal=Calendar.getInstance();
		  cal.setTime(date);
		while(cal.equals(year1))  
		if(cal.before(year1)){
			prev.click();
		}
		else 
			next.click();

	}
}
