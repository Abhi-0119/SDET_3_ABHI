package JDBC.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateTest
{
	@Test

	public void exeUpdateTest() throws SQLException 
	{
		Connection con = null;
		try
		{
			// register the driver
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			// connect to DB
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			//create statement
			Statement stmt = con.createStatement();
			//execute query
			int result = stmt.executeUpdate(" insert into students_info (regno, firstname, middlename,lastname) values('005','sunny','king','t')");
			if(result == 1)
			{
				System.out.println("Execute Update Passed");
			}
			else
			{
				System.out.println("Execute Update Failed");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		//close connection
		finally {
			con.close();
		}

	}

}
