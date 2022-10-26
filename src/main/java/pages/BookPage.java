package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookPage {
	public WebDriver driver;
	public By booksPage= By.xpath("//a[contains(@href,'let-the-sun-shine') and contains(text(),'Let the sun shine')]");
	
	public By title= By.xpath("//h1[contains(@class,'entry-title')]");
	public By stars= By.xpath("//p[@class='stars']");
	public By price= By.xpath("//p[contains(@class,'price')]");
	public By search= By.xpath("//a[contains(@class,'trigger')]");
	public By shortDescription= By.xpath("//div[contains(@class,'short-description')]");
	public By longDescription= By.xpath("//div[contains(@class,'product_meta')]");
	public By quantity= By.xpath("//input[contains(@id,'quantity')]");
	public By addToCart= By.xpath("//button[contains(@name,'add-to-cart')]");
	
	
	
	public BookPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement findElement(By locator) {
		   WebElement element=driver.findElement(locator);
		  return element;
			
	}
}
