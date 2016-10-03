package com.imdb.test.testcase;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {	
	
	 WebDriver driver ;
	
	 @BeforeTest
	 public void setup(){
	
		System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Rajendra\\Desktop\\Guru99\\Day03\\selenium-2.40.0\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://www.imdb.com/chart/top");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}	
	
	
	@AfterTest
	 public void tearDown() {
       driver.quit();
   }
	

}
