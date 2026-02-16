package com.util;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Properties;

//import com.Hrms.utils.TestNGUtility;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
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
			TestngUtils.assertFail(e.getMessage());
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
				
				TestngUtils.assertFail1("Invalid browser");
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
			
			TestngUtils.assertFail1(e.getMessage());

		}
		
	}
	
	public static void enterValue(FrameLocator pimframe,String selector,String value)
	{
		try
		{
			
			pimframe.locator(selector).fill(value);
		}
		catch(Exception e)
		{
			
			TestngUtils.assertFail1(e.getMessage());

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
			TestngUtils.assertFail1(e.getMessage());

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
			TestngUtils.assertFail1(e.getMessage());

		}
	}
	public static void clickElement(FrameLocator pimframe,String selector)
	{
		try
		{
			pimframe.locator(selector).click();
		}
		catch(Exception e)
		{
			TestngUtils.assertFail1(e.getMessage());

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
			TestngUtils.assertFail1(e.getMessage());
		}
		return text;
	}
	
	public static String getElementText(FrameLocator frame,String selector)
	{
		String empText=null;
		try
		{
			empText=frame.locator(selector).textContent();
		}catch(Exception e)
		{
			TestngUtils.assertFail1(e.getMessage());
		}
		return empText;
	}
	
	
	//Mouse Actions
	
	public static void moveToElement(String selector)
	{
		try
		{
			findElement(selector).hover();
		}
		catch(Exception e)
		{
			TestngUtils.assertFail1(e.getMessage());

		}
	}

	//switch to frame
	
	public static FrameLocator switchToFrameByUsingIdorName(String selector)
	{
		FrameLocator frame=null;
		try
		{
			frame=page.frameLocator(selector);
		}
		catch(Exception e)
		{
			TestngUtils.assertFail1(e.getMessage());

		}
		return frame;
	}

	public static void selectDropdownValue(FrameLocator frame,String selector,String option)
	{
		try
		{
			frame.locator(selector).selectOption(option);
		}
		catch(Exception e)
		{
			TestngUtils.assertFail1(e.getMessage());

		}
	}
	
	
	public static void uploadFile(FrameLocator frame,String selector,String filepath)
	{
		try
		{
			frame.locator(selector).setInputFiles(Paths.get(filepath));
		}
		catch(Exception e)
		{
			TestngUtils.assertFail1(e.getMessage());

		}
	}
	public static boolean isElementChecked(FrameLocator frame,String selector)
	{
		boolean	element=false;
		try
		{
			frame.locator(selector).click();
			element=frame.locator(selector).isChecked();

		}
		catch(Exception e)
		{
			TestngUtils.assertFail1(e.getMessage());

		}
		return element;
	}
}
