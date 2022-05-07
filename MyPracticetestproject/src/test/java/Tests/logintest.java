package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.loginpage;
import property.Propertydemo;

public class logintest {
	WebDriver driver;
	public static  String Browser;
	loginpage lp;
	Propertydemo pd;
	@BeforeTest
	
	public void setup() throws Exception  {
		pd=new Propertydemo();
		pd.readdataprop();
			if(Browser.contains("chrome")) {
			
			String cpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\MyPracticetestproject\\src\\test\\resources\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",cpath);
			driver=new ChromeDriver();
		}else if(Browser.equals("Firefox")) {
			String gpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\MyPracticetestproject\\src\\test\\resources\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", gpath);
			driver=new FirefoxDriver();
		}
		}
	
	@Test
	
	public void test() {
		
		driver.get("https://example.testproject.io/web/");
		//driver.manage().window().maximize();
		/* lp=new loginpage(driver);
		 lp.user_name(username);
		 lp.usr_pass(password);
		 lp.hintp();
		 lp.lbtn();*/
	}
		
	}


