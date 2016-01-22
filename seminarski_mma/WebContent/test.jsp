<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="rs.Procesor" %>
    <%@ page import="rs.ramMemorija" %>
    <%@page import="rs.ProizvodiDAO" %>
    <%@ page import="rs.hardDisk" %>
     	<%@ page import="rs.Tastatura" %>
     	<%@ page import="rs.maticnaPloca" %>
      	<%@ page import="rs.Monitor" %>
        <%@ page import="rs.Mis" %>
        <%@ page import="rs.flashMemorija" %>
        <%@ page import="rs.grafickaKartica" %>
    <%@page import="java.util.ArrayList" %>
        <%@ page import="rs.Poruka" %>
        <%@ page import="rs.PorukaDAO" %>
        <%@ page import="rs.AdminDAO" %>
        <%@ page import="rs.Narudzbenica" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 



ProizvodiDAO da=new ProizvodiDAO ();


da.deleteNarudzbenica();
 %>
</body>
</html>