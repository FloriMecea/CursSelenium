package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.NavMenuPage;
import utils.BaseTest;

public class tema19_JSE extends BaseTest {
	

	@Test
	public void example1_jse() throws InterruptedException  {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		NavMenuPage menu= new NavMenuPage(driver);
		
		menu.navigateTo(menu.blogLink);
		String javaScriptHover = "var objObject = document.createEvent('MouseEvents');" +
				 "objObject.initMouseEvent('mouseover',true);" +
				 "arguments[0].dispatchEvent(objObject);";
		jse.executeScript(javaScriptHover, menu.getElement(menu.blogLink));
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click()", menu.getElement(menu.postFormatLogtLink));
		
		assertEquals(jse.executeScript("return document.URL").toString(),"https://keybooks.ro/category/post-formats/");
		
		 WebElement gallery= driver.findElement(By.cssSelector("a[href*='gallery-format']"));
     	//nu se vede prea bine ca e acoperit de partea de sus
		 jse.executeScript("arguments[0].scrollIntoView();",gallery);
		 Thread.sleep(3000);
		 
		//Sau folosim Actions class move to element	
		//Actions action=new Actions(driver);
    	//	action.moveToElement(gallery).perform();
		//Thread.sleep(3000);
		
		jse.executeScript("arguments[0].click()", gallery);
		assertEquals(jse.executeScript("return document.URL").toString(),"https://keybooks.ro/2016/02/01/gallery-format/");
		
		WebElement gallery_comments= driver.findElement(By.cssSelector("h2[class*='comments']"));
		jse.executeScript("arguments[0].scrollIntoView();",gallery_comments);
		Thread.sleep(3000);
		
		//sendKeys in js 
		WebElement comment=driver.findElement(By.cssSelector("textarea[id='comment']"));
		jse.executeScript("arguments[0].value='Comment12'", comment);
		
		WebElement name=driver.findElement(By.cssSelector("input[name='author']"));
		jse.executeScript("arguments[0].value='Flori'", name);
		
		WebElement email=driver.findElement(By.cssSelector("input[name='email']"));
		jse.executeScript("arguments[0].value='florimecea@yahoo.com'", email);
		
		WebElement submit=driver.findElement(By.cssSelector("input[name='submit']"));
		Thread.sleep(3000);
		jse.executeScript("arguments[0].click()",submit);
		
		//alternativa pt is displayed
		//jse.executeScript("document.getElementsByClassName('post_title')[0].checkVisibility");
		
		Thread.sleep(3000);
		//alternativa pt getText
		String authorName=  jse.executeScript("return document.getElementsByClassName('comment_author')[0].innerHTML").toString();  
		
		WebElement submittedAuthorName=driver.findElement(By.cssSelector("span[class*='comment_author']"));
		
		System.out.println("JSE autor: " +authorName);	
		System.out.println("Autorul este: "+submittedAuthorName.getText());
		assertEquals(authorName, "Flori");
		assertEquals(submittedAuthorName.getText(), "Flori");
	}
		
}
