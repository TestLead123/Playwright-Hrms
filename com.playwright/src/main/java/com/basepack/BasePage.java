package com.basepack;

import org.testng.annotations.BeforeTest;

import com.util.CommonUtils;

public class BasePage 
{

	@BeforeTest
	
	public void setup() throws InterruptedException
	{
		CommonUtils.readPropertiesFile();
		
		CommonUtils.startBrowser();
		
	}
	
	
}
