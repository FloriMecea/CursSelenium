package curs8;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FluentWaitExample extends BaseTest{

	@Test
	public void testWait() {
         driver.findElement(By.cssSelector("div[id='start']>button")).click();
         
         WebElement finish =driver.findElement(By.cssSelector("div[id='finish']"));
 	//	assertEquals(finish.getText(), "Hello World!");
           
         FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        		 .withTimeout(Duration.ofSeconds(10))
        		 .pollingEvery(Duration.ofMillis(100))
        		 .ignoring(NoSuchElementException.class);
        
         wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("finish") , "Hellow World!"));	 
        		 
         
  	//	WebElement finish =driver.findElement(By.cssSelector("div[id='finish']>h4"));
		//assertEquals(finish.getText(), "Hello World!");
		
	}
}
