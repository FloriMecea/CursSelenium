package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BlogPage2_Tema15 {
	
	public WebDriver driver;
	public By audioPost= By.cssSelector("h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/audio-post/']");
	public By sliderMelodie=By.cssSelector("span[class*='mejs-time-slider']");
	public By clickPlay=By.cssSelector("div[class*='mejs-play']");
	public By playPause= By.cssSelector("div[class*='playpause']");
	public By sliderSonor=By.cssSelector("a[class*='volume-slider']");

	
	public BlogPage2_Tema15(WebDriver driver) {
		this.driver=driver;
	}
	
   public void hoverBlog() throws InterruptedException {
		   NavMenuPage menu= new NavMenuPage(driver);
		   menu.hoverElement(menu.blogLink);
		   Thread.sleep(1000);
		  
   }
	
	public WebElement findElement(By locator) {
		   WebElement element=driver.findElement(locator);
		  return element;
			
	}
	public void addText(By locator, String message) {
		   WebElement element=driver.findElement(locator);
		   element.sendKeys(message);
			
	}
	 public void dragAndDrop(By locator, int x, int y) {
		   WebElement element= driver.findElement(locator);
		   Actions action= new Actions(driver);
		   
		   action.dragAndDropBy(element, x, y).perform();
	   }

}
