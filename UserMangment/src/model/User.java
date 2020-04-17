package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class User {

		public Connection connect() {
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hcs", "root", "");
				// For testing
				System.out.print("Successfully connected");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}

		public String insertUser(String Uid, String name, String DOB, String email, String gender, String phoneNo, String Address) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database";
				}
				// create a prepared statement
				String query = "insert into usertbl(UserID_tbl,User_ID,User_Name,User_DOB,User_Email,User_Gender,User_Phone_No,User_Address)"
						+ " values (  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, Uid);
				preparedStmt.setString(3, name);
				preparedStmt.setString(4, DOB);
				preparedStmt.setString(5, email);
				preparedStmt.setString(6, gender);
				preparedStmt.setString(7, phoneNo);
				preparedStmt.setString(8, Address);

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

		public String readUser() {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for reading.";
				}
				// Prepare the table to be displayed
				output = "<table class=\"table\"><tr><th>User_ID</th>"
						+ "<th>User_Name</th>" + "<th>User_DOB</th>" + "<th>User_Email</th>" + "<th>User_Gender</th>"
						+ "<th>User_Phone_No</th>" + "<th>User_Address</th>" + "<th>Update</th><th>Remove</th></tr>";
				String query = "select * from usertbl";
				Statement stmt = con.createStatement();
				ResultSet rs =  stmt.executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next()) {
					String UserID_tbl = Integer.toString(rs.getInt("UserID_tbl"));
					String User_ID = rs.getString("User_ID");
					String User_Name = rs.getString("User_Name");
					String User_DOB = rs.getString("User_DOB");
					String User_Email = rs.getString("User_Email");
					String User_Gender = rs.getString("User_Gender");
					String User_Phone_No = rs.getString("User_Phone_No");
					String User_Address = rs.getString("User_Address");
					// Add into the html table
					output += "<tr><td>" + User_ID + "</td>";
					output += "<td>" + User_Name + "</td>";

					output += "<td>" + User_DOB + "</td>";
					output += "<td>" + User_Email + "</td>";
					output += "<td>" + User_Gender + "</td>";
					output += "<td>" + User_Phone_No + "</td>";
					output += "<td>" + User_Address + "</td>";
					// buttons
					output += "<td><input name=\"btnUpdate\" "
							+ " type=\"button\" class=\"btn btn-primary\" value=\"Update\"></td>"
							+ "<td><form method=\"post\" action=\"items.jsp\">" + "<input name=\"btnRemove\" "
							+ " type=\"submit\" class=\"btn btn-danger\" value=\"Remove\">"
							+ "<input name=\"itemID\" type=\"hidden\" " + " value=\"" + UserID_tbl + "\">"
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

		public String updateUser( String UTblId,String Uid, String name, String DOB, String email, String gender, String phoneNo, String Address) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				// create a prepared statement
				String query = "UPDATE usertbl SET User_ID=?,User_Name=?,User_DOB=?,User_Email=?,User_Gender=?,User_Phone_No=?,User_Address=? WHERE UserID_tbl=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setString(1, Uid);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, DOB);
				preparedStmt.setString(4, email);
				preparedStmt.setString(5, gender);
				preparedStmt.setString(6, phoneNo);
				preparedStmt.setString(7, Address);
				
				preparedStmt.setInt(8, Integer.parseInt(UTblId));
				
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

		public String deleteUser(String UserID_tbl) {
			String output = "";
			try {
				Connection con = connect();
				if (con == null) {
					return "Error while connecting to the database for deleting.";
				}
				// create a prepared statement
				String query = "delete from usertbl where UserID_tbl=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(UserID_tbl));
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


