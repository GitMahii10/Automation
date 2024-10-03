package com.automation.basefile;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage
{

	private WebDriver driver;

public BasePage(WebDriver driver) {

		this.driver = driver;
	//	PageFactory.initElements(driver, this);

	}



  //=====================================================
  //   EXPLICIT WAITS BASED ON WEBELEMENTS & BY CLASSES
  //=====================================================
 
   public void waitForWebElementToAppearBy(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}
   
   public void waitForWebElementsToAppearBy(List<WebElement> ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));

	}
	public void waitForWebElementToAppearBy(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void waitForWebElementToAppear(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	    wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public void waitForElementToAppearBy(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitbyDefault() throws InterruptedException
	{
		Thread.sleep(1000);
	}

	
	  //===================================
	  //   SELECT DROPDOWN - OPTIONS
	  //===================================
	
	public void selectbyVisbleText(WebElement ele, String text)
	{
		try {
		Select selObj =new Select(ele);
		selObj.selectByVisibleText(text);
	}
	catch (Exception e)
	{
		System.out.println (e);
		}
	}

	public void selectbyVisbleValue(WebElement ele, String value)
	{
		try {
		Select selObj =new Select(ele);
		selObj.selectByValue(value);
	}
	catch (Exception e)
	{
		System.out.println (e);
		}
	}

	public void selectbyIndex(WebElement ele, int index)
	{
		Select selObj =new Select(ele);
		selObj.selectByIndex(index);
	}

	/*public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	} */
	
	
	  //===================================
	  //   ELEMENTS HANDILED BY - ID
	  //===================================

	public void clickById(String id)
	{
		try {
			By ProductByid = By.id(id);
			waitForElementToAppearBy(ProductByid);
		    driver.findElement(By.id(id)).click();

		}
	catch (Exception e)
	{
		System.out.println (e);
		}
	}
	
	
	public void sendKeysById(String xpath,String value)
	{
		try {

		driver.findElement(By.id(xpath)).clear();
		driver.findElement(By.id(xpath)).sendKeys(value);
				}
		catch (Exception e)
		{
			System.out.println (e);
			}
		}
	
	
	  //===================================
	  //   ELEMENTS HANDILED BY - XPATH
	  //===================================
	
	
	public void clickByXpath(String xpath)
	{
		try {
			By ProductByxpath = By.xpath(xpath);
			waitForElementToAppearBy(ProductByxpath);
		driver.findElement(By.xpath(xpath)).click();

		}
	catch (Exception e)
	{
		System.out.println (e);
		}
	}

	public void sendKeysByXpath(String xpath,String value)
	{
		try {
		driver.findElement(By.xpath(xpath)).clear();
		driver.findElement(By.xpath(xpath)).sendKeys(value);

		}
		catch (Exception e)
		{
			System.out.println (e);
			}
		}

	

		public String getTextByXpath (String xpath)
		{
			By findBy = By.xpath(xpath);
			waitForWebElementToAppearBy(findBy);
			 String text = driver.findElement(findBy).getText();
			 return text;
		}
		
		public String getTextofElement(By findBy) 
		{
			
			waitForWebElementToAppearBy(findBy);
			
			//waitForWebElementToAppearBy(driver.findElement(findby));
			return (driver.findElement(findBy).getText());
		}
		
		public int getElementsCount(String xpath)
		{
			return ( driver.findElements(By.xpath(xpath)).size());
			
		}
		
		public Boolean isElementVisible(WebElement ele)
		{
			waitForWebElementToAppearBy(ele);
			return (ele.isDisplayed());
			
		}
		
		public Boolean isElementVisible(String xpath)
		{
			By findBy = By.xpath(xpath);
			waitForWebElementToAppearBy(findBy);
			return (driver.findElement(findBy).isDisplayed());
			
		}
		
		
		// Javascripts 
		public void scrollElement(WebElement ele)
		{
			
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);",ele);
		}




}






