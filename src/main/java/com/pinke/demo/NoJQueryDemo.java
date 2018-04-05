package com.pinke.demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pinke.utils.WebDriverUtils;

public class NoJQueryDemo {
	public static void main(String[] args) {
		WebDriver driver = WebDriverUtils.geChrometDriver();
		driver.get("http://www.w3school.com.cn/jsref/dom_obj_all.asp");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "var headNode = document.head;"
				+ "var scriptNode = document.createElement('script');"
				+ "var typeNode = document.createAttribute('type');"
				+ "typeNode.value = \"text/javascript\";"
				+ "var srcNode = document.createAttribute('src');"
				+ "srcNode.value = \"http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js\"; "
				+ "scriptNode.setAttributeNode(typeNode);"
				+ "scriptNode.setAttributeNode(srcNode);"
				+ "headNode.appendChild(scriptNode);";
		js.executeScript(script);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebElement element = (WebElement)new WebDriverWait(driver,10L).until(ExpectedConditions.jsReturnsValue("return $('h1')[0]"));
		
		WebElement element = (WebElement)js.executeScript("return $('h1')[0]");	
		System.out.println(element.getText());
		
	
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
