package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShipingAdressPage {
	public WebDriver driver;
	public Select select;
	public WebElement dropdown_country;
	public WebElement dropdown_province;
	
	public By country= By.cssSelector("select[id='shipping_country']");
	public By province= By.cssSelector("select[id='shipping_state']");
	
	
	
	
	public ShipingAdressPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void selectByIndex(int index) {	
	  dropdown_country= driver.findElement(country);
	  select= new Select(dropdown_country);
	  select.selectByIndex(index);
	  
   }
	public String getSelectedOption(By locator) {
		dropdown_country= driver.findElement(locator);
		select= new Select(dropdown_country);
		return select.getFirstSelectedOption().getText();
		
	}
	public void selectByValue(String value) {
		dropdown_province= driver.findElement(province);
		select= new Select(dropdown_province);
		select.selectByValue(value);
	}
}
 