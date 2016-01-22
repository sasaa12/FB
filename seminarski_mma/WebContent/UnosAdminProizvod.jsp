<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online shop MMA</title>
<link rel="icon" href="http://www.winwin.rs/skin/frontend/winwin/default/favicon.ico" type="image/x-icon" />
</head>
<body>




<a><%@ include file="header.jsp" %></a>


<table align="center" width="90%" cellspacing="1">
<tr>
<td >
<a href="adminMeni.jsp">BACK</a></td>
<td >
<table align="center" border="1">
<tr>
<th><form action="ServletAdminUnosProcesor"method="post">
<table>
<tr><td align="center"><font size="5" color="green"> PROCESOR UNOS:</font></td></tr>
<tr align="right"><th>Šifra :<input type="text"name="sifra"> </th> </tr>
<tr align="right"><th>Proizvodjač :<input type="text"name="proizvodjac"> </th> </tr>
<tr align="right"><th>Model :<input type="text"name="model"> </th> </tr>
<tr align="right"><th>Cena :<input type="text"name="cena"> </th> </tr>
<tr align="right"><th>Radni takt :<input type="text"name="radniTakt"> </th> </tr>
<tr align="right"><th>Socket :<input type="text"name="socket"> </th> </tr>
<tr align="right"><th>Slika:<input type="text"name="slika"> </th> </tr>
<tr align="right"><th>Garancija:<input type="text"name="garancija"> </th> </tr>
<tr align="right"><th>Akcija:<input type="text"name="akcija"> </th> </tr>
<tr><th colspan="2"><font color="red"> ${msg1 }</font></th></tr>
<tr align="center"><th colspan="2"><input type="submit"value="Posalji"> </th> </tr>
</table>
</form> </th>
<th><form action="ServletAdminUnosRAm"method="post">
<table>
<tr><td align="center"><font size="5"color="green"> RAM MEMORIJA UNOS:</font></td></tr>
<tr align="right"><th>Šifra :<input type="text"name="sifra"> </th> </tr>
<tr align="right"><th>Proizvodjac :<input type="text"name="proizvodjac"> </th> </tr>
<tr align="right"><th>Model :<input type="text"name="model"> </th> </tr>
<tr align="right"><th>Cena :<input type="text"name="cena"> </th> </tr>
<tr align="right"><th>Brzina rada :<input type="text"name="brzinaRada"> </th> </tr>
<tr align="right"><th>Kapacitet :<input type="text"name="kapacitet"> </th> </tr>
<tr align="right"><th>Tip:<input type="text"name="tip"> </th> </tr>
<tr align="right"><th>Slika:<input type="text"name="slika"> </th> </tr>
<tr align="right"><th>Garancija:<input type="text"name="garancija"> </th> </tr>
<tr align="right"><th>Akcija:<input type="text"name="akcija"> </th> </tr>
<tr><th colspan="2"><font color="red"> ${msg2 }</font></th></tr>
<tr align="center"><th colspan="2"><input type="submit"value="Posalji"> </th> </tr>
</table>
</form>
</th>
</tr>
<tr>
<th><form action="ServletAdminUnosTastatura"method="post">
<table>
<tr><td align="center"><font size="5"color="green"> TASTATURA UNOS:</font></td></tr>
<tr align="right"><th>Šifra :<input type="text"name="sifra"> </th> </tr>
<tr align="right"><th>Proizvodjac :<input type="text"name="proizvodjac"> </th> </tr>
<tr align="right"><th>Model :<input type="text"name="model"> </th> </tr>
<tr align="right"><th>Cena :<input type="text"name="cena"> </th> </tr>
<tr align="right"><th>Tip:<input type="text"name="tip"> </th> </tr>
<tr align="right"><th>Slika:<input type="text"name="slika"> </th> </tr>
<tr align="right"><th>Garancija:<input type="text"name="garancija"> </th> </tr>
<tr align="right"><th>Akcija:<input type="text"name="akcija"> </th> </tr>
<tr><th colspan="2"><font color="red"> ${msg3 }</font></th></tr>
<tr align="center"><th colspan="2"><input type="submit"value="Posalji"> </th> </tr>
</table>
</form> </th>
<th><form action="ServletAdminUnosMis"method="post">
<table>
<tr><td align="center"><font size="5"color="green"> MIŠ UNOS:</font></td></tr>
<tr align="right"><th>Šifra :<input type="text"name="sifra"> </th> </tr>
<tr align="right"><th>Proizvodjac :<input type="text"name="proizvodjac"> </th> </tr>
<tr align="right"><th>Model :<input type="text"name="model"> </th> </tr>
<tr align="right"><th>Cena :<input type="text"name="cena"> </th> </tr>
<tr align="right"><th>Tip:<input type="text"name="tip"> </th> </tr>
<tr align="right"><th>Slika:<input type="text"name="slika"> </th> </tr>
<tr align="right"><th>Garancija:<input type="text"name="garancija"> </th> </tr>
<tr align="right"><th>Akcija:<input type="text"name="akcija"> </th> </tr>
<tr><th colspan="2"><font color="red"> ${msg4 }</font></th></tr>
<tr align="center"><th colspan="2"><input type="submit"value="Posalji"> </th> </tr>
</table>
</form>
</th>
</tr>
<tr>
<th><form action="ServletAdminUnosMonitor"method="post">
<table>
<tr><td align="center"><font size="5"color="green"> MONITOR UNOS:</font></td></tr>
<tr align="right"><th>Šifra:<input type="text"name="sifra"> </th> </tr>
<tr align="right"><th>Proizvodjac:<input type="text"name="proizvodjac"> </th> </tr>
<tr align="right"><th>Model:<input type="text"name="model"> </th> </tr>
<tr align="right"><th>Cena:<input type="text"name="cena"> </th> </tr>
<tr align="right"><th>Dijagonala:<input type="text"name="dijagonala"> </th> </tr>
<tr align="right"><th>TipEkrana:<input type="text"name="tipEkrana"> </th> </tr>
<tr align="right"><th>Slika:<input type="text"name="slika"> </th> </tr>
<tr align="right"><th>Garancija:<input type="text"name="garancija"> </th> </tr>
<tr align="right"><th>Akcija:<input type="text"name="akcija"> </th> </tr>
<tr><th colspan="2"><font color="red"> ${msg5 }</font></th></tr>
<tr align="center"><th colspan="2"><input type="submit"value="Posalji"> </th> </tr>
</table>
</form>
 </th>
