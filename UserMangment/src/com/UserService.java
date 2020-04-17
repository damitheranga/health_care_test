package com;

import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.User;

@Path("/User")

public class UserService {
	User UserObj = new User();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return UserObj.readUser();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUser(@FormParam("User_ID") String User_ID,
			@FormParam("User_Name") String User_Name, @FormParam("User_DOB") String User_DOB,
			@FormParam("User_Email") String User_Email, @FormParam("User_Gender") String User_Gender,
			@FormParam("User_Phone_No") String User_Phone_No,@FormParam("User_Address") String User_Address) {
		String output = UserObj.insertUser(User_ID, User_Name, User_DOB, User_Email,
				User_Gender, User_Phone_No, User_Address);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(String UserData) {
		// Convert the input string to a JSON object
		JsonObject UserObject = new JsonParser().parse(UserData).getAsJsonObject();
		// Read the values from the JSON object
		String UserID_tbl = UserObject.get("UserID_tbl").getAsString();
		String User_ID = UserObject.get("User_ID").getAsString();
		String User_Name = UserObject.get("User_Name").getAsString();
		String User_DOB = UserObject.get("User_DOB").getAsString();
		String User_Email = UserObject.get("User_Email").getAsString();
		String User_Gender = UserObject.get("User_Gender").getAsString();
		String User_Phone_No = UserObject.get("User_Phone_No").getAsString();
		String User_Address = UserObject.get("User_Address").getAsString();

		String output = UserObj.updateUser( UserID_tbl, User_ID, User_Name, User_DOB, User_Email, User_Gender, User_Phone_No, User_Address);
		return output;
		
	}


	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteHospital(String UserData)
	{
	//Convert the input string to an XML document
	org.jsoup.nodes.Document doc = Jsoup.parse(UserData, "", Parser.xmlParser());
	//Read the value from the element <itemID>
	String UserID_tbl = doc.select("UserID_tbl").text();
		String output = UserObj.deleteUser(UserID_tbl);
		return output;
	}

}



