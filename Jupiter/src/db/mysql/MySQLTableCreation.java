package db.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class MySQLTableCreation {
	public static void main(String[] args) {
		try {
			// This is java.sql.Connection. Not com.mysql.jdbc.Connection.
			Connection conn = null;

			// Step 1 Connect to MySQL.
			try {
				System.out.println("Connecting to " + MySQLDBUtil.URL);
				// add driver to mysql driver to registered driver arrayList,added static model without create a reference
				Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
				conn = DriverManager.getConnection(MySQLDBUtil.URL);
			} catch (SQLException e) {
				e.printStackTrace();
			}
            

			if (conn == null) {
				return;
			}
			
			// Step 2 Drop tables in case they exist.

			Statement stmt = conn.createStatement();
			//Drop tables with foreign key first
			String sql = "DROP TABLE IF EXISTS category";
			stmt.executeUpdate(sql);
						
			sql = "DROP TABLE IF EXISTS history";
			stmt.executeUpdate(sql);
						
			sql = "DROP TABLE IF EXISTS items";
			stmt.executeUpdate(sql);
						
			sql = "DROP TABLE IF EXISTS users";
			stmt.executeUpdate(sql);

			System.out.println("Import is done successfully.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}