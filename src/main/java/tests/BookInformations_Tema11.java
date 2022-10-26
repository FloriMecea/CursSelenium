package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.BookPage;
import pages.NavMenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class BookInformations_Tema11 extends BaseTest{
	
	@Test(priority=0)
	public void goToBook() throws InterruptedException {
		NavMenuPage menu= new NavMenuPage(driver);
		BookPage pag=new BookPage(driver);
		//ShopPage shop= new ShopPage(driver);
		
	    menu.navigateTo(menu.shopLink);
		Thread.sleep(1000);
	    menu.navigateTo(pag.booksPage);
		Thread.sleep(2000);
		
		
	    assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/let-the-sun-shine/");
	//    assertTrue(pag.FindElement(pag.title).isDisplayed());
	//    assertTrue(pag.FindElement(pag.price).isDisplayed());
	//    assertTrue(pag.FindElement(pag.stars).isDisplayed());  //nu avem 
	}
	
	@Test(priority=1)
	public void checkTitleIsDisplayed() throws InterruptedException {
		BookPage pag=new BookPage(driver);
	
	    assertTrue(pag.findElement(pag.title).isDisplayed());

	}
	
	@Test(priority=2)
	public void checkPriceIsDisplayed() throws InterruptedException {
		BookPage pag=new BookPage(driver);
	  
	    assertTrue(pag.findElement(pag.price).isDisplayed());
	 
	}
	
	@Test(priority=3)
	public void checkStarsIsDisplayed() throws InterruptedException {
		BookPage pag=new BookPage(driver);
		    
	    assertTrue(pag.findElement(pag.stars).isDisplayed());  //nu avem 
	}
	@Test(priority=4)
	public void checkSearchIsDisplayed() throws InterruptedException {
		BookPage pag=new BookPage(driver);
		    
	    assertTrue(pag.findElement(pag.search).isDisplayed()); 
	}
	
	@Test(priority=5)
	public void checkShortDescriptionIsDisplayed() throws InterruptedException {
		BookPage pag=new BookPage(driver);
		    
	    assertTrue(pag.findElement(pag.shortDescription).isDisplayed());  
	}
	
	@Test(priority=6)
	public void checkLongDescriptionIsDisplayed() throws InterruptedException {
		BookPage pag=new BookPage(driver);
		    
	    assertTrue(pag.findElement(pag.longDescription).isDisplayed());  
	}
	
	@Test(priority=7)
	public void checkQuantityIsDisplayed() throws InterruptedException {
		BookPage pag=new BookPage(driver);
		    
	    assertTrue(pag.findElement(pag.quantity).isDisplayed());   
	}
	
	@Test(priority=8)
	public void checkAddToCartIsDisplayed() throws InterruptedException {
		BookPage pag=new BookPage(driver);
		    
	    assertTrue(pag.findElement(pag.addToCart).isDisplayed());   
	}
}
