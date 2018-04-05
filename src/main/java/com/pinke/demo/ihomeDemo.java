package com.pinke.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pinke.utils.WebDriverUtils;

public class ihomeDemo {
	public static void main(String[] args) {
		/*for(int i=0; i < args.length; i++) {
			System.out.println(args[i]);
		}*/
		WebDriver driver = WebDriverUtils.geChrometDriver();
		driver.get("http://ihome6.com");
		driver.findElement(By.xpath("//a[@class='a-login']")).click(); //�����¼
		driver.findElement(By.xpath("//input[@id='user']")).sendKeys("xief"); //�����û���
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456"); //��������
		driver.findElement(By.xpath("//button[@id='login-ent-btn']")).click(); //�����¼button
		driver.findElement(By.xpath("//div[@id='top-seller-center']/a")).click(); //�����������������
		//driver.findElement(By.xpath("//div[@class='leftMeun']/ul[3]/li[5]/a")).click(); //�����Ʒ���ࣻ
		//css�﷨
		driver.findElement(By.cssSelector("div.leftMeun > ul:nth-child(7) > li:nth-child(5) > a")).click();
		//��д��һ��һ������
		//WebElement firstClass_input = driver.findElement(By.xpath("//table[@class='table sort']/tbody[1]/tr/td[2]/input"));
		
		//����Ƿ����shotclassҳ��
		String curl = driver.getCurrentUrl();
		assert curl.equals("http://www.ihome6.com/ShotClass");
		
		//dom�﷨
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		//WebElement firstClass_input = (WebElement)jsExecutor.executeScript("return document.getElementsByClassName('ipsua')[0]");
		
		//jquery �﷨
		WebElement firstClass_input = (WebElement)jsExecutor.executeScript("return $(\":input[class='ipsua']\")[0];");
		firstClass_input.clear();
		firstClass_input.sendKeys("123");
		
		//�����һ������ǰ���С��ͷ
		firstClass_input.findElement(By.xpath("./../span")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		//��д��һ����������
		WebElement secondClass_input = driver.findElement(By.xpath("//table[@class='table sort']/tbody[2]/tr/td[2]/input"));
		secondClass_input.clear();
		secondClass_input.sendKeys("222");
		
		//�������ӷ���
		//driver.findElement(By.xpath("//table[@class='table sort']/tbody[2]/tr[@class='row add-sub']/td[2]/a")).click();
		driver.findElement(By.xpath("//table[@class='table sort']/tbody[2]/tr[last()]/td[2]/a")).click(); //�õ� ν�ʣ�last()
		
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.close();
	WebDriverUtils.stopService();
	}
}
