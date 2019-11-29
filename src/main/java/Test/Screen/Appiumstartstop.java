package Test.Screen;

import java.io.File;

import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Appiumstartstop {
	static String Appium_Node_Path="C:\\Program Files\\nodejs\\node.exe";
    static String Appium_JS_Path="C:\\Program Files\\nodejs\\node_modules\\appium\\lib\\appium.js";
    static AppiumDriverLocalService service;
    static String service_url;
@Test
    public static void appiumStart() throws Exception{
        service = AppiumDriverLocalService.buildDefaultService();

		/*
		 * service = AppiumDriverLocalService.buildService(new
		 * AppiumServiceBuilder().withIPAddress("127.0.0.1").
		 * usingPort(4723).usingDriverExecutable(new File(Appium_Node_Path)).
		 * withAppiumJS(new File(Appium_JS_Path)));
		 */
        service.start();
        service.stop();
//        Thread.sleep(2500);
//        service_url = service.getUrl().toString();
    }

//    public static void appiumStop() throws Exception{
//        service.stop();
//
//    }
}
