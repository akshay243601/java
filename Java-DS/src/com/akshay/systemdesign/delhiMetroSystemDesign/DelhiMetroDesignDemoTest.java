package com.akshay.systemdesign.delhiMetroSystemDesign;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DelhiMetroDesignDemoTest {
	DelhiMetroDesignDemo delhiMetroDesignDemo = null;
	
	@Before
	public void setUp() {
		delhiMetroDesignDemo = new DelhiMetroDesignDemo();
	}

	@Test
	public void checkFair() throws Exception {
		Integer output = (int) delhiMetroDesignDemo.getTotalfare(Stations.A1, Stations.A3);
		assertEquals("14", output.toString());
	}

}
