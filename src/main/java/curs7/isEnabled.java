package curs7;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class isEnabled extends BaseTest {
	
	@Test
	public void isEnabled() throws InterruptedException {
		WebElement loginPopuUp= driver.findElement(By.cssSelector("li[class='menu_user_login']"));
		System.out.println(loginPopuUp.isEnabled());
		
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('disabled','');",loginPopuUp); 
		
		System.out.println(loginPopuUp.isEnabled());
		loginPopuUp.click();
		
	    WebElement usernameField=driver.findElement(By.id("log"));
	    //usernameField.click();
	    System.out.println("username : " +usernameField.isEnabled() );
	    jse.executeScript("arguments[0].setAttribute('disabled','');",usernameField); 
	  
	    //comanda de mai jos cu sendKeys ar trebui sa dea eroare cu element not interactable
	    //  usernameField.sendKeys("TestUser");
	    System.out.println("username : " +usernameField.isEnabled() );
		Thread.sleep(3000);
		
		//loginPopuUp.click();
	}

}
