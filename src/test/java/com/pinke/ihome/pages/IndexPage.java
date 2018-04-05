package com.pinke.ihome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
		/**
		 * ��ҳ���ע�������
		 */
				@FindBy(linkText="���ע��")
		private WebElement register_link;
		
		/**
		 * ��ҳ��¼����
		 */
		@FindBy(xpath ="//a[@href='/User-login.html']")
		private WebElement login_link;
		
		public IndexPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		/**
		 * ������ע������
		 */
		public void goRegist() {
			register_link.click();
		}
		
		/**
		 * �����¼���ӣ�
		 */
		
		public void goLogin() {
			login_link.click();
		}
		
}