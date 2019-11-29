package Test.Screen;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class saucelabweb {
	public static final String USERNAME = "shephalis1234";
	  public static final String ACCESS_KEY = "c5c01258-ab8a-482f-8ce1-c73bab86803c";
	  public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	 
	public static void main(String args[]) throws MalformedURLException {
		 
		DesiredCapabilities caps = DesiredCapabilities.chrome();

	ChromeOptions browserOptions = new ChromeOptions();
	caps.setCapability("name", "Windows 10 with chrome");

	caps.setCapability("platformName", "Windows 10");
	caps.setCapability("browserVersion", "78.0");
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("https://zapier.com/blog/best-free-crm/");
    driver.findElement(By.xpath("//span[text()='Log In']")).click();
    driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("shep.shidhi456@gmail.com");
    driver.findElement(By.xpath("//span[text()='Continue']")).click();
    driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("minni@#45");
    driver.findElement(By.xpath("//span[text()='Continue']")).click();
    driver.close();
    

}
}