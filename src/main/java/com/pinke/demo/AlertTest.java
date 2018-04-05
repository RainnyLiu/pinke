package com.pinke.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pinke.utils.WebDriverUtils;

public class AlertTest {
	public static void main(String[] args) {
		WebDriver driver = WebDriverUtils.geChrometDriver();
		driver.get("http://localhost/pinke/alert.html");
		driver.findElement(By.id("btn3")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("--机器敲入数据,测试长度YYYYYYYYYYYYYYYYYYYYYYY--");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alert.accept();
		//alert.dismiss();
		
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
