package com.automation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.basefile.BasePage;

public class HomePage extends BasePage{




WebDriver driver;

	public HomePage(WebDriver driver)
	{
		super(driver);

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}



	//============================
    //     HOME_PAGE - ELEMENTS
    //============================

	String text;

	@FindBy(xpath="//button[contains(text (), ' HOME ')]")
	WebElement homeButton;

	@FindBy(xpath="//div[@class='card-body']")
	List <WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	@FindBy (xpath ="//i [@class= 'fa fa-shopping-cart']/following-sibling::label")
	WebElement cartCount;

	@FindBy (xpath = "//button[@class = 'btn btn-custom']/i [@class= 'fa fa-shopping-cart']")
	WebElement cartpage;


	By productsBy = By.cssSelector(".mb-3");
	By ProductByXpath = By.xpath("//div[@class= 'card']/parent ::div");

	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By addToCartByXpath = By.xpath("//button[contains(.,'Add To Cart')]");

	By toastMessage = By.cssSelector("#toast-container");
	By toastMessageByXpath = By.xpath("//div[@id= 'toast-container']");


	public void dummy()
	{
		driver.findElement(productsBy).getText();
	}

	public List<WebElement> getProductList() {
		waitForElementToAppear(ProductByXpath);
		return products;
	}

	public WebElement getProductByName(String productName)
	{
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}


	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCartByXpath).click();
		waitForElementToAppear(toastMessageByXpath);
		waitForElementToDisappear(spinner);


	}

	public void addAllProductsToCart() throws InterruptedException
	{
		List <WebElement> products =getProductList();
		int prodCount = products.size();
		
		if (prodCount !=0) {
		for(WebElement prod:products)
		{
			prod.findElement(addToCartByXpath).click();
			waitForElementToDisappear(spinner);
		}}
		

		}
	public int getCartCount() {
		
		waitForWebElementToAppear(cartCount);
		
		int Count =  Integer.parseInt(cartCount.getText());
		//System.out.println("the Count is"+ cartCountis);
		return Count;
	}

	public void gotoCartPage()
	{
		cartpage.click();
	}







}
