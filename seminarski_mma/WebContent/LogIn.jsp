
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="rs.Osoba" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LogIn</title>
</head>
<body>

<form action="ServletLogIn" method="post">
<table align="center" bgcolor="3399CC" width="400"height="400"> 
<tr bgcolor="F0FFFF" height="40px">
<td>USERNAME:</td> 
<td><input type="text" name="korisnickoIme"></td>
</tr>

<tr bgcolor="F0FFFF" height="40px"> 
<td>PASS:</td> 
<td><input type="password" name="sifra"></td>
</tr>

<tr bgcolor="F0FFFF" height="40px"><th colspan = "2">
${msg }</th> </tr>

<tr bgcolor="F0FFFF" height="40px">
<td colspan="2"><input type="submit" name="login" value="Login"></td>
</tr>

 <tr height="70px" bgcolor="698B69">
 <td colspan="2"><a href="index.jsp"> <<--Na pocetnu </a></td>
 </tr>
 <tr height="70px" bgcolor="698B69">
 <td colspan="2"><a href="SignUp.jsp"> Registracija </a></td>
 
 </tr>
</table>
</form>
</body>
</html>