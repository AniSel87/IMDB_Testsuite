package com.imdb.test.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Imdb_Top_chart_Page {
	

	
	public static List<WebElement> Top_chart_sorting(WebDriver driver) {
		
		WebElement sortlist_select = driver.findElement(By.xpath("//select[@class='lister-sort-by']"));
		List<WebElement> slists = sortlist_select.findElements(By.tagName("option"));		
		return slists;
	}	
	
	public static List<WebElement> Top_chart_genre_select (WebDriver driver ) {
		
		WebElement Genre_Qlink = driver.findElement(By.xpath("//*[@id='sidebar']/div[6]/span/ul"));
		List<WebElement> Genre_Qlinks = Genre_Qlink.findElements(By.tagName("li"));
		return Genre_Qlinks ;

	}	
	

	public static List<WebElement> Top_chart_genre_sorting (WebDriver driver) {	
		
		WebElement sortlist_select = driver.findElement(By.xpath("//*[@id='main']/div/div/div[2]")); 	
	   	List<WebElement> Genre_links = sortlist_select.findElements(By.tagName("a")); 	   	 	
	   	return Genre_links;   	
		
	}
	

}