package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class RedirectPage extends SeleniumWrappers{

		public RedirectPage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
		
		//public By iframe=By.tagName("iframe");
		public By facebookIcon=By.cssSelector("span[class*='facebook']");
		public By twitterIcon=By.cssSelector("span[class*='twitter']");
		public By instagramIcon=By.cssSelector("span[class*='instagramm']");

		
}
