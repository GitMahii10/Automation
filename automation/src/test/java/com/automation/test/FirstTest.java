package com.automation.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	static WebDriver driver;


	public static void main(String[] args){

		FirstTest firstTest = new FirstTest();
		WebDriverManager.chromedriver().setup();

		//Creating WebDriver instance
		 driver = new ChromeDriver();

	    //this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Navigate to web page
		driver.get("https://demoqa.com/login");


		//Maximizing window
		driver.manage().window().maximize();

		//Retrieving web page title
		String title = driver.getTitle();
		System.out.println("The page title is : " +title);

		//Locating web element

		String uname = "testuser";
		String password = "Password@123";


		firstTest.login(uname, password).tearDown();
		Boolean loginStatus = verifyUserLogIn(driver);


		System.out.println("The login is valid or Not " +loginStatus);


		firstTest.tearDown();



	}

	public  FirstTest login (String userName,String password)
	{

		WebElement uName = driver.findElement(By.xpath("//*[@id='userName']"));
		//WebElement uName1 = driver.findElement(By.id("userName"));
		WebElement pswd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));


		uName.clear();
		uName.sendKeys(userName);
		pswd.sendKeys(password);
		loginBtn.click();
		return this;

	}

	public static Boolean verifyUserLogIn (WebDriver driver)
	{
       try {

			//Locating web element
			WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[@id='submit']"));
			//Validating presence of element
			if(logoutBtn.isDisplayed()){

				//Performing action on web element
				logoutBtn.click();
				System.out.println("LogOut Successful!");

			}
			return true;
		}
		catch (Exception e) {
			System.out.println("Incorrect login....");

			return false;
		}



	}

	public FirstTest tearDown () {

		if (driver != null) {
			driver.quit();
		}
			System.out.println("Driver is closed ");
			return this;
	}

}