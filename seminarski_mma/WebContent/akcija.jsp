    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
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
<a><%@ include file="header.jsp" %></a>

<%
ArrayList<Procesor> procesor = (ArrayList<Procesor>)request.getAttribute("procesor"); 
ArrayList<ramMemorija> ram=(ArrayList<ramMemorija>)request.getAttribute("rammemorija");
ArrayList<hardDisk> hd=(ArrayList<hardDisk>)request.getAttribute("harddisk");
ArrayList<Tastatura> ts=(ArrayList<Tastatura>)request.getAttribute("tastatura");
ArrayList<Mis> ms=(ArrayList<Mis>)request.getAttribute("mis");
ArrayList<maticnaPloca> mp=(ArrayList<maticnaPloca>)request.getAttribute("maticnaploca");
ArrayList<Monitor> mon=(ArrayList<Monitor>)request.getAttribute("monitor");
ArrayList<grafickaKartica> grk=(ArrayList<grafickaKartica>)request.getAttribute("grafickakartica");
ArrayList<flashMemorija> fm=(ArrayList<flashMemorija>)request.getAttribute("flesmemorija");
%>

<table width="1200px" align="center">

<tr align="center" height="40px">
		<td colspan="6" align="left" bgcolor="9E9E9E"><font color="white">Procesori:</font></td>
		
		
	</tr>
	<%
	if(procesor!= null &&procesor.size()>0) {
		
		for (Procesor pom : procesor) {
		%>
		
	
	<tr align="center" height="40px" bgcolor="F7F7F7">
		<td width="40px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td ><%=pom.getRadniTakt() %></td>
		<td><%=pom.getCena()%></td>

		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?psifra=<%=pom.getSifra() %>'" value="dodaj"></td>
	</tr>

	<%

		}
	}
	else{%>
		<tr align="center" height="30px" bgcolor="545454">
		<td colspan="6">Nema procesora na akciji.</td>
		 </tr>
		
	<% }
	%>
	
	
	
	<tr align="center" height="40px">
		<td colspan="6" align="left" bgcolor="9E9E9E"><font color="white">Ram memorije:</font></td>
		
		
	</tr>
	<%
	if(ram!= null &&ram.size()>0) {
		
		for (ramMemorija pom : ram) {
		%>
		
	
	<tr align="center" height="40px" bgcolor="F7F7F7">
		<td width="40px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getBrzinaRada()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?rsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
	</tr>
	
	<%

		}
	}
	else{%>
		<tr align="center" height="30px" bgcolor="545454">
		<td colspan="6">Nema ram memorije na akciji.</td>
		 </tr>
		
	<% }
	%>
	
	
	<tr align="center" height="40px">
		<td colspan="6" align="left" bgcolor="9E9E9E"><font color="white">Hard diskovi:</font></td>
		
		
	</tr>
	<%
	if(hd!= null &&hd.size()>0) {
		
		for (hardDisk pom : hd) {
		%>
		
	
	<tr align="center" height="40px" bgcolor="F7F7F7">
		<td width="40px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getTip()%></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getKapacitet()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?hsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
	</tr>
	
	<%

		}
	}
	else{%>
		<tr align="center" height="30px" bgcolor="545454">
		<td colspan="6">Nema hard diskova na akciji.</td>
		 </tr>
		
	<% }
	%>
	
	
	
	<tr align="center" height="40px">
		<td colspan="6" align="left" bgcolor="9E9E9E"><font color="white">Tastature:</font></td>
		
		
	</tr>
	<%
	if(ts!= null &&ts.size()>0) {
		
		for (Tastatura pom : ts) {
		%>
		
	
	<tr align="center" height="40px" bgcolor="F7F7F7">
		<td width="40px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getTip()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?tsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
	</tr>
	
	<%

		}
	}
	else{%>
		<tr align="center" height="30px" bgcolor="545454">
		<td colspan="6">Nema tastatura na akciji.</td>
		 </tr>
		
	<% }
	%>
	
	
	<tr align="center" height="40px">
		<td colspan="6" align="left" bgcolor="9E9E9E"><font color="white">Misevi:</font></td>
		
		
	</tr>
	<%
	if(ms!= null &&ms.size()>0) {
		
		for (Mis pom : ms) {
		%>
		
	
	<tr align="center" height="40px" bgcolor="F7F7F7">
		<td width="40px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getTip()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?msifra=<%=pom.getSifra() %>'" value="dodaj"></td>
		
	</tr>
	
	<%

		}
	}
	else{%>
		<tr align="center" height="30px" bgcolor="545454">
		<td colspan="6">Nema miseva na akciji.</td>
		 </tr>
		
	<% }
	%>
	
	
	<tr align="center" height="40px">
		<td colspan="6" align="left" bgcolor="9E9E9E"><font color="white">Maticne ploce:</font></td>
		
		
	</tr>
	<%
	if(mp!= null &&mp.size()>0) {
		
		for (maticnaPloca pom : mp) {
		%>
		

	<tr align="center" height="40px" bgcolor="F7F7F7">
		<td width="40px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getMaxmemorija()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?mpsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
	</tr>
	
	<%

		}
	}
	else{%>
		<tr align="center" height="30px" bgcolor="545454">
		<td colspan="6">Nema maticnih ploca na akciji.</td>
		 </tr>
		
	<% }
	%>
	
	<tr align="center" height="40px">
		<td colspan="6" align="left" bgcolor="9E9E9E"><font color="white">Monitori:</font></td>
		
		
	</tr>
	<%
	if(mon!= null &&mon.size()>0) {
		
		for (Monitor pom : mon) {
		%>
		

	<tr align="center" height="40px" bgcolor="F7F7F7">
		<td width="40px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getTipEkrana()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?monsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
	</tr>
	
	<%

		}
	}
	else{%>
		<tr align="center" height="30px" bgcolor="545454">
		<td colspan="6">Nema monitora na akciji.</td>
		 </tr>
		
	<% }
	%>
	
	
	<tr align="center" height="40px">
		<td colspan="6" align="left" bgcolor="9E9E9E"><font color="white">Fles memorije:</font></td>
		
		
	</tr>
	<%
	if(fm!= null &&fm.size()>0) {
		
		for (flashMemorija pom : fm) {
		%>
		
	
	<tr align="center" height="40px" bgcolor="F7F7F7">
		<td width="40px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getKapacitet()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?fsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
	</tr>
	
	<%

		}
	}
	else{%>
		<tr align="center" height="30px" bgcolor="545454">
		<td colspan="6">Nema fles memorija na akciji.</td>
		 </tr>
		
	<% }
	%>
	
	
	<tr align="center" height="40px">
		<td colspan="6" align="left" bgcolor="9E9E9E"><font color="white">Graficke kartice:</font></td>
		
		
	</tr>
	<%
	if(grk!= null &&grk.size()>0) {
		
		for (grafickaKartica pom : grk) {
		%>
		
	
	<tr align="center" height="40px" bgcolor="F7F7F7">
		<td width="40px"><img src="<%=pom.getSlika()%>"  height="40px"  width="40px" ></td>
		<td><%=pom.getProizvodjac()%></td>
		<td><%=pom.getModel()%></td>
		<td><%=pom.getMemorija()%></td>
		<td><%=pom.getCena()%></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?gsifra=<%=pom.getSifra() %>'" value="dodaj"></td>	</tr>
	
	<%

		}
	}
	else{%>
		<tr align="center" height="30px" bgcolor="545454">
		<td colspan="6">Nema grafickih kartica na akciji.</td>
		 </tr>
		
	<% }
	%>
</table>

<a><%@ include file="footer.jsp" %></a>
</body>
</html>