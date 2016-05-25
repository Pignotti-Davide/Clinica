<%@ page import="clinica.model.TipologiaEsame"%>
<%@ page import="clinica.persistence.TipologiaEsameDaoJPA"%>
<%@ page import="java.util.List"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - lista esami</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-homepage.css" rel="stylesheet">
</head>

<body>
	<img src="http://susysksiw.altervista.org/logo3.jpg">

	<h4>
		<center>Consulta il nostro catalogo</center>
	</h4>
	<center>
		<% 	
		TipologiaEsameDaoJPA tipdao = new TipologiaEsameDaoJPA();
		List<TipologiaEsame> lista =tipdao.findAll();
						for(TipologiaEsame tipo: lista){
							out.print(tipo.getNome()+",i cui requisiti sono:");
							out.print("<br>"); 
							if(tipo.getPrerequisiti().isEmpty())
								out.print("Nessuno requisito richiesto"); 
							out.print("<br>"); 
							for(String s:tipo.getPrerequisiti().keySet()){
								out.print(s+":");
								out.print(tipo.getPrerequisiti().get(s)); 
								out.print("<br>"); 
							}
							out.print("<br>"); 
							
							out.print("------------------------------");
							out.print("<br>"); 
							}%>

		<tr>

		</tr>
		<br>

		<center>
</body>
</html>
