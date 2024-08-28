package com.automation.basefile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
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
	
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	    wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public void waitbyDefault() throws InterruptedException
	{
		Thread.sleep(1000);		
	}
	
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

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForElementToAppearBy(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
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
		
		public String getTextByXpath (String xpath)
		{
			 String text = driver.findElement(By.xpath(xpath)).getText();
			 return text;
		}
	

}
	





