package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavMenuPage {
	
	public WebDriver driver;
	
	public NavMenuPage(WebDriver driver) {
		this.driver= driver;
	}
	
	//locatori
	//driver.findElement(By.linkText("BOOKS"));
	public By shopLink= By.linkText("BOOKS");
	public By loginLink= By.linkText("Login");
	public By contactLink= By.linkText("CONTACTS");
	
	public void navigateTo(By locator) { //o metoda care o pot folosi pe urma sa o apelez 
		//pt mai multi locatori
		//adica in loc sa fac o metoda pentru fiecare locator, fac una singura
		driver.findElement(locator).click();
	}
	
	//ShopPage shopPage= new ShopPage(driver);
	public ShopPage navigateToShop() {
		//cele 2 de mai jos din DropDownTest au fost inlocuite cu driver.findElement(shopLink).click();
		//NavMenuPage navMenu= new NavMenuPage(driver);
	//	navMenu.navigateTo(navMenu.shopLink);
		driver.findElement(shopLink).click();
		
		//ShopPage shopPage= new ShopPage(driver);
		return new ShopPage(driver);
	}
}
