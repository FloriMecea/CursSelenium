package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.NavMenuPage;

public class BaseTest {

	public WebDriver driver;
	public JavascriptExecutor jse;
	public NavMenuPage navMenu;
	
	@BeforeClass
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
		
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://keybooks.ro");
	//	driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	//	driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

	//	driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

	//	driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
	
	
		jse= (JavascriptExecutor) driver;
	  navMenu= new NavMenuPage(driver);
		
		//new line for conflicts exercise

	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();		

	}
}
