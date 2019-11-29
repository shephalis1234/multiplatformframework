package Test.Screen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Dockerfirefox {
	@Test
	public void firefox() throws MalformedURLException {
		DesiredCapabilities caps=DesiredCapabilities.firefox();
//		caps.setBrowserName(BrowserType.CHROME);

	URL url=new URL("http://192.168.99.100:4444/wd/hub");
	WebDriver driver=new RemoteWebDriver(url, caps);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://zapier.com/blog/best-free-crm/");
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("//span[text()='Log In']")).click();
	driver.findElement(By.xpath("//*[@name='email']")).sendKeys("shep.shidhi456@gmail.com");
	driver.findElement(By.xpath("//span[text()='Continue']")).click();
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("minni@#45");
	driver.findElement(By.xpath("//*[text()='Continue']")).click();
	driver.close();
	}
}
