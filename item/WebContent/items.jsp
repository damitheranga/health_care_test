<%@page import="com.item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
 
if (request.getParameter("itemCode") != null)
{
	item itemObj = new item();
	itemObj.connect();//For testing the connect method
	
	/*session.setAttribute("itemCode", request.getParameter("itemCode"));
	session.setAttribute("itemName", request.getParameter("itemName"));
	session.setAttribute("itemPrice", request.getParameter("itemPrice"));
	session.setAttribute("itemDesc", request.getParameter("itemDesc"));*/
	//only for inserting values for table 
	

	
	String stsMsg = itemObj.insertItem(request.getParameter("itemCode"),
	request.getParameter("itemName"),
	request.getParameter("itemPrice"),
	request.getParameter("itemDesc"));
	
	
	session.setAttribute("statusMsg", stsMsg);
	
}
 
 
 if (request.getParameter("itemID") != null)
 {
	 item itemObj = new item();
	 String stsMsg = itemObj.deleteItem(request.getParameter("itemID"));
	 session.setAttribute("statusMsg", stsMsg);
 }
 
 /*if (request.getParameter("itemCode") != null)
 {
	 item itemObj = new item();
	 
		itemObj.connect();//For testing the connect method
		
		session.setAttribute("itemCode", request.getParameter("itemCode"));
		session.setAttribute("itemName", request.getParameter("itemName"));
		session.setAttribute("itemPrice", request.getParameter("itemPrice"));
		session.setAttribute("itemDesc", request.getParameter("itemDesc"));
	 
	 String stsMsg = itemObj.updateItem(request.getParameter("itemCode"),
	 request.getParameter("itemName"),
	 request.getParameter("itemPrice"),
	 request.getParameter("itemDesc"));
	 session.setAttribute("statusMsg", stsMsg);
	 
	 String itemID = request.getParameter("itemID");
	 String sql ="select * from item where itemID='"+itemID+"'";
	 resultSet = statement.executeQuery(sql);
	 while(resultSet.next()){
 }*/
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<title>Items Management</title>
</head>
<body>

	<div class= "container">
	<h1>Item Management</h1>
	<form method="post" action="items.jsp">
  	<div class="form-group row">
    <label for="" class="col-sm-2 col-form-label">Item Code:</label>
    <div class="col-sm-10">
      <input class="form-control form-control-sm" name="itemCode" type="text">
    </div>
  	</div>
  	
  	<div class="form-group row">
  	<label for="" class="col-sm-2 col-form-label">Item Name:</label>
    <div class="col-sm-10">
      <input class="form-control form-control-sm" name="itemName" type="text">
    </div>
  	</div>
  	
  	<div class="form-group row">
  	<label for="" class="col-sm-2 col-form-label">Item Price:</label>
    <div class="col-sm-10">
      <input class="form-control form-control-sm" name="itemPrice" type="text">
    </div>
  	</div>
  	
  	<div class="form-group row">
  	<label for="" class="col-sm-2 col-form-label">	Item Description:</label>
    <div class="col-sm-10">
      <input class="form-control form-control-sm" name="itemDesc" type="text">
    </div>
  	</div>
  	

	<input class="btn btn-success" name="btnSubmit" type="submit" value="Save">
	</div>
	</form>
	</div>
	<br>

		
		<div class="alert alert-success" role="alert">
  
		<%
		out.print(session.getAttribute("statusMsg"));
		%>
		</div>

	<br>
		<%
		item itemObj = new item();
		out.print(itemObj.readItems());
		%>
</body>
</html>
	



