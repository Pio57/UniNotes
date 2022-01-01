<%--
  Created by IntelliJ IDEA.
  User: piosantosuosso
  Date: 30/12/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>visualizzaTutti</title>
</head>
<body>
<table >
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
    </thead>

    <tbody>
    <form method="post" action="/UniNotes_war_exploded/Esame/visualizzaTutto">
        <e:forEach items="${esame}" var="e">

            <tr>
                <td data-head="id">
                        ${e.getId()}
                </td>
                <td data-head="nome">
                        ${e.getNome()}
                </td>
                <td data-head="voto">
                        ${e.getVoto()}
                </td>
                <td data-head="cfu">
                        ${e.getCfu()}
                </td>
                <td data-head="dataEsame">
                        ${e.getData()}
                </td>
                <td data-head="nomeProfessore">
                        ${e.getNomeProfessore()}
                </td>
            </tr>

        </e:forEach>
    </form>

    </tbody>

</table>
</body>
</html>
