package com.demo;

import java.sql.*;
import java.util.*;

public class EmpDAO {

	public static Connection getConnection() {
		Connection con =null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Corrected JDBC URL and arguments
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return con;
	}


	public static int Save(Employee e) {
	    Connection con = EmpDAO.getConnection();
	    int status = 0;
	    try {
	        String s1 = "insert into emp (name,password,email,country) values (?,?,?,?)";
	        PreparedStatement p = con.prepareStatement(s1);
	        p.setString(1, e.getName());
	        p.setString(2, e.getPassword());
	        p.setString(3, e.getEmail());
	        p.setString(4, e.getCountry());

	        status = p.executeUpdate();
	    } catch (SQLException e1) {
	        e1.printStackTrace();
	    }
	    return status;
	}


    public static List<Employee> getAllEMployee() {
        List<Employee> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM emp");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Employee getEMployeeByid(int id) {
        Employee e = new Employee();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM emp WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public static int update(Employee e) {
        int status = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE emp SET name=?, password=?, email=?, country=? WHERE id=?");
            ps.setString(1, e.getName());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());
            ps.setInt(5, e.getId());
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static void delte(int id) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM emp WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
