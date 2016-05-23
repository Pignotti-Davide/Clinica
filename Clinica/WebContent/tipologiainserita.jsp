<%@ page import ="clinica.model.TipologiaEsame" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - Area amministrazione </title>
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">
</head>
          <img src="http://susysksiw.altervista.org/logo3.jpg">
          
<body>

  <h4><center> Inserimento tipologia</center>    </h4>
                                <center>Hai inserito una nuova tipologia d'esame 
						Nome:${tip.nome};
						<br>
						<% 
						TipologiaEsame tipo= (TipologiaEsame)session.getAttribute("tip");
						for(String s:tipo.getPrerequisiti().keySet()){
							out.print(s); 
							out.print("<br>"); 
							out.print(tipo.getPrerequisiti().get(s)); 
							}%>
				<center>
</body>
</html>
