package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.NavMenuPage;
import pages.SingleAuthorPage;
import utils.BaseTest;

public class CheckPercentage_Tema8 extends BaseTest {
	
	@Test
	public void check() throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		SingleAuthorPage pag=new SingleAuthorPage(driver);
		navMenu.navigateTo(pag.singleAuthorLink);
		Thread.sleep(2000);
		
		String drama_percentage= pag.returnPercentage(pag.drama_locator);
		String biography_percentage= pag.returnPercentage(pag.biography_locator);
		String cookbooks_percentage= pag.returnPercentage(pag.cookbooks_locator);
		assertEquals(drama_percentage, "95%");
		assertEquals(biography_percentage, "75%");
		assertEquals(cookbooks_percentage, "82%");
		
	}

	
	
}
