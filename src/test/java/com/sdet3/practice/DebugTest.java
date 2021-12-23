package com.sdet3.practice;

import org.testng.annotations.Test;

public class DebugTest 
{
	@Test
	public void reverse()
	{
		String a = "avadeYattehc";
		String rev = "";
		for (int i=a.length()-1;i>=0;i--)
		{
			rev=rev+a.charAt(i);
		}
		System.out.println(rev);
	}

}
