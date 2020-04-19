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

import model.Doctor;

@Path("/Doctor")

public class DoctorService {
	Doctor doctorObj = new Doctor();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctor() {
		return doctorObj.readDoctor();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctor(@FormParam("docCode") String docCode,
			@FormParam("docname") String docname, @FormParam("docaddr") String docaddr,
			@FormParam("doctell") String doctell, @FormParam("docmaill") String docmaill) {
		String output = doctorObj.insertDoctor( docCode, docname, docaddr, doctell,
				docmaill);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(String doctorData) {
		// Convert the input string to a JSON object
		JsonObject doctorObject = new JsonParser().parse(doctorData).getAsJsonObject();
		// Read the values from the JSON object
		String docid = doctorObject.get("docid").getAsString();
		String docCode = doctorObject.get("docCode").getAsString();
		String docname = doctorObject.get("docname").getAsString();
		String docaddr = doctorObject.get("docaddr").getAsString();
		String doctell = doctorObject.get("doctell").getAsString();
		String docmaill = doctorObject.get("docmaill").getAsString();
		
		String output = doctorObj.updateDoctor(docid, docCode, docname, docaddr, doctell,docmaill);
		return output;
	}


	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctor(String doctorData)
	{
	//Convert the input string to an XML document
	org.jsoup.nodes.Document doc = Jsoup.parse(doctorData, "", Parser.xmlParser());
	//Read the value from the element <itemID>
	String docid = doc.select("docid").text();
		String output = doctorObj.deleteDoctor(docid);
		return output;
	}

}
