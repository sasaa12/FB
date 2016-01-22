
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="ServletReg" method="post">
<table align="center" bgcolor="777777"  width="400"height="400"> 
<tr height="40px" bgcolor="4EEE94">
<td>Korisnicko ime:</td> 
<td><input type="text" name="korisnickoIme"></td>
</tr>

<tr height="40px" bgcolor="4EEE94">
<td>Email:</td> 
<td><input type="text" name="email"></td>
</tr>
<tr height="40px"bgcolor="4EEE94">
<td>Sifra</td>
<td><input type="password" name="sifra"></td>
</tr>
<tr height="40px" bgcolor="4EEE94">
<td colspan="2"><input type="submit" name="signup" value="SignUp"></td>
</tr>

<tr height="40px" bgcolor="4EEE94">

<td colspan="2">${msg }</td>

</tr>

 <tr height="70px" bgcolor="32CD32">
 <td colspan="2"><a href="index.jsp"> <<--Na pocetnu </a></td>
 </tr>
 <tr height="70px" bgcolor="32CD32">
 <td colspan="2"><a href="LogIn.jsp"> Na prijavu </a></td>
 
 </tr>
</table>
</form>

</body>
</html>