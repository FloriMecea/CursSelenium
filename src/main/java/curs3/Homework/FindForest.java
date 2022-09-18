package curs3.Homework;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class FindForest extends BaseTest{
	@Test
	public void checkForest() throws InterruptedException {
		List<WebElement> myList= new ArrayList<WebElement>();
		myList=driver.findElements(By.className("sc_tabs_title"));
		SoftAssert sa=new SoftAssert();
		
		for (WebElement element:  myList) {
			element.click();
			Thread.sleep(1000);
			sa.assertTrue(driver.findElement(By.linkText("The forest")).isDisplayed());
			
		}
		driver.findElement(By.linkText("The forest")).click();
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());	
		
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/shop/the-forest/");
		
		
	}

}
