package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example4 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Drievr");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbcproject","root","Rajamani@-01");
			String query="select*from emp where esal>?";
			PreparedStatement s=con.prepareStatement(query);
			s.setInt(1, 30000);
			
			ResultSet res=s.executeQuery();
			
			while(res.next()==true) {
				System.out.println(res.getInt(1));
			}  
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("forgot to attach driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("something wrong with database and credentials");
			e.printStackTrace();
		}

	}

}
