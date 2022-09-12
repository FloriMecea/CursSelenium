package curs6;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class JSAlertsExample extends BaseTest{
	
	@Test(priority=0)
	public void simpleAlertExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		Thread.sleep(3000);
	  
		Alert alertJs=driver.switchTo().alert();
		alertJs.accept(); //da click e butonul ok sau confirm din alerta Js
		
		
		//sau asa dar nu e indicat:
		//driver.switchTo().alert().accept();
		
		WebElement result= driver.findElement(By.cssSelector("p[id='result']"));
		assertEquals(result.getText(), "You successfully clicked an alert");
		Thread.sleep(3000);
	}

	@Test(priority=1)
	public void confirmJsAlertExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick*='Confirm']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		
		WebElement result= driver.findElement(By.cssSelector("p[id='result']"));
		assertEquals(result.getText(), "You clicked: Cancel");
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)
	public void promptJsAlertExample() throws InterruptedException {
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().alert().sendKeys("Test");
		driver.switchTo().alert().accept();
		
		WebElement result= driver.findElement(By.cssSelector("p[id='result']"));
		assertEquals(result.getText(), "You entered: Test");
		Thread.sleep(3000);
		
	}
}
