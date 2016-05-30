<%@ page import="clinica.model.Utente" %>
<%@ page import="clinica.model.Utente" %>
<% Utente utente = (Utente)session.getAttribute("utente");
   boolean autorizzato = true;
   if (utente!=null)
	   out.clear();
   RequestDispatcher rd = application.getRequestDispatcher("/index.html");
	   rd.forward(request, response);
	  
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - Errore</title>
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">
</head>
          <img src="Grafica/logo3.jpg">
          
<body>

  <h4><center>Sei già loggato come <%  out.print(utente.getUsername());%></center>    </h4>
                           	  <center><h4><a href="index.html">Torna alla homepage</a>
                           	  <br><button class="btn-default" type="submit"><font size="3" color="red">(LogOut)</font> </button>
                                </h4>    
</body>
</html>
