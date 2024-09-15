package com.automation.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pageObjects.LoginPage;
import com.automation.pageObjects.RegistrationPage;

public class LogInTest extends BaseTest

{

	protected static Logger logger = LoggerFactory.getLogger(LogInTest.class);
	
	@Test
	public void VerifyLogIn() throws IOException
	{
		String email = "testdata@mailinator.com";
		String password = "MKO)(*nji9";
		
		String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();
		logger.info("Start of " +Methodname);

		 loginPage = new LoginPage(driver);
		 
		 //loginPage.login(email, password).
		

	
	assertEquals("Login Successfully", loginPage.login(email, password).getErrorMessage());
	
	logger.info("End of TEST METHOD " +Methodname + "is  PASS");

	}

	
	
	@Test
	public void VerifyRegistration() throws IOException
	{
		String firstName = "NewFirstName";
		String lastName = "NewlastName";
		String mobileNo = "9965265879";
		String occupation = "Engineer";
		String email = "t41123237@mailinator.com";
		String password = "MKO)(*nji9";
		
		String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();
		logger.info("Start of " +Methodname);


		//LoginPage loginPage = launchApp();
		LoginPage loginPage = new LoginPage(driver);
		RegistrationPage regPage = new RegistrationPage(driver);

         regPage.clickRegister();
		 regPage.addFirstName(firstName)
		   		.addLastName(lastName)
		   		.addEmailId(email)
		   		.addPassword(password)
		        .addPhoneNo(mobileNo)
		        .selectOccupation(occupation)
		        .check18YearOld()
		        .chooseGender("Male")
		        .submitRegistration();
		 
		//System.out.println ( regPage.getMessage());


		 assertEquals("Account Created Successfully", regPage.confirmRegistration());
		 
		 logger.info("End of TEST METHOD " +Methodname + "is  PASS");
	}
	
	
	@Test
	public void registerwithExistingEmail() throws IOException
	{
		String firstName = "NewFirstName";
		String lastName = "NewlastName";
		String mobileNo = "9965265879";
		String occupation = "Engineer";
		String email = "tetaataa1123@mailinator.com";
		String password = "MKO)(*nji9";
		
		String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();
		logger.info("Start of " +Methodname);


		//LoginPage loginPage = launchApp();
		RegistrationPage regPage = new RegistrationPage(driver);

         regPage.clickRegister();
		 regPage.addFirstName(firstName)
		   		.addLastName(lastName)
		   		.addEmailId(email)
		   		.addPassword(password)
		        .addPhoneNo(mobileNo)
		        .selectOccupation(occupation)
		        .check18YearOld()
		        .chooseGender("Male")
		        .submitRegistration();
		 
		
		 assertEquals("User already exisits with this Email Id!", regPage.getMessage());
		 
		 logger.info("End of TEST METHOD " +Methodname + "is  PASS");
	}

}
