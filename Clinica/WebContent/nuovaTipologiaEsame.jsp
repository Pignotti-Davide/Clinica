	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>	Area amministrazione - aggiungi nuova tipologia esame</title>
<script type="text/javascript">

// Funzione che permette di aggiungere elementi al form (ESEMPIO 2)
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
				righe = righe + "Requisito n�"+i+
				" : Nome requisito: <input type='text' name='requisito"+i+"' size='10' />"+
				"	Descrizione requisito: <input type='text' name='descrizione_requisito"+i+"' size='40'/>"+
				"<br/>";
			}
			// Aggiorno il contenuto del box che conterrà gli elementi aggiunti
			box.innerHTML=righe;
		}
	}
}
</script>
</head>

<body>
 <img src="http://susysksiw.altervista.org/logo3.jpg">
          
	<h4>Aggiungi una nuova tipologia di esame</h4>

	<form method="get" action="controllerTipologiaEsame" name="form">
		<table border="0">
			${nomeError}
			<tr>
				<td>Nome Esame :</td>
				<td><input type='text' name='nome_Esame' value="0"/></td>
			</tr>
			<tr>
			<td>Descrizione Esame:</td>
			<td><input type="text" name="descrizione"></input></td>
			</tr>
			<tr>
				<td>Numero di requisiti :</td>
				<td><input type="text" name="num_requisiti" value="0" maxlength="2"
					onkeyup="AggiungiRequisito(this)" /></td>
			</tr>
		</table>
		<span id='box_requisiti'> <!-- Box che conterrà le righe aggiunte. Inizialmente vuoto! -->
		</span> <input type="submit" value="invia" />
	</form>

</body>
</html>
