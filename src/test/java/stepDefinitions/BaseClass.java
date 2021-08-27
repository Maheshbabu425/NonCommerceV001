package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.RandomStringUtils;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;


public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage acp;
	public SearchCustomerPage scp;
	
	// Created for generating random string for Unique email
	// Cucumber reports dependency need to add
	public static String randomstring()
	{
		String generatedString1= RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
	}
}
