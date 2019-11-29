package Object_Repository.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Browser.Driver;

public class FirstPageobject extends Driver {

	@FindBy(xpath="//a[text()='Gmail']")
    WebElement gmail;
	
	public FirstPageobject() {
		PageFactory.initElements(driver, this);
	}
	public boolean gmail() {
		boolean b=gmail.isDisplayed();
		return b;
	}
	
}
