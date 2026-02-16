package com.playwright;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.MouseButton;

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
	  driver.keyboard().press("Control+A");
	  driver.keyboard().press("Delete");
	  driver.locator("[name='txtUserName']").fill("playwright");
	  driver.keyboard().press("Tab");

	  driver.locator("[name='txtPassword']").fill("playwright");
	  
	  //driver.locator("[name='Submit']").click();
	  driver.locator("[name='Submit']").press("Enter");
	  
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
  
  @Test

  public void shiftArrowDown()throws InterruptedException
  {
  
	  driver.navigate("https://www.google.com");
	  driver.locator("#APjFqb").click();
	  driver.keyboard().down("Shift"); //prsess shift key
	  driver.keyboard().press("ArrowDown");
	  driver.keyboard().up("Shift"); //Release shift key
      driver.keyboard().press("Enter");
      
	  
	  }
  @Test

  public void dragAndDrop()throws InterruptedException
  {
	  driver.navigate("https://jqueryui.com/resources/demos/droppable/default.html");
	  driver.locator("#draggable").dragTo(driver.locator("#droppable"));
	  String text=driver.locator("xpath=/html/body/div[2]/p").textContent();
	  
	  System.out.println(text);
	  
	  if(text.equals("Dropped!"))
	  {
	  
		  System.out.println("Drag and drop action performed successfully");
	  }
	  else
	  {
		  System.out.println("Drag and drop action not performed successfully");

	  }
  }
  
  @Test 
  public void doubleClick()
  {
	  driver.navigate("file:///C:/Users/ira/Downloads/doubleClickMe%20(1).html");
	  driver.locator("xpath=/html/body/button").dblclick();
	  //verify the field2 text
	 String test=driver.locator("#field2").inputValue();//Hello world!
	  System.out.println(test);

	  if(test.equals("Hello World!"))
	  {
		  System.out.println("Double click action performed sucessfully");
 
	  }
	  else
	  {
		  System.out.println("Double click action not performed sucessfully");
  
	  }
  }
  
  
  @Test 
  public void rightClick()
  {
	  driver.navigate("https://demoqa.com/buttons");
	  driver.locator("#rightClickBtn").click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
	  
	  //verify the right click text
	 String test=driver.locator("#rightClickMessage").textContent();
	  System.out.println(test);

	  if(test.equals("You have done a right click"))
	  {
		  System.out.println("Right click action performed sucessfully");
 
	  }
	  else
	  {
		  System.out.println("Right click action not performed sucessfully");
  
	  }
  }
  
  @Test 
  public void singleCheckbox()
  {
	  driver.navigate("https://demo.guru99.com/test/radio.html");
	  
	  Locator checkbox1=driver.locator("#vfb-6-0");
	  
	  checkbox1.click();  

	  if(checkbox1.isChecked())
	  {
		  System.out.println("checkbox1 is selected");
 
	  }
	  else
	  {
		  System.out.println("checkbox1 is not selected");
  
	  }
	  
	  //identify (or) list of all the checkboxes
	  
	 Locator allcheckboxes =driver.locator("xpath=//input[@type='checkbox']");
	 
	  System.out.println("checkbox1 is selected" +allcheckboxes.count());
	  
	  for(int i=0;i<allcheckboxes.count();i++)
	  {
		  //click on checkbox one by one
		  allcheckboxes.nth(i).click();
	  

	  if(allcheckboxes.nth(i).isChecked())
	  {
		  System.out.println("checkbox is selected");
 
	  }
	  else
	  {
		  System.out.println("checkbox is not selected");
  
	  }
	  }
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
