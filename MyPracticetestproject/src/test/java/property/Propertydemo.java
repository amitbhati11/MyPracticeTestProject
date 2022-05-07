package property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import Tests.logintest;

public class Propertydemo {
	
 Properties pp;
	 String  file="C:\\Users\\Admin_SRV\\eclipse-workspace\\MyPracticetestproject\\src\\test\\resources\\Propertyfile\\data.properties";
	public  void readdataprop() throws Exception {
		Properties pp=new Properties();
		
FileInputStream fis=new FileInputStream(file);

pp.load(fis);

     String Browser= pp.getProperty("Browser");
     
     logintest.Browser=pp.getProperty("Browser");
     
     
	}
	
	public  void writeprop() throws Exception {
		
		FileOutputStream output=new FileOutputStream(file);
		pp.setProperty("result"," pass");
		
		pp.store(output, null);
		
	}
	
	public static void main(String [] args) throws Exception {
		//writeprop();
	//	readdataprop();
		
	}

}
