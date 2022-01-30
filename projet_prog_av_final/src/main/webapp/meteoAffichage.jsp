<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="datatypes.*" %>
<%@ page import="entity.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Miage Weather</title>
  <link rel="stylesheet" href="./css/style.css">
</head>
<body>
  <ul>
  <li><a href="meteoAffichage.jsp">Météo</a></li>
  <li><a href="meteoAffichage.jsp?">Prédictions</a></li>
  <li><a href="historique.jsp">Historique</a></li>
  <li style="float:right"><a class="active" href="login.jsp">Déconnexion</a></li>
</ul> 
<form method="get" action="MeteoServlet">
    <div class="input">
      <input type="text" placeholder="Entrer une ville" class="input_text" name="ville_txt" required>
      <input type="submit" value="Submit" class="submit">
    </div>
</form>

  <div class="container">
    <div class="card">
          <h1 class="name" id="name"></h1>
    <h1 class="imgURL" id="imgURL"></h1>
      <p class="temp"></p>
      <p class="wind"></p>
      <p class="humid"></p>
      <p class="locate"></p>
      <p class="airQ"></p>
    </div>
  </div>
<%HttpSession ss= request.getSession();
String ville = (String) ss.getAttribute("ville");
if (ss.getAttribute("place")!=null) {
Place place = (Place)ss.getAttribute("place");
WindType wind = (WindType) place.getWind();
HumidityType humid = (HumidityType) place.getHumidity();
LocationType loc = (LocationType) place.getLocation();
AirQualityType airQ = (AirQualityType) place.getAirQuality();
TemperatureType temp = (TemperatureType) place.getTemperature();%>
<script>
var img = document.querySelector('#name');
var main = document.querySelector('#imgURL');
var temp = document.querySelector('.temp');
var wind = document.querySelector('.wind');
var humid = document.querySelector('.humid');
var locate = document.querySelector('.locate');
var airQ = document.querySelector('.airQ');
img.innerHTML="<img src='http://openweathermap.org/img/wn/<%=ss.getAttribute("imgURL")%>.png'>";
main.innerHTML="<%=ville.toUpperCase()%>";
temp.innerHTML="<%=temp.toString()%>";
wind.innerHTML="<%=wind.toString()%>";
humid.innerHTML="<%=humid.toString()%>";
locate.innerHTML="<%=loc.toString()%>";
airQ.innerHTML="<%=airQ.toString()%>";
</script>
<%} %>
<!-- 
<script type="text/javascript">var input = document.querySelector('.input_text');
var main = document.querySelector('#name');
var temp = document.querySelector('.temp');
var desc = document.querySelector('.desc');
var clouds = document.querySelector('.clouds');
var button= document.querySelector('.submit');



button.addEventListener("click", function(name){
	var ville = document.getElementById('ville_txt').value
fetch("https://api.openweathermap.org/data/2.5/weather?q="+ville+"&appid=a4036c6f889794512116e3a729b2f0a7&lang=French&units=metric")
.then(response => response.json())
.then(data => {
  var tempValue = data['main']['temp'];
  var nameValue = data['name'];
  var descValue = data['weather'][0]['description'];

  main.innerHTML="<img src='http://openweathermap.org/img/wn/"+data['weather'][0]['icon']+".png'>"
  main.innerHTML += nameValue;
  desc.innerHTML = "Desc - "+descValue;
  temp.innerHTML = "Temp - "+tempValue;
  input.value ="";

})

.catch(err => alert('Nom de ville inconnu'));
})</script>
-->
</body>

</html>