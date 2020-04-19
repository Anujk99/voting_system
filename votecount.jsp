<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
body{
background-image: url('https://answers.unity.com/storage/attachments/135164-fade.png');
  background-size: cover;

}
/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}
.button {
	background-color: magenta; /* Green */
	border: 2px;
	color: burlywood;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	margin: 4px 2px;
	cursor: pointer;
}

.button1 {
	border-radius: 8px;
}
/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* The Close Button */

	
		table{
	font-size:20px;
	font-color:BLACK;
		}
		th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: 	#696969;}
tr:nth-child(odd) {background-color: 	GREY;}
.button {
  background-color: paleturquoise; /* Green */
 
  border: windowframe;
  color: red;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  margin: 4px 2px;
  cursor: pointer;
}



</style>
</head>
<body>






	
	
	<div id="header"></div>
<body>

	 
<div id="header"></div>
<%
int id=(int)Integer.parseInt(request.getParameter("id"));
String t1=String.valueOf(id);

try {
	boolean st = false;
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:F:/vote/vote.db");
                      Statement st1= conn.createStatement();
                      String t="e"+String.valueOf(id);
                      ResultSet rs= st1.executeQuery("select * from "+t);
                      
                       
	
	
%>
<center>
	<table border=1px style="width:80%">
	  <tr>
	    <th>Candidate Id</th>
	    <th>Candidate Name</th> 
	    <th>Candidate's party</th>
	    <th>Total vote</th>
	 
		 </tr>
<%
while(rs.next())
	{
	%>
	
	 
	  <tr>
	  
	    <td><%=rs.getInt(1) %></td>
	   <td><%=rs.getString(2) %></td>
	   <td><%=rs.getString(3)%></td>
           <td><%=rs.getInt(4) %></td>
	    
           
	  </tr>
	 

	<%
	}
	%>
	 </table></center>
	
	
	
	<% conn.close();%>

	
<%}catch (Exception e) {
	System.out.println(e);
}

%>
<center>
<a href="index.html"><button class="button button1">
				<h3>Go Home</h3>
			</button></a>
</center>

</body>
</html>