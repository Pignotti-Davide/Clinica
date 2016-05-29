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
		   <script type="text/javascript" language="javascript">
function visualizza(id){
  if (document.getElementById){
    if(document.getElementById(id).style.display == 'none'){
      document.getElementById(id).style.display = 'block';
    }else{
      document.getElementById(id).style.display = 'none';
    }
  }
}
</script>
	<% 	
		TipologiaEsameDaoJPA tipdao = new TipologiaEsameDaoJPA();
		List<TipologiaEsame> lista =tipdao.findAll();
		
						for(TipologiaEsame tipo: lista){
							%>
							<div id="testo"><a href="#" onclick="visualizza('immagine<%out.print(lista.indexOf(tipo));%>'); return false">
<%out.print(tipo.getNome()); %></a></div>
							<%if(tipo.getPrerequisiti().isEmpty())
								out.print("Nessuno requisito richiesto"); 
							out.print("<br>"); %>
								<div id="immagine<%out.print(lista.indexOf(tipo));%>" style="display:none"><%for(String s:tipo.getPrerequisiti().keySet()){
									out.print(tipo.getPrerequisiti().get(s));out.print("<br>"); }%></div>
								
								
								<%
							out.print("<br>"); 
							
							out.print("------------------------------");
							out.print("<br>"); 
							}%>
		<tr>
  <h4><a href="index.html">Torna alla homepage</a>
                                </h4>
		</tr>
		<br>

		<center>
</body>
</html>

