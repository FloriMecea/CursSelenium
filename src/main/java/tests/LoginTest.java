package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;





import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

	@Parameters({"user","pass"})
	@Test(priority=0, groups="LoginFunctionality")
	public void loginTest(String username, String password) throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		//loginPage.loginInApp(username, password)
		//assert
		
		LoginPage loginPage= new LoginPage(driver);
		
		//loginPage.loginInApp("TestUser", "12345@67890");
		loginPage.loginInApp(username, password);
		
		//varianta1
		assertTrue(loginPage.loginSuccessMessageIsDisplayed());
		//varianta2
		assertTrue(loginPage.loginMessageIsDisplayed(loginPage.loginSuccessMessage));
	    loginPage.logoutFromApp();
	}
	
	@Parameters({"invalidUser","invalidPass"})
	@Test(priority=1)
	public void invalidLoginTest(String username, String password) throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		//loginPage.loginInApp(username, password)
		//assert
		
		LoginPage loginPage= new LoginPage(driver);
		
		//loginPage.loginInApp("TestCeva", "12345@67890");
		loginPage.loginInApp(username, password);
		
		//varianta1
	  assertTrue(loginPage.loginErrorMessageIsDisplayed());
		//varianta2
		assertTrue(loginPage.loginMessageIsDisplayed(loginPage.loginErrorMessage));
	   
	}
}
