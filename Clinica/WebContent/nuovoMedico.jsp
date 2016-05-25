
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>	Area amministrazione - aggiungi nuovo medico</title>
</head>

<body>
 <img src="http://susysksiw.altervista.org/logo3.jpg">
          
	<h4>Aggiungi un nuovo medico</h4>

	<form method="get" action="controllerMedico" name="form">
		           <font size="3" color="red">${nomeError}</font> <br>
			<br>
			<tr>
				<td>Nome Medico :</td>
				<td><input type='text' name='nome_Medico' placeholder="nome"/></td><br>
			</tr>
                   <font size="3" color="red">${cognomeError}</font> <br>
			<tr>
				<td>Cognome Medico :</td>
				<td><input type='text' name='cognome_Medico' placeholder="cognome" /></td><br>
			</tr>
           <font size="3" color="red">${specializzazioneError}</font> <br>
            <tr>
				<td>Specializzazione medico :</td>
				<td><input type='text' name='specializzazione_Medico' placeholder="specializzazione"/></td>
			</tr>
		 <br>
		<input type="submit" value="invia" />
	</form>

</body>
</html>