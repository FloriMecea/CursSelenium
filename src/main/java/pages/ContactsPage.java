package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.SeleniumWrappers;

public class ContactsPage extends SeleniumWrappers {
	//public WebDriver driver;
	public WebElement drama, biography,cookbooks;
	
	public By contactsLink= By.linkText("CONTACTS");
	public By nameField= By.cssSelector("input[name='your-name']");
	public By emailField= By.cssSelector("input[name*='your-email']");
	public By SubjectField= By.cssSelector("input[name='your-s']");
	public By messageField= By.cssSelector("textarea[name='your-message']");
	public By sendMessageButton= By.cssSelector("input[value='Send Message']");
	public By emptyMessage= By.cssSelector("span[class*='not-valid']");
	
	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	public void pressSendButton(By locator) {
	   WebElement element=driver.findElement(locator);
	   element.click(); 
		
	}
	
	public void addText(By locator, String message) {
		   WebElement element=driver.findElement(locator);
		   element.sendKeys(message);
			
		}
	
	public String checkEmptyField(By locator) {
		   WebElement element=driver.findElement(locator);
		 return element.getText();
		
		}
	
	
}
