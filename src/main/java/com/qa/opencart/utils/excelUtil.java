package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;

public class excelUtil {
	private static final String TEST_DATA_SHEET_PATH=("");
	private static Workbook book;
	private static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName)  {
		System.out.println("reading data from"+sheetName);
		Object data[][]=null;
		try {
		FileInputStream ip=new FileInputStream(TEST_DATA_SHEET_PATH);
		book=WorkbookFactory.create(ip);
		sheet=book.getSheet(sheetName);
		data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(InvalidFormatException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return data;
		
	}

}
