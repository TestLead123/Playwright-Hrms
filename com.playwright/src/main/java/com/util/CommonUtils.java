package com.util;

import java.io.FileInputStream;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommonUtils 
{

	public static FileInputStream fis;
	public static Properties config;
    public static Playwright playwright;
	public static Browser browser;
    public static Page page;
	
	public static void readPropertiesFile() {
		// TODO Auto-generated method stub
		
		try
		{
			//Acess the config.properties file into working environment
			
			fis=new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resource\\config.properties");
			
			//Create the memory space for that for that config.properties file
			
			config=new Properties();
			
			//store config.properties file in a memory space
			
			config.load(fis);
			
		}
		catch(Exception e)
		{
			TestNGUtility.assertFail(e.getMessage());
		}
	}
	
	//browser configuration
	
	
	public static void startBrowser() throws InterruptedException
	{
		
		String browsername=config.getProperty("browser"); //firefox
		
		switch(browsername.toUpperCase())
		{
		
		case "CHROME" :
			
			playwright=Playwright.create();
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "FIREFOX" :
			
			playwright=Playwright.create();
			browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "EDGE" :
			
			playwright=Playwright.create();
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
			break;
			
			default:
				
				TestNGUtility.assertFail1("Invalid browser");
		}
		
		 page=browser.newPage();
		page.navigate(config.getProperty("url"));
		
	}
	
	
	//Enter the value method
	
	public static void enterValue(String selector,String value)
	{
		try
		{
			
			findElement(selector).clear();
			findElement(selector).fill(value);
		}
		catch(Exception e)
		{
			
			TestNGUtility.assertFail1(e.getMessage());

		}
		
	}

	public static Locator findElement(String selector)
	{
		Locator element=null;
		try
		{
			element=page.locator(selector);
		}
		catch(Exception e)
		{
			TestNGUtility.assertFail1(e.getMessage());

		}
		return element;
	}
	
	public static void clickElement(String selector)
	{
		try
		{
			findElement(selector).click();
		}
		catch(Exception e)
		{
			TestNGUtility.assertFail1(e.getMessage());

		}
	}
	
	public static String getElementText(String selector)
	{
		String text=null;
		try
		{
			text=findElement(selector).textContent().trim();
		}catch(Exception e)
		{
			TestNGUtility.assertFail1(e.getMessage());
		}
		return text;
	}
	
}
