<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<% 			if(a!=null)
	if(a.getKorisnickoime().equals("admin")){
%>
<% }else{
%>

<%} %>

<table align="center" width="1200">
			
			<tr height="50px">
			</tr>
			<tr>
			<td align="center"><a href="ServletIspisPoruke" ><p align="center"> <img  src="slike/porukeAdmin.jpg" width="200" height="50" ></p> </a><br>
			</td>
			</tr>
			
			<tr height="50px">
			</tr>
			<tr>
			<td align="center"><a href="ServletNarudzbenica"><p align="left"><p align="center"><img  src="slike/narudzbinaAdmin.jpg" width="200" height="50" ></p></a></th>
			</td>
			</tr>
			
			<tr height="50px">
			</tr>
			<tr>
			<td align="center"><a href="UnosAdminProizvod.jsp"><p align="center"><img  src="slike/unosAdmin.jpg" width="200" height="50" > </p></a>
			</td>
			</tr>
			</table>

<%@include file="footer.jsp" %>


</body>
</html>