package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import pages.NavMenuPage;
import pages.RedirectPage;
import utils.BaseTest;

public class Tema20 extends BaseTest{
	 @Test
	  public void iframeExample() throws InterruptedException {
		  NavMenuPage menu= new NavMenuPage(driver);
		  menu.navigateTo(menu.homeLink);
		  
		  RedirectPage pg= new RedirectPage(driver);
		  menu.navigateTo(pg.facebookIcon);
		//  System.out.println(driver.getCurrentUrl());
		 
		  
		  Thread.sleep(2000);
		  menu.navigateTo(pg.twitterIcon);
		//  System.out.println(driver.getCurrentUrl());
		
		  
		  Thread.sleep(2000);
		  menu.navigateTo(pg.instagramIcon);
		//  System.out.println(driver.getCurrentUrl());
		  
		  System.out.println("All:"+driver.getWindowHandles());
		  System.out.println("Current:"+driver.getWindowHandle());
		  
		  List<String> browserTabs= new ArrayList<String>(driver.getWindowHandles());
		  System.out.println(browserTabs.size());
	 
	/*	 nu era corect, aveam la switch alta ordine
	  for (int i=0; i<browserTabs.size();i++) {
			 driver.switchTo().window(browserTabs.get(i));
			 Thread.sleep(3000);
		     System.out.println(driver.getCurrentUrl());
		 
		     switch (i) {
			 	case 0: assertEquals(driver.getCurrentUrl(),"https://keybooks.ro/home-3/"); break;
			 	case 1: assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/keytraining.ro"); break;
			 	case 2: assertEquals(driver.getCurrentUrl(),"https://twitter.com/"); break;
			 	case 3: assertEquals(driver.getCurrentUrl(),"https://www.instagram.com/"); break;		 
			 }
		    
		 }
 */
          String[] urls = new String[browserTabs.size()];
          
          for(int i= 0;i < browserTabs.size(); i++) {
               driver.switchTo().window(browserTabs.get(i));
               urls[i] = driver.getCurrentUrl();
               
          }
          
          for (String tab : browserTabs) {
              driver.switchTo().window(tab);
              assertEquals(driver.getCurrentUrl(), urls[browserTabs.indexOf(tab)] );
              driver.close();
             
          }

		  
	  
	  }
}
