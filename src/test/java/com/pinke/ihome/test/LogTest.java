package com.pinke.ihome.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class LogTest {
	private static Logger logger = LogManager.getLogger("ÔÙÒ»´Î");
	@Test
	private void logTest1() {
		logger.info("¹þ¹þ£¬test1");
	}
	
	@Test
	private void logTest2() {
		logger.warn("¹þ¹þ£¬test2");
	}

	@Test
	private void logTest3() {
		logger.debug("¹þ¹þ£¬test3");
	}

	@Test
	private void logTest4() {
		logger.error("¹þ¹þ£¬test4");
	}


}
