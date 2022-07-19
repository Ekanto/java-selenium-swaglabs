package com.excelfile;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtility {
	public FileInputStream fileInputStream;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path=null;
	
	public XlUtility(String path) {
		this.path = path;
	}
	
	public int getRowCount(String sheetname) throws IOException{
		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fileInputStream.close();
		return rowcount;
	}
	
	public int getCellCount(String sheetName, int rowNum) throws IOException{
		fileInputStream  = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fileInputStream.close();
		return cellcount;
	}
	
	public String getCellData(String sheetName, int rowNum, int colnum) throws IOException {
		fileInputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colnum);
		
		DataFormatter dataFormatter = new DataFormatter();
		String data;
		try {
			data = dataFormatter.formatCellValue(cell);
		}
		catch (Exception e) {
			data = "";
		}
		workbook.close();
		fileInputStream.close();
		return data;
		
	}
	
	
	
	

}
