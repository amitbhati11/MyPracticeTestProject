package Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import pages.IndainRailwayProject;

public class IndianRailTest {
	
	WebDriver driver;
	IndainRailwayProject ir;
	
	@BeforeTest
	
	public void setup() {
		String cpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\MyPracticetestproject\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",cpath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().deleteAllCookies();
	}
	
	@Test
	
	public void testexecution() throws InterruptedException, TesseractException {
		driver.get("https://www.indianrail.gov.in/enquiry/SEAT/SeatAvailability.html?locale=en");
		
		ir=new IndainRailwayProject(driver);
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");*/
		ir.trainno();
		ir.datecal();
		String Expecteddate="3-July-2022";
		String Emonth=Expecteddate.split("-")[1];
		String Eyear=Expecteddate.split("-")[2];
		String Edate=Expecteddate.split("-")[0];
		System.out.println(Emonth+"###"+Eyear);
		
		String Cmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().trim();
		String Cyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().trim();
		System.out.println(Cmonth+"@@@"+Cyear);
		
		while((!Cmonth.equals(Emonth))||(!Cyear.equals(Eyear))) {
			
			WebElement nxtbtn=driver.findElement(By.xpath("//span[text()='Next']"));
			nxtbtn.click();
			Cmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().trim();
			Cyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().trim();
			
			
			List <WebElement> list=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
			list.size();
			for(int i=0;i<list.size();i++) {
				String Cdate=list.get(i).getText();
				
				if(Cdate.equals(Edate)) {
					WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
					wait.until(ExpectedConditions.visibilityOfAllElements(list));
					list.get(i).click();
					
					break;
				}
			}
			
		}
		
		Thread.sleep(3000);
		ir.SourceStation();
		Thread.sleep(1000);
		ir.Arrivalstation();
		Thread.sleep(3000);
		ir.enterclass();
		ir.enterquota();
		ir.Submitbtn();
		
		Thread.sleep(5000);
		
	File src=	driver.findElement(By.xpath("//img[@id='CaptchaImgID']")).getScreenshotAs(OutputType.FILE);
	String path="C:/Users/Admin_SRV/eclipse-workspace/MyPracticetestproject/Screenshots/image4.png";
	try {
		FileHandler.copy(src, new File(path));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("exception is:"+e.getMessage());
	}
	Thread.sleep(3000);
	ITesseract imges=new Tesseract();
	String imgtxt=imges.doOCR(new File(path));
	System.out.println(imgtxt);
	//regex
	String S=imgtxt.split("[0-9]+\\+-[0-9]*")[0];
	System.out.println(S);
		String S1=imgtxt.split("[0-9]+")[0];
		String S2=imgtxt.split("[0-9]*")[1];
		//	String s2=imgtxt.split("\\d+[\\+-x\\*]\\d+")[2];
		/*Integer I=Integer.valueOf(s1);
		String s=String.valueOf(I);*/
		System.out.println("the value 0f s1:"+S1);
		System.out.println("the value of s2:"+S2);
	
		String z=S.substring(0,3).trim();
		String z1=S.substring(5,7).trim() ;
	
		System.out.println("the value of z"+z);
	  System.out.println("the value of z1:"+z1);
	/*	
		System.out.println("the value of z2:"+z2);*/
		
		Integer i1=Integer.valueOf(z);
		Integer i2=Integer.valueOf(z1);
	if(S.contains("+")) {
		
		Integer I=i1+i2;
		
		String value=String.valueOf(I);
		driver.findElement(By.id("inputCaptcha")).sendKeys(value);
	}else if(S.contains("-")) {
		Integer I=i1-i2;
		String value=String.valueOf(I);
		driver.findElement(By.id("inputCaptcha")).sendKeys(value);
	}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='test']")).click();
					
	}
	

}
