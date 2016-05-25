
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - Consulta i risultati dei tuoi esami</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/shop-homepage.css" rel="stylesheet">
</head>
<img src="http://susysksiw.altervista.org/logo3.jpg">

<body>

	<h4>
		<center>Accedi ai risultati dei tuoi esami</center>
	</h4>
	<center>
		Inserisci il codice del tuo esame per consultare i risultati
		<form action="controllerPaziente" method="get">

			<div class="form-group">
				<p>${codiceError}</p>
				<label>Codice</label> <input type="text" class="form-control"
					placeholder="Username" name="username" value='${param["username"]}'>
			</div>



			<button type="submit" class="btn btn-default">Invia</button>
		</form>
		<center>
</body>
</html>
