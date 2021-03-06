package com.Vtiger.genericUtil;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersClass implements ITestListener
{

	public void onTestStart(ITestResult result) {
	
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"   Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+"   OOPS Test Failed");
		try 
		{
			BaseClass.takeScreenshot(result.getMethod().getMethodName());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
