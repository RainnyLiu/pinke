package com.pinke.demo;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.pinke.utils.WebDriverUtils;

public class BbsLoginDemo {
	public static void main(String[] args) {
		WebDriver driver = WebDriverUtils.geChrometDriver();
		//打开首页
		//driver.get("http://bbs.51testing.com");
		driver.navigate().to("http://bbs.51testing.com");
		
		//模拟写一个cookie
		Cookie myCookie = new Cookie(
				"myfavorit", 
				"computer", 
				".51testing.com", 
				"/", 
				new Date(System.currentTimeMillis()+5*60*1000));
		driver.manage().addCookie(myCookie);
		
		
		//填写用户名
		driver.findElement(By.id("ls_username")).sendKeys("xiaoyu.rainny");
		driver.findElement(By.id("ls_password")).sendKeys("d0nt4get");
		
		//点击登录
		driver.findElement(By.cssSelector("button.pn.vm")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取当前页面的所有cookie
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie : cookies) {
			System.out.println(cookie);
		}
		
		//获取窗口大小
		System.out.println(driver.manage().window().getSize());
		
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
