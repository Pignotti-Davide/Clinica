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
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/shop-homepage.css" rel="stylesheet">
</head>
<img src="../Grafica/logo3.jpg">

<body>

	<h4>
		<center>Inserimento tipologia</center>
	</h4>
	<center>
		Hai inserito una nuova tipologia d'esame <br>Nome:${tip.nome}; <br>
		<tr>
		<td>Decrizione dell'esame: ${tip.descrizione}</td>
		</tr><br>
		<% 
						TipologiaEsame tipologia= (TipologiaEsame)session.getAttribute("tip");
						if(!tipologia.getPrerequisiti().isEmpty())
						out.print("Requisiti: <br>");
						for(String s:tipologia.getPrerequisiti().keySet()){
							out.print(s+": ");
							out.print(tipologia.getPrerequisiti().get(s)); 
							out.print("<br>"); 
							}
							out.print("<br> Risultati offerti: <br>");
							for(String s:tipologia.getIndicatoriRisultati()){
							out.print(s+"<br>");}%>
		<center>
</body>
</html>
