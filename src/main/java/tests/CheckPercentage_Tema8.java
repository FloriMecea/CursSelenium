package tests;

import pages.NavMenuPage;
import pages.SingleAuthorPage;
import utils.BaseTest;

public class CheckPercentage_Tema8 extends BaseTest {
	
	public void Test() {
		NavMenuPage navMenu= new NavMenuPage(driver);
		SingleAuthorPage pag=new SingleAuthorPage(driver);
		navMenu.navigateTo(pag.singleAuthorLink);
		
		
	}

	
	
}
