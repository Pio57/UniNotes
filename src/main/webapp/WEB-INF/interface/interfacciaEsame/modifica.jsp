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
<form method="post" action="/UniNotes_war_exploded/Esame/modifica">
    <input required id="idEsame" name="idEsame" placeholder="idEsame">
    <input required id="nome" name="nome" placeholder="nome">
    <input required id="voto" name="voto" placeholder="voto">
    <input required id="cfu" name="cfu" placeholder="cfu">
    <input required id="dataEsame" name="dataEsame" placeholder="dataEsame">
    <input required id="nomeProfessore" name="nomeProfessore" placeholder="nomeProfessore">
    <button type="submit" >Modifica</button>

</form>
</body>
</html>
