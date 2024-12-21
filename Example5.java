package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example5 {

	public static void main(String[] args) {
		// update Manu salary with 80000;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcproject","root","Rajamani@-01");
			String query="update emp set esal=? where ename=?";
			PreparedStatement s=con.prepareStatement(query);
			s.setInt(1, 80000);
			s.setString(2, "Manu");
			
			s.executeUpdate();
			
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("forget to attach driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("something wrong with db or credentials");
			e.printStackTrace();
		}
	}
}