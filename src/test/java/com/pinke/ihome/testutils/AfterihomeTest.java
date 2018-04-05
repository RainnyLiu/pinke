package com.pinke.ihome.testutils;

import org.testng.annotations.AfterSuite;

import com.pinke.utils.WebDriverUtils;

public class AfterihomeTest {
	@AfterSuite
	public void stopService() {
		WebDriverUtils.stopService();
		
	}
}
