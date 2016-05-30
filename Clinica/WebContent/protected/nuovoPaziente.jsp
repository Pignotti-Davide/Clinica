<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/shop-homepage.css" rel="stylesheet">
</head>
<body>
<img src="../Grafica/logo3.jpg">
          
	<center><h4>Aggiungi un nuovo paziente</h4>

	<form method="get" action="../ControllerNuovoPaziente" name="form">
		           <font size="3" color="red">${nomeError}</font> <br>
			<br>
			<tr>
				<td>Nome Paziente :</td>
				<td><input type='text' name='nome_Paziente' placeholder="nome"/></td><br>
			</tr>
                   <font size="3" color="red">${cognomeError}</font> <br>
			<tr>
				<td>Cognome Paziente :</td>
				<td><input type='text' name='cognome_Paziente' placeholder="cognome" /></td><br>
			</tr>            
		 <br>
		<input type="submit" value="invia" />
	</form>
 <br><a href="index.html">Torna alla homepage</a></center>
</body>
</html>