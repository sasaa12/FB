 <%@page import="rs.Narudzbenica"%>
<%@page import="rs.Procesor"%>
<%@page import="rs.ramMemorija"%>
<%@page import="rs.hardDisk"%>
<%@page import="rs.maticnaPloca"%>
<%@page import="rs.Tastatura"%>
<%@page import="rs.Mis"%>
<%@page import="rs.flashMemorija"%>
<%@page import="rs.grafickaKartica"%>
<%@page import="rs.Monitor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%HttpSession sesija1=request.getSession();
Osoba osob=(Osoba)sesija1.getAttribute("os");
if(osob!=null){%>
<body>
<a><%@ include file="header.jsp" %></a>
<% 

Narudzbenica nar=new Narudzbenica();
Float sumaram=0.0f;
Float sumaproc=0.0f;
Float sumahard=0.0f;
Float sumatas=0.0f;
Float sumamis=0.0f;
Float sumamp=0.0f;
Float sumamon=0.0f;
Float sumagk=0.0f;
Float sumafm=0.0f;


ArrayList<ramMemorija> listram=(ArrayList<ramMemorija>)sesija.getAttribute("listram");
ArrayList<Procesor> listproc=(ArrayList<Procesor>) sesija.getAttribute("listproc");
ArrayList<hardDisk> listhard=(ArrayList<hardDisk>) sesija.getAttribute("listhard"); 
ArrayList<Tastatura> listtas=(ArrayList<Tastatura>) sesija.getAttribute("listtas");
ArrayList<Mis> listmis=(ArrayList<Mis>) sesija.getAttribute("listmis");
ArrayList<Monitor> listmon=(ArrayList<Monitor>) sesija.getAttribute("listmon");
ArrayList<maticnaPloca> listmp=(ArrayList<maticnaPloca>) sesija.getAttribute("listmp");
ArrayList<flashMemorija> listfm=(ArrayList<flashMemorija>) sesija.getAttribute("listfm");
ArrayList<grafickaKartica> listgk=(ArrayList<grafickaKartica>) sesija.getAttribute("listgk");
%>


<table  width="1200px"  align="center"  >
<tr align="center" height="50px"> 
		<td colspan="5" align="center" bgcolor="green"><b><font color="white"> DOBRODOŠLI U KORPU </font></b></td>
		</tr>
<% 
if(listram!=null){
	
	for(int i=0;i<listram.size();i++){
		sumaram=sumaram+listram.get(i).getCena();
		%>



		

		<tr align="center" height="25px" bgcolor="CAFF70"> 
		<td  width="70px" height="25px"><h3><img alt="p" src="<%=listram.get(i).getSlika() %>" height="25px" width="50px"></h3></td>
		<td ><h4><%=listram.get(i).getProizvodjac() %></h4></td>
		<td ><h4><%=listram.get(i).getModel() %></h4></td>
		<td ><h4><%=listram.get(i).getBrzinaRada() %></h4></td>
		<td ><h4><%=listram.get(i).getCena() %></h4></td>
		</tr> 
		


<%}}else{ %>
<% }%>

<% if(listproc!=null){
	
	for(int i=0;i<listproc.size();i++){
		sumaproc=sumaproc+listproc.get(i).getCena();
	%>
		<tr align="center" height="25px" bgcolor="CAFF70"> 
		<td  width="70px" height="25px""><h3><img alt="p" src="<%=listproc.get(i).getSlika() %>" height="25px" width="50px"></h3></td>
		<td><h3><%=listproc.get(i).getProizvodjac() %></h3></td>
		<td ><h3><%=listproc.get(i).getModel() %></h3></td>
		<td><h3><%=listproc.get(i).getRadniTakt() %></h3></td>
		<td ><h3><%=listproc.get(i).getCena() %></h3></td>
		</tr> 
		


<%}} else { %>
<%} %>


<% if(listhard!=null){
	
	for(int i=0;i<listhard.size();i++){
		sumahard=sumahard+listhard.get(i).getCena();
	%>

		<tr align="center" height="25px" bgcolor="CAFF70">
		<td   width="70px" height="25px"><h3><img alt="p" src="<%=listhard.get(i).getSlika() %>" height="25px" width="50px"></h3></td>
		<td ><h3><%=listhard.get(i).getProizvodjac() %></h3></td>
		<td ><h3><%=listhard.get(i).getTip() %></h3></td>
		<td ><h3><%=listhard.get(i).getKapacitet() %></h3></td>
		<td ><h3><%=listhard.get(i).getCena() %></h3></td>
		</tr> 
		


<%}} else { %>
<%} %>

<% if(listtas!=null){
	
	for(int i=0;i<listtas.size();i++){
		sumatas=sumatas+listtas.get(i).getCena();
	%>

		<tr align="center" height="25px" bgcolor="CAFF70">
		<td  width="70px" height="25px"><h3><img alt="p" src="<%=listtas.get(i).getSlika() %>" height="25px" width="50px"></h3></td>
		<td ><h3><%=listtas.get(i).getProizvodjac() %></h3></td>
		<td ><h3><%=listtas.get(i).getTip() %></h3></td>
		<td ><h3><%=listtas.get(i).getModel() %></h3></td>
		<td ><h3><%=listtas.get(i).getCena() %></h3></td>
		</tr> 
		


<%}} else { %>
<%} %>

<% if(listmis!=null){
	
	for(int i=0;i<listmis.size();i++){
		sumamis=sumamis+listmis.get(i).getCena();
	%>

		<tr align="center" height="25px" bgcolor="CAFF70">
		<td   width="70px" height="25px"><h3><img alt="p" src="<%=listmis.get(i).getSlika() %>" height="25px" width="50px"></h3></td>
		<td ><h3><%=listmis.get(i).getProizvodjac() %></h3></td>
		<td ><h3><%=listmis.get(i).getTip() %></h3></td>
		<td ><h3><%=listmis.get(i).getModel() %></h3></td>
		<td ><h3><%=listmis.get(i).getCena() %></h3></td>
		</tr> 
		


<%}} else { %>
<%} %>

<% if(listmp!=null){
	
	for(int i=0;i<listmp.size();i++){
		sumamp=sumamp+listmp.get(i).getCena();
	%>

		<tr align="center" height="25px" bgcolor="CAFF70">
		<td   width="70px" height="25px"><h3><img alt="p" src="<%=listmp.get(i).getSlika() %>" height="25px" width="50px"></h3></td>
		<td ><h3><%=listmp.get(i).getProizvodjac() %></h3></td>
		<td ><h3><%=listmp.get(i).getModel() %></h3></td>
		<td ><h3><%=listmp.get(i).getMaxmemorija()%></h3></td>
		<td ><h3><%=listmp.get(i).getCena() %></h3></td>
		</tr> 
		


<%}} else { %>
<%} %>

<% if(listmon!=null){
	
	for(int i=0;i<listmon.size();i++){
		sumamon=sumamon+listmon.get(i).getCena();
	%>

		<tr align="center" height="25px" bgcolor="CAFF70">
		<td  width="70px" height="25px"><h3><img alt="p" src="<%=listmon.get(i).getSlika() %>" height="25px" width="50px"></h3></td>
		<td ><h3><%=listmon.get(i).getProizvodjac() %></h3></td>
		<td ><h3><%=listmon.get(i).getModel() %></h3></td>
		<td ><h3><%=listmon.get(i).getTipEkrana() %></h3></td>
		<td ><h3><%=listmon.get(i).getCena() %></h3></td>
		</tr> 
		


<%}} else { %>
<%} %>

<% if(listfm!=null){
	
	for(int i=0;i<listfm.size();i++){
		sumafm=sumafm+listfm.get(i).getCena();
	%>

		<tr align="center" height="25px" bgcolor="CAFF70">
		<td   width="70px" height="25px"><h3><img alt="p" src="<%=listfm.get(i).getSlika() %>" height="25px" width="50px"></h3></td>
		<td ><h3><%=listfm.get(i).getProizvodjac() %></h3></td>
		<td ><h3><%=listfm.get(i).getModel() %></h3></td>
		<td ><h3><%=listfm.get(i).getKapacitet()%></h3></td>
		<td ><h3><%=listfm.get(i).getCena() %></h3></td>
		</tr> 
		


<%}} else { %>
<%} %>

<% if(listgk!=null){
	
	for(int i=0;i<listgk.size();i++){
		sumagk=sumagk+listgk.get(i).getCena();
	%>

		<tr align="center" height="25px" bgcolor="CAFF70">
		<td  width="70px" height="25px"><h3><img alt="p" src="<%=listgk.get(i).getSlika() %>" height="25px" width="50px"></h3></td>
		<td ><h3><%=listgk.get(i).getProizvodjac() %></h3></td>
		<td ><h3><%=listgk.get(i).getModel() %></h3></td>
		<td ><h3><%=listgk.get(i).getMemorija()%></h3></td>
		<td ><h3><%=listgk.get(i).getCena() %></h3></td>
		</tr> 
		


<%}} else { %>
<%} %>


		<% if (listproc.size()>0 || listgk.size()>0 || listram.size()>0 || listhard.size() >0
				|| listtas.size()>0 || listmis.size()>0 || listmp.size()>0 || listmon.size()>0 || listfm.size()>0)  {%>
			
		<tr>
		<td align="right" colspan="3">
		<input align="right" type="button" onclick="location.href='ServletKupovina'" value="KUPI" >
		</td>
		<td align="right">
		<input type="button" onclick="location.href='ServletIsprazniKorpu'" value="ISPRAZNI KORPU">
		</td>
		<td align="right"><b><font color="red"><%=sumaproc+sumaram+sumahard+sumatas+sumamis+sumamp+sumamon+sumagk+sumafm %></font></b></td>
		</tr>
			
		<tr >
		<td colspan="3"><h4><b>${msg}</b></h4></td>
		</tr>
		
		<%} else {} %>

		
		

</table>

<% nar.setCena(sumaproc+sumaram+sumahard+sumatas+sumamis+sumamp+sumamon+sumagk+sumafm);
nar.setIme(osob.getKorisnickoIme());
sesija.setAttribute("nar", nar);
%>


<a><%@ include file="footer.jsp" %></a>
</body>
<%} else
	response.sendRedirect("LogIn.jsp");%>
</html>