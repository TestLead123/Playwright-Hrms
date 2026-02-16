package com.basepack;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.util.CommonUtils;

public class BasePage 
{
	public Page page;

	@BeforeTest
	
	public void setup() throws InterruptedException
	{
		CommonUtils.readPropertiesFile();
		
		CommonUtils.startBrowser();
		
		
	}
	@AfterTest
	public void tearDown() {

		// Close Playwright browser
	//	page.close();
	}
	
}
