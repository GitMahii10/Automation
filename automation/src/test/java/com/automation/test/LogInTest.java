package com.automation.test;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
	  
	  public void VerifyValidLogIn() throws IOException { String email =
	  "testdata@mailinator.com"; String password = "MKO)(*nji9";
	  
	  String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();
	  
	  logger.info("Start of " + Methodname);
	  
	  
	  
	  loginPage = new LoginPage(driver);
	  
	  //loginPage.login(email, password).
	  
	  
	  
	  assertEquals("Login Successfully", loginPage.login(email,
	  password).getLogInMessage());
	  
	  logger.info("End of TEST METHOD " +Methodname + "is  PASS");
	  
	  
	  }
	 

	
	 @Test
	public void VerifyEnterInvaildEmail() throws IOException {
		String email = "(te st*d)@.com";
		String password = "XDR%^&cft6";

		String Methodname = new Object() {
		}.getClass().getEnclosingMethod().getName();

		logger.info("Start of " + Methodname);

		loginPage = new LoginPage(driver);

		// loginPage.login(email, password).

	
		 
		 
		  assertEquals("*Enter Valid Email", loginPage.login(email,
		  password).emailInvalidMessage());
		
		logger.info("End of TEST METHOD " + Methodname + "is  PASS");
		
	}
	
	@Test
	
	public void verifyEnterInvaildPasswordspecialcaracter() {
		String email="testdata@mailinator.com";
		
		String password="@##$AAKASRIHAJalsdsd132424";
		String Methodname = new Object() {}.getClass().getEnclosingMethod().getName();
		
		logger.info("Start of " + Methodname);
		
		loginPage=new LoginPage(driver);
		
		assertEquals("*Password is required",loginPage.login(email,password).passwordInvalidMessage());
		
		logger.info("End of the TEST METHOD"+Methodname+"is PASS");
	
		
		}
	
@Test
	
	public void verifyEnterInvaildPassword() {
		String email="testdata@mailinator.com";
		
		String password="";
		String Methodname = new Object() {}.getClass().getEnclosingMethod().getName();
		
		logger.info("Start of " + Methodname);
		
		loginPage=new LoginPage(driver);
		
		assertEquals("*Password is required",loginPage.login(email,password).passwordInvalidMessage());
		
		logger.info("End of the TEST METHOD"+Methodname+"is PASS");
	
		
		}


@Test

public void verifyManitoryFieldsValidation() {
	String email="";
	
	String password="";
	String Methodname = new Object() {}.getClass().getEnclosingMethod().getName();
	
	logger.info("Start of " + Methodname);
	
	loginPage=new LoginPage(driver);
	loginPage.login(email,password);
	loginPage.emailMandatory ();
	loginPage.passwordMandatory ();
	
	loginPage  =new LoginPage(driver); 
	
	String eamil="*Email is required";
	String pasword="*Password is required";
	loginPage.emailMandatory ();
	loginPage.passwordMandatory();
	
	// verify with base file

	/*if( eamil.equals( passwordException) ) {
		assertTrue(true);
		
	}
	else {
		assertTrue(false);
		
	} */
	
	
	
	logger.info("End of the TEST METHOD"+Methodname+"is PASS");

	
	}
	//}
	
	

	/*
	  @Test
	 
	  public void VerifyRegistration() throws IOException { String firstName =
	  "NewFirstName"; String lastName = "NewlastName"; String mobileNo =
	  "9965265879"; String occupation = "Engineer"; String email =
	  "t41123237@mailinator.com"; String password = "MKO)(*nji9";
	  
	  String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();
	  logger.info("Start of " +Methodname);
	  
	  
	  //LoginPage loginPage = launchApp(); LoginPage loginPage = new
	  LoginPage(driver); RegistrationPage regPage = new RegistrationPage(driver);
	  
	  regPage.clickRegister(); regPage.addFirstName(firstName)
	  .addLastName(lastName) .addEmailId(email) .addPassword(password)
	  .addPhoneNo(mobileNo) .selectOccupation(occupation) .check18YearOld()
	  .chooseGender("Male") .submitRegistration();
	  
	  //System.out.println ( regPage.getMessage());
	  
	  
	  assertEquals("Account Created Successfully", regPage.confirmRegistration());
	  
	  logger.info("End of TEST METHOD " +Methodname + "is  PASS"); }
	  
	  
	  @Test public void registerwithExistingEmail() throws IOException { String
	  firstName = "NewFirstName"; String lastName = "NewlastName"; String mobileNo
	  = "9965265879"; String occupation = "Engineer"; String email =
	  "tetaataa1123@mailinator.com"; String password = "MKO)(*nji9";
	  
	  String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();
	  logger.info("Start of " +Methodname);
	  
	  
	  //LoginPage loginPage = launchApp(); RegistrationPage regPage = new
	  RegistrationPage(driver);
	  
	  regPage.clickRegister(); regPage.addFirstName(firstName)
	  .addLastName(lastName) .addEmailId(email) .addPassword(password)
	  .addPhoneNo(mobileNo) .selectOccupation(occupation) .check18YearOld()
	  .chooseGender("Male") .submitRegistration();
	  
	  
	  assertEquals("User already exisits with this Email Id!",
	  regPage.getMessage());
	  
	  logger.info("End of TEST METHOD " +Methodname + "is  PASS"); }
	 */
    public void verifynewemailid()
    {
    	
	String email="karpagavallidivya@malinator.com";

	String password="XDR%^&cft6dhgfud";
	String Methodname = new Object() {}.getClass().getEnclosingMethod().getName();
	
	logger.info("Start of " + Methodname);
	
	loginPage=new LoginPage(driver);
	
	// update as per latest base file
	assertEquals("*Password is required",loginPage.login(email,password));
	
	logger.info("End of the TEST METHOD"+Methodname+"is PASS");

	
	}
}
