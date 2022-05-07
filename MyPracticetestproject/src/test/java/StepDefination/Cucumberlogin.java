package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.Homepages;
import pages.loginpage;

public class Cucumberlogin {
	WebDriver driver;
	loginpage lp;
	Homepages hp;
	@Before
	
	public void setup() {	
		String cpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\MyPracticetestproject\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",cpath);
		driver=new ChromeDriver();
	}
	
	@Given("enter login url")
	public void enter_login_url() {
		
		driver.get("https://example.testproject.io/web/");
	}

	@And("^verify with valid credentasils enter (.*) and (.*)$")
	public void verify_with_valid_credentasils_enter_username_and_passowrd(String username,String password) throws Exception {
		lp=new loginpage(driver);
		lp.user_name(username);
          lp.usr_pass(password);
          Thread.sleep(3000);
		
	}
	
	@And("^verify with invalid credentasils enter(.*) and (.*)$")
	public void verify_with_invalid_credentasils_enter_username_and_passowrd(String username,String password) throws InterruptedException {
		lp=new loginpage(driver);
		lp.user_name(username);
          lp.usr_pass(password);
          Thread.sleep(3000);
	}

	@When("click on login button")
	public void click_on_login_button() {
		lp=new loginpage(driver);
		lp.hintp();
		lp.lbtn();
	}

	@Then("navigate to home page")
	public void navigate_to_home_page() throws InterruptedException {
  hp=new Homepages(driver);
  hp.homecontent();
  Thread.sleep(2000);
	}

	@After
	
	public void teardown() {
		
		driver.close();
	}
	

}
