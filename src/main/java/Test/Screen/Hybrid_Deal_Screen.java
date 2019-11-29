package Test.Screen;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browser.Driver;
import Object_Repository.Screen.CampaignScreen_Object;

import Object_Repository.Screen.HybridHomeScreenObject;
import Object_Repository.Screen.Hybrid_Screen_Object;

public class Hybrid_Deal_Screen extends Driver {
	public static Hybrid_Screen_Object hybridscreen;
	public static HybridHomeScreenObject hybridhomescreen;
	public static CampaignScreen_Object hybriddeal;
	
	@BeforeMethod
	public void setUp() throws Exception {
		application("andriod","andriod");
		
		hybridhomescreen= new HybridHomeScreenObject();
		hybridscreen =new Hybrid_Screen_Object();
		hybriddeal = new CampaignScreen_Object();
		hybridhomescreen=hybridscreen.LoginProcedure();
		hybriddeal=hybridhomescreen.home();
		
	}

		@Test(priority = 1)
		public void verifyAddition() throws Exception {
			hybriddeal.Deal();
		System.out.println("result is pass");

		}
		
	@AfterMethod
	public void tearDown() {
	andrioddriver.quit();
	}





	}


