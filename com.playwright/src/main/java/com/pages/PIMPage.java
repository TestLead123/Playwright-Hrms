package com.pages;

//import com.microsoft.playwright.Page;

public class PIMPage 

{
 
  //Locators non-static
  private String by_pim="//li[@id='pim']";
  private String by_addEmp="//*[@id='pim']/ul/li[2]/a/span";
  private String by_iframe="//iframe[@id='rightMenu']";
  private String by_firstname="//input[@id='txtEmpFirstName']";
  private String by_lastname="//input[@id='txtEmpLastName']";
  private String by_save="//input[@id='btnEdit']";
  private String by_backBtn="//input[@class='backbutton']";
  private String by_searchByDropdown="//select[@id='loc_code']";
  private String by_searchForEmp="//input[@id='loc_name']";
  private String by_SearchBtnFor="//*[@id='standardView']/div[2]/input[2]";
  private String by_EmpNameVerify="//a[contains(test(),'ram Dsu']";
  private String by_editButton="//input[@id='btnEditPers']";
  private String by_checkSmokerchekbox="//input[@id='chkSmokeFlag']";
  private String by_clickSaveBtn="//input[@id='btnEditPers']";
  private String by_browse="//input[@id='photofile']";
  
  public String getPim()
  {
	  return by_pim;
  }
  
  public String getAddEmp()
  {
	  return by_addEmp;
  }
  
  public String getFrame()
  {
	  return by_iframe;

  }
  
  public String getFirstName()
  {
	  return by_firstname;
  }
  
  public String getLastName()
  {
	  return by_lastname;
  }
  
  public String getSaveButton()
  {
	  return by_save;
  }
  
  public String clickBackButton()
  {
	  return by_backBtn;
  }
  
  public String getSearchByDropdown()
  {
	  return by_searchByDropdown;
  }
  
  public String getSearchFor()
  {
	  return by_searchForEmp;
  }
  
  public String getSearchButton()
  {
	  return by_SearchBtnFor;
  }
  public String getEmpNameVerify()
  {
	  return by_EmpNameVerify;
  }
  public String getEdit()
  {
	  return by_editButton;
  }
  
  public String getCheckSmoker()
  {
	  return by_checkSmokerchekbox;
  }
  public String getSave()
  {
	  return by_clickSaveBtn;
  }
  public String getBrowse()
  {
	  return by_browse;
  }
  
  
}
