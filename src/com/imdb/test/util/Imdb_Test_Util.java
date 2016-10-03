package com.imdb.test.util;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.imdb.test.testcase.TestBase;

//function to fetch count of movie item displayed in top 250 page of IMDb
public class Imdb_Test_Util extends TestBase {
	
	public static int verify(WebDriver driver) throws Exception {
		
		List<WebElement> rows=driver.findElements(By.xpath(getPropData("Top250_Page_Result")));
		int result_num = rows.size();		
		return result_num;
	}
	
	//function to fetch all top movie genre links and clicking on Western link
	public static String Top_chart_genre_click(List<WebElement> Qlinks, String Genre_name){
		String act = null ;
		java.util.Iterator<WebElement> i = Qlinks.iterator();		
		while(i.hasNext()) {		    
			WebElement Genre_Qlink = i.next();		    
		    if(Genre_Qlink.getText().equalsIgnoreCase(Genre_name)){
			  Genre_Qlink.findElement(By.tagName("a")).click();			  
			   act = "link clicked" ;
			   }			
		}			
		return act ;
	}
	
	//Fetching count of movie item listed after Western genre link clicked 
	public static int verifyGenre(WebDriver driver) throws Exception {
				
		List<WebElement> Genre_row = driver.findElements(By.xpath(getPropData("Top_Genre_sort_Result")));
		int result_cnt = Genre_row.size();		
		return result_cnt;
	}		
	
}
