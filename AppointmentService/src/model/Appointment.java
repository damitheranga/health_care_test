package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class Appointment
{
	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hcs", "root", "");
			// For testing
			System.out.print("Successfully Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertAppointment(String pcode, String pname, String pemail, String padd, String doctorName, String ptel) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the Database";
			}
			// create a prepared statement
			String query = "insert into appointment(appointmentID,appointmentPCode,appointmentPName,appointmentPEmail,appointmentPAdd,appointmentDoctorName,appointmentPTel)"
					+ " values ( ?,  ?,  ?,  ?,  ?,  ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, pcode);
			preparedStmt.setString(3, pname);
			preparedStmt.setString(4, pemail);
			preparedStmt.setString(5, padd);
			preparedStmt.setString(6, doctorName);
			preparedStmt.setString(7, ptel);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted Successfully";
		} catch (Exception e) {
			output = "Error while Inserting";
			System.err.println(e.getMessage());
		}
		return output;

	}

	public String readAppointment() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while Connecting to the Database for Reading.";
			}
			// Prepare the table to be displayed
			output = "<table border=\"1\" class=\"table\"><tr><th> Appointment Code </th>"
					+ "<th> Person Name </th><th> Person Email </th>" + "<th> Person Address </th>" + "<th> Doctor Name </th>"
					+ "<th> Person Phone No </th>" + "<th> Update </th><th> Delete </th></tr>";
			String query = "select * from appointment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) { 
				String appointmentID = Integer.toString(rs.getInt("appointmentID"));
				String appointmentPCode = rs.getString("appointmentPCode");
				String appointmentPName = rs.getString("appointmentPName");
				String appointmentPEmail = rs.getString("appointmentPEmail");
				String appointmentPAdd = rs.getString("appointmentPAdd");
				String appointmentDoctorName = rs.getString("appointmentDoctorName");
				String appointmentPTel = rs.getString("appointmentPTel");
				// Add into the html table
				output += "<tr><td>" + appointmentPCode + "</td>";
				output += "<td>" + appointmentPName + "</td>";
				output += "<td>" + appointmentPEmail + "</td>";
				output += "<td>" + appointmentPAdd + "</td>";
				output += "<td>" + appointmentDoctorName + "</td>";
				output += "<td>" + appointmentPTel + "</td>";
			
				// buttons
				output += "<td><input name=\"btnUpdate\" "
						+ " type=\"button\" class=\"btn btn-primary\" value=\"Update\"></td>"
						+ "<td><form method=\"post\" action=\"appointment.jsp\">" + "<input name=\"btnRemove\" "
						+ " type=\"submit\" class=\"btn btn-danger\" value=\"Remove\">"
						+ "<input name=\"itemID\" type=\"hidden\" " + " value=\"" + appointmentID + "\">"
						+ "</form></td></tr>";
			}
			con.close();
			// Complete the table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while Reading the Appointment Details.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateAppointment(String ID,String pcode, String pname, String pemail, String padd, String doctorName, String ptel) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while Connecting to the Database for Updating.";
			}
			// create a prepared statement
			String query = "UPDATE appointment SET appointmentPCode=?,appointmentPName=?,appointmentPEmail=?,appointmentPAdd=?,appointmentDoctorName=?,appointmentPTel=? WHERE appointmentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, pcode);
			preparedStmt.setString(2, pname);
			preparedStmt.setString(3, pemail);
			preparedStmt.setString(4, padd);
			preparedStmt.setString(5, doctorName);
			preparedStmt.setString(6, ptel);
			preparedStmt.setInt(7, Integer.parseInt(ID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated Successfully";
		} catch (Exception e) {
			output = "Error while Updating the Item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteAppointment(String appointmentID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the Database for Deleting.";
			}
			// create a prepared statement
			String query = "delete from appointment where appointmentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(appointmentID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted Successfully";
		} catch (Exception e) {
			output = "Error while Deleting the Appointment.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}