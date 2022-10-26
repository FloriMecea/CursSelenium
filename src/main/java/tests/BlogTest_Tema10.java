package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.BlogPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class BlogTest_Tema10 extends BaseTest{
	
	@Test(priority=0)
	public void goToClassic() throws InterruptedException {
		NavMenuPage menu= new NavMenuPage(driver);
		BlogPage pag=new BlogPage(driver);
		
		pag.hoverBlog();
	    menu.navigateTo(pag.blogClassicElement);
		
		Thread.sleep(3000);
		assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/category/classic/");
		  
		menu.navigateTo(pag.book);
	    assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/2016/02/02/best-poetry-books-of-all-time/");
	    
	    
	}
	@Test(priority=1)
	public void fillFormular() throws InterruptedException {
		NavMenuPage menu= new NavMenuPage(driver);
		BlogPage pag=new BlogPage(driver);
		
		//completam formularul  
		pag.addText(pag.comment, "Mi-a placut cartea aceasta!");
		pag.addText(pag.name, "Flori");
		pag.addText(pag.email, "email@email.com");	
		pag.addText(pag.website, "Subiect1");		
		WebElement check=pag.findElement(pag.checkbox);
		check.click();		
		Thread.sleep(2000);
		WebElement comment=pag.findElement(pag.sendComment);
		comment.click();
		
		/* sau se poate apela asa daca se face cu metoda comentata in BlogPage
		 * pag.FindElement(pag.sendComment).click();
		 */
		Thread.sleep(3000);
		
		String text=pag.findElement(pag.message).getText();
		assertEquals(text,"Your comment is awaiting moderation.");
	}
}
