package JDBC.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQueryTest 
{
	@Test
	public void excQueryTest() throws SQLException
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
			ResultSet result = stmt.executeQuery("select * from students_info");
			while(result.next())
			{
				System.out.println(result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3)+"  "+result.getString(4));
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
