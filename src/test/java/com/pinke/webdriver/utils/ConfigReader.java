package com.pinke.webdriver.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	public static final String BROWER = "browser"; //怕别人把这个名字写错，可以强制先定义好，不允许改
	public static final String WAITTIME = "waitTime";
	static {
		prop = new Properties();
		InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
		
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getConfig(String name) {
		return prop.getProperty(name);		
	}

}
