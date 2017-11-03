package Dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Bean.Patient;

public class ServerConnection {
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/test";
	public static final String USER = "root";
	public static final String PASSWORD = "test";

	public void addPatient(Patient patient) throws SQLException, ClassNotFoundException {
		Connection con = null; 
		Class.forName(JDBC_DRIVER);
		String st = "INSERT INTO patient (first_name, last_name, age, sex)" + " values (?, ?, ?, ?)";
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pSt = con.prepareStatement(st); 
			pSt.setString(1, patient.getFirstName());
			pSt.setString(2, patient.getLastName());
			pSt.setInt(3, patient.getAge());
			pSt.setString(4, patient.getSex()); 
			pSt.execute();
			System.out.println("gets here");
			
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	public ArrayList<Patient> viewPatient() throws ClassNotFoundException, SQLException{
		ArrayList<Patient> returnList = new ArrayList<Patient>(); 
		Connection con = null; 
		Class.forName(JDBC_DRIVER);
		ResultSet rs = null; 
		Statement s = null; 
		String st = "SELECT * FROM patient";
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			s = con.createStatement();
			rs = s.executeQuery(st); 
		while (rs.next()) {
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			Integer age = rs.getInt("age"); 
			String sex = rs.getString("sex");
			Patient p = new Patient(firstName, lastName, age, sex); 
			int id = rs.getInt("id");
			p.setId(id);
			returnList.add(p); }
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return returnList; 
	}

	public void updatePatient(Patient newPatient) throws ClassNotFoundException, SQLException {
		Connection con = null; 
		Class.forName(JDBC_DRIVER);
		ResultSet rs = null; 
		PreparedStatement ps = null; 
		String st = "UPDATE patient SET first_name=?, last_name=?, age=?, sex=? WHERE id=?";
		Class.forName(JDBC_DRIVER);
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(st);
			ps.setString(1, newPatient.getFirstName());
			ps.setString(2, newPatient.getLastName());
			ps.setInt(3, newPatient.getAge());
			ps.setString(4, newPatient.getSex());
			ps.setInt(5, newPatient.getId());
			ps.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
			
		}
		
	}
	
	public void deletePatient(int id) throws ClassNotFoundException, SQLException {
		Connection con = null; 
		Class.forName(JDBC_DRIVER);
		ResultSet rs = null; 
		PreparedStatement ps = null; 
		String st = "DELETE FROM patient WHERE id=?";
		Class.forName(JDBC_DRIVER);
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(st);
			ps.setInt(1, id);
			ps.executeUpdate();
		} finally {
			if (con != null) {
				con.close();
			}
			
		}
	}
}
