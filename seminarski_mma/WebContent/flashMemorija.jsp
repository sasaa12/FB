<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="rs.ProizvodiDAO" %>
     <%@ page import="rs.flashMemorija" %>
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
<td ><a><%@ include file="levo.jsp" %></a></td>


<%
	ArrayList<flashMemorija> lp = null;

	ProizvodiDAO od = new ProizvodiDAO();
	
	lp=od.selectflashMemorija();
	
	if (lp != null && lp.size()>0){
%>


<td>

<table  width="100%" height="100px" align="left" >

		<tr height="32px"></tr>
		<%for (flashMemorija pom : lp){%>
		<tr >
		
			<td height="70px" width="130px"><h3><img alt="p" src="<%=pom.getSlika() %>" height="75px" width="90px"></h3></td>
			<td height="70px"><h3><%=pom.getProizvodjac() %></h3></td>
			<td height="70px"><h3><%=pom.getModel() %></h3></td>
			<td height="70px"><h3><%=pom.getKapacitet() %></h3></td>
			<td height="70px"><h3><%=pom.getCena() %></h3></td>
			
			
			<td  height="70px" width="130px"><input type="button" onclick="location.href='ServletKorpa?fsifra=<%=pom.getSifra() %>'" value="dodaj"></td>
		
		</tr>
		<%} %>
	</table>
</td>

</tr>
</table>


	
	
<%} else{%>
	 !!!
<%} %>

<a><%@ include file="footer.jsp" %></a>

</body>
</html>