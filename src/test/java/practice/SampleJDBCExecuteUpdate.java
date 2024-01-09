package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver(); // take driver from Mysql
		
		//Step 1: register the db
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/organizationdb", "root", "root");
		
		//Step 3: issue create statement
		Statement state = con.createStatement();
		
		//Step 4: execute a query
		String query = "insert into orginfo values('Amdocs',20,'Banglore');";
		int result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data is added");
		}
		
		
		//Step 5: close DB
		con.close();
		
	}

}
