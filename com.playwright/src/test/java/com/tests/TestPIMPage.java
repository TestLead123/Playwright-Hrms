package com.tests;

import org.testng.annotations.Test;

import com.basepack.BasePage;
import com.microsoft.playwright.FrameLocator;
import com.pages.LoginPage;
import com.pages.PIMPage;
import com.util.CommonUtils;
import com.util.TestngUtils;


public class TestPIMPage extends BasePage 
{

	LoginPage loginPage = new LoginPage(); 
	PIMPage pimPage=new PIMPage();
	
	@Test
    public void addEmployeeThenVerify() throws InterruptedException {
    
    	// initialize here

    	//CommonUtils.loginWithMultipleRecordsUsingExcel("MultipleLoginFunctionality");
		

    			// Login
    			loginPage.login();
    			//CommonUtils.hardWait(3);

	//validate welcome message
	
	TestngUtils.assertTrue(CommonUtils.getElementText(loginPage.getWelcomeText()),"Welcome playwright");
	
	
	 System.out.println("Login Successful");
	 
	 CommonUtils.moveToElement(pimPage.getPim());
	 
Thread.sleep(5000);
     //click on add employee

	 CommonUtils.clickElement(pimPage.getAddEmp());
	 Thread.sleep(5000);	

	 
	 //identify  the frame
	 
	 FrameLocator pimframe=CommonUtils.switchToFrameByUsingIdorName(pimPage.getFrame());
	 
	 CommonUtils.enterValue(pimframe,pimPage.getFirstName(),"ram" );
	 
	 Thread.sleep(5000);	

	 
	 CommonUtils.enterValue(pimframe,pimPage.getLastName(),"Dsu" );
	 
	 String filepath="D:\\FedEX KT.txt)";
	 
	 //Upload a photo or file
	 
	 CommonUtils.uploadFile(pimframe,pimPage.getBrowse(),filepath);
	 
	 
	 CommonUtils.clickElement(pimframe,pimPage.getSaveButton());

	 
	 System.out.println("saved Successfully");
	 
	 CommonUtils.clickElement(pimframe,pimPage.getEdit());

	 pimPage.getCheckSmoker();
 
	 CommonUtils.isElementChecked(pimframe,pimPage.getCheckSmoker());
	 
	 CommonUtils.clickElement(pimframe,pimPage.getSave());

	 
	 
	 CommonUtils.clickElement(pimframe,pimPage.clickBackButton());
	 Thread.sleep(5000);	

	 CommonUtils.selectDropdownValue(pimframe,pimPage.getSearchByDropdown(),"Emp. First Name");
	 
	 System.out.println("Employee information dropdown selected Successfully");

	 CommonUtils.enterValue(pimframe,pimPage.getSearchFor(),"ram" );
	 
	 CommonUtils.clickElement(pimframe,pimPage.getSearchButton());
	 
	 //verify the frame text
		TestngUtils.assertTrue(CommonUtils.getElementText(pimframe,pimPage.getEmpNameVerify()),"ram Dsu");
		
		

	}
}
