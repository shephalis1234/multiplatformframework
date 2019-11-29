package Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import Browser.Driver;
import io.appium.java_client.MobileElement;



public class StaticFunctionality extends Driver {
	public static String filePath;
	public String captureScreenshot(String path) {
        File scrFile = ((TakesScreenshot) andrioddriver)
				.getScreenshotAs(OutputType.FILE);	
	try {
		filePath=path+"\\toastmessage1.png";
		FileUtils.copyFile(scrFile,  new File(filePath));
	} catch (IOException e) {
			e.printStackTrace();
	}
	return filePath;
}
	public void keyboard() {
		if(andrioddriver.isKeyboardShown()==true) {
			andrioddriver.hideKeyboard();
		}
	}
		
		    public void getImgText(String imageLocation) {
//		    	captureScreenshot(filePath);
		    	TessBaseAPI api = new TessBaseAPI();
		    	
		    	PIX image = lept.pixRead("C:\\HaudAPI\\CombineFramework\\Andriodscreenshot\\toastmessage1.png");
		    			
		        api.SetImage(image);
		    	
		    	BytePointer  outText = api.GetUTF8Text();
		       String str = outText.getString();
//		       Assert.assertTrue(!str.isEmpty());
		        System.out.println("OCR output:\n" + str);
		   }
		  public void notification() throws InterruptedException {
			  andrioddriver.openNotifications();
		    Thread.sleep(2000);
			   List<MobileElement> allnotifications = andrioddriver.findElements(By.id("android:id/title"));
			   System.out.println("no of notifications " + allnotifications.size());
			 
			   for (MobileElement webElement : allnotifications) {
			       System.out.println(webElement.getText());
			       if(webElement.getText().contains("Appium Settings")){
			          System.out.println("Notification found");
			          break;
			   }
			      
			   }
			   andrioddriver.navigate().back();
			   }
	
}
