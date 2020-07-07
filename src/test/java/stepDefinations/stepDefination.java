package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class stepDefination extends Base {
	LoginPage lp;

	@Given("^Initialize the Browser with chrome$")
	public void initialize_the_Browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^Click on login link in home page to land on secure sign in page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l=new LandingPage(driver);
		
		 lp= l.getLogin();
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_and_and_logs_in1(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		lp.getEmail().sendKeys(arg1);
		lp.getPassword().sendKeys(arg1);
	}

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Thread.sleep(2000L);
		driver.quit();
	}
	@When("^user enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
    }
//varun for git Clone
//varun from git main
//develop branch- GitDemo Asian Architect
}
