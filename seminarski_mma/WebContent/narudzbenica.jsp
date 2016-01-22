<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="rs.ProizvodiDAO"%>
<%@page import="rs.Narudzbenica"%>
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

ArrayList<Narudzbenica>po =(ArrayList<Narudzbenica>)request.getAttribute("po");
%>

<% if(po!= null && po.size()>0){ %>
<table  align="center" width="1219px">
<tr height="30px" bgcolor="orange">
<th colspan="4"><font color="black"><b><h4>NARUDZBINE:</h4></b></font></th>
</tr>
<tr height="30px" bgcolor="CD661D">
	<th>ID</th>
	<th>KORISNIČKO IME</th>
	<th>UKUPNA CENA</th>
	<th>VREME</th>
	
</tr>
<% for(Narudzbenica p : po){%>
<tr bgcolor="FOFFFO" height="30px">
	<td><%=p.getId()%></td>
	<td><%=p.getIme() %></td>
	<td><%=p.getCena() %>&nbsp<a>dinara</a></td>
	<td><%=p.getVreme() %></td>

</tr>
<%} %>



</table>

<%} else{
%>

<table align="center">
<tr>
<td colspan="3"><font color="red">NEMA NARUDZBINA</a></td>
</tr>
</table>
<%

} %>


<a><%@ include file="footer.jsp" %></a>
</body>
</html>