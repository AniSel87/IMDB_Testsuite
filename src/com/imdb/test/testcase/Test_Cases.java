package com.imdb.test.testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.imdb.test.pages.*;
import com.imdb.test.util.*;

public  class Test_Cases extends TestBase {
	
	@Test 
	public void TC_1() throws Exception {
				
		//verification of IMDb chart top 250 page returns at least 1 
		int TC1_result = Imdb_Test_Util.verify(driver);		
		Assert.assertTrue(TC1_result>0);		 
	}
			
	@Test 
	//check of IMDb chart top 250 page returns at least 1 for each sort option
		public void TC_2() throws Exception{		
		List<WebElement> slists = Imdb_Top_chart_Page.Top_chart_sorting(driver);					
		java.util.Iterator<WebElement> i = slists.iterator();		
		while(i.hasNext()) {			
		   WebElement slist = i.next();		    
		   // System.out.println(slist.getText());		   
		   	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		   
			Select select1 = new Select(driver.findElement(By.xpath("//select[@class='lister-sort-by']")));			
			select1.selectByVisibleText(slist.getText());	
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			int TC2_result = Imdb_Test_Util.verify(driver);			
			Assert.assertTrue(TC2_result>0);				
		}				
		
	}
	
	
	
	@Test
	public void TC_3() throws Exception{	
		
		//Navigating to Western genre and checking if atleast one movie is displayed
		
		List<WebElement> Genre_Qlinks = Imdb_Top_chart_Page.Top_chart_genre_select(driver);
		
		String Action = Imdb_Test_Util.Top_chart_genre_click(Genre_Qlinks, "Western");
		
		Assert.assertEquals("link clicked", Action);
			
		// checking if atleast one movie is displayed for each sorting option of Western genre			
		List<WebElement> Genre_slist = Imdb_Top_chart_Page.Top_chart_genre_sorting(driver);	
		for(int ia=1;ia<Genre_slist.size()+1;ia++){		
		String Sort_path = "//*[@id='main']/div/div/div[2]/a["+ia+"]" ;				
		WebElement sort_item = driver.findElement(By.xpath(Sort_path));		
		sort_item.click();		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		
		int TC3_result = Imdb_Test_Util.verifyGenre(driver);	
		
		Assert.assertTrue(TC3_result>0);
			}
			
		}		
	
	}
	

