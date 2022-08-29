package curs4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import utils.BaseTest;

public class CssSelectorExample extends BaseTest {
	
	//selenium: id, class name, link text, partial link text, name, tagName  -se citesc direct din DOM fara sa fac nimic si o pun in driver
	//driver.findElement(By.id('menu_user'))
	
	//selenium: xpath, cssSelector - mai trebuie sa mai construiesc/sa caut eu ceva din DOM intai
	// --> xpath:  //ul[@id='menu_user']
	// --> xpath:  //ul[@type='list']
	// --> xpath:  //ul[@class='menu_user_nav']
	// --> xpath:  //ul[contain(@class,'menu_user_nav')]
	//--------------------
	// --> cssSelector:  //ul[id='menu_user']
	//  --> cssSelector:  //ul[type='list']
	
	@Test
	public void testCssSelectors() {
		

	
	//#menu_user - cauta/gaseste un orice element(tag element) care are atributul id-ul egal cu 'menu_user'
	//ul#menu_user - cauta/gaseste un orice element de tip ul care are atributul id-ul egal cu 'menu_user'

	//ul -tagul html
	//#-> id
	//ul[id='menu_user']=ul#menu_user
	
	//css selector arata ca mai jos
	//ul[id=menu_user]
	
	//xpath arata ca mai jos
	//  //ul[@id=menu_user]
		
		
	//# -->id
	WebElement loginMenu=driver.findElement(By.cssSelector("#menu_user"));
	System.out.println(loginMenu.getText());
	
	JavascriptExecutor jse= (JavascriptExecutor) driver;
	jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')",loginMenu);

	
	
	//  .  -->indetifica class
	
	WebElement logoSlogan=driver.findElement(By.cssSelector(".logo_slogan"));
	System.out.println(logoSlogan.getText());
	
	jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')",logoSlogan);
	//jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;', arguments[1].setAttribute('style', 'background:orange; border:4px solid red;')",logoSlogan, loginMenu);
	
	//<h3 class="sc_title sc_title_underline sc_align_center inverse " style="text-align:center;color:#ffffff;"><em>Stay In Touch</em>&nbsp; with Our Updates</h3>
	//style="text-align:center;color:#ffffff;"
	WebElement updatesTitle=driver.findElement(By.cssSelector("h3[style='text-align:center;color:#ffffff;']"));
	System.out.println(updatesTitle.getText());
	
	jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')",updatesTitle);

	
	
	//<h3 class="sc_title sc_title_underline sc_align_right inverse " style="text-align:right;color:#ffffff;"><em>Inspire</em> Daily Reading</h3>
	//div.column-1_2 h3.sc_title_underline
	//div[class='column-1_2'] h3.sc_title_underline
	//div[class='column-1_2'] h3[class='sc_title_underline']
	
	
	WebElement inspireText=driver.findElement(By.cssSelector("div.column-1_2 h3.sc_title_underline"));
	System.out.println(inspireText.getText());
	
	jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')",inspireText);

	}
}
