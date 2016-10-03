package com.imdb.test.pages;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.imdb.test.*;
import com.imdb.test.testcase.TestBase;


public class Imdb_Top_chart_Page extends TestBase {	

	//Getting Sort items elements of Top chart 250 page
	public static List<WebElement> Top_chart_sorting(WebDriver driver) throws Exception {
		
		WebElement sortlist_select = driver.findElement(By.xpath(getPropData("Top250_Page_Sort_list")));
		List<WebElement> slists = sortlist_select.findElements(By.tagName("option"));		
		return slists;
	}	
	
	//Getting quick links elements of top movie by genre
	public static List<WebElement> Top_chart_genre_select (WebDriver driver ) throws Exception {
		
		WebElement Genre_Qlink = driver.findElement(By.xpath(getPropData("Movie_Genre_Quicklinks")));
		List<WebElement> Genre_Qlinks = Genre_Qlink.findElements(By.tagName("li"));
		return Genre_Qlinks ;

	}	
	
    //Getting sorting options elements of Western genre 
	public static List<WebElement> Top_chart_genre_sorting (WebDriver driver) throws Exception {	
		
		WebElement sortlist_select = driver.findElement(By.xpath(getPropData("Top_Genre_Sort_list"))); 	
	   	List<WebElement> Genre_links = sortlist_select.findElements(By.tagName("a")); 	   	 	
	   	return Genre_links;   	
		
	}
	

}