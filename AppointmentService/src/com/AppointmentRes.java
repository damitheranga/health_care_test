package com;

//For REST Service
import javax.swing.text.Document;

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

import model.Appointment;

@Path("/Appointment")

public class AppointmentRes {

	Appointment appobj = new Appointment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readAppointment() {
		return appobj.readAppointment();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAppointment(@FormParam("appointmentPCode") String appointmentPCode,
			@FormParam("appointmentPName") String appointmentPName,
			@FormParam("appointmentPEmail") String appointmentPEmail,
			@FormParam("appointmentPAdd") String appointmentPAdd,
			@FormParam("appointmentDoctorName") String appointmentDoctorName,
			@FormParam("appointmentPTel") String appointmentPTel) {
		String output = appobj.insertAppointment(appointmentPCode, appointmentPName, appointmentPEmail, appointmentPAdd,
				appointmentDoctorName, appointmentPTel);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAppointment(String appointmentdata) {
		// Convert the input string to a JSON object
		JsonObject appointmentObject = new JsonParser().parse(appointmentdata).getAsJsonObject();
		// Read the values from the JSON object
		String appointmentID = appointmentObject.get("appointmentID").getAsString();
		String appointmentPCode = appointmentObject.get("appointmentPCode").getAsString();
		String appointmentPName = appointmentObject.get("appointmentPName").getAsString();
		String appointmentPEmail = appointmentObject.get("appointmentPEmail").getAsString();
		String appointmentPAdd = appointmentObject.get("appointmentPAdd").getAsString();
		String appointmentDoctorName = appointmentObject.get("appointmentDoctorName").getAsString();
		String appointmentPTel = appointmentObject.get("appointmentPTel").getAsString();

		String output = appobj.updateAppointment(appointmentID, appointmentPCode, appointmentPName, appointmentPEmail,
				appointmentPAdd, appointmentDoctorName, appointmentPTel);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAppointment(String appointmentdata) {
		// Convert the input string to an XML document
		org.jsoup.nodes.Document doc = Jsoup.parse(appointmentdata, "", Parser.xmlParser());
		// Read the value from the element <appointmentdata>
		String appointmentID = doc.select("appointmentID").text();
		String output = appobj.deleteAppointment(appointmentID);
		return output;
	}

}