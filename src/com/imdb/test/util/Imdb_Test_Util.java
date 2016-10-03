package com.imdb.test.util;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Imdb_Test_Util {
	
	public static int verify(WebDriver driver) {
		List<WebElement> rows=driver.findElements(By.xpath("//div[@id='main']/div/span/div/div/div[3]/table/tbody/tr"));
		int result_num = rows.size();		
		return result_num;
	}
	

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
	
	public static int verifyGenre(WebDriver driver) {
		
		List<WebElement> Genre_row = driver.findElements(By.xpath("//div[@class='lister-item mode-advanced']"));		
		int result_cnt = Genre_row.size();		
		return result_cnt;
	}		
	
}
