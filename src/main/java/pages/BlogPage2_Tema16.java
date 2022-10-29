package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BlogPage2_Tema16 {
	
	public WebDriver driver;
	public By portofolio2Link= By.cssSelector("a[href='https://keybooks.ro/category/portfolio-2-columns/']");
	public By portofolio= By.linkText("Portfolio");

	
	public BlogPage2_Tema16(WebDriver driver) {
		this.driver=driver;
	}
	
 
	public WebElement findElement(By locator) {
		   WebElement element=driver.findElement(locator);
		  return element;
			
	}
	public void addText(By locator, String message) {
		   WebElement element=driver.findElement(locator);
		   element.sendKeys(message);
			
	}
	 public void dragAndDrop(By locator, int x, int y) {
		   WebElement element= driver.findElement(locator);
		   Actions action= new Actions(driver);
		   
		   action.dragAndDropBy(element, x, y).perform();
	   }

}
