package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement usrnm;
	
	@FindBy(id="password")
	WebElement pass;
	
	@FindBy(xpath="//small[text()='Hint: password is 12345']")
	WebElement hint;
	
	@FindBy(id="login")
	WebElement lognbutton;
	
	
//constructor
	
	public loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void user_name(String username) {
		usrnm.sendKeys(username);
	}
	
	public void usr_pass(String password) {
		pass.sendKeys(password);
	}

	public void hintp() {
		hint.isDisplayed();
	}
	public void lbtn() {
		lognbutton.click();
	}
}
