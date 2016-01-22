<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servis</title>
<link rel="icon" href="http://www.winwin.rs/skin/frontend/winwin/default/favicon.ico" type="image/x-icon" />
<script
    src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>
var map;
function initialize() {
  var mapOptions = {
    zoom: 14,
    center: new google.maps.LatLng(43.8971067,20.3444641)
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>

<body background="slike/pozadinaServis.jpg">

<div id="map-canvas" style="height:400px; width:600px" align="center"></div>
<br>
Cacak <br>
Svetog Save 65 Cacka <br>
Tel/Fax: (+381 32) 30-27-00,<br>

Radno vreme :<br>
08-20h radnim danom,<br>
09-19h subotom,<br>
09-16h nedeljom.<br>

<a href="index.jsp">&nbsp;&nbsp;<img  src="slike/back.jpg"></a>
</body>
</html>