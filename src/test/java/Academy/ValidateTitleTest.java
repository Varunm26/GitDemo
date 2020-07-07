package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class ValidateTitleTest extends Base {
    public WebDriver driver;
    
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		
		driver=initializeDriver();
		log.info("VAlidateTiltle-Test-Browser is initialized");
		//driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
		log.info("VAlidateTiltle-Test-Browser open Url");
	}
	@Test
	public void basePageNavigation() throws IOException {
//		driver=initializeDriver();
//		driver.get(prop.getProperty("url"));
		//one Inheritance
		//Creating Object to that class and invoke methods of it.
		LandingPage l=new LandingPage(driver);
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES 123");
		//System.out.println("pass1");
		Assert.assertTrue(l.getTitle().isDisplayed());
		log.info("VAlidateTiltle-Test-basePageNavigationTitle");
		
	}
	@AfterTest
	public void teardown1() {
		driver.close();
	}
}
