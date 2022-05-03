package com.inetbanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.enetBanking.Utilities.ReadConfig;

public class BaseClass {
	
	//public String baseURL="https://demo.guru99.com/v4";
	//public String Username="mngr403014";
	//public String password="ubUgEjY";
	
	//Using Configuration file for data
	
	ReadConfig data= new ReadConfig();
	public String baseURL=data.getApplicationURL();
	public String Username=data.getUsername();
	public String password=data.getPassword();
	
	public static WebDriver driver;
	public static Logger logger; 
	
	@Parameters("browser")   //for Specific browser input
	
	@BeforeClass
	public void Setup(String br)
	{
		logger= logger.getLogger("InternetBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		//Launching Browser
		
		//Approach 1 Using Default Path
		//System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\chromedriver.exe"); 
		
		//Approach 2 By Using Eclipse Directory
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\eclipse-workspace\\InternetBanking\\Drivers\\chromedriver.exe");
		
		//Approach 3 Using Project Directory
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe"); 
		
		//Using ReadConfiguration File For Browser Launching
		//System.setProperty("webdriver.chrome.driver",data.getChromePath()); 
		//driver= new ChromeDriver();
		
		//Running Browser using TestNG.XML Input
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",data.getChromePath()); 
			driver= new ChromeDriver();
		}
		
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",data.getFirefoxPath()); 
			driver= new ChromeDriver();
		}
		
		if(br.equals("ie"))
		{
			System.setProperty("webdriver.chrome.driver",data.getIEPath()); 
			driver= new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void CaptureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
	
}
