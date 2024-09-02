package com.automation.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.Base.BaseTest;
import com.automation.pageObjects.HomePage;
import com.automation.pageObjects.LoginPage;
import com.automation.pageObjects.MyCardPage;
import com.automation.pageObjects.OrdersPage;
import com.automation.pageObjects.PaymentPage;

public class HomeTest extends BaseTest{
	
	@Test
	public void verifyProducts() throws InterruptedException {
		
		
		String prouctName = "ZARA COAT 3";
		String email = "testdata@mailinator.com";
		String password = "MKO)(*nji9";
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		
		loginPage.login(email, password);
		
		homePage.addProductToCart(prouctName);
		assertEquals (1, homePage.getCartCount());
		
		//Assert.assertEquals(false, true);
		//homePage.addAllProductsToCart();
		//assertEquals (1, homePage.getCartCount());
		
	}
	
	@Test
	public void completePayment() throws InterruptedException {
		
		String prouctName = "ZARA COAT 3";
		String email = "testdata@mailinator.com";
		String password = "MKO)(*nji9";
		
		
		String cardNo = "4242 4242 4242 4242";
		String name = "TEST";
		String CVV = "124";
		String country = "India";
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		MyCardPage cartPage = new MyCardPage(driver);
		PaymentPage paymentPage = new PaymentPage(driver);
		OrdersPage orderPage = new OrdersPage(driver);
		
		loginPage.login(email,password);
		
		homePage.addProductToCart(prouctName);
		homePage.gotoCartPage();
		cartPage.gotoBuyNow();
		
		paymentPage.completeOrder(cardNo,name,CVV,country);
		String Orderid = paymentPage.getOrderID();
		paymentPage.gotoOrderHistoryPage();
		
		
		
		
		Assert.assertEquals(Orderid, orderPage.getOrderId());
		
		System.out.println("Order is createdsuccssfully");
		
		
		
	}

}
