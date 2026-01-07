package com.playwright;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest2 
{
	Page driver;
	
  @Test
  public void verifyTitleOfWebpage() 
  {
     //navigate the application URL
	  
	  driver.navigate("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	  
	  //-------------operation code
	  //get the title
	  String title=driver.title();
	  
	  //print the title
	  System.out.println("title of the webpage :" +title);
	  
	  //verify title of the web page
	  
	  Assert.assertEquals(title, "OrangeHRM - New Level of HR Management");
	  
	  
	  
	  //Identify username and enter username
	  
	  driver.locator("[name='txtUserName']").fill("playwright");
	  
	  driver.locator("[name='txtPassword']").fill("playwright");
	  
	  driver.locator("[name='Submit']").click();
	  
	  //identify and get the welcome selenium text
	  
	  String text=driver.locator("xpath=/html/body/div[3]/ul/li[1]").textContent();
	  
	  System.out.println(text);

	  if(text.equals("Welcome playwright"))
	  {
		  System.out.println("welcome page verified successfully");
	  }
	  else
	  {
		  System.out.println("welcome page not verified successfully");
 
	  }
	  
	  //identify and click on logout
	  
	  driver.locator("xpath=/html/body/div[3]/ul/li[3]/a").click();
	  
  }
  @BeforeClass
  public void openBrowser() 
  {
	  //start the playwright engine
	  
	  Playwright playwright=Playwright.create();
	  
	  //open the firefox browswer
	  
	  Browser browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
	  
	  //open the new tab(page)in firefox
	  
	  driver=browser.newPage();
	  
	  
	  
	  }

  @AfterClass
  public void closeBrowser() 
  {
	  driver.close();
  }

}
