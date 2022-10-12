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
		
		String a= pag.returnPercentage(pag.drama_locator);
		String b= pag.returnPercentage(pag.biography_locator);
		String c= pag.returnPercentage(pag.cookbooks_locator);
		assertEquals(a, "95%");
		assertEquals(b, "75%");
		assertEquals(c, "82%");
		
	}

	
	
}
