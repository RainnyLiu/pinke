package com.pinke.ihome.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class LogTest {
	private static Logger logger = LogManager.getLogger("��һ��");
	@Test
	private void logTest1() {
		logger.info("������test1");
	}
	
	@Test
	private void logTest2() {
		logger.warn("������test2");
	}

	@Test
	private void logTest3() {
		logger.debug("������test3");
	}

	@Test
	private void logTest4() {
		logger.error("������test4");
	}


}
