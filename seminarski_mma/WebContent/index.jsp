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


<a><%@ include file="header.jsp" %></a>

<table align="center" width="90%" cellspacing="1" background="slike/silver.jpg">
<tr> 
<td >
<a><%@ include file="levo.jsp" %></a>
</td>

<td>
<%
	Procesor p = null;

	ProizvodiDAO od = new ProizvodiDAO();
	
	p=od.getRProcesor();
	
	if (p != null ){
%>
<table  width="100%" height="100px" align="center" >

		<tr >
		
		<td height="80px" width="130px"><h3><img alt="p" src="<%=p.getSlika() %>" height="75px" width="90px"></h3></td>
		<td height="70px" width="120px"><h3><%=p.getProizvodjac() %></h3></td>
		<td height="70px" width="120px"><h3><%=p.getModel() %></h3></td>
		<td height="70px" width="120px"><h3><%=p.getRadniTakt() %></h3></td>
		<td height="70px" width="120px"><h3><%=p.getCena() %></h3></td>
			
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?psifra=<%=p.getSifra() %>'" value="dodaj"></td>
			
		
		</tr> 
		
</table>
<%} else{%>
	 !!!
<%} %>


<%
	ramMemorija rm = null;

	ProizvodiDAO oda = new ProizvodiDAO();
	
	rm=oda.getRramMemorija();
	
	if (rm != null ){
%>
<table  width="100%" height="100px" align="center"   >

		<tr > 
		
		<td height="80px" width="130px"><h3><img alt="p" src="<%=rm.getSlika() %>" height="75px" width="90px"></h3></td>
		<td height="70px" width="120px"><h3><%=rm.getProizvodjac() %></h3></td>
		<td height="70px" width="120px"><h3><%=rm.getModel() %></h3></td>
		<td height="70px" width="120px"><h3><%=rm.getBrzinaRada() %></h3></td>
		<td height="70px" width="120px"><h3><%=rm.getCena() %></h3></td>
		
			
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?rsifra=<%=rm.getSifra() %>'" value="dodaj"></td>
			
		
		</tr> 
		
</table>
<%} else{%>
	 !!!
<%} %>

<%
	hardDisk hd = null;

	ProizvodiDAO hdd = new ProizvodiDAO();
	
	hd=hdd.getRhardDisk();
	
	if (hd != null ){
%>
<table  width="100%" height="100px" align="center" >

		<tr > 
		
		<td height="80px" width="130px"><h3><img alt="p" src="<%=hd.getSlika() %>" height="75px" width="90px"></h3></td>
		<td height="70px" width="120px"><h3><%=hd.getProizvodjac() %></h3></td>
		<td height="70px" width="120px"><h3><%=hd.getTip() %></h3></td>
		<td height="70px" width="120px"><h3><%=hd.getKapacitet() %></h3></td>
		<td height="70px" width="120px"><h3><%=hd.getCena() %></h3></td>
	
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?hsifra=<%=hd.getSifra() %>'" value="dodaj"></td>
		
		</tr> 
		
</table>
<%} else{%>
	 !!!
<%} %>

<%
	Tastatura tas = null;

	ProizvodiDAO ta = new ProizvodiDAO();
	
	tas=ta.getRTastatura();
	
	if (tas != null ){
%>
<table  width="100%" height="100px"  align="center"  >

		<tr > 
		
		<td height="80px" width="130px"><h3><img alt="p" src="<%=tas.getSlika() %>" height="75px" width="90px"></h3></td>
		<td height="70px" width="120px"><h3><%=tas.getProizvodjac() %></h3></td>
		<td height="70px" width="120px"><h3><%=tas.getModel() %></h3></td>
		<td height="70px" width="120px"><h3><%=tas.getTip() %></h3></td>
		<td height="70px" width="120px"><h3><%=tas.getCena() %></h3></td>
	
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?tsifra=<%=tas.getSifra() %>'" value="dodaj"></td>
		
		</tr> 
		
</table>
<%} else{%>
	 !!!
<%} %>

