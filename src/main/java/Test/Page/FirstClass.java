package Test.Page;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import Browser.Driver;

import WebAppPom.FirstPageobject;

public class FirstClass extends Driver{
	FirstPageobject FirstPageobject;
	@Parameters({"confBeforeParameter"})
	@BeforeMethod
	public void setUp(String webapp) throws MalformedURLException {
		application(webapp);
		FirstPageobject = new FirstPageobject();

	}
	@Test(priority = 1)
	public void verify() throws Exception {
		boolean b=FirstPageobject.gmail();
		Assert.assertEquals(b,true);
	}
	@Test(dataProvider = "getData")
	public void testMethod( Object data) {
	    System.out.println(data);
	}


@AfterMethod
public void teardown() {
	driver.close();
}



@DataProvider
public Object[][] getData() throws FileNotFoundException {
    JsonObject jsonData = (JsonObject) new JsonParser().parse(new FileReader("C:/HaudAPI/CombineFramework/first1.json"));
//    JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
//    JsonArray dataSet = jsonData.getAsJsonArray();
    JsonArray jsonArray = (JsonArray) jsonData.get("dataSet");
    List<Object> testData = new Gson().fromJson(jsonArray, new TypeToken<List<Object>>() {
    }.getType());
    Object[][] returnValue = new Object[testData.size()][1];
    int index = 0;
    for (Object[] each : returnValue) {
        each[0] = testData.get(index++);
    }
    return returnValue;
}
}