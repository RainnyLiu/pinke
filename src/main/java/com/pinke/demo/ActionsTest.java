package com.pinke.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.pinke.utils.WebDriverUtils;

public class ActionsTest {
	public static void main(String[] args) {
		WebDriver driver = WebDriverUtils.geChrometDriver();
		//driver.get("http://bbs.51testing.com/forum.php");
//1.����webelement.click
//2.������action.click
//3.������javascript,��dom��λԪ�ص���click
		
//		Actions actions = new Actions(driver);
//		actions.click(driver.findElement(By.xpath("//a[@href='forum-42-1.html']")));
//		actions.perform();
		
//		actions.click(driver.findElement(By.xpath("//a[@href='forum-42-1.html']"))).perform();;
		
		
		//ʵ������javascript дdom�������¼�
		//((JavascriptExecutor)driver).executeScript("document.getElementById('aa').click")
		
		Actions actions = new Actions(driver);
		driver.get("http://www.ihome6.com/");
		WebElement e1 = driver.findElement(By.xpath("//a[text()='���ģ��']"));
		WebElement e2 = driver.findElement(By.xpath("//a[text()='�˹�����']"));
		WebElement e3 = driver.findElement(By.xpath("//a[text()='����Ҿ�']"));
		
//		actions.moveToElement(e1).pause(Duration.ofSeconds(2L))
//			.moveToElement(e2).pause(Duration.ofSeconds(2L))
//			.moveToElement(e3)
//			.perform();
		
//		actions.moveToElement(driver.findElement(By.xpath("//a[@href='userManager-securitys']"))).pause(Duration.ofSeconds(2L))
//		.moveToElement(driver.findElement(By.xpath("//a[@href='UserCoupon-index']"))).pause(Duration.ofSeconds(2L))
//		.click().perform();

		WebElement e4 = driver.findElement(By.id("searchInput"));
		
		//actions.keyDown(e4, Keys.SHIFT).sendKeys(e4, "abc").keyUp(Keys.SHIFT).perform();
		//actions.keyDown(e4, Keys.CONTROL).sendKeys(e4, "c").keyUp(Keys.CONTROL).perform();
		actions.keyDown(e4, Keys.CONTROL).sendKeys(e4, "v").keyUp(Keys.CONTROL).perform();
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//e4.clear(); //��ʱ��ʧЧ
		
		String content = e4.getAttribute("value"); // clearʧЧ���ʺϣ���������� forѭ��
		/*for(int i = 0; i < content.length(); i++)
			actions.sendKeys(e4,Keys.BACK_SPACE).perform();*/
		
		//actions.doubleClick(e4).pause(Duration.ofSeconds(1L)).sendKeys(Keys.BACK_SPACE).perform();
		
		actions.click(e4).pause(Duration.ofSeconds(1L))
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).pause(Duration.ofSeconds(1L)) //ʵ��ctrl+a��ȫѡ
		.sendKeys(Keys.BACK_SPACE) //Ȼ��ɾ��ȫѡ������
		.perform();
		
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