<%
	Mis mis = null;

	ProizvodiDAO mi = new ProizvodiDAO();
	
	mis=mi.getRMis();
	
	if (mis != null ){
%>
<table  width="100%" height="100px"  align="center"  >

		<tr > 
		
		<td height="80px" width="130px"><h3><img alt="p" src="<%=mis.getSlika() %>" height="75px" width="90px"></h3></td>
		<td height="70px" width="120px"><h3><%=mis.getProizvodjac() %></h3></td>
		<td height="70px" width="120px"><h3><%=mis.getModel() %></h3></td>
		<td height="70px" width="120px"><h3><%=mis.getTip() %></h3></td>
		<td height="70px" width="120px"><h3><%=mis.getCena() %></h3></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?msifra=<%=mis.getSifra() %>'" value="dodaj"></td>
		
		</tr> 
		
</table>
<%} else{%>
	 !!!
<%} %>


<%
	maticnaPloca mp = null;

	ProizvodiDAO map = new ProizvodiDAO();
	
	mp=map.getRmaticnaPloca();
	
	if (mp != null ){
%>
<table  width="100%" height="100px"  align="center"  >

		<tr > 
		
		<td height="80px" width="130px"><h3><img alt="p" src="<%=mp.getSlika() %>" height="75px" width="90px"></h3></td>
		<td height="70px" width="120px"><h3><%=mp.getProizvodjac() %></h3></td>
		<td height="70px" width="120px"><h3><%=mp.getModel() %></h3></td>
		<td height="70px" width="120px"><h3><%=mp.getMaxmemorija() %></h3></td>
		<td height="70px" width="120px"><h3><%=mp.getCena() %></h3></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?mpsifra=<%=mp.getSifra() %>'" value="dodaj"></td>
		
		</tr> 
		
</table>
<%} else{%>
	 !!!
<%} %>

<%
	Monitor mon = null;

	ProizvodiDAO mo = new ProizvodiDAO();
	
	mon=mo.getRMonitor();
	
	if (mp != null ){
%>
<table  width="100%" height="100px"  align="center"  >

		<tr> 
		
		<td height="80px" width="130px"><h3><img alt="p" src="<%=mon.getSlika() %>" height="75px" width="90px"></h3></td>
		<td height="70px" width="120px"><h3><%=mon.getProizvodjac() %></h3></td>
		<td height="70px" width="120px"><h3><%=mon.getModel() %></h3></td>
		<td height="70px" width="120px"><h3><%=mon.getTipEkrana() %></h3></td>
		<td height="70px" width="120px"><h3><%=mon.getCena() %></h3></td>
	
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?monsifra=<%=mon.getSifra() %>'" value="dodaj"></td>
		
		</tr> 
		
</table>
<%} else{%>
	 !!!
<%} %>


<%
	flashMemorija fm = null;

	ProizvodiDAO fl = new ProizvodiDAO();
	
	fm=fl.getRFlasMemorija();
	
	if (fm != null ){
%>
<table  width="100%" height="100px"  align="center"  >

		<tr > 
		
		<td height="80px" width="130px"><h3><img alt="p" src="<%=fm.getSlika() %>" height="75px" width="90px"></h3></td>
		<td height="70px" width="120px"><h3><%=fm.getProizvodjac() %></h3></td>
		<td height="70px" width="120px"><h3><%=fm.getModel() %></h3></td>
		<td height="70px" width="120px"><h3><%=fm.getKapacitet() %></h3></td>
		<td height="70px" width="120px"><h3><%=fm.getCena() %></h3></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?fsifra=<%=fm.getSifra() %>'" value="dodaj"></td>
		
		</tr> 
		
</table>
<%} else{%>
	 !!!
<%} %>


<%
	grafickaKartica gk = null;

	ProizvodiDAO graf = new ProizvodiDAO();
	
	gk=graf.getRGrafickaKartica();
	
	if (gk != null ){
%>
<table  width="100%" height="100px"  align="center" >

		<tr > 
		
		<td height="80px" width="130px"><h3><img alt="p" src="<%=gk.getSlika() %>" height="75px" width="90px"></h3></td>
		<td height="70px" width="120px"><h3><%=gk.getProizvodjac() %></h3></td>
		<td height="70px" width="120px"><h3><%=gk.getModel() %></h3></td>
		<td height="70px" width="120px"><h3><%=gk.getMemorija() %></h3></td>
		<td height="70px" width="120px"><h3><%=gk.getCena() %></h3></td>
		
		<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?gsifra=<%=gk.getSifra() %>'" value="dodaj"></td>
		
		</tr> 
		
</table>
<%} else{%>
	 !!!
<%} %>
</td> 


</tr>

</table>

<a><%@ include file="footer.jsp" %></a>

</body>
</html>