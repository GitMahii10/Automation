package com.automation.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pageObjects.HomePage;
import com.automation.pageObjects.LoginPage;
import com.automation.pageObjects.MyCardPage;
import com.automation.pageObjects.OrdersPage;
import com.automation.pageObjects.PaymentPage;

public class HomeTest extends BaseTest{
	
	@Test (priority = 1, dataProvider="getData")
	public void verifyProducts(String prouctName, String email,String password) throws InterruptedException {
		
		
		
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		
		loginPage.login(email, password);
		
		homePage.addProductToCart(prouctName);
		assertEquals (1, homePage.getCartCount());
		
		//Assert.assertEquals(false, true);
		//homePage.addAllProductsToCart();
		//assertEquals (1, homePage.getCartCount());
		
	}
	
	@Test  (priority  = 1, dataProvider = "getDataNew")//, dependsOnMethods = "verifyProducts")
	public void completePayment(HashMap<String, String> map) throws InterruptedException {
		
		
		/*String prouctName = "ZARA COAT 3";
		String email = "testdata@mailinator.com";
		String password = "MKO)(*nji9";*/
		
		String cardNo = "4242 4242 4242 4242";
		String name = "TEST";
		String CVV = "124";
		String country = "India";
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		MyCardPage cartPage = new MyCardPage(driver);
		PaymentPage paymentPage = new PaymentPage(driver);
		OrdersPage orderPage = new OrdersPage(driver);
		
		loginPage.login(map.get("email"),map.get("password"));
		
		homePage.addProductToCart(map.get("product"));
		homePage.gotoCartPage();
		cartPage.gotoBuyNow();
		
		paymentPage.completeOrder(cardNo,name,CVV,country);
		String Orderid = paymentPage.getOrderID();
		String trimOrderid = Orderid.replaceAll("[^a-zA-Z0-9]","");
		
		paymentPage.gotoOrderHistoryPage();
		
		
		
		
		Assert.assertEquals(trimOrderid, orderPage.getOrderId());
		
		System.out.println("Order is created succssfully");
		
		
		
	}

	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//automation//testData//LogInCreds.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
		
	} 
	
	@DataProvider
	public Object[][] getDataobj() throws IOException
	{

		
		return new Object [] [] {{"ZARA COAT 3","testdata@mailinator.com", "MKO)(*nji9"}};
		
		
	}
	
	@DataProvider
	public  Object [] [] getDataNew()
	{
		
		HashMap<String, String> map  = new HashMap <String, String> ();
		map.put("email", "testdata@mailinator.com");
		map.put("password", "MKO)(*nji9");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String, String> map1  = new HashMap <String, String> ();
		map1.put("email", "testdata@mailinator.com");
		map1.put("password", "MKO)(*nji9");
		map1.put("product", "ZARA COAT 3");
		
		return new Object [] [] {{map1}, {map1}};
		
		
	}
	
}
