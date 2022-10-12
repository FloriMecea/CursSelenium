package curs6.Homework;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ReviewBook extends BaseTest{
	
	@Test(priority=0)
	public void cautareCarte() throws InterruptedException {
		WebElement book= driver.findElement(By.cssSelector("a[href='storm']"));
		book.click();
		Thread.sleep(1000);
				
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/storm/");
		
		WebElement reviewTab= driver.findElement(By.cssSelector("a[href='#tab-reviews']"));
		reviewTab.click();
		Thread.sleep(1000);
		
		WebElement submitButton= driver.findElement(By.cssSelector("input[id='submit']"));
		submitButton.click();
		Thread.sleep(1000);
		
		Alert alertJs=driver.switchTo().alert();
		alertJs.accept(); 
		Thread.sleep(1000);
		
		WebElement stars= driver.findElement(By.cssSelector("a[class*='star']:nth-of-type(4)"));
		stars.click();
		Thread.sleep(1000);
		
		WebElement message= driver.findElement(By.cssSelector("textarea[id='comment']"));
		message.sendKeys("Mi-a placut mult cartea aceasta, o recomand!!");
		Thread.sleep(1000);
		
		WebElement name= driver.findElement(By.cssSelector("input[id='author']"));
		name.sendKeys("Flori");
		Thread.sleep(1000);
		
		WebElement email= driver.findElement(By.cssSelector("input[id='email']"));
		email.sendKeys("florimecea@yahoo.com");
		Thread.sleep(1000);
		
		WebElement checkbox= driver.findElement(By.cssSelector("input[value='yes']"));
		checkbox.click();
		Thread.sleep(1000);
		
		submitButton.click();
		Thread.sleep(1000);
		
		WebElement submitted_review_message= driver.findElement(By.cssSelector("em[class*='awaiting-approval']"));
		assertEquals(submitted_review_message.getText(),"Your review is awaiting approval");
		
    }
}

