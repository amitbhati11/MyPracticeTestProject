package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepages {
	
	WebDriver driver;
	
	@FindBy(xpath="//h1[text()='TestProject Example page']")
	WebElement testp;
	
	public Homepages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void homecontent() {
		testp.isDisplayed();
	}

}
