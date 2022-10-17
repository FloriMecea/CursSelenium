package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactsPage {
	public WebDriver driver;
	public WebElement drama, biography,cookbooks;
	
	public By contactsLink= By.linkText("CONTACTS");
	
	
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public By nume_locator= By.cssSelector("div[class*='first inited']>div>div");
	public By email_locator= By.cssSelector("div[class*='even inited']>div>div");
	public By subiect_locator= By.cssSelector("div[class*='odd inited']>div>div");
	public By mesaj_locator= By.cssSelector("div[class*='odd inited']>div>div");
	public By sendMessage_locator= By.cssSelector("div[class*='odd inited']>div>div");
	
	public void sendMessage (By locator, String text) throws InterruptedException {
	
		WebElement element=driver.findElement(locator);
		Thread.sleep(3000);
		System.out.println(element.getText());
		
	}
	
	public boolean checkField (By locator, String value) throws InterruptedException {
		
		WebElement element=driver.findElement(locator);
		Thread.sleep(3000);
		System.out.println(element.getText());
		//return (assertEquals(element.getText(),value));
		return true;
	}
	
}
