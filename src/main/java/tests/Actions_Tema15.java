package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.BlogPage2_Tema15;
import pages.NavMenuPage;
import utils.BaseTest;

public class Actions_Tema15 extends BaseTest {
	@Test (priority=0)
	public void test() throws InterruptedException {
		   NavMenuPage menu= new NavMenuPage(driver);
		   menu.hoverElement(menu.blogLink);
		   Thread.sleep(1000);
		   menu.hoverElement(menu.blogLink);
		   menu.hoverElement(menu.postFormatLogtLink);
		   menu.navigateTo(menu.postFormatLogtLink);
		   assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/category/post-formats/");
		   		   
		   BlogPage2_Tema15 pag= new BlogPage2_Tema15(driver);
		   menu.navigateTo(pag.audioPost);
		   Thread.sleep(3000);
		   assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/2016/02/02/audio-post/");
		   pag.findElement(pag.clickPlay).click();
		   Thread.sleep(6000);
		   pag.findElement(pag.playPause).click();
		   pag.dragAndDrop(pag.sliderMelodie, 200, 0);
		   Thread.sleep(3000);
		   pag.dragAndDrop(pag.sliderSonor, -50, 0);
	   }
}
