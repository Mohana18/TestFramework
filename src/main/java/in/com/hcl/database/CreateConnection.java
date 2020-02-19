package in.com.hcl.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnection 
{
	public ResultSet DBConnection(String db,String query) throws SQLException, ClassNotFoundException, IOException
	{
		String dburl=Utils.Generic.GetPropertyValue("dburl")+db;

		String userid=Utils.Generic.GetPropertyValue("un");
		String password=Utils.Generic.GetPropertyValue("pw");
		Connection con = DriverManager.getConnection(dburl,userid,password);
		Class.forName("com.mysql.jdbc.Driver");
		Statement stmt = con.createStatement();			
		ResultSet rs=stmt.executeQuery(query);
		return rs;

	}

}
