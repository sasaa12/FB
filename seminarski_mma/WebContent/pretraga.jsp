<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ page import="rs.ProizvodiDAO" %>
     	<%@ page import="rs.Procesor" %>
     	<%@ page import="rs.ramMemorija" %>
     	<%@ page import="rs.hardDisk" %>
     	<%@ page import="rs.Tastatura" %>
     	<%@ page import="rs.maticnaPloca" %>
      	<%@ page import="rs.Monitor" %>
        <%@ page import="rs.Mis" %>
        <%@ page import="rs.flashMemorija" %>
        <%@ page import="rs.grafickaKartica" %>
     <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<Procesor> p = (ArrayList<Procesor>)request.getAttribute("procesor");
ArrayList<ramMemorija> rm = (ArrayList<ramMemorija>)request.getAttribute("rammemorija");
ArrayList<hardDisk> hd = (ArrayList<hardDisk>)request.getAttribute("harddisk");
ArrayList<Tastatura> ts=(ArrayList<Tastatura>)request.getAttribute("tastatura");
ArrayList<Mis> ms=(ArrayList<Mis>)request.getAttribute("mis");
ArrayList<maticnaPloca> mp=(ArrayList<maticnaPloca>)request.getAttribute("maticnaploca");
ArrayList<Monitor> mon=(ArrayList<Monitor>)request.getAttribute("monitor");
ArrayList<grafickaKartica> grk=(ArrayList<grafickaKartica>)request.getAttribute("grafickakartica");
ArrayList<flashMemorija> fm=(ArrayList<flashMemorija>)request.getAttribute("flesmemorija");
%>

<%int s=0; %>
<a><%@ include file="header.jsp" %></a>

<table width="1202" align="center">

	<tr height="40px" bgcolor="black">
		<td colspan="6" align="center"><font color="white">Rezultat pretrage:</font></td>
	</tr>
	
	
	
	<tr align="center" height="30px">
		
	</tr>
	<%
	if(p.size()>0) {
		
		int i=0;
	
		for (Procesor pom : p) {
			i++;
			
			
	%>

	<tr align="center" height="40px" bgcolor="778899">
		<td width="30px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td ><%=pom.getRadniTakt() %></td>
		<td><%=pom.getCena()%></td>
	
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?psifra=<%=pom.getSifra() %>'" value="dodaj"></td>
		
	</tr>
	
	<%

		}
	}
	else{
	s++;
	%>

		
	<% }
	%>


<%
	if(hd.size()>0) {
		
		int i=0;
	
		for (hardDisk pom : hd) {
			i++;
			
			
	%>
	
	<tr align="center" height="40px" bgcolor="778899">
		<td width="30px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px"  ></td>
		
		<td><%=pom.getTip()%></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getKapacitet()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?hsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
		
	</tr>

	<%

		}
	}
	else{
	s++;
	%>

		
	<% }
	%>

<%
	if(rm.size()>0) {
		
		int i=0;
	
		for (ramMemorija pom : rm) {
			i++;
			
			
	%>
		<tr align="center" height="40px" bgcolor="778899">
		<td width="30px"><img src="<%=pom.getSlika()%>"   height="40px"  width="40px"  ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getBrzinaRada()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?rsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
		
	</tr>
	
	<%

		}
	}
	else{
	s++;
	%>

		
	<% }
	%>
	
	
	<%
	if(ts.size()>0) {
		
		int i=0;
	
		for (Tastatura pom : ts) {
			i++;
			
			
	%>
		<tr align="center" height="40px" bgcolor="778899">
		<td width="30px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getTip()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?tsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
		
	</tr>
	
	<%

		}
	}
	else{
	s++;
	%>

		
	<% }
	%>


<%
	if(ms.size()>0) {
		
		int i=0;
	
		for (Mis pom : ms) {
			i++;
			
			
	%>
	
	<tr align="center" height="40px" bgcolor="778899">
		<td width="30px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getTip()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?msifra=<%=pom.getSifra() %>'" value="dodaj"></td>
		
	</tr>
	
	<%

		}
	}
	else{
	s++;
	%>

		
	<% }
	%>
	
	
	<%
	if(grk.size()>0) {
		
		int i=0;
	
		for (grafickaKartica pom : grk) {
			i++;
			
			
	%>
	
	<tr align="center" height="40px" bgcolor="778899">
		<td width="30px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getMemorija()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?gsifra=<%=pom.getSifra() %>'" value="dodaj"></td>	</tr>
		
	</tr>
	
	<%

		}
	}
	else{
	s++;
	%>

		
	<% }
	%>
	
	
	<%
	if(fm.size()>0) {
		
		int i=0;
	
		for (flashMemorija pom : fm) {
			i++;
			
			
	%>
	
	<tr align="center" height="40px" bgcolor="778899">
		<td width="30px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getKapacitet()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?fsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
		
	</tr>
	
	<%

		}
	}
	else{
	s++;
	%>

		
	<% }
	%>


<%
	if(mp.size()>0) {
		
		int i=0;
	
		for (maticnaPloca pom : mp) {
			i++;
			
			
	%>
	
	<tr align="center" height="40px" bgcolor="778899">
		<td width="30px"><img src="<%=pom.getSlika()%>"   height="40px"  width="40px"  ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getMaxmemorija()%></td>
		<td><%=pom.getCena()%></td>
	
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?mpsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
		
	</tr>
	
	<%

		}
	}
	else{
	s++;
	%>

		
	<% }
	%>

	<%
	if(mon.size()>0) {
		
		int i=0;
	
		for (Monitor pom : mon) {
			i++;
			
			
	%>
	
	<tr align="center" height="40px" bgcolor="778899">
		<td width="30px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getTipEkrana()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?monsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
		
	</tr>
	
	<%

		}
	}
	else{
	s++;
	%>

		
	<% }
	%>


	
<a><%@ include file="footer.jsp" %></a>

</body>
</html>