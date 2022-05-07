package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndainRailwayProject {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='trainNo']")
	WebElement trno;
	
	@FindBy(xpath="//img[@title='Select date']")
	WebElement calender;
	
	@FindBy(id="sourceStation")
	WebElement srcstation;
	
	@FindBy(xpath="//input[@id='destinationStation']")
	WebElement destn;
	
	
	@FindBy(xpath="(//input[@value='Get Availability'])[3]")
	WebElement btn;
	
	//Constructor intilization
	
	public IndainRailwayProject(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void trainno() throws InterruptedException {
		trno.sendKeys("12349");
		Thread.sleep(3000);
		trno.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		trno.sendKeys(Keys.ENTER);
	}
	
	public void datecal() {
		
		calender.click();
	}
	public void SourceStation() throws InterruptedException {
		WebDriverWait Wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		srcstation.sendKeys("BHAGALPUR");
		Wait.until(ExpectedConditions.visibilityOf(srcstation));
		Wait.until(ExpectedConditions.elementToBeClickable(srcstation));
		
		Thread.sleep(3000);
		srcstation.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
	}
	
	public void Arrivalstation() throws InterruptedException {
		
		destn.sendKeys("DELHI");
		Thread.sleep(3000);
		destn.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
	}
	
	public void enterclass() {
		
		Select st=new Select(driver.findElement(By.xpath("//select[@id='class']")));
		st.selectByValue("FC");
		}
	
	public void enterquota() {
		
		Select sb=new Select(driver.findElement(By.xpath("//select[@name='quota']")));
		sb.selectByVisibleText(" Premium Tatkal Quota");
	}
	
	public void Submitbtn() {
		btn.click();
	}
	
	

}
