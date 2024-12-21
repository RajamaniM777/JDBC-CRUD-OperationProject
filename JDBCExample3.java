package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCExample3 {

	public static void main(String[] args) {
		//insert eno=4,ename='pavan',esal=50000
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					 "jdbc:mysql://localhost:3306/jdbcproject", "root", "Rajamani@-01");
			String query="insert into emp values(?,?,?)";
			PreparedStatement s=con.prepareStatement(query);
			s.setInt(1, 4);
			s.setString(2, "pavan");
			s.setInt(3, 50000);
			
			s.executeUpdate();
			
			s.close();
			con.close();
			System.out.println("successfully inserted...check database..");
		} catch (ClassNotFoundException e) {
			System.out.println("check driver class");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("check database credentials");
			e.printStackTrace();
		}
	}
	
		

	

}
