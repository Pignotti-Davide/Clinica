<%@page import="clinica.persistence.*"%>
<%@page import="clinica.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci nuovo esame</title>
</head>
<body>
<form method="get" action="../controllerNuovoEsame" name="form">
Seleziona Tipologia d'esame:
<select name="tipologiaEsame">
<% for(TipologiaEsame t:new TipologiaEsameDaoJPA().findAll())
	out.print( "<option value="+t.getIdTipologiaEsame()+">"+t.getNome()+"</option>");%>
</select><br>
Seleziona Paziente:
<select name="paziente">
<% for(Paziente p:new PazienteDaoJPA().findAll())
	out.print( "<option value="+p.getIdPaziente()+">"+p.getNome()+" "+p.getCognome()+"</option>");%>
</select><br>
Seleziona Medico:
<select name="medico">
<% for(Medico m:new MedicoDaoJPA().findAll())
	out.print( "<option value="+m.getIdMedico()+">"+m.getNome()+" "+m.getCognome()+"</option>");%>
</select><br>
Seleziona la data dell'esame:
<input name="dataPerL'esame" type="datetime" />
	<input type="submit" value="invia" />
	</form>
 <br><a href="index.html">Torna alla homepage</a></center>
</body>
</html>