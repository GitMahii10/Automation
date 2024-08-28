package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.basefile.BasePage;

public class RegistrationPage extends BasePage{
	
	
WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
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
	
	public RegistrationPage addFirstName(String userName)
	{
		firstName.clear();
		firstName.sendKeys(userName);
		return this;
	}
	
	public RegistrationPage addLastName(String userLastName)
	{
		lastName.clear();
		lastName.sendKeys(userLastName);
		return this;
	}
	
	public RegistrationPage addEmailId(String email)
	{
		emailId.clear();
		emailId.sendKeys(email);
		return this;
	}
	
	public RegistrationPage addPhoneNo(String phoneNo)
	{
		phoneNumber.clear();
		phoneNumber.sendKeys(phoneNo);
		return this;
	}
	
	public RegistrationPage selectOccupation(String occu)
	{
		selectbyVisbleText(occupation, occu);
		return this;
	}
	
	public RegistrationPage chooseGender(String gender)
	{
		if (gender == "Male")
			checkBoxMale.click();
		else
			checkBoxFemale.click();
		
		return this;
	}
	
	public RegistrationPage addPassword(String password)
	{
		
		userPassword.sendKeys(password);
		confirmPassword.sendKeys(password);
		return this;
	}
	
	public RegistrationPage check18YearOld()
	{
		yearOld.click();
		return this;
	}
	
	public RegistrationPage clickRegister()
	{
		registerButton.click();
		return this;
	}
	
	public String confirmRegistration()
	{
		return (regMessage.getText());
	}
	
	
	
	
	
	
	

}
