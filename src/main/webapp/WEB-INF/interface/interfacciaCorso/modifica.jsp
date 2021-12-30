<%--
  Created by IntelliJ IDEA.
  User: piosantosuosso
  Date: 30/12/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>modifica</title>
</head>
<body>


<form method="post" action="/UniNotes_war_exploded/Corso/modifica">
    <input required id="idCorso" name="idCorso" placeholder="idCorso">
    <input required id="Nome" name="Nome" placeholder="Nome">
    <input required id="Descrizione" name="Descrizione" placeholder="Descrizione">
    <input required id="NomeProfessore" name="NomeProfessore" placeholder="Nome professore">
    <button type="submit" >Modifica</button>

</form>

</body>
</html>
