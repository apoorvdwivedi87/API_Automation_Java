package com.hooks;

import java.io.IOException;

import com.testHooks.TestInitializeHooks;

import io.cucumber.java.Before;

public class ApplicationHooks extends TestInitializeHooks{

	
	
	
	@Before(order = 0)
	public void setTestRunSettings() throws IOException  {
		initializeTestSettings();
		
	}
	
	
}
