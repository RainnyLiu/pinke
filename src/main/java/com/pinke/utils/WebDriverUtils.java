package com.pinke.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.firefox.GeckoDriverService.Builder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;

public class WebDriverUtils {
	private static DriverService service;
	static { //��һ�����õĻ�ʹ�������֮��ͻᣬ��Ϊ����static
		service = new ChromeDriverService.Builder()  //��������chrome service,��ֻ����һ��
				.usingDriverExecutable(new File("drivers/chromedriver.exe"))
				.usingAnyFreePort()
				.build();
		
		try {
			service.start(); //��������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static WebDriver geChrometDriver() { //�ڶ������õģ����������
		URL url = service.getUrl(); 
		
		WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.chrome()); // Driver ͨ���򿪵�service�������Σ�Ч�����
		return driver;
	}
	
	public static void stopService() {
		service.stop(); //�رշ���
	}
	
/*	private static Builder geckservice;
	static { //��һ�����õĻ�ʹ�������֮��ͻᣬ��Ϊ����static
		geckservice = new GeckoDriverService.Builder();  //��������chrome service,��ֻ����һ��
				.usingDriverExecutable(new File("drivers/geckodriver.exe"))
				.usingAnyFreePort()
				.build();
		
		try {
			geckservice.start(); //��������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static WebDriver geFirxtDriver() { //�ڶ������õģ����������
		URL url = geckservice.getUrl(); 
		
		WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.firefox()); // Driver ͨ���򿪵�service�������Σ�Ч�����
		return driver;
	}
	
	
	private static org.openqa.selenium.remote.service.DriverService.Builder<GeckoDriverService, Builder> usingDriverExecutable(
			File file) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void stopGeckoService() {
		geckservice.stop(); //�رշ���
	}*/

}
