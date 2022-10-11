package curs5.Homework;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;


public class ComandaCarteaStory extends BaseTest{
	
	@Test(priority=0)
	public void cautareCarte() throws InterruptedException {
		WebElement searchIcon= driver.findElement(By.cssSelector("button[class*='search']"));
		searchIcon.click();
		
		WebElement searchField= driver.findElement(By.cssSelector("input[class*='search']"));
		searchField.sendKeys("The story about me");
		Thread.sleep(1000);
		searchIcon.click();
		Thread.sleep(1000);
		
		
		WebElement loadMore= driver.findElement(By.cssSelector("span[class*='viewmore_text_1']"));
		loadMore.click();
		Thread.sleep(1000);
	
		
		WebElement book= driver.findElement(By.cssSelector("a[href*=\"the-story-about-me\"][class*='hover_icon']"));
		book.click();
		Thread.sleep(1000);
		
		
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-story-about-me/");
		
		WebElement addToCart= driver.findElement(By.cssSelector("button[class*='add_to_cart']"));
		addToCart.click();
		Thread.sleep(1000);
	
		
		
		WebElement alertaAdaugare= driver.findElement(By.cssSelector("div[role='alert']"));
		System.out.println(alertaAdaugare.getText());
	//    assertEquals(alertaAdaugare.getText(),("The story about me has been added to your cart."));
		Thread.sleep(1000);
	    
	    WebElement viewCart= driver.findElement(By.cssSelector("a[href*='cart'][tabindex='1']"));
	    viewCart.click();
	    Thread.sleep(1000);
	    assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/cart/");
	    	    		
	}
	
	@Test(priority=1)
	public void modificareCantitate() throws InterruptedException {
		
		//https://keybooks.ro/cart/
		WebElement adaugareCantitate= driver.findElement(By.cssSelector("input[id*='quantity']"));
		adaugareCantitate.clear();
		adaugareCantitate.sendKeys("2");
		
		WebElement salvareCantitate= driver.findElement(By.cssSelector("button[value='Update cart']"));
		salvareCantitate.click();
		
		WebElement alertaModificare= driver.findElement(By.cssSelector("div[role='alert']"));
		System.out.println(alertaModificare.getText());
	    assertEquals(alertaModificare.getText(),("Cart updated."));
	    
	    WebElement checkout= driver.findElement(By.cssSelector("a[class*='checkout']"));
	    checkout.click();
	    Thread.sleep(2000);
	    assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/checkout/");
	    
	    WebElement billing= driver.findElement(By.cssSelector("div[class*='billing']>h3"));
	    assertEquals(billing.getText(),"Billing details");
	    
	    WebElement additionalInformation= driver.findElement(By.cssSelector("div[class*='additional-fields']>h3"));
	    assertEquals(additionalInformation.getText(),"Additional information");
		
	}

}
