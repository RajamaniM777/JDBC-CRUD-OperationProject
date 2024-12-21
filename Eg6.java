package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Eg6 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcproject","root","Rajamani@-01");
			String query="delete from emp where ename like '?'";
			PreparedStatement s=con.prepareStatement(query);
			s.executeUpdate();
			s.setString(1, "r%");
			s.close();
			con.close();
					
		} catch (ClassNotFoundException e) {
			System.out.println("forget to attach Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("something wrong in db or credentials");
			e.printStackTrace();
		}

	}

}
