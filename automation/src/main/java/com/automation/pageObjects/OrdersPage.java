package com.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.basefile.BasePage;

public class OrdersPage extends BasePage {





	WebDriver driver;

	public OrdersPage(WebDriver driver)
	{
		super(driver);

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

    //===========================
	//  ORDER PAGE - ELEMENTS
	//===========================
	String firstOrderId = "(//tr[@class = 'ng-star-inserted']/th) [1]";
	String viewFirstOrder = "(//button[contains(text(),'View')])[1]";
	String deleteFirstOrder = "(//button[contains(text(),'Delete')])[1]";
	String gotoShop = "//button[contains(text(),'Go Back to Shop')]";
	String gotoCart = "//button[contains(text(),'Go Back to Cart')]";
	String viewOrderBtn = "//div[@class = 'btn -teal']";
	String orderCount = "//tr[@class = 'ng-star-inserted']/th)";
	
	
	
	
	
	//===========================
	//  ORDER PAGE - METHORDS
	//===========================

	public String getOrderId()
	{
	 	return (getTextByXpath(firstOrderId));
	}
	
	public OrdersPage viewOrder()
	{
		clickByXpath(viewFirstOrder);
		return this;
	}
	
	public OrdersPage deleteOrder()
	{
		clickByXpath(deleteFirstOrder);
		return this;
	}
	
	public OrdersPage gotoShop()
	{
		clickByXpath(gotoShop);
		return this;
	}
	
	public OrdersPage gotoCartPage()
	{
		clickByXpath(gotoCart);
		return this;
	}
	
	public OrdersPage clickViewOrder()
	{
		clickByXpath(viewOrderBtn);
		return this;
	}
	
	public int getOrdersCount()
	{
	 	return (getElementsCount(orderCount));
	}
	
}
