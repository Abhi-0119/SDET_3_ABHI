package com.sdet3.practice;

import org.testng.annotations.Test;

public class DataProvider 
{
	@Test(dataProvider = "getValue")
	public void print(String value1,String value2)
	{
		System.out.println(value1+"  "+value2);
	}
	@org.testng.annotations.DataProvider
	public Object[][] getValue()
	{
		Object arr[][] = new Object[4][2];
		
		arr[0][0]="TYSS";
		arr[0][1]="Hyd";
		arr[1][0]="QSP";
		arr[1][1]="panjagutta";
	    arr[2][0]="JSP";
	    arr[2][1]="Kphb";
	    arr[3][0]="PSP";
	    arr[3][1]="Noida";
	    return arr;
				
	}

}
