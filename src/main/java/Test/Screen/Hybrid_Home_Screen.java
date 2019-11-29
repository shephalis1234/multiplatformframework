package Test.Screen;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser.Driver;
import Object_Repository.Screen.HybridHomeScreenObject;
import Object_Repository.Screen.Hybrid_Screen_Object;

public class Hybrid_Home_Screen extends Driver {
	public static Hybrid_Screen_Object hybridscreen;
	public static HybridHomeScreenObject hybridhomescreen;
	@BeforeMethod
	public void setUp() throws Exception {
		application("andriod","andriod");
		
		hybridhomescreen= new HybridHomeScreenObject();
		hybridscreen =new Hybrid_Screen_Object();
		hybridhomescreen=hybridscreen.LoginProcedure();
		
	}

		@Test(priority = 1)
		public void verifyAddition() throws Exception {
			hybridhomescreen.home();
		System.out.println("result is pass");

		}
		
	@AfterMethod
	public void tearDown() {
	andrioddriver.quit();
	}





	}
