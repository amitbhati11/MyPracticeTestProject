package Excelutils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutildemo {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public Excelutildemo(String xlpath,String Sheetname) throws Exception {
		workbook=new XSSFWorkbook(xlpath);
		sheet=workbook.getSheet(Sheetname);
		
	}
	
	public int getrowcount() {
	int rownum=	sheet.getPhysicalNumberOfRows();
	
	return rownum;
	}
	
	public int getcolcount() {
	int colnum=	sheet.getRow(0).getPhysicalNumberOfCells();
	
	return colnum;
	}
	
	public String getcellstringdata(int rownum,int colnum) {
		DataFormatter formater=new DataFormatter();
		
	String value=formater.formatCellValue(sheet.getRow(rownum).getCell(colnum));
	
	return value;
	}

}
