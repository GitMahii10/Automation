package com.automation.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.automation.Base.BaseTest;
import com.automation.pageObjects.LoginPage;
import com.automation.pageObjects.RegistrationPage;

public class LogInTest extends BaseTest{
	
	WebDriver driver;
	
	@Test
	public void VerifyLogIn() throws IOException
	{
		String email = "testdata@mailinator.com";
		String password = "MKO)(*nji9";
		
		LoginPage loginPage = launchApp();
		//String s = loginPage.login(email, password).getErrorMessage();
		
	//assert.assertTrue("waitForWebElementToAppear",	loginPage.login(email, password).getErrorMessage());
	//assert.assertTrue("Login Successfully",	(loginPage.login(email, password).getErrorMessage()));
	assertEquals("Login Successfully", loginPage.login(email, password).getErrorMessage());
		
	}

	private boolean assertTrue(String string, String errorMessage) {
		// TODO Auto-generated method stub
		return false;
	}
	@Test
	public void VerifyRegistration() throws IOException
	{
		String firstName = "NewFirstName";
		String lastName = "NewlastName";
		String mobileNo = "9965265879";
		String occupation = "Engineer";
		String email = "testdata123@mailinator.com";
		String password = "MKO)(*nji9";
		
		
		LoginPage loginPage = launchApp();
		RegistrationPage regPage = new RegistrationPage(driver);
		
				
		 regPage.addFirstName(firstName)
		   		.addLastName(lastName)
		   		.addEmailId(email)
		   		.addPassword(password)
		        .addPhoneNo(mobileNo)
		        .selectOccupation(occupation)
		        .check18YearOld()
		        .chooseGender("Male");
		 
		 
		 
		 assertEquals("Registration Successfully", loginPage.getErrorMessage());
	}

}
