<%@ page import="clinica.model.Utente" %>
<% Utente utente = (Utente)session.getAttribute("utente");
   boolean autorizzato = true;
   if (utente!=null)
	   autorizzato &= (utente.getRole().equals("utente"));
   else 
   	   autorizzato = false;
   if (!autorizzato) {
   	   out.clear();
	   RequestDispatcher rd = application.getRequestDispatcher("/error.jsp");
   	   rd.forward(request, response);
	   return;
	}
%>


<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - Area utente</title>
    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/shop-homepage.css" rel="stylesheet">
</head>
          <img src="../Grafica/logo3.jpg">
          
<body>

  <h4><center>Area dedicata agli utenti</center>    </h4>
                             <center>Ciao, <%out.print(utente.getUsername()); %>  , sei qui come <%out.print(utente.getRole()); %>.  <form  method="get" action="../userLogout" name="form">
                                	<button class="btn-default" type="submit"><font size="3" color="red">(LogOut)</font> </button>
	</form>
		           <font size="3" color="red">${codeError}</font> <br>
                               <br>Per consultare i risultati degli esami inserisci il codice:
                              <form method="get" action="controllerRisultati" name="form">
		           <font size="3" color="red">${codeError}</font> <br>
			<br>
			<tr>
				
				<td><input type='text' name='code' placeholder="codice"/></td><br>
			</tr>
		<input type="submit" value="invia" />
	</form>
                                   <br><a href="index.html">Torna alla homepage</a>
                                  
                                
				
</body>
</html>