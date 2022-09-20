package curs4.Homework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ContactPageTema extends BaseTest {

    @Test
	public void ContactPage() throws InterruptedException {
		WebElement contactPage= driver.findElement(By.cssSelector("li[id*='72'] a[href*='contacts']"));
    	contactPage.click();
	
    	assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/contacts/");
    	
    	
    	//input[name='your-name']
    	WebElement name=driver.findElement(By.cssSelector("input[name='your-name']"));
    	name.sendKeys("Flori");
    	
    	//input[name='your-email']
    	WebElement email=driver.findElement(By.cssSelector("input[name='your-email']"));
    	email.sendKeys("flori@testkeybooks.ro");
    	
    	//input[name='your-s']
    	WebElement subject=driver.findElement(By.cssSelector("input[name='your-s']"));
    	subject.sendKeys("Nu pot cumpara cartea Forest");
    	
    	//textarea[name='your-message']
    	WebElement message=driver.findElement(By.cssSelector("textarea[name='your-message']"));
    	message.sendKeys("Buna ziua, am incercat de 2 zile sa cumpar cartea Forest, dar am mereu erori in pagina.Am nevoie de ajutor.");
    	
    	//input[value='Send Message']
    	WebElement sendMessageButton=driver.findElement(By.cssSelector("input[value='Send Message']"));
    	sendMessageButton.click();
    	
    
    	
    	//div[class*='response-output']
    	WebElement messageReceived=driver.findElement(By.cssSelector("div[class*='response-output']"));
    	
    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div[class*='response-output']"),"Thank you for your message. It has been sent."));
    	//Thread.sleep(2000);
    	
    	System.out.println("------");
    	System.out.println(messageReceived.getText());
    	assertTrue(messageReceived.getText().contains("Thank you for your message. It has been sent."));
    	//sau ca mai jos
    	assertEquals(messageReceived.getText(),"Thank you for your message. It has been sent.");
    	
	}
}
