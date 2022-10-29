package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BlogPage2_Tema16;
import pages.NavMenuPage;
import utils.BaseTest;

public class Actions_Tema16 extends BaseTest {
	

	@DataProvider
	public Object[][] blogPost(){
		Object[][] posts= new Object[15][3];
		
        
		posts[0][0]= "div[data-columns='2'] div:nth-of-type(1)";
		posts[0][1]= "15 Amazing Things About Reading in the Fall";
		posts[0][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/15-amazing-things-about-reading-in-the-fall/']";

		posts[1][0]="div[data-columns='2'] div[class*='column_2']:nth-of-type(2)";  //aici nu a mers cu "div[data-columns='2'] div:nth-of-type(2)" asa ca am schimbat locatorul
		posts[1][1]= "10 Book Recommendations For Family Members";
		posts[1][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/10-book-recommendations-for-family-members/']";

		posts[2][0]= "div[data-columns='2'] div:nth-of-type(3)";
		posts[2][1]= "The Best business books – Financial Times";
		posts[2][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/best-business-books-financial-times/']";

		posts[3][0]= "div[data-columns='2'] div:nth-of-type(4)";
		posts[3][1]= "The Best Poetry Books of All Time";
		posts[3][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/best-poetry-books-of-all-time/']";

		posts[4][0]= "div[data-columns='2'] div:nth-of-type(5)";
		posts[4][1]= "Five the Best Audiobooks";
		posts[4][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/five-best-audiobook/']";

		posts[5][0]= "div[data-columns='2'] div:nth-of-type(6)";
		posts[5][1]= "Book reviews: Find the best new books";
		posts[5][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/book-reviews-find-the-best-new-books/']";
        
		posts[6][0]= "div[data-columns='2'] div:nth-of-type(7)";
		posts[6][1]= "How end-of-year book lists prove we lack diversity";
		posts[6][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/how-end-of-year-book-lists-prove-we-lack-diversity/']";

  
		posts[7][0]= "div[data-columns='2'] div:nth-of-type(8)";
		posts[7][1]= "We need to talk about all women writers";
		posts[7][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/we-need-to-talk-about-all-women-writers/']";
        
		posts[8][0]= "div[data-columns='2'] div:nth-of-type(9)";
		posts[8][1]= "The hottest books to warm you up this winter";
		posts[8][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/the-hottest-books-to-warm-you-up-this-winter/']";
        
		posts[9][0]= "div[data-columns='2'] div:nth-of-type(10)";
		posts[9][1]= "Why I won’t stop buying books";
		posts[9][2]=  "h4[class='post_title'] a[href='https://keybooks.ro/2016/02/02/why-i-wont-stop-buying-books/']";
        
		posts[10][0]= "div[data-columns='2'] div:nth-of-type(11)";
		posts[10][1]= "Celebrity Picks:Favorite Reads of 2015";
		posts[10][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2016/01/02/celebrity-picksfavorite-reads-of-2015/']";
        
		posts[11][0]= "div[data-columns='2'] div:nth-of-type(12)";
		posts[11][1]= "Weekend Reading";
		posts[11][2]=  "h4[class='post_title'] a[href='https://keybooks.ro/2016/01/02/weekend-reading/']";
        
		posts[12][0]= "div[data-columns='2'] div:nth-of-type(13)";
		posts[12][1]= "Coffee Table Books";
		posts[12][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2015/12/12/coffee-table-books/']";
        
		posts[13][0]= "div[data-columns='2'] div:nth-of-type(14)";
		posts[13][1]= "Turn the Page: Your Next Rock ‘N’ Roll Book Club";
		posts[13][2]= "h4[class='post_title'] a[href='https://keybooks.ro/2015/12/12/turn-the-page-your-next-rock-n-roll-book-club/']";

		posts[14][0]= "div[data-columns='2'] div:nth-of-type(15)";
		posts[14][1]= "The Book Report: Episode 3";
		posts[14][2]=  "h4[class='post_title'] a[href='https://keybooks.ro/2015/11/11/the-book-report-episode-3/']";
        
		return posts;		
	}
		

	@Test (priority=0)
	public void test() throws InterruptedException {
		   NavMenuPage menu= new NavMenuPage(driver);
		   BlogPage2_Tema16 pag= new BlogPage2_Tema16(driver);
		  
		   menu.hoverElement(menu.blogLink);
		  // Thread.sleep(1000);
		   menu.hoverElement(pag.portofolio);
		   menu.hoverElement(pag.portofolio2Link);
		   menu.navigateTo(pag.portofolio2Link);
		   assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/category/portfolio-2-columns/");
		   
	   }
	
	@Test(priority=1, dataProvider="blogPost") 
	public void test1(String hoverLocator, String title, String hoverText) throws InterruptedException {
		   NavMenuPage menu= new NavMenuPage(driver);
		 //  WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	     //  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(hoverLocator)));
		   
		   menu.hoverElement(By.cssSelector(hoverLocator));
		  Thread.sleep(1000);
		  // wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(hoverText)));
		   System.out.println(driver.findElement(By.cssSelector(hoverText)).getText());
		   assertEquals(driver.findElement(By.cssSelector(hoverText)).getText(),title);
	   }
	
}
