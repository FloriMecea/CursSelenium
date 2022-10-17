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
	
	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	
}
