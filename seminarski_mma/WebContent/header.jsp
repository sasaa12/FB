
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page import="rs.Osoba" %>  
      <%@ page import="rs.Admin" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table  align="center" width="90%" cellspacing="1"> 
<tr>
<th colspan = "5"><h1 align="left"><img src="slike/pozadinao2.jpg" width="100%"height="200 px"></h1>

<%
HttpSession sesija = request.getSession();
Osoba osoba = (Osoba)sesija.getAttribute("os");

HttpSession sesija2 = request.getSession();
Admin a = (Admin)sesija2.getAttribute("admin");

if(osoba!=null){
%>

<%=osoba.getKorisnickoIme() %>
<a href="ServletLogIn" >Odjavite se</a><br>
<% }else{
	
	if(a!=null){
		%>
	
		<%=a.getKorisnickoime() %>
		<a href="ServletLogIn" >Odjavite se</a><br>
		
	<%}else{%>

	

<a href="LogIn.jsp" >Prijavite se</a>
<%}} %>

 </th>
</tr>

<tr height="60px"  >
<th  align="center"><a href="ServletRandom"><img src="slike/1.jpg" height="60"width="150px"></a></th>
<th  align="center"><a href="ServletAkcija"><img src="slike/2.jpg" height="60"width="150px"></a></th>
<th  align="center"><a href="korpa.jsp"><img src="slike/3.jpg" height="60"width="150px"></a></th>
<th  align="center"><a href="servis.jsp"><img src="slike/5.jpg" height="60"width="150px"></a></th>
<th  align="center"><a href="kontakt.jsp"><img src="slike/4.jpg" height="60"width="150px"></a></th>
</tr>

</table>



</body>
</html>