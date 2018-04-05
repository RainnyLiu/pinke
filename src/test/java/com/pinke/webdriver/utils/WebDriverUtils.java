package com.pinke.webdriver.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

public class WebDriverUtils {
	private static DriverService service;
	
	private WebDriverUtils() {}; //防止别人乱用我的类，设置为private，不让别人构造！
	
	public static WebDriver getDriver(String browserName, Class<?> clazz) {
		WebDriver driver = null;
		if(service == null)
			if("chrome".equalsIgnoreCase(browserName)) {
				service = new ChromeDriverService.Builder()  //独立启动chrome service,即只启动一次
						.usingDriverExecutable(new File("drivers/chromedriver.exe"))
						.usingAnyFreePort()
						.build();
				
			}else if("firefox".equalsIgnoreCase(browserName)) {
				service = new GeckoDriverService.Builder()  //独立启动chrome service,即只启动一次
						.usingDriverExecutable(new File("drivers/geckodriver.exe"))
						.usingAnyFreePort()
						.build();
				
			}else if("ie".equalsIgnoreCase(browserName)) {
				service = new InternetExplorerDriverService.Builder()  //独立启动chrome service,即只启动一次
						.usingDriverExecutable(new File("drivers/IEDriverServer.exe"))
						.usingAnyFreePort()
						.build();
				
			}else {
				System.err.println("浏览器不支持");
				return null;
			}
			try {
				service.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if("chrome".equalsIgnoreCase(browserName)) {
				driver = new RemoteLogWebDriver(service.getUrl(), DesiredCapabilities.chrome(),clazz); 
			}else if("firefox".equalsIgnoreCase(browserName)) {
				driver = new RemoteLogWebDriver(service.getUrl(), DesiredCapabilities.firefox(),clazz); 
			}else if("ie".equalsIgnoreCase(browserName)) {
				driver = new RemoteLogWebDriver(service.getUrl(), DesiredCapabilities.internetExplorer(),clazz); 
			}else {
				System.err.println("浏览器不支持");
				return null;
			}
			return driver;
	}
	public static void stopService() {
		if(service != null)
		service.stop(); //关闭服务
	}
}
