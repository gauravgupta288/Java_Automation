package com.OrangeHRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public static Properties pro;
	File src ;
	FileInputStream fis;
	
	public ReadConfig(){
		src = new File("Configurations/config.properties");
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			fis.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception "+ e.getMessage());
		}
	}
	public String getBaseURL() {
		return 	pro.getProperty("baseURL");
	}
	public String getBaseUserName() {
		return 	pro.getProperty("userName");
	}
	public String getBasePassword() {
		return 	pro.getProperty("password");
	}

	public String getInvalidPassword() {
		return 	pro.getProperty("invalidPassword");
	}

}
