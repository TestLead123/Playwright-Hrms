package com.util;

import org.testng.Assert;

public class TestngUtils {

	public static void assertFail(String message) 
	
	{
		// TODO Auto-generated method stub
			}

	public static void assertFail1(String message) 
	{
		// TODO Auto-generated method stub
		
			}
	
	//This method check the actual string contains the expected string
	
	public static void assertTrue(String actual,String expected)
	{
		if(actual.equalsIgnoreCase(expected))
		{
			Assert.assertTrue(expected.contains(actual));
		}
		else
		{
			Assert.fail(expected + "not present in" +actual);
		}
				}
	
	
	
	}
