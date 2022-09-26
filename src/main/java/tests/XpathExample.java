package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample extends BaseTest {
	
	@Test(priority=1)
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
	
	@Test(priority=2)
	public void xpathExample2() {
		driver.findElement(By.xpath("//span[@class='user_name']")).click();
		
		
		
		// xpath
		// //a[contains(@href,'profile.php')]  -xpath
		//  //a[contains(text(),'Settings')]
		
		//- css
		//a[href*='profile.php'] 
	
		driver.findElement(By.xpath("//a[contains(text(),'Settings')]")).click();
		
		//a[contains(text(),'recent')]
		driver.findElement(By.xpath("//a[contains(text(),'recent')]")).click();
	
	  //	//th[contains(@class,'woocommerce-orders-table__header')]/span[contains(text(),'Order')]
	  // (//th[contains(@class,'woocommerce-orders-table__header')]/span)[2]	
	
	WebElement element=	driver.findElement(By.xpath("//th[contains(@class,'woocommerce-orders-table__header')]/span[contains(text(),'Order')]"));
	jse.executeScript("arguments[0].setAttribute('style','background:orange', 'border:4px solid red')", element);
	
	WebElement element_index=driver.findElement(By.xpath("(//th[contains(@class,'woocommerce-orders-table__header')]/span)[3]"));
	jse.executeScript("arguments[0].setAttribute('style','background:orange', 'border:4px solid red')", element_index);
	
	// //td[contains(@class,'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(),"1697")]
	WebElement order_number=driver.findElement(By.xpath("//td[contains(@class,'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(),\"1697\")]"));
	jse.executeScript("arguments[0].setAttribute('style','background:orange', 'border:4px solid red')", order_number);
	
	
	//Not  ->  //td[contains(@class,'woocommerce-orders-table__cell')][@data-title='Order']/a[not(contains(text(),"1697"))]
	//NOT
			WebElement orders = driver.findElement(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[not(contains(text(), '1697'))]"));
			
			jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red')", orders);
	
	order_number.click();
	assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/account/view-order/1697/");
	
	
	}

}
