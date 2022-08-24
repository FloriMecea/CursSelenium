package curs2;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseTest;

public class WebElementExample  extends BaseTest{

	
	@Test
	public void login() throws InterruptedException {
		
		driver.findElement(By.className("menu_user_login")).click();
		Thread.sleep(3000);//bad practice
		System.out.println(driver.findElement(By.id("log")).isDisplayed()); //isDiplayed() --> verifica daca elementul este vizibil sau nu


		
	}
	
	
}
