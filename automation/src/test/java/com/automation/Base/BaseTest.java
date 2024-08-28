package com.automation.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automation.pageObjects.LoginPage;

public class BaseTest
{

	static WebDriver driver;
	static String browserName ;
	static String applicationURL;
	static FileInputStream file;
	
	static Properties prop = new Properties ();
		
	
	@BeforeTest
	public static WebDriver initializeDriver() throws IOException {
		 
		file = new FileInputStream ((System.getProperty("user.dir"))+"\\src\\main\\java\\com\\automation\\basefile\\GlobalData.properties");
			
			
			prop.load(file);
			applicationURL = prop.getProperty("appURL");
			browserName = prop.getProperty("browser");
		
				
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
		return driver;
}
	
	public LoginPage launchApp() throws IOException {
		
		driver.get(applicationURL);
       LoginPage loginPage = new LoginPage(driver);
		return loginPage;
			
	}
	
	
	
	/*public LoginPage getLogInpage() throws IOException {
		
		driver = initializeDriver();
		launchApp();
		
		LoginPage login = new LoginPage(driver);
		
		return login;
	} */
	
	@AfterTest
	public void tearDown()
	{
		if (driver != null)
		{
			driver.quit();
				System.out.println("Driver is closed ");
		}
				else
				{
					System.out.println("the Driver is alreay null");
				}
	}
	
}
