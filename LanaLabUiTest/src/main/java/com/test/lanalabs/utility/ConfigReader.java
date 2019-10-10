package com.test.lanalabs.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;
	FileInputStream fis = null;

	public ConfigReader() {
		try {
			File src = new File(System.getProperty("user.dir") + "//configuration//config.property");
			fis = new FileInputStream(src);
			prop = new Properties();

			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}
	
	   public String extentConfigPath() {
      	 return prop.getProperty("EXTENT_CONFIG_PATH");
       }
	   
	   public  String app_url(){
				 return prop.getProperty("APP_URL");
				} 
	   
	   public String getLoginSceanrioTestDataJSONPath() {
		   return prop.getProperty("LOGIN_CREDENTIALS_TESTDATA_PATH");
	   }
	   
	   
	   public String getLoginSceanrioTestDataValueForInvalidUserName() {
		   return prop.getProperty("LOGIN_CREDENTIALS_TESTDATA_VALUE_FOR_INVALID_USER_NAME");
	   }
	   
	   
	   public String getLoginSceanrioTestDataValueForValidCaseSensativePassword() {
		   return prop.getProperty("LOGIN_CREDENTIALS_TESTDATA_VALUE_FOR_INVALID_CASE_SENSATIVE_PASSWORD");
	   }
	   
	   public String getLoginSceanrioTestDataValueForValidCaseSensativeUserName() {
		   return prop.getProperty("LOGIN_CREDENTIALS_TESTDATA_VALUE_FOR_VALID_CASE_SENSATIVE_USERNAME");
	   }
	   
	   public String getLoginSceanrioTestDataValueForValidCredentials() {
		   return prop.getProperty("LOGIN_CREDENTIALS_TESTDATA_VALUE_FOR_VALID_CREDENTAILS");
	   }
	   
	   public String getFilterScenarioTestDataJSONPath() {
		   return prop.getProperty("FILTER_SCENARIO_TESTDATA_PATH");
	   }
	   
	   public String getFilterScenarioTestDataValue() {
		   return prop.getProperty("FILTER_SCEANRIOS_TESTDATA_VALUE");
	   }
}

