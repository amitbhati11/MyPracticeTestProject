package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Unitedairline {
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='One-way']")
	WebElement flight;
	
	@FindBy(xpath="//input[@id='bookFlightOriginInput']")
	WebElement from;
	
	@FindBy(xpath="//input[@id='bookFlightDestinationInput']")
	WebElement to;
	
	@FindBy(xpath="//input[@id='DepartDate']")
	WebElement dates;
	
	@FindBy(xpath="//button[text()='1 Adult']")
	WebElement traveler;
	
	@FindBy(xpath="//button[@id='cabinType']")
	WebElement cabintype;
	
	@FindBy(xpath="//span[contains(text(),'Find flights')]")
	WebElement findbtn;
	
	//Constructor
	
	public Unitedairline(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void trip() {
		flight.click();
	}
	
	public void departure() throws InterruptedException {
		from.clear();
		Thread.sleep(3000);
		from.sendKeys("ORD");
		Thread.sleep(3000);
		from.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		from.sendKeys(Keys.ENTER);
	}
	
	public void arrival() throws InterruptedException {
		to.sendKeys("SFO");
		Thread.sleep(3000);
		to.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		to.sendKeys(Keys.ENTER);
		
	}
	
	public void departdate() {
		dates.click();
	}
	public void travelertype() {
		traveler.click();
	}
	public void cabinclass() {
		cabintype.click();
	}
	public void Submitbtn() {
		findbtn.click();
	}
	

}
