package com.automation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.automation.pageObjects.LoginPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest
{

	public static WebDriver driver;
	static String browserName ;
	static String applicationURL;
	static FileInputStream file;
    public	LoginPage loginPage;

	static Properties prop = new Properties ();


	//@BeforeTest
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
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();


		return driver;
}
   @BeforeMethod(alwaysRun=true)
	public LoginPage launchApp() throws IOException {

		initializeDriver();
		driver.get(applicationURL);
         loginPage = new LoginPage(driver);
         
         System.out.println(" Driver is initiated");
		return loginPage;

	}



	/*public LoginPage getLogInpage() throws IOException {

		driver = initializeDriver();
		launchApp();

		LoginPage login = new LoginPage(driver);

		return login;
	} */

	@AfterMethod(alwaysRun=true)
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
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	//{map, map}

	}
	public String takeScreenShot(String tcName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File desc = new File(System.getProperty("user.dir") + "//reports//" + tcName + ".png");
		FileUtils.copyFile(source, desc);
		//FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + tcName + ".png";
		
	}

}
