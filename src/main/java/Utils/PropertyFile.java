package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
public static String get(String propertyname, String propertydevice) throws IOException {
		
		String returnproperty=null;
		FileInputStream file;
		Properties property = new Properties();
		switch (propertydevice) {
			case "webbrowser":
				file = new FileInputStream("./properties/config.properties");
				property.load(file);
				break;
			case "andriod":
				 file = new FileInputStream("./properties/andriod.properties");
				 property.load(file);
				break;
			
			}
		try {
			
			returnproperty = property.getProperty(propertyname);
			if(returnproperty==null) {
				throw new Exception("Property named "+propertyname+ "not found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
			
			
			return returnproperty;
		

		}
}
	


