package com.tests;

import org.testng.annotations.Test;

import com.basepack.BasePage;
import com.pages.LoginPage;
import com.util.CommonUtils;
import com.util.TestNGUtility;


public class TestPIMPage extends BasePage 
{

	LoginPage loginPage = new LoginPage(); 
	
	@Test(description = "Verify that an employee can be added successfully")
    public void addEmployeeThenVerify() {
    
    	// initialize here

    	//CommonUtils.loginWithMultipleRecordsUsingExcel("MultipleLoginFunctionality");
		

    			// Login
    			loginPage.login();
    			
	//validate welcome message
	
	TestNGUtility.assertTrue(CommonUtils.getElementText(loginPage.getWelcomeText()),"Welcome playwright");
	
	
	 System.out.println("Login Successful");
	}
}
