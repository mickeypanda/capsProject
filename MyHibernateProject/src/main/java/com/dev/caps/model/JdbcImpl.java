package com.dev.caps.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dev.caps.beans.Person;

public class JdbcImpl implements PersonDAO {
	
	public void create(Person person) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbUrl="jdbc:mysql://localhost:3306/capsv4_db";
			con = DriverManager.getConnection(dbUrl,"root","root"); 

			String sql = "insert into movies_info values(?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,person.getPerId());
			pstmt.setString(2,person.getName());
			pstmt.setInt(3, person.getAge());
			pstmt.setString(4, person.getEmail());
			pstmt.setString(5, person.getAddress());
			
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println("Person details Saved");
			}else {
				System.out.println("Failed!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public void update() {
		//to be implemented
	}
	
	public void delete() {
		//to be implemented
	}
	
	public void search(int perId) {
		//to be implemented
	}
}
