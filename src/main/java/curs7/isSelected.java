package curs7;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class isSelected extends BaseTest{
	
	@Test
	public void isSelectedExample() throws InterruptedException {
		driver.findElement(By.cssSelector("li>a[href='#popup_login']")).click();
		
	//isSelected merge doar pe checkbox si radio button	
	WebElement rememberMe= driver.findElement(By.cssSelector("ul input[id='rememberme']"));
    System.out.println(rememberMe.isSelected());
    Thread.sleep(3000);
    rememberMe.click();
    System.out.println(rememberMe.isSelected());
    assertTrue(rememberMe.isSelected());
    
    
    //isSelected folosit pt username ne da valoarea false, desi este selectat, caci merge doar 
    //pe checkbox si radio button
    WebElement usernameField=driver.findElement(By.id("log"));
    usernameField.click();
    System.out.println("username : " +usernameField.isSelected() );
		
		//li>a[href="#popup_login"]
	}

	
	
}
