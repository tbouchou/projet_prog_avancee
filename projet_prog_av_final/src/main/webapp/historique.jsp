<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="datatypes.*" %>
<%@ page import="entity.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historique</title>
<link rel="stylesheet" href="./css/histo.css">
<link rel="stylesheet" href="./css/style.css">
</head>
<%
HttpSession ss = request.getSession();
%>
<body>
  <ul>
  <li><a href="meteoAffichage.jsp">Météo</a></li>
  <li><a href="meteoAffichage.jsp?">Prédictions</a></li>
  <li><a href="historique.jsp">Historique</a></li>
  <li style="float:right"><a class="active" href="login.jsp">Déconnexion</a></li>
</ul> 
<table>
<tr>
    <th>Date</th>
    <th>Ville</th>
    <th>Température</th>
  </tr>

  <%List <WeatherReport> listWR = WeatherReport.getListWR();
  if (listWR!=null) {
  for (WeatherReport wR : listWR) {%>
  <tr>
  <%
  	if (wR.getAccount()==ss.getAttribute("compte")){
  		Date date = wR.getDate();
  		System.out.println(date);
  		String ville = wR.getVille();
  		Place place = wR.getPlace();
  		TemperatureType temp = place.getTemperature();
  		double tempT = temp.getTemperature();%>
  		<td><%=date %></td>
  		<td><%=ville %></td>
  		<td><%=tempT %></td>
  		<%}%>
  	</tr>
  	<%}
	}%>

</table>
</body>
</html>