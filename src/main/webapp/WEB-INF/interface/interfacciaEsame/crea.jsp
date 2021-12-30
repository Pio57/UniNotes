<%--
  Created by IntelliJ IDEA.
  User: piosantosuosso
  Date: 30/12/21
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>crea</title>
</head>
<body>


<form method="post" action="/UniNotes_war_exploded/Esame/crea">
    <input required id="nome" name="nome" placeholder="nome">
    <input required id="voto" name="voto" placeholder="voto">
    <input required id="cfu" name="cfu" placeholder="cfu">
    <input required id="dataEsame" name="dataEsame" placeholder="dataEsame">
    <input required id="NomeProfessore" name="NomeProfessore" placeholder="Nome professore">
    <button type="submit" >Crea Esame</button>

</form>

</body>
</html>
