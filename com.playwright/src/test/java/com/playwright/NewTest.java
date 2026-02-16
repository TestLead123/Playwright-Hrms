package com.playwright;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.testng.annotations.BeforeClass;

import java.nio.file.Paths;

import org.testng.annotations.AfterClass;

public class NewTest 
{
	Page driver;
	
  @Test
  public void verifyTitleOfWebpage() throws InterruptedException 
  {
     //navigate the application URL
	  
	  driver.navigate("http://127.0.0.1/orangehrm-2.5.0.2/login.php");
	  
	  //-------------operation code
	  //get the title
	  String title=driver.title();
	  
	  //print the title
	  System.out.println("title of the webpage :" +title);
	  
	  //verify title of the web page
	  
	  //-------------------verification code
	  if(title.equals("OrangeHRM - New level of HR Management"))
	  {
		  System.out.println("title verified");
	  }
	  
	  else
	  {
		  System.out.println("title not verified");
 
	  }
	  
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
	  
	  
	  //Mouse hover actions
	  
	  driver.locator("#pim").hover();
	  
	  Thread.sleep(5000);
	  
	  //click on add employee page
	  
	  driver.locator("//input[@id='photofile']").click();
	  
	  //upload the file
	  
	  FrameLocator frame=driver.frameLocator("#rightMenu");
	  
	  frame.locator("#photofile").setInputFiles(Paths.get("D:\\sql notes..docx"));
	  
	  //identify and click on logout
	  
	  driver.locator("xpath=/html/body/div[3]/ul/li[3]/a").click();
	  
	  
  }
  
  @Test
  public void handleModelpopupWindows() throws InterruptedException 
  {
     //navigate the application URL
	  
	  driver.navigate("https://mdbootstrap.com/docs/standard/components/modal/#docsTabsOverview");
	  driver.locator("#accept_cookies_btn").click();
	  driver.locator("xpath=/html/body/header/nav/div/span/ul/li[8]/a[2]").click();
	  driver.locator("xpath=/html/body/header/span/div/div/div/div[2]/button").click();
	  
	  
	  }
  
  @Test
  public void handleMultipleWindows() throws InterruptedException 
  {
	  //create page
	  //Page  parentPage=Browser.NewPageOptions();
     //navigate the application URL
	  
	/*  //wait until popup window opended
	 Page childwindowOne= parentPage.waitForPopup(()->{parentPage.locator("text=Click Here").click();});
	
	 //wait until page content load
	 childwindowOne.waitForLoadState();
	 
	  System.out.println("childwindowOne: "+childwindowOne.title());
	  childwindowOne.close();
	  
	  //go for parentpage do some action
	  Page childwindowTwo= parentPage.waitForPopup(()->{ parentPage.locator("text=Elemental Selenium").click();});
	  
	  childwindowTwo.waitForLoadState();
	  System.out.println("childwindowTwo: "+childwindowTwo.title());
	  parentPage.close(); */
	  
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
