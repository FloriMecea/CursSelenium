package curs8;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ExplicitWaitExample extends BaseTest {

	@Test
	public void testWait() {
        driver.findElement(By.cssSelector("div[id='start']>button")).click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        //sau ca mai jos
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("finish"), "Hello World!"));
       
		WebElement finish =driver.findElement(By.cssSelector("div[id='finish']>h4"));
		assertEquals(finish.getText(), "Hello World!");
		
	}
	
}
