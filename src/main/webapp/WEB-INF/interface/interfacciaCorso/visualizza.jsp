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


<table class="table client-table">
    <caption><h1 >  </h1></caption>

    <thead>
    <tr>

        <th>
            Id
        </th>
        <th>
            Nome
        </th>
        <th>
            Descrizione
        </th>
        <th>
            Nome professore
        </th>



    </tr>
    </thead>

    <tbody>
            <tr>
                <td data-head="Id">
                        ${Corso.getId()}
                </td>
                <td data-head="Nome">
                        ${Corso.getNome()}
                </td>
                <td data-head="Cognome">
                        ${Corso.getDescrizione()}
                </td>
                <td data-head="Email">
                        ${Corso.getNomeProfessore()}
                </td>
            </tr>
    </tbody>
</table>
</body>
</html>
