package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.basefile.BasePage;



public class LoginPage extends BasePage {


   WebDriver driver;


	public LoginPage(WebDriver driver)
	{
		super(driver);

		//this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	//============================
    //     LOGIN_PAGE - ELEMENTS
    //============================

	@FindBy(id="userEmail")
	WebElement userEmail;

	@FindBy(id="userPassword")
	WebElement passwordEle;

	@FindBy(id="login")
	WebElement submit;

	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	@FindBy (xpath = "//form//div[contains(text(), '*Password is required')]'")
	WebElement passwordEException;

	@FindBy (xpath = "//form//div[contains(text(), '*Email is required')]")
	WebElement emailException;

	@FindBy	(xpath = "(//a [contains(text(), 'Register')])[1]")
	WebElement register;


	//=====================================
    //     REGISTRATION_PAGE - ELEMENTS
    //=====================================


	@FindBy(id="firstName")
	WebElement firstName;

	@FindBy(id="firstName")
	WebElement lastName;

	@FindBy(id="firstName")
	WebElement emailId;

	@FindBy(id="firstName")
	WebElement phoneNumber;

	@FindBy(xpath="//select [@formcontrolname = 'occupation']")
	WebElement occupation;

	@FindBy(xpath="//input[@value = 'Male']")
	WebElement checkBoxMale;

	@FindBy(xpath = "//div/label[contains(text(),'Gender')]/following-sibling::label/input[@value='Female']")
	WebElement checkBoxFemale;

	@FindBy(id="userPassword")
	WebElement userPassword;

	@FindBy(id="confirmPassword")
	WebElement confirmPassword;

	@FindBy(xpath="//input[@type = 'checkbox' and @formcontrolname = 'required']")
	WebElement yearOld;

	@FindBy(id="login")
	WebElement registerButton;

	@FindBy(xpath="//section//h1[@class = 'headcolor' ]")
	WebElement regMessage;

	@FindBy(xpath="//section//button[@class = 'btn btn-primary' ]")
	WebElement loginButton;



	//============================
	//      TEST METHODS
	//============================

	public LoginPage login(String email,String password)
	{

		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		//ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return this;

	}

	public String getErrorMessage()
	{

		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	public LoginPage clickRegister () {
		register.click();
		return this;
	}



}
