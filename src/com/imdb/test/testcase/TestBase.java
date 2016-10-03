package com.imdb.test.testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	 WebDriver driver ;
	 static Properties prop;
	 
	 @BeforeSuite
	 public static void FileReader()throws Exception{
		 
		 prop=new Properties();		 
		 String Filepath=System.getProperty("user.dir")+"\\src\\Imdb_Testsuite_Property.properties";			
		 InputStream ObjIS = null;		
		 ObjIS=new FileInputStream(Filepath);			
		 prop.load(ObjIS);
	 }
	 
	 public static String getPropData(String ISData)throws Exception{
		 FileReader();
		 String OSdata = prop.getProperty(ISData);
		 return OSdata ;
	 }
	 @BeforeTest
	 public void setup()throws Exception{
		 
		//Opening of IMDb top chart page after launching google chrome browser 	
		System.setProperty("webdriver.chrome.driver", getPropData("driverpath"));					
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 driver.get(getPropData("url"));	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
	 
	@AfterTest
	 public void tearDown() {  
     
      driver.close();
      
		 }	
}
