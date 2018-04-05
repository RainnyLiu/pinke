package com.pinke.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pinke.utils.WebDriverUtils;

public class OpenBaidu {
	public static void main(String[] args) {
		
		WebDriver driver = WebDriverUtils.geChrometDriver();
		
		driver.get("http://baidu.com");
		driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("»Á∫Œ—ßœ∞≤‚ ‘");
		driver.findElement(By.xpath("//input[@id='su']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		WebDriverUtils.stopService();
	}

}
