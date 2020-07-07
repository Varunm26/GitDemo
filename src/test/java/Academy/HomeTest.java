package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

//Inheritance of base class- so that home class can access that methods of base class.
public class HomeTest extends Base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		//driver=initializeDriver();
		//driver.get("http://qaclickacademy.com");
		//log.error("HomeTest-Home Page Initialize error");
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String text) throws IOException, InterruptedException {
		driver=initializeDriver();
		log.error("HomeTest-Home Page Initialize error");
		log.info("HomeTest-Home Page Initialize");
		driver.get(prop.getProperty("url"));
		//one Inheritance
		//Creating Object to that class and invoke methods of it.
		LandingPage l=new LandingPage(driver);
		//l.getLogin().click();	
	//	LoginPage lp=new LoginPage(driver);
		LoginPage lp= l.getLogin();
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		log.fatal("HomeTest-"+text);
		lp.getLogin().click();
		
		System.out.println("HomeLoginQA");
		driver.close();
	}
	

	@DataProvider
	public Object[][] getData() {
		//Row stands for how many different data types test should run
		//column stands for how many values per each test
		Object[][] data=new Object[2][3];
		//Array size is 2 (0,1)
		//1st row
		data[0][0]="restricteduser@qw.com";
		data[0][1]="12345";
		data[0][2]="restricteduser";
		//2nd row
		data[1][0]="NONrestricteduser@qw.com";
	    data[1][1]="67890";
	    data[1][2]="NONrestricteduser";

		return data;
		
	}
	@AfterTest
	public void teardown3() throws InterruptedException {
	
		
	}
	

}
