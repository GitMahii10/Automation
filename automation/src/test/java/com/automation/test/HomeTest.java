package com.automation.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.base.ReTry;
import com.automation.pageObjects.HomePage;
import com.automation.pageObjects.LoginPage;
import com.automation.pageObjects.MyCardPage;
import com.automation.pageObjects.OrdersPage;
import com.automation.pageObjects.PaymentPage;




public class HomeTest extends BaseTest
{
	
	
	protected static Logger logger = LogManager.getLogger(HomeTest.class);
	
	
	
	@Test (priority = 3, dataProvider="getDataobj", retryAnalyzer = ReTry.class)
	
	public void verifyProducts(String prouctName, String email,String password) throws InterruptedException
	{
		
		
		String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();
		logger.info("Start of " +Methodname);
		
		logger.info("log error");
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		
		loginPage.login(email, password);
		
		homePage.addProductToCart(prouctName);
		assertEquals (1, homePage.getCartCount());
		
		logger.info("End of TEST METHOD " +Methodname + "is  PASS");
		
		//Assert.assertEquals(false, true);
		//homePage.addAllProductsToCart();
		//assertEquals (1, homePage.getCartCount());
		
	}
	
	@Test (priority = 1, dataProvider="getData", retryAnalyzer = ReTry.class)
	public void verifyProductswithJson(HashMap <String, String> input) throws InterruptedException {
		
		String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();
		logger.info("Start of " +Methodname);
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		
		//loginPage.login(input.get("email"), input.get("password"));
		
		assertEquals("Login Successfully", loginPage.login(input.get("email"), input.get("password")).getErrorMessage());
		
		homePage.addProductToCart(input.get("product"));
		assertEquals (1, homePage.getCartCount());
		
		//Assert.assertEquals(false, true);
		//homePage.addAllProductsToCart();
		//assertEquals (1, homePage.getCartCount());
		
		logger.info("End of TEST METHOD " +Methodname + "is  PASS");
		
	}
	
	@Test  (priority  = 2, dataProvider = "getDataNew")//, dependsOnMethods = "verifyProducts")
	public void completePayment(HashMap<String, String> map) throws InterruptedException {
		
		
		/*String prouctName = "ZARA COAT 3";
		String email = "testdata@mailinator.com";
		String password = "MKO)(*nji9";*/
		
		String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();
		logger.info("Start of " +Methodname);
		
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
		
		//System.out.println("Order is created succssfully");
		logger.info("End of TEST METHOD " +Methodname + "is  PASS");
		
		
		
	}

	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\com\\automation\\testData\\LogInCreds.json");
		return new Object[][]  {{data.get(0)}};//, {data.get(1) } };
		

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
		
		return new Object [] [] {{map1}};//, {map1}};
		
		
	}
	
}
