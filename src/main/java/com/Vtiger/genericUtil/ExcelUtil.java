package com.Vtiger.genericUtil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readExcelData(String sheetName,int row,int cell) throws Throwable   {
		FileInputStream fis = new FileInputStream(IAutoConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		String excelValue = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return excelValue;
	}
	/**
	 * 
	 * @param path
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readExcelData(String path,String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String excelValue = wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
		return excelValue;
	}

	
	public int getLastRowNum(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IAutoConstants.excelpath);
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		return sh.getLastRowNum();
		
	}

	public String selValueForDD(String sheetname,int cell,String DDvalue) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IAutoConstants.excelpath);
		Workbook wb =  WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastrow= sh.getLastRowNum();
		String value = "Null";
		for(int i=0;i<=lastrow;i++)
		{
			value= sh.getRow(i).getCell(cell).getStringCellValue();
			if(value.equalsIgnoreCase(DDvalue))
			{
				break;
			}			
		}
		return value;
	}
	
}
