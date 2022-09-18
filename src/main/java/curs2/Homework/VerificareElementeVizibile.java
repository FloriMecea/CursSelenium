package curs2.Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class VerificareElementeVizibile extends BaseTest {
	
	@Test
	public void verificare() throws InterruptedException {
		WebElement login_menu=driver.findElement(By.className("menu_user_login"));
		System.out.print("Login menu is vizible? Answer: ");
		System.out.println(login_menu.isDisplayed());
		SoftAssert sa =  new SoftAssert();
	    sa.assertTrue(login_menu.isDisplayed());

		
		System.out.print("Login or Email field is vizible? Answer: ");
		System.out.println(driver.findElement(By.id("log")).isDisplayed());
		sa.assertFalse(driver.findElement(By.id("log")).isDisplayed());
		
		System.out.print("Password field is vizible? Answer: ");
		System.out.println(driver.findElement(By.id("password")).isDisplayed());
		sa.assertFalse(driver.findElement(By.id("log")).isDisplayed());
		
		login_menu.click();
		System.out.println("Login popup opened");
		Thread.sleep(2000);
		
		System.out.print("Login or Email field is vizible? Answer: ");
		System.out.println(driver.findElement(By.id("log")).isDisplayed());
	    sa.assertTrue(driver.findElement(By.id("log")).isDisplayed());
		
		System.out.print("Password field is vizible? Answer: ");
		System.out.println(driver.findElement(By.id("password")).isDisplayed());
	    sa.assertTrue(driver.findElement(By.id("password")).isDisplayed());
		sa.assertAll();

		
	}

}
