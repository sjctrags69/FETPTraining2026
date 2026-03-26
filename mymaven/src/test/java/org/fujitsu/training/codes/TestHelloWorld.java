package org.fujitsu.training.codes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestHelloWorld {
	private HelloWorld hw;
	
	
	@BeforeEach
	public void setup() {
		hw = new HelloWorld();
		System.out.println();
	}
	
	@AfterEach
	public void teardown() {
		hw = null;
	}
	
	
	@Test
	public void testGetMessage() {
		hw.getMessage();
	}

}
