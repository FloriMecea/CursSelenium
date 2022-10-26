package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import pages.Tema13_Page;
import utils.BaseTest;

public class Tema13_Test extends BaseTest {
	
	
	@Test
	public void comparePrice() {
		NavMenuPage menu=new NavMenuPage(driver);
		menu.navigateTo(menu.shopLink);
		
		Tema13_Page pag= new Tema13_Page(driver);
		
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/");
		
		pag.selectPriceLowToHigh(pag.dropdown);
		
		assertEquals(pag.checkCurrentSelection(pag.dropdown),"Sort by price: low to high");
		pag.compare();
	}

}
