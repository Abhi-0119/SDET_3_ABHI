package com.sdet3.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.genericUtil.ExcelUtil;

public class DataProviderExcel
{
	ExcelUtil eutil = new ExcelUtil();
	@Test
	public void print()
	{
		
	}
	@DataProvider
	public void excelData() throws EncryptedDocumentException, IOException
	{
		int lastrow = eutil.getLastRowNum("Sheet2");
	}

}
