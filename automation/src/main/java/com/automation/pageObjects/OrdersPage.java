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


	String orderId = "(//tr[@class = 'ng-star-inserted']/th) [1]";
	String viewOrder = "";
	String deleteOrder = "";
	String gotoShop = "//button[contains(text(),'Go Back to Shop')]";
	String gotoCart = "//button[contains(text(),'Go Back to Cart')]";
	
	
	

}
