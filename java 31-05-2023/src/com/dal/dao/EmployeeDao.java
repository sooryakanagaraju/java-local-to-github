package com.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dal.model.Employee;
import com.dal.util.MyDbConnection;

public class EmployeeDao {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	public void insertEmployee(Employee emp) {
		
		con =MyDbConnection.getMyConnection();
		try {
			ps =con.prepareStatement("insert into DedEMP values(?,?)");
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			int noofrows =ps.executeUpdate();
			System.out.println(noofrows + " got inserted into DB successfully!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void showEmployee() {
		con =MyDbConnection.getMyConnection();
		try {
			stmt =con.createStatement();
			rs =stmt.executeQuery("select * from DedEMP");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void updateEmployee(int empno, Employee emp) {
	    try (Connection con = MyDbConnection.getMyConnection();
	         PreparedStatement ps = con.prepareStatement("UPDATE DedEMP SET ename = ? WHERE empno = ?")) {

	        ps.setString(1, emp.getEname());
	        ps.setInt(2, empno);
	        int rows = ps.executeUpdate();
	        System.out.println(rows + " rows updated ");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deleteEmployee(int empno) {
	    try (Connection con = MyDbConnection.getMyConnection();
	         PreparedStatement ps = con.prepareStatement("DELETE FROM DedEMP WHERE empno = ?")) {

	        ps.setInt(1, empno);
	        int rows = ps.executeUpdate();
	        System.out.println(rows + " rows deleted");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
		
}
