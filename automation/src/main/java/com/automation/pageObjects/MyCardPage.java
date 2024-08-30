package com.automation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
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
	List <WebElement> cartItems;

	@FindBy(xpath = "//button[contains(.,'Buy Now')]")
	WebElement buyNowButton;

	@FindBy(xpath = "//button[@class = 'btn btn-danger']")
	WebElement deleteItemButton;

	@FindBy(xpath = "//button[ contains (.,'Checkout')]")
	WebElement checkOutButton;
	
	By cartItemsByXpath = By.xpath("//div[@class= 'infoWrap']");

	



	




	//================================
    //     MYCART_PAGE - METHORDS
    //================================
	
	public MyCardPage gotoBuyNow()
	{
		if (getBasketCount() !=0)
		buyNowButton.click();
		return this;
	}
	public MyCardPage deleteItem()
	{
		if (getBasketCount() !=0)
		deleteItemButton.click();
		return this;
	}
	
	public int getBasketCount()
	{
		int count = cartItems.size();
		return count;
	} 
	
	/*public List<WebElement> getCart() {
		waitForElementToAppear(cartItemsByXpath);
		return cartItems;
	}

	public WebElement getProductByName(String productName)
	{
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}*/



}
