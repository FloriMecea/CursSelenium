package utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import org.testng.annotations.Test;

public class SeleniumWrappers {
	
	public WebDriver driver;
	public SeleniumWrappers(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * Custom sendKeys method/Wraps selenium default SendKeys and enhance it 
	 * with clear() method before sending the text. 
	 * @param locator   -->used inside method to create an WebElement object
	 * @param value  --> String value to be used as what we want to set
	 */

	
	public void sendKeys(By locator, String value) {
		WebElement element=driver.findElement(locator);
		
		try {
			
			element.clear();
			element.sendKeys(value);
			
		} catch(Exception e) {
			System.out.println("Something went wrong!");
		}
		
	}
	
	
	public void click(By locator) {
		WebElement element=driver.findElement(locator);
      try {
    	   waitForElementToBeClickable(element);
			element.click();
			
		} catch(NoSuchElementException e) {
			System.out.println("Something went wrong!");
		} catch(StaleElementReferenceException e) {
			WebElement element2=driver.findElement(locator);
			element2.click();
		}
		
	}
	
   public void waitForElementToBeClickable(WebElement element) {
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
   
   public void dragAndDrop(By locator, int x, int y) {
	   WebElement element= driver.findElement(locator);
	   Actions action= new Actions(driver);
	   
	   action.dragAndDropBy(element, x, y).perform(); //vreau sa il mut pe orizontala sau verticala x, y
	   //sau se poate ca mai jos dar e o varianta lunga
     //  action.clickAndHold(element).moveByOffset(300, 0).release().build().perform();
   
	   //sendKeys si click exista si pe action, dar difera de sendKeys si click de pe WebElement
	 //  action.sendKeys(Keys.TAB).click().sendKeys(Keys.TAB).perform();
   }


   public void hoverElement(By locator) {	
	WebElement element = driver.findElement(locator);
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();	
  }

  public String readURL() {	
	return driver.getCurrentUrl();	
  }
  
  public WebElement getElement(By locator) {
	
	  WebElement element;

	  
	  try {
		  element=driver.findElement(locator) ;
		  return element;
	  } catch(Exception e) {
		  throw new TestException("Cannot find element on <getElement>");
	  }
	
  }

}