<th><form action="ServletAdminUnosGraficka"method="post">
<table>
<tr><td align="center"><font size="5"color="green"> GRAFIČKA UNOS:</font></td></tr>
<tr align="right"><th>Šifra :<input type="text"name="sifra"> </th> </tr>
<tr align="right"><th>Proizvodjac :<input type="text"name="proizvodjac"> </th> </tr>
<tr align="right"><th>Model :<input type="text"name="model"> </th> </tr>
<tr align="right"><th>Cena :<input type="text"name="cena"> </th> </tr>
<tr align="right"><th>Memorija :<input type="text"name="memorija"> </th> </tr>
<tr align="right"><th>Slika:<input type="text"name="slika"> </th> </tr>
<tr align="right"><th>Garancija:<input type="text"name="garancija"> </th> </tr>
<tr align="right"><th>Akcija:<input type="text"name="akcija"> </th> </tr>
<tr><th colspan="2"><font color="red"> ${msg6 }</font></th></tr>
<tr align="center"><th colspan="2"><input type="submit"value="Posalji"> </th> </tr>
</table>
</form></th>
</tr>
<tr>
<th> <form action="ServletAdminUnosHard"method="post">
<table>
<tr><td align="center"><font size="5"color="green"> HARD DISK UNOS:</font></td></tr>
<tr align="right"><th>Šifra :<input type="text"name="sifra"> </th> </tr>
<tr align="right"><th>Tip:<input type="text"name="tip"> </th> </tr>
<tr align="right"><th>Proizvodjac :<input type="text"name="proizvodjac"> </th> </tr>
<tr align="right"><th>Cena :<input type="text"name="cena"> </th> </tr>
<tr align="right"><th>Kapacitet :<input type="text"name="kapacitet"> </th> </tr>
<tr align="right"><th>Slika:<input type="text"name="slika"> </th> </tr>
<tr align="right"><th>Garancija:<input type="text"name="garancija"> </th> </tr>
<tr align="right"><th>Akcija:<input type="text"name="akcija"> </th> </tr>
<tr><th colspan="2"><font color="red"> ${msg7 }</font></th></tr>
<tr align="center"><th colspan="2"><input type="submit"value="Posalji"> </th> </tr>
</table>
</form></th>
<th><form action="ServletAdminUnosFlash"method="post">
<table>
<tr><td align="center"><font size="5"color="green"> FLEŠ MEMORIJA UNOS:</font></td></tr>
<tr align="right"><th>Šifra :<input type="text"name="sifra"> </th> </tr>
<tr align="right"><th>Proizvodjac :<input type="text"name="proizvodjac"> </th> </tr>
<tr align="right"><th>Model :<input type="text"name="model"> </th> </tr>
<tr align="right"><th>Cena :<input type="text"name="cena"> </th> </tr>
<tr align="right"><th>Kapacitet :<input type="text"name="kapacitet"> </th> </tr>
<tr align="right"><th>Slika:<input type="text"name="slika"> </th> </tr>
<tr align="right"><th>Garancija:<input type="text"name="garancija"> </th> </tr>
<tr align="right"><th>Akcija:<input type="text"name="akcija"> </th> </tr>
<tr><th colspan="2"><font color="red"> ${msg8 }</font></th></tr>
<tr align="center"><th colspan="2"><input type="submit"value="Posalji"> </th> </tr>
</table>
</form>
</th>
</tr>
<tr>
<th colspan="2"><form action="ServletAdmiUnosMaticna"method="post">
<table>
<tr><td align="center"><font size="5"color="green"> MATIČNA PLOČA UNOS:</font></td></tr>
<tr align="right"><th>Šifra :<input type="text"name="sifra"> </th> </tr>
<tr align="right"><th>Proizvodjač :<input type="text"name="proizvodjac"> </th> </tr>
<tr align="right"><th>Model :<input type="text"name="model"> </th> </tr>
<tr align="right"><th>Cena :<input type="text"name="cena"> </th> </tr>
<tr align="right"><th>Socket :<input type="text"name="socket"> </th> </tr>
<tr align="right"><th>Maksimalna memorija :<input type="text"name="maxMemorija"> </th> </tr>
<tr align="right"><th>Slika:<input type="text"name="slika"> </th> </tr>
<tr align="right"><th>Garancija:<input type="text"name="garancija"> </th> </tr>
<tr align="right"><th>Akcija:<input type="text"name="akcija"> </th> </tr>
<tr><th colspan="2"><font color="red"> ${msg9 }</font></th></tr>
<tr align="center"><th colspan="2"><input type="submit"value="Posalji"> </th> </tr>
</table>
</form></th>
</tr>
</table>
</td>

</tr>
</table>



<a><%@ include file="footer.jsp" %></a>






</body>
</html>