package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample extends BaseTest {
	
	@Test
	public void xpathExample() {
		WebElement login= driver.findElement(By.xpath("//li[@class='menu_user_login']"));
 
		jse.executeScript("arguments[0].setAttribute('style','background:orange', 'border:4px solid red')", login);
		login.click();
		
		
		//  //input[@id='log' or @name="log"]  -or din xpath
		//input[id='log'],[name='log']   Or din css
		//input[id='log'][name='log']    AND din css
		
		WebElement userField= driver.findElement(By.xpath("//input[@id='log' or @name='log']"));
		jse.executeScript("arguments[0].setAttribute('style','background:orange', 'border:4px solid red')", userField);
		userField.sendKeys("TestUser");
		
		
		WebElement password= driver.findElement(By.xpath("//input[@id='password' and @name='pwd']"));
		jse.executeScript("arguments[0].setAttribute('style','background:orange', 'border:4px solid red')", password);
		password.sendKeys("12345@67890");
		
		WebElement loginButton= driver.findElement(By.xpath("//input[@class='submit_button']"));
		jse.executeScript("arguments[0].setAttribute('style','background:orange', 'border:4px solid red')", loginButton);
		loginButton.click();

		
	}

}
