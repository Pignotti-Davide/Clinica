<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Clinica Healthy - Accedi all'area amministratore</title>
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">
</head>
          <img src="http://susysksiw.altervista.org/logo3.jpg">
          
<body>

  <h4><center>Accedi all'area amministrazione</center>    </h4>
                                <center>Effettua il login con i tuoi dati amministrazione
                                <form action="controllerPaziente" method="get">
					
					<div class="form-group">
						<p>
						${usernameError}
						</p>
						<label>Username</label> <input type="text" class="form-control"
							placeholder="Username" name="username"
							value='${param["username"]}'>
					</div>
					<div class="form-group">
						<p>
								${passwordError}
						</p>
						<label>Password</label><input type="text" class="form-control"
							placeholder="Password" name="password"
							value='${param["password"]}'>
					</div>
              
					<button type="submit" class="btn btn-default">Invia</button>
				</form><center>
</body>
</html>