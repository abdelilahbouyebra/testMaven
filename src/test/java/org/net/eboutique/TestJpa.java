package org.net.eboutique;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJpa {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext app=
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			assertTrue(true);
			} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}
	}

}
