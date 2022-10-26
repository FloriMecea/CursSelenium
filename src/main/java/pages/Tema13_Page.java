package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Tema13_Page {
	public WebDriver driver;
	public By dropdown =By.cssSelector("select[class='orderby']");
	public By firstBook= By.cssSelector("ul[class='products columns-4'] li[class*='column-1_4']:nth-of-type(1)");
	public By lastBook= By.cssSelector("ul[class='products columns-4'] li[class*='column-1_4']:last-of-type");
	public By firstBookPrice= By.cssSelector("ul[class='products columns-4'] li[class*='column-1_4']:nth-of-type(1) bdi");
	public By lastBookPrice= By.cssSelector("ul[class='products columns-4'] li[class*='column-1_4']:last-of-type bdi");
	
	
	public Tema13_Page(WebDriver driver) {
		this.driver=driver;
	}

	public void selectPriceLowToHigh(By locator) {
		WebElement element=driver.findElement(locator);
		Select select=new Select(element);
		select.selectByValue("price");
	}
	
	public String checkCurrentSelection(By locator) {
		WebElement element=driver.findElement(locator);
		Select select=new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean compare() {
		WebElement price1= driver.findElement(firstBookPrice);		
		WebElement price2= driver.findElement(lastBookPrice);
		String text1=price1.getText();
		
		System.out.println(text1);
		String text2=price2.getText();
		System.out.println(text2);
		
		text1=text1.substring(1);
		text2=text2.substring(1);
		System.out.println("After eliminating $ from text1: "+ text1);
		System.out.println("After eliminating $ from text2: "+ text2);
		
		float nr1=Float.parseFloat(text1);
		//System.out.println(nr1);
		float nr2=Float.parseFloat(text2);
		//System.out.println(nr2);
		
		if(nr1<nr2) {
			System.out.println("Prima carte are pretul mai mic decat ultima carte");
			return true;
	
		} else if(nr1>nr2) {
			System.out.println("Prima carte are pretul mai mare decat ultima carte");
			return false;
		
		} else {
			 System.out.println("Cele 2 carti au acelasi pret");
		    return false;
		}
			
	}
}
