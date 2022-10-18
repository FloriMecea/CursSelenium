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
	public void GoToClassic() throws InterruptedException {
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
	public void FillFormular() throws InterruptedException {
		NavMenuPage menu= new NavMenuPage(driver);
		BlogPage pag=new BlogPage(driver);
		
		//completam formularul  
		pag.addText(pag.comment, "Mi-a placut cartea aceasta!");
		pag.addText(pag.name, "Flori");
		pag.addText(pag.email, "email@email.com");	
		pag.addText(pag.website, "Subiect1");		
		WebElement check=pag.FindElement(pag.checkbox);
		check.click();		
		Thread.sleep(2000);
		WebElement comment=pag.FindElement(pag.sendComment);
		comment.click();
		Thread.sleep(3000);
		
		String text=pag.FindElement(pag.message).getText();
		assertEquals(text,"Your comment is awaiting moderation.");
	}
}
