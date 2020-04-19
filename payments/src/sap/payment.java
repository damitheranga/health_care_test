package sap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class payment {

	

	public Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/hsc", "root", "");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public String insertpayment(String paymentID, String paymentDate, String paymentMethod, String paymentDueDate, String apt_ID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}
			// create a prepared statement
			String query = "insert into payment(paymentID,paymentDate,paymentMethod,paymentDueDate,apt_ID)"
					+ " values ( ?,  ?,  ?,  ?,  ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, paymentID);
			preparedStmt.setString(2, paymentDate);
			preparedStmt.setString(3, paymentMethod);
			preparedStmt.setString(4, paymentDueDate);
			preparedStmt.setString(5, apt_ID);			

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
		return output;

	}
	
	public String readItems() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the table to be displayed
			output = "<table class=\"table\"><tr><th>payment Id</th>"
					+ "<th>payment Date</th><th>Appoinment ID</th>" + "<th>payment Method</th>"
					+ "<th>payment DueDate</th>";
			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String paymentID = rs.getString("paymentID");
				String paymentDate = rs.getString("paymentDate");
				String paymentMethod = rs.getString("paymentMethod");
				String paymentDueDate = rs.getString("paymentDueDate");
				String appoinmentId = rs.getString("apt_ID");

				
				// Add into the html table
				output += "<tr><td>" + paymentID + "</td>";
				output += "<td>" + paymentDate + "</td>";

				output += "<td>" + appoinmentId + "</td>";
				output += "<td>" + paymentMethod + "</td>";
				output += "<td>" + paymentDueDate + "</td>";
				// buttons
				output += "<td><input name=\"btnUpdate\" "
						+ " type=\"button\" class=\"btn btn-primary\" value=\"Update\"></td>"
						+ "<td><form method=\"post\" action=\"items.jsp\">" + "<input name=\"btnRemove\" "
						+ " type=\"submit\" class=\"btn btn-danger\" value=\"Remove\">"
						+ "<input name=\"itemID\" type=\"hidden\" " + " value=\"" + paymentID + "\">"
						+ "</form></td></tr>";
			}
			con.close();
			// Complete the table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String updatepaymant(String ID, String date,String method, String dueDate,String apt_ID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE payment SET paymentDate=?,apt_ID=?,paymentMethod=?,paymentDueDate=? WHERE paymentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, date);
			preparedStmt.setString(2, apt_ID);
			preparedStmt.setString(3, method);
			preparedStmt.setString(4, dueDate);
			preparedStmt.setString(5, ID);
			
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	public String deletepayment(String paymentID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from payment where paymentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(paymentID));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}

}

