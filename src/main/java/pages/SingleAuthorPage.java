package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SingleAuthorPage{
	public WebDriver driver;
	public WebElement drama, biography,cookbooks;
	
	public By singleAuthorLink= By.linkText("https://keybooks.ro/team/margaret-robins/");
	
	
	public SingleAuthorPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public By drama_locator= By.cssSelector("div[class*='first inited']>div>div");
	public By biography_locator= By.cssSelector("div[class*='even inited']>div>div");
	public By cookbooks_locator= By.cssSelector("div[class*='even inited']>div>div");
	
	public void checkPercentage(String value, By locator) {
		//drama=driver.findElement(drama_locator);
		WebElement element=driver.findElement(locator);
		element.getText();
	}
}
