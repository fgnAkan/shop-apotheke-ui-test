package utils;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class Common {
	public Map<String, String> readUserProperties(String testName) {
		Properties userProperties = new Properties();

		try{
			 String jsonFilePath="/properties/user.properties";
	            String currrentDir=System.getProperty("user.dir");
			
			userProperties.load(new FileReader(currrentDir+jsonFilePath));
		
		} catch (Exception e) {
			System.out.println("Try to read user.properties file");
		}


		Map<String, String> userProperty = new HashMap<String, String>();

		userProperty.put("userName", (String) userProperties.get(testName + ".userName"));
		userProperty.put("password", (String) userProperties.get(testName + ".password"));
		userProperty.put("accountNameSurname", (String) userProperties.get(testName + ".accountNameSurname"));
		return userProperty;
	}
	

}
