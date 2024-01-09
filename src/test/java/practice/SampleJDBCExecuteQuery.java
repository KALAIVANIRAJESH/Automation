package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver(); // take driver from Mysql
		
		//Step 1: register the db
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/organizationdb", "root", "root");
		
		//Step 3: issue create statement
		Statement state = con.createStatement();
		
		//Step 4: execute a query
		ResultSet result = state.executeQuery("select * from orginfo");
		while(result.next())
		{
			System.out.println(result.getString(1)+result.getInt(2)+result.getString(3));
		}
		
		//Step 5: close DB
		con.close();
		
		
	}

}
