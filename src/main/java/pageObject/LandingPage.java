package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	//By signin=By.cssSelector("a[href*='sign_in']");
	By signin=By.xpath("//span[text()='Login']");  
	By title=By.cssSelector("div[class='text-center'] h2");
	By NavBar=By.cssSelector("ul.nav.navbar-nav.navbar-right");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public LoginPage getLogin() throws InterruptedException {
		 driver.findElement(signin).click();
		 Thread.sleep(4000L);
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavigationBar() {
		return driver.findElement(NavBar);
	}
}
