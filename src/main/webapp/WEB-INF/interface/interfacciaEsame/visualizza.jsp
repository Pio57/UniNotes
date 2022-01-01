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
    <title>visualizza</title>
</head>
<body>
<table class="table esame-table">
    <thead>
    <tr>
        <th>
            Id
        </th>
        <th>
            Nome Esame
        </th>
        <th>
            Voto
        </th>
        <th>
           CFU
        </th>
        <th>
            Data di svolgimento dell' Esame
        </th>
        <th>
            Nome professore
        </th>
    </tr>
    </thead>

    <tbody>
    <tr>
        <td data-head="id">
            ${Esame.getId()}
        </td>
        <td data-head="nome">
            ${Esame.getNome()}
        </td>
        <td data-head="voto">
            ${Esame.getVoto()}
        </td>
        <td data-head="cfu">
            ${Esame.getCfu()}
        </td>
        <td data-head="dataEsame">
            ${Esame.getData()}
        </td>
        <td data-head="nomeProfessore">
            ${Esame.getNomeProfessore()}
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
