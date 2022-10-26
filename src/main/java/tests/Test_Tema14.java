package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class Test_Tema14 extends BaseTest {

	
	@DataProvider
	public Object[][] booksList(){
		Object[][] books= new Object[6][2];
		
		books[0][0]="a[href='the-forest']";
		books[0][1]=1;

		books[1][0]="a[href='the-son']";	
		books[1][1]=2;

		books[2][0]="a[href='life-in-the-garden']";
		books[2][1]=3;

		books[3][0]="a[href='the-long-road-to-the-deep-silence']";
		books[3][1]=4;

		books[4][0]="a[href='its-a-really-strange-story']";
		books[4][1]=5;

		books[5][0]="a[href='storm']";
		books[5][1]=6;
		
			
		return books;
	}
	
	@DataProvider
	public Object[][] booksList2(){
		Object[][] books= new Object[6][2];
		
        
        books[0][0]= "a[href='the-forest']";
        books[0][1]= "https://keybooks.ro/shop/the-forest/";

        books[1][0]="a[href='the-son']"; 
        books[1][1]= "https://keybooks.ro/shop/the-son/";

        books[2][0]= "a[href='life-in-the-garden']";
        books[2][1]= "https://keybooks.ro/shop/life-in-the-garden/";

        books[3][0]= "a[href='the-long-road-to-the-deep-silence']";
        books[3][1]= "https://keybooks.ro/shop/the-long-road-to-the-deep-silence/";

        books[4][0]= "a[href='its-a-really-strange-story']";
        books[4][1]= "https://keybooks.ro/shop/its-a-really-strange-story/";

        books[5][0]= "a[href='storm']";
        books[5][1]= "https://keybooks.ro/shop/storm/";
        
		return books;
	}
	
//	@Test (dataProvider="booksList")  //prima metoda dar mai greoaie
	public void bookTest(String bookCSS, int nr) throws InterruptedException {
		
		NavMenuPage navMenu= new NavMenuPage(driver);
		
		navMenu.navigateTo(navMenu.homeLink);	
		
		
		navMenu.navigateTo(By.cssSelector(bookCSS));
		Thread.sleep(3000);
		if(nr== 1) {
		  
		  assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-forest/");
		} 
		else if (nr==2) {
			
			assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-son/");
		}else if (nr==3) {
			assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/life-in-the-garden/");
		} else if(nr==4) {
			assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-long-road-to-the-deep-silence/");

		}else if (nr==5) {
				assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/its-a-really-strange-story/");
		} else if(nr==6) {
				assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/storm/");
	}
	
	}
	
	@Test (dataProvider="booksList2")  //a doua metoda care e mai simpla
	public void bookTest2(String bookCSS, String url) throws InterruptedException {
		
		NavMenuPage navMenu= new NavMenuPage(driver);	
		navMenu.navigateTo(navMenu.homeLink);		
		navMenu.navigateTo(By.cssSelector(bookCSS));
  
	    assertEquals(driver.getCurrentUrl(),url);
		
	}

}
