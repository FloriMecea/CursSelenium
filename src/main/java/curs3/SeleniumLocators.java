package curs3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class SeleniumLocators extends BaseTest {

	@Test(priority=0)
	public void tagNameLocator() {
		
		WebElement discoverText= driver.findElement(By.tagName("em"));
	    System.out.println(discoverText.getText());
	    assertEquals(discoverText.getText(),"Discover");
	    
	    
	    //XPATH
	  //a[contains(text(), "DISCOVER MORE BOOKS")]
	    //a[contains(text(), "DISCOVER MORE BOOKS")])[2]
	
	}
	
	@Test (priority=1)
	public void linkTextLocator() { //doar pe web elementele cu tagul "a"
		driver.findElement(By.linkText("BOOKS")).click();
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/");
	}
	
	
	@Test (priority=2)
	public void partiallinkTextLocator() {//doar pe web elementele cu tagul "a"
		driver.findElement(By.partialLinkText("Cooking")).click();
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/cooking-with-love/");
	}
	
	@Test (priority=3)
	public void classNameLocator() {
		WebElement price= driver.findElement(By.className("price"));
	  //assertTrue ne spune dc un element este ascuns in pagina sau nu
		assertTrue(price.isDisplayed());
		
		//modifica domul paginii din sesiunea ta curenta de browser, e bine sa nu fie folosit caci modifica aplicatia
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red')", price);
	
		assertTrue(price.getText().contains("20.55"));
	}
	
	@Test (priority=4)
	public void idLocator() {
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)"); //Y-jos,X-lateral
		driver.findElement(By.id("tab-title-reviews")).click();
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/cooking-with-love/");
	}
	
	@Test (priority=5)
	public void nameLocator() throws InterruptedException {
		driver.findElement(By.name("comment")).sendKeys("Commentul meu la aceasta carte");
		Thread.sleep(4000);
		
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/cooking-with-love/");
	}
}
