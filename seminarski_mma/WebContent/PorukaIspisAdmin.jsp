<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="rs.PorukaDAO"%>
<%@page import="rs.Poruka"%>
<%@page import="java.util.ArrayList"%>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>
<a><%@ include file="header.jsp" %></a>
<%

ArrayList<Poruka>po =(ArrayList<Poruka>)request.getAttribute("po");
%>

<% if(po!= null && po.size()>0){ %>
<table  align="center" width="1218">
<tr height="40px" bgcolor="2F4F4F">

<th colspan="5">Poruke posetliaca sajta: </th>
</tr>
<tr height="40px" bgcolor="6C7B8B">
	<th>ID</th>
	<th>IME</th>
	<th>EMAIL</th>
	<th>TEMA</th>
	<th>PORUKA</th>
</tr>
<% for(Poruka p : po){%>
<tr bgcolor="9FB6CD" height="50px">
	<td><%=p.getIdporuke()%></td>
	<td><%=p.getIme() %></td>
	<td><%=p.getEmail() %></td>
	<td><%=p.getTema() %></td>
	<td><%=p.getPoruka() %></td>
</tr>
<%} %>
</table>

<%} else{
%>
<table align="center">
<tr>
<td colspan="3"><font color="red">NEMA PORUKA</a></td>
</tr>
</table>
<%

} %>


<a><%@ include file="footer.jsp" %></a>
</body>





</html>