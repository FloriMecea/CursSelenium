package pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumWrappers;

public class NavMenuPage extends SeleniumWrappers {
	
	//comentat la cursul de data provider
	//public WebDriver driver;
	
	public NavMenuPage(WebDriver driver) {
		//comentat la cursul de data provider
		//this.driver= driver;
		super(driver);
	}
	
	//locatori
	//driver.findElement(By.linkText("BOOKS"));
	public By shopLink= By.linkText("BOOKS");
	public By loginLink= By.linkText("Login");
	public By contactLink= By.linkText("CONTACTS");
	
	
	public By searchIcon=By.cssSelector("button[class*='search_submit']");
	public By searchField=By.cssSelector("input[class='search_field']");
	
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
	
	public void searchBook(String value) {
	   click(searchIcon);
	   sendKeys(searchField,value);
	   click(searchIcon);
	}
	
	public boolean isBookPictureDisplayed(String picture) {
     WebElement element =  driver.findElement(By.cssSelector("div[data-image*='"+picture+"']"));
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed(); 
	}
}
