<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="./css/login.css" rel="stylesheet">
<link rel="icon" href="./images/favicon-meteo.jpg" />
</head>
<body>

<form method="get" action="HelloServlet">
<div class="login">
	<div class="titreLogin">
	<h1>Miage Weather APP</h1>
	</div>
  <div class="login-triangle"></div>
  
  <h2 class="login-header">Log in</h2>

  <form class="login-container">
    <p><input type="text" name="idP" placeholder="Entrer votre identifiant" required></p>
    <p><input type="password" name="pwd" placeholder="Entrer votre mot de passe" required></p>
    <p><input type="submit" value="Connexion"></p>
    <p><input type="reset" value="Effacer"></p>
    <p class="errLog"></p>
  </form>
</div>
</form>
<%
HttpSession ss= request.getSession();
if (ss.getAttribute("erreur")!=null){%>
<script>
var err = document.querySelector('.errLog');
err.innerHTML="<%=ss.getAttribute("erreur")%>";
</script>
<%} %>
</body>
</html>