package com.pages;

import com.util.CommonUtils;
import com.util.TestNGUtility;

public class LoginPage 
{

	 private String usernameInputLocator="input[name='txtUserName']";
	
	 private String passwordInputLocator="input[name='txtPassword']";

	 private String loginButtonLocator="input[name='Submit']";

	 private String verifyWelcomeText="xpath=/html/body/div[3]/ul/li[1]";

	 private String clickOnLogout="xpath=/html/body/div[3]/ul/li[3]/a";

	 private String welcomeTextLocator="xpath=//li[text()='Welcome playwright']";
	 
	 
	 //functions============
	 
	 public void login()
	 {
		 try
		 {
		 CommonUtils.enterValue(enterUsername(),"playwright");
		 
		 CommonUtils.enterValue(enterPassword(),"playwright");
		 
		 CommonUtils.clickElement(clickOnLogin());
		 
		 }catch(Exception e) {
		 
		 TestNGUtility.assertFail(e.getMessage());
		 }
	 }
	 
	 
	 public String enterUsername() 
	 {
	        return usernameInputLocator;
	    }
	 
	 
	 public String enterPassword()
	 {
		 return passwordInputLocator; 
	 }
	 
	 public String clickOnLogin()
	 {
		 return loginButtonLocator; 
	 }
	 
	 
	 public String verifyWelcomeMessage()
	 {
		 return verifyWelcomeText; 
	 }
	 
	 public String getWelcomeText()
	 {
		 return welcomeTextLocator;
	 }
	 
	 public String clickOLogout()
	 {
		 return clickOnLogout; 
	 }
	 
	 
}
