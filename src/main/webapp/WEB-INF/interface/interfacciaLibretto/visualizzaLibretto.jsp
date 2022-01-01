<%--
  Created by IntelliJ IDEA.
  User: damia
  Date: 30/12/2021
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Visualizza Libretto</title>
</head>
<body>
<table >
    <thead>
    <tr>
        <th>
            Id
        </th>
        <th>
           Numero di Esami superati
        </th>
        <th>
            Media ponderata
        </th>
        <th>
            CFU Totali acquisiti dal superamento degli Esami
        </th>
        <th>
            Lista esami svolti dallo studente
        </th>
    </thead>

    <tbody>
    <form method="post" action="/UniNotes_war_exploded/Esame/visualizzaTutto">
        <l:forEach items="${esame}" var="l">

            <tr>
                <td data-head="id">
                        ${l.getId()}
                </td>
                <td data-head="numEsami">
                        ${l.getNumEsami()}
                </td>
                <td data-head="media">
                        ${l.getMedia()}
                </td>
                <td data-head="cfuCrediti">
                        ${l.getCfuCrediti()}
                </td>
            </tr>

        </l:forEach>
    </form>

    </tbody>

</table>
</body>
</html>
