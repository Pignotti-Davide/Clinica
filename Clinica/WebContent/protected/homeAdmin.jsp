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
          <img src="http://susysksiw.altervista.org/logo3.jpg">
          
<body>

  <h4><center>Area riservata all'amministrazione</center>    </h4>
                                <center>Ciao, <%out.print(utente.getUsername()); %>  , sei qui come <%out.print(utente.getRole()); %>!!!!!
                               <form  method="get" action="../userLogout" name="form">
                                	<button class="btn-default" type="submit"><font size="3" color="red">(LogOut)</font> </button>
                                	</form>
                               <br>Ecco ciò che puoi fare: 
                                 <br><a href="nuovoMedico.jsp">Inserisci un medico</a>
                                
                                     <br><a href="protected/nuovoPaziente.jsp">Inserisci un paziente</a>
                                       <br><a href="index.html">Torna alla homepage</a>
                               <br><a href="index.html">Torna alla homepage</a></center>
                                
				
</body>
</html>