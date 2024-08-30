package com.automation.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.Base.BaseTest;
import com.automation.pageObjects.HomePage;
import com.automation.pageObjects.LoginPage;

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

}
