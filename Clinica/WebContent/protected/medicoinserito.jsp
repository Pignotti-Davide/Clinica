<%@ page import="clinica.model.Utente" %>
<% Utente utente = (Utente)session.getAttribute("utente");
   boolean autorizzato = true;
   if (utente!=null)
	   autorizzato &= (utente.getRole().equals("admin"));
   else 
   	   autorizzato = false;
   if (!autorizzato) {
   	   out.clear();
	   RequestDispatcher rd = application.getRequestDispatcher("/error.jsp");
   	   rd.forward(request, response);
	   return;
	}
%>

<%@ page import="clinica.model.TipologiaEsame"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - Area amministrazione</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-homepage.css" rel="stylesheet">
</head>

<body>
<img src="http://susysksiw.altervista.org/logo3.jpg">

	<h4>
		<center>Inserimento medico</center>
	</h4>
	<center>
		Hai inserito un nuovo medico <br>
        Nome:${med.nome}; <br>
        Cognome:${med.cognome}; <br>
        Specializzazione:${med.specializzazione}; <br>
		<tr>

		</tr><br>
	
		<center>
</body>
</html>
