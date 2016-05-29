<%@ page import="clinica.model.Utente"%>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/shop-homepage.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Area amministrazione - aggiungi nuova tipologia esame</title>
<script type="text/javascript">
function AggiungiRisultato(risultati){
var numero_risultati = risultati.value;
	var box = document.getElementById('box_risultati');
	if(numero_risultati==""){
		box.innerHTML='';
	}else{
		if(isNaN(numero_risultati)==true){
			box.innerHTML='';
		}else{
			var righe = "";
			
			// Inserisco una riga ad ogni ciclo
			for(i=1; i<=numero_risultati; i++){
				righe = righe + "Tipo Risultato n°"+i+
				" : Nome risultato: <input type='text' name='risultato"+i+"' size='10' />"+
				"<br/>";
			}
			box.innerHTML=righe;
		}
	}
}
function AggiungiRequisito(requisiti){
	var numero_requisiti = requisiti.value;
	var box = document.getElementById('box_requisiti');
	if(numero_requisiti==""){
		box.innerHTML='';
	}else{
		if(isNaN(numero_requisiti)==true){
			box.innerHTML='';
		}else{
			var righe = "";
			
			// Inserisco una riga ad ogni ciclo
			for(i=1; i<=numero_requisiti; i++){
				righe = righe + "Requisito n°"+i+
				" : Nome requisito: <input type='text' name='requisito"+i+"' size='10' />"+
				"	Descrizione requisito: <input type='text' name='descrizione_requisito"+i+"' size='40'/>"+
				"<br/>";
			}
			box.innerHTML=righe;
		}
	}
}
</script>
</head>

<body>
	<img src="../Grafica/logo3.jpg">

	<h4>Aggiungi una nuova tipologia di esame</h4>

	<form method="get" action="../controllerNuovaTipologiaEsame" name="form">
		<table border="0">
			${nomeError}
			<tr>
				<td>Nome Esame :</td>
				<td><input type='text' name='nome_Esame' value="0" /></td>
			</tr>
			<tr>
				<td>Descrizione Esame:</td>
				<td><input type="text" name="descrizione"></input></td>
			</tr>
			<tr>
				<td>Numero di requisiti :</td>
				<td><input type="text" name="num_requisiti" value="0"
					maxlength="2" onkeyup="AggiungiRequisito(this)" /></td>
				<td>Numero Risultati:</td>
				<td><input type="text" name="num_risultati" value="0"
					maxlength="2" onkeyup="AggiungiRisultato(this)"></input></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><span id='box_requisiti'> <!-- Box che conterrÃ  le righe aggiunte. Inizialmente vuoto! -->
				</span></td>
				<td><span id='box_risultati'> <!-- Box che conterrÃ  le righe aggiunte. Inizialmente vuoto! -->
				</span></td>
			</tr>
		</table>
		<input type="submit" value="invia" />
	</form>

</body>
</html>
