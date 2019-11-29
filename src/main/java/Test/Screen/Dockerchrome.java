package Test.Screen;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Dockerchrome {
@Test
public void docker() throws MalformedURLException {
DesiredCapabilities caps=DesiredCapabilities.chrome();
//ChromeOptions options = new ChromeOptions();

//caps.setCapability("platformName", "Windows 10");
//caps.setCapability("browserVersion", "78.0");
URL url=new URL("http://192.168.99.100:4444/wd/hub");
WebDriver driver=new RemoteWebDriver(url, caps);
//driver.get("https://www.hubspot.com/products/crm");
//System.out.println(driver.getTitle());
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
