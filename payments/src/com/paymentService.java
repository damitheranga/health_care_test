package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import sap.payment;

@Path("/payment")
public class paymentService {

	payment paymentObj = new payment();

	@GET
	@Path("/get-payments")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return paymentObj.readItems();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertpayment(@FormParam("paymentID") String paymentID,
			@FormParam("paymentDate") String paymentDate, @FormParam("paymentTime") String paymentTime,
			@FormParam("paymentMethod") String paymentMethod, @FormParam("paymentDueDate") String paymentDueDate,@FormParam("apt_ID") String apt_ID)
			 {
		String output = paymentObj.insertpayment(paymentID, paymentDate, paymentMethod,
				paymentDueDate,apt_ID);
		return output;
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatepaymant(@FormParam("paymentID") String paymentID,
			@FormParam("paymentDate") String paymentDate, @FormParam("paymentTime") String paymentTime,
			@FormParam("paymentMethod") String paymentMethod, @FormParam("paymentDueDate") String paymentDueDate,@FormParam("apt_ID") String apt_ID) {
		
		

		String output = paymentObj.updatepaymant(paymentID , paymentDate, paymentMethod, paymentDueDate,apt_ID);
		return output;
	}


	@DELETE
	@Path("/delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deletepayment(@QueryParam("paymentID") String paymentID)
	{

		String output = paymentObj.deletepayment(paymentID);
		return output;
	}
}
