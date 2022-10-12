package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import utils.BaseTest;
import utils.DataProviderClass;

public class DataProviderSearchBookTest extends BaseTest {

	@Test(dataProviderClass=DataProviderClass.class, dataProvider="bookNamesDataProvider")
	 public void searchBookTest(String book, String picture) throws InterruptedException {
		 NavMenuPage menu=new NavMenuPage(driver);
		 
	//	 Astea 3 le-am mutat in pageObjects- pe NavMenu am creat metoda searchBook
	//	menu.click(menu.searchIcon);
	//	menu.sendKeys(menu.searchField, book);
	//	menu.click(menu.searchIcon);
		
		menu.searchBook(book);
		
		Thread.sleep(3000);
		
		assertTrue(menu.isBookPictureDisplayed(picture));
	 }
}
