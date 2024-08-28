package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.basefile.BasePage;

public class MyCardPage extends BasePage {
	
	
	
WebDriver driver;
	
	public MyCardPage(WebDriver driver)
	{
		super(driver);
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//================================
    //     MYCART_PAGE - ELEMENTS
    //================================
	
	@FindBy(xpath = "//div[@class= 'infoWrap']")
	WebElement cartItems;
	
	@FindBy(xpath = "//button[contains(.,'Buy Now')]")
	WebElement buyNowButton;
	
	@FindBy(xpath = "//button[@class = 'btn btn-danger']")
	WebElement deleteItemButton;
	
	@FindBy(xpath = "//button[ contains (.,'Checkout')]")
	WebElement checkOutButton;
	
	
	
	
	
	
	//================================
    //     MYCART_PAGE - METHORDS
    //================================

}
