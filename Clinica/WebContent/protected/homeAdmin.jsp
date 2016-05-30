<%@ page import="clinica.model.Utente" %>
<% Utente utente = (Utente)session.getAttribute("utente");
   boolean autorizzato = true;
   if (utente!=null)
	   autorizzato &= (utente.getRole().equals("admin"));
   else 
   	   autorizzato = false;
   if (!autorizzato) {
   	   out.clear();
	   RequestDispatcher rd = application.getRequestDispatcher("/login.jsp");
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
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/shop-homepage.css" rel="stylesheet">
</head>
          <img src="http://susysksiw.altervista.org/logo3.jpg">
          
<body>

  <h4><center>Area riservata all'amministrazione</center>    </h4>
                                <center>Ciao, <%out.print(utente.getUsername()); %>  , sei qui come <%out.print(utente.getRole()); %>!!!!!
                               <form  method="get" action="../userLogout" name="form">
                                	<button class="btn-default" type="submit"><font size="3" color="red">(LogOut)</font> </button>
                                	</form>
                               <br>Ecco ciò che puoi fare: 
                                 <br>
                                  <center>
<img  src="../Grafica/inseriscipaziente.png"  usemap="#link1"><map name="link1" id="link1">
<area shape="rect" coords="180, 100, 80, 200" href="nuovoPaziente.jsp"  alt="click">
</map> <img  src="../Grafica/inseriscimedico.png"  usemap="#link2"><map name="link2" id="link2">
<area shape="rect" coords="180, 100, 80, 200" href="nuovoMedico.jsp"  alt="click">
</map> <br>
<img  src="../Grafica/inserisciesame.png"  usemap="#link3"><map name="link3" id="link3">
<area shape="rect" coords="180, 100, 80, 200" href="nuovoEsame.jsp"  alt="click">
</map> <img  src="../Grafica/inseriscitipologia.png"  usemap="#link4"><map name="link4" id="link4">
<area shape="rect" coords="180, 100, 80, 200" href="nuovaTipologiaEsame.jsp"  alt="click">
</map> 
                               <br><a href="index.html">Torna alla homepage</a></center>
                                
				
</body>
</html>