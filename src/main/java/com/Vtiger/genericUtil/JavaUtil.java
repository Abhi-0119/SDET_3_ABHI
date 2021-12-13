package com.Vtiger.genericUtil;

import java.util.Random;

import com.github.javafaker.Faker;

/**
 * 
 * @author sunny
 *
 */
public class JavaUtil {

	 
	private JavaUtil()
	{

	}

	public static JavaUtil objForJavaUtil()
	{
		JavaUtil jv = new JavaUtil();
		return jv;

	}
	/**
	 * @author sunny
	 * Description : this method is used to create random Number
	 * @return int
	 */
	public int generateRandomNumber(int maxrange) 
	{
		Random r = new Random();
		return r.nextInt(maxrange);
	}
	
	
	public String phoneNumber() 
	{
		Faker f = new Faker();
		return f.phoneNumber().cellPhone();
	}
	/**
	 *@author sunny
	 * Description : this method is used to create random Fullname
	 * @return String
	 */
	public String genrateFullName()
	{
		Faker f = new Faker();
		return f.name().fullName();
	}
	/**
	 * @author sunny
	 * Description : this method is used to create random Firstname
	 * @return String
	 */
	public String genrateFirstName()
	{
		Faker f = new Faker();
		return f.name().firstName();
	}
	/**
	 * @author sunny
	 * Description : this method is used to create random LastName
	 * @return String
	 */
	public String genrateLastName()
	{
		Faker f = new Faker();
		return f.name().lastName();
	}

	

	

}
