package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Excelutils.Excelutildemo;
import pages.loginpage;

public class Dataexcelutilsp {
	
	WebDriver driver;
	loginpage lp;
	
	@Parameters("browser")
	
	@BeforeTest
	
	public void setup(String browser) {
		System.out.println("the browser is:"+browser);
		if(browser.equals("Chrome")) {
		String cpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\MyPracticetestproject\\src\\test\\resources\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",cpath);
		driver=new ChromeDriver();
	}else if(browser.equals("Firefox")) {
		String gpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\MyPracticetestproject\\src\\test\\resources\\drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", gpath);
		driver=new FirefoxDriver();
	}
	}
	@DataProvider(name="testdata")
	
	public Object [][] dataprovide() throws Exception{
		String xlpath="C:\\Users\\Admin_SRV\\eclipse-workspace\\MyPracticetestproject\\src\\test\\resources\\datautils\\loginDataprovider.xlsx";
		String Sheetname="Sheet1";
		Object data [][]=getcelldata(xlpath, Sheetname);
		return data;
	}
	
	@Test(dataProvider="testdata")
	
	public void finaldata(String username,String password,String id) {
		
	
		driver.get("https://example.testproject.io/web/");
		//driver.manage().window().maximize();
		 lp=new loginpage(driver);
		 lp.user_name(username);
		 lp.usr_pass(password);
		 lp.hintp();
		 lp.lbtn();
			System.out.println(username+" | "+password+" | "+id);
	}
	
	@AfterTest
	
	public void teardown() {
		
		System.out.println("Success");  
		driver.close();
		
	}
	
	public Object [][] getcelldata(String xlpath,String Sheetname) throws Exception {
		Excelutildemo eud=new Excelutildemo(xlpath, Sheetname);
		
		int Rownum=eud.getrowcount();
		int Colnum=eud.getcolcount();
		
		    Object data [][]=new Object[Rownum-1][Colnum];
		    
		    for(int i=1;i<Rownum;i++) {
		    	
		    	for(int j=0;j<Colnum;j++) {
		    		
		    		data [i-1][j]= eud.getcellstringdata(i, j);
		    	}
		    }return data;
	}

}
