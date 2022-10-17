package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.NavMenuPage;
import pages.PageFormatsPage;
import pages.ShopPage;
import utils.BaseTest;

public class ActionClassExample extends BaseTest {
  // @Test
   public void dragAndDropTest() {
	   NavMenuPage menu= new NavMenuPage(driver);
	   menu.navigateTo(menu.shopLink);
	   
	   ShopPage shop= new ShopPage(driver);
	   shop.dragAndDrop(shop.sliderInitialPosition, 100, 0);
	   shop.dragAndDrop(shop.sliderFinalPosition, -100, 0);
	   
   }
   
//   @Test(priority=1)
   public void hoverElement() throws InterruptedException {
	   NavMenuPage menu= new NavMenuPage(driver);
	   menu.hoverElement(menu.blogLink);
	   Thread.sleep(1000);
	   menu.hoverElement(menu.blogLink);
	   menu.hoverElement(menu.postFormatLogtLink);
	   menu.navigateTo(menu.postFormatLogtLink);
	   assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/category/post-formats/");
	   assertEquals(menu.readURL(),"https://keybooks.ro/category/post-formats/");
   }
   
 //  @Test(priority=2)
   public void sendKeysExample() throws InterruptedException {
	   PageFormatsPage pageFormats= new PageFormatsPage(driver);
	   pageFormats.hoverElement(pageFormats.searchField);
	   WebElement element=driver.findElement(pageFormats.searchField);
	   Actions action= new Actions(driver);
	   //tasta apasata pt shift
	   action.keyDown(Keys.SHIFT).sendKeys(element,"abracadabra").perform();
	   Thread.sleep(3000);
	   }
   
   
   @Test(priority=3)
   public void sendKeysExample2() throws InterruptedException {
	// basePage.menu.navigateTo(basePage.menu.contactLink);  --pt BasePage 
	   
	   
	   NavMenuPage menu= new NavMenuPage(driver);
	  menu.navigateTo(menu.contactLink);
	  ContactsPage contactPage= new ContactsPage(driver);
	  
	  WebElement nameElement= driver.findElement(contactPage.nameField);
	  
	  Thread.sleep(3000);
	  Actions action=new Actions(driver);
	  
	  action
	  .moveToElement(nameElement)
	  .sendKeys(nameElement,"Name")
	  .sendKeys(Keys.TAB,"email@email.com")
	  .sendKeys(Keys.TAB, "My Subject")
	  .sendKeys(Keys.TAB, "Message Message")
	  .sendKeys(Keys.TAB, Keys.ENTER).perform();
	  
	  Thread.sleep(3000);
   }
   
   @Test(priority=4)
   public void offSetExample() throws InterruptedException {
	   ContactsPage contactPage= new ContactsPage(driver);
	   WebElement nameElement= driver.findElement(contactPage.nameField);
	   int getx=nameElement.getLocation().getX();
	   System.out.println(getx);
	   int gety=nameElement.getLocation().getY();
	   System.out.println(gety);
	   
	   Actions action=new Actions(driver);
	   
	   action
		  .moveByOffset(getx,gety)
		  .click()
		  .sendKeys("Test Ceva")
		  .sendKeys(Keys.TAB,"email@email.com")
		  .sendKeys(Keys.TAB, "My Subject")
		  .sendKeys(Keys.TAB, "Message Message")
		  .sendKeys(Keys.TAB, Keys.ENTER).perform();
		  
		  Thread.sleep(3000);
   }
   
}
