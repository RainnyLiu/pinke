package com.pinke.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pinke.utils.WebDriverUtils;

public class BBSTest {
	public static void main(String[] args) {
		WebDriver driver = WebDriverUtils.geChrometDriver();
		driver.get("http://bbs.51testing.com");
		WebElement username_input = driver.findElement(By.id("ls_username"));
		username_input.sendKeys("12345");
		WebElement password_input = driver.findElement(By.name("password"));
		password_input.sendKeys("123456789");
		//WebElement hotTopic_link = driver.findElement(By.linkText("玩出论坛新花样，绑微信享专属活动"));
		//WebElement hotTopic_link = driver.findElement(By.partialLinkText("玩出论坛新花样"));
		//hotTopic_link.click();
		WebElement chart_div = driver.findElement(By.id("chart"));
		//WebElement em = chart_div.findElement(By.tagName("em")); // find单个tag元素
		List<WebElement> ems = chart_div.findElements(By.tagName("em")); // find多个tag元素
		for (WebElement em : ems) 
			System.out.println(em.getText());
		
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
