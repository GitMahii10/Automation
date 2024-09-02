package com.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.basefile.BasePage;

public class PaymentPage extends BasePage {


	WebDriver driver;

	public PaymentPage(WebDriver driver)
	{
		super(driver);

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	String cardNumber = "//div[contains (.,'Credit Card Number')]/input";
	String CVV        = "//div[contains (.,'CVV Code')]/input";
	String name       = "//div[contains (.,'Name on Card ')]/input";
	String countryname= "//input [@placeHolder='Select Country']";
	//String selectCountry = "//section/button//span[contains(.,' India')]";
	String placeOrder ="//a[contains(.,'Place Order ')]";
	String successMSG = "//table//h1[@class = 'hero-primary']";
	String orderHistory = "//label[contains(.,'Orders History Page ')]";
	String orderId     = "//label[@class = 'ng-star-inserted']";


	public void addCardNo (String cardValuer)
	{
		sendKeysByXpath (cardNumber, cardValuer);
	}

	public void addCVV (String CVV_Valuer)
	{
		sendKeysByXpath (CVV, CVV_Valuer);
	}

	public void addName (String nameValue)
	{
		sendKeysByXpath (name, nameValue);
	}

	public void chooseCountry (String countryName)
	{
		sendKeysByXpath (countryname, countryName);
		clickByXpath (countryname);
		clickByXpath ("//section/button//span[contains(.,' "+ countryName+"')]");

	}

	public void placeOrder ()
	{
		
		scrollElement(driver.findElement(By.xpath( placeOrder)));
		clickByXpath (placeOrder);
		System.out.println("place Order clicked");
	}

	public void completeOrder (String cardName, String name, String cvv, String country)
	{

		addCardNo (cardName);
		addCVV(cvv);
		addName(name);
		chooseCountry(country);
		placeOrder();
	}
	public String getSuccessMsg ()
	{
		return getTextByXpath(successMSG);
	} 
	
	public String getOrderID()
	{
		return getTextByXpath(orderId);
	} 

	
	public void  gotoOrderHistoryPage ()
	{
		clickByXpath(orderHistory);
	} 



}
