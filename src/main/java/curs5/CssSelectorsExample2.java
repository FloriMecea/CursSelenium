package curs5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectorsExample2 extends BaseTest{
	
	//@Test
	public void cssSelectorTest() throws InterruptedException {
		
		// * --->contains
		WebElement bookTitle= driver.findElement(By.cssSelector("h3[class*='sc_title_regular']"));
		
		
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')",bookTitle);

		Thread.sleep(3000);
		
		// ~ --->dc este nevoie de match word
		WebElement bookTitle2= driver.findElement(By.cssSelector("h3[class~='sc_title_regular']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:red; border:4px solid red;')",bookTitle2);

		
		//^  --> starts with
		WebElement bookTitle3= driver.findElement(By.cssSelector("a[href^='its']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:green; border:4px solid red;')",bookTitle3);

		//$  --> ends  with
		WebElement bookTitle4= driver.findElement(By.cssSelector("a[href$='garden']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:blue; border:4px solid red;')",bookTitle4);

		
	}

	@Test
	public void cssSelectorTest2() throws InterruptedException {
		
		// first-of-type
		WebElement menuEntry= driver.findElement(By.cssSelector("div[class='menu_main_wrap']>nav[class='menu_main_nav_area']>ul>li:first-of-type"));
		
		
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')",menuEntry);

		Thread.sleep(3000);
		
	
		
	}
}
