package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Unitedairline;

public class Unitedairlinetest {
	WebDriver driver;
	Unitedairline uap;
	@BeforeTest
	
	public void setup() {
		
		String cpath="C:\\Users\\Admin_SRV\\git\\MyPracticeTestProject\\MyPracticetestproject\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",cpath);
		driver=new ChromeDriver();
		
	}
	
	@Test
	
	public void testexecution() throws InterruptedException {
		
		driver.get("https://www.united.com/en/us");
		
		driver.manage().window().maximize();
		
		uap=new Unitedairline(driver);
		uap.trip();
		uap.departure();
		uap.arrival();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(3000);
	//	uap.departdate();
		/*Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='SingleDatePickerInput_clearDate SingleDatePickerInput_clearDate_1 SingleDatePickerInput_clearDate__default SingleDatePickerInput_clearDate__default_2']")).click();
		uap.departdate();
		String Expedate="15-August 2022";
		String Emonthyear=Expedate.split("-")[1];
		String Eday=Expedate.split("-")[0];
		System.out.println(Eday);
		
		System.out.println(Emonthyear+" :Expected time");
		
	String Cmonthyear=	driver.findElement(By.xpath("(//div[@class='CalendarMonth_caption CalendarMonth_caption_1'])[2]")).getText();
	System.out.println(Cmonthyear+" :Currenttime");
	while(!Cmonthyear.equalsIgnoreCase(Emonthyear)) {
		
		driver.findElement(By.xpath("//button[@class='app-containers-BookCalendar-bookCalendar__nextIconContainer--308a5']")).click();
		Cmonthyear=	driver.findElement(By.xpath("(//div[@class='CalendarMonth_caption CalendarMonth_caption_1'])[2]")).getText();
		
	}
	   List<WebElement> list= driver.findElements(By.xpath("(//table[@class='CalendarMonth_table CalendarMonth_table_1'])[1]//tbody//tr//td"));
	list.size();
	System.out.println(list.size());
	
	for(int i=0;i<list.size();i++) {
//	String Cdate=list.get(i).getText();
	System.out.println(Cdate);
		if(Cdate.equals(Eday)) {
			list.get(i).click();
			break;
		}
	}*/
	/*Thread.sleep(5000);
	
	WebElement et=driver.findElement(By.xpath("(//div[@class='CalendarMonth CalendarMonth_1'])[1]/table//tbody//tr//td[text()='16']"));
	//driver.switchTo().activeElement();
	//wait.until(ExpectedConditions.visibilityOf(et));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	et.getText();
	wait.until(ExpectedConditions.elementToBeClickable(et));
	 
	 System.out.println(et.getText());
	 et.click();
	 et.sendKeys(Keys.ENTER);*/
		uap.travelertype();
		for(int l=1;l<2;l++) {
		driver.findElement(By.xpath("(//div[@class='app-components-PassengerSelector-passengers__passengerRow__controls--2Occ-'])[1]//button[@aria-label='Substract one Adult']")).click();
		}
		
		driver.findElement(By.xpath("(//div[@class='app-components-PassengerSelector-passengers__passengerRow__controls--2Occ-'])[2]//button[@aria-label='Substract one Seniors']")).click();
		driver.findElement(By.xpath("(//div[@class='app-components-PassengerSelector-passengers__passengerRow__controls--2Occ-'])[4]//button[@aria-label='Substract one Infant on lap']")).click();
		driver.findElement(By.xpath("(//div[@class='app-components-PassengerSelector-passengers__passengerRow__controls--2Occ-'])[5]//button[@aria-label='Substract one Child']")).click();
	//	driver.findElement(By.xpath("(//div[@class='app-components-PassengerSelector-passengers__passengerRow__controls--2Occ-'])[5]//button[@aria-label='Substract one Child']")).click();
		
	for(int i=0;i<=2;i++) {
		driver.findElement(By.xpath("(//div[@class='app-components-PassengerSelector-passengers__passengerRow__controls--2Occ-'])[6]//button[@aria-label='Substract one Child']")).click();
	}
	;
	for(int k=0;k<2;k++) {
		driver.findElement(By.xpath("(//div[@class='app-components-PassengerSelector-passengers__passengerRow__controls--2Occ-'])[8]//button[@aria-label='Substract one Child']")).click();
	}
	Thread.sleep(2000);
	uap.cabinclass();
	driver.findElement(By.xpath("//li[text()='Business or First']")).click();
	
	uap.Submitbtn();
	
	}
	
	}


