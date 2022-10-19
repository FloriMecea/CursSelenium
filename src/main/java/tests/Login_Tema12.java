package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import pages.ShipingAdressPage;
import utils.BaseTest;

public class Login_Tema12 extends BaseTest{
	@Test (priority=0)
	public void login() {
		NavMenuPage navMenu= new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		LoginPage loginPage= new LoginPage(driver);
		
		loginPage.loginInApp("TestUser", "12345@67890");
				
		//varianta1
		assertTrue(loginPage.loginSuccessMessageIsDisplayed());
		//varianta2
		assertTrue(loginPage.loginMessageIsDisplayed(loginPage.loginSuccessMessage));
	   // loginPage.logoutFromApp();
	}
	
	@Test(priority=1)
	public void changeCountry() {
		NavMenuPage navMenu= new NavMenuPage(driver);
		ShipingAdressPage shippingPage= new ShipingAdressPage(driver);
		
		driver.get("https://keybooks.ro/account/edit-address/shipping/");
		
		shippingPage.selectByIndex(41);
				
		assertEquals(shippingPage.getSelectedOption(shippingPage.country),"Canada");
		
		//le-am mutat in urmatoarea metoda
		
	//	shippingPage.selectByValue("NL");	
	//	assertEquals(shippingPage.getSelectedOption(shippingPage.province),"Newfoundland and Labrador");
	  
	}
	@Test(priority=2)
	public void changeProvince() {
		//NavMenuPage navMenu= new NavMenuPage(driver);
		ShipingAdressPage shippingPage= new ShipingAdressPage(driver);
	
	//	driver.get("https://keybooks.ro/account/edit-address/shipping/");
		
		shippingPage.selectByValue("NL");
		
		assertEquals(shippingPage.getSelectedOption(shippingPage.province),"Newfoundland and Labrador");
	  
	}
}
