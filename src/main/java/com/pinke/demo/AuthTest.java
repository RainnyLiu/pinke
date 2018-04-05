package com.pinke.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.security.UserAndPassword;

import com.pinke.utils.WebDriverUtils;

public class AuthTest {
	public static void main(String[] args) {
		WebDriver driver = WebDriverUtils.geChrometDriver();
		driver.get("http://localhost:8080");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("a[href='/host-manager/html']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		//alert.authenticateUsing(new UserAndPassword("xiaoyu","123456"));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//alert.accept();
		alert.dismiss();
		
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
