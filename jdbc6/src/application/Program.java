package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) { 
		
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller BaseSalary = 2090 WHERE Departament = 1");
		
			//erro provocada
			int x =1;
			if(x < 2) {
				throw new SQLException("erro falso");
				}
			// =============
			
			int rows2 = st.executeUpdate("UPDATE seller BaseSalary = 3090 WHERE Departament = 2");
	
			System.out.println("rows1 " + rows1);
			System.out.println("rows2 " + rows2);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}