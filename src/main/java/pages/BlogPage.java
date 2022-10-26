package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage {
	
	public WebDriver driver;
	public By blogClassicElement= By.xpath("//a[contains(text(),'Classic')]");
	public By book= By.xpath("//h4//a[contains(text(),'The Best Poetry Books of All Time')]");
	
	public By comment= By.xpath("//textarea[@id='comment']");
	public By name= By.xpath("//input[@id='author']");
	public By email= By.xpath("//input[@id='email']");
	public By website= By.xpath("//input[@id='url']");
	public By checkbox= By.xpath("//input[contains(@id,'wp-comment')]");
	public By sendComment= By.xpath("//input[@id='send_comment']");
	public By message= By.xpath("//div[contains(text(),'Your comment is awaiting moderation.')]");
	
	
	public BlogPage(WebDriver driver) {
		this.driver=driver;
	}
	
   public void hoverBlog() throws InterruptedException {
		   NavMenuPage menu= new NavMenuPage(driver);
		   menu.hoverElement(menu.blogLink);
		   Thread.sleep(1000);
		  
   }
	
	public WebElement FindElement(By locator) {
		   WebElement element=driver.findElement(locator);
		  return element;
			
	}
	/* o alta modalitate de a scrie FindElement
	public WebElement FindElement(By locator) {
        return driver.findElement(locator);          
} */

	public void addText(By locator, String message) {
		   WebElement element=driver.findElement(locator);
		   element.sendKeys(message);
			
	}
}
