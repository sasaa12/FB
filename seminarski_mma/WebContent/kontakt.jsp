
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a><%@ include file="header.jsp" %></a>

<form action="ServletPoruka"method="post">

<table align="center" bgcolor="6C7B8B" width="1200px" align="left"">
<tr bgcolor="6C7B8B">
<br>
<th colspan="2"><h1>Posaljite poruku:</h1></th>

</tr>

<tr align="left" height="50px" bgcolor="BBBBBB">
<td>Ime: </td>
<td><a><input type="text" name="name"> </a></td>
</tr>

<tr align="left" height="50px"bgcolor="BBBBBB">
<td>Email: </td>
<td><a><input type="text" name="email"> </a></td>
</tr>

<tr align="left" height="50px" bgcolor="BBBBBB">
<td>Tema: </td>
<td><a><input type="text" name="tema"> </a></td>
</tr>


<tr  align="left" height="50px" bgcolor="BBBBBB">
<td>Vasa poruka: </td>
<td><textarea name="coment" cols="25" rows="5"></textarea> </td>

</tr>

<tr align="center" height="50px" bgcolor="BBBBBB">
<th colspan = "2"><font color="red"> ${msg }</font>
</th>
</tr>

<tr align="center" height="50px" bgcolor="BBBBBB">
<th colspan="2" width="100px">
<input type="submit" name="submit" value="posalji">
</th>

</tr>


</table>




</form>

<a><%@ include file="footer.jsp" %></a>



</body>
</html>