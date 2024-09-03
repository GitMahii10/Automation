package com.automation.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pageObjects.LoginPage;
import com.automation.pageObjects.RegistrationPage;

public class LogInTest extends BaseTest{

	
	@Test
	public void VerifyLogIn() throws IOException
	{
		String email = "testdata@mailinator.com";
		String password = "MKO)(*nji9";

		 loginPage = new LoginPage(driver);
		 
		 //loginPage.login(email, password).
		

	
	assertEquals("Login Successfully", loginPage.login(email, password).getErrorMessage());

	}

	
	
	@Test
	public void VerifyRegistration() throws IOException
	{
		String firstName = "NewFirstName";
		String lastName = "NewlastName";
		String mobileNo = "9965265879";
		String occupation = "Engineer";
		String email = "tetaaaa35411237@mailinator.com";
		String password = "MKO)(*nji9";


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
		 
		System.out.println ( regPage.getMessage());


		 assertEquals("Account Created Successfully", regPage.confirmRegistration());
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
		 
		
		 assertEquals("User already exiIsits with this Email Id!", regPage.getMessage());
	}

}
