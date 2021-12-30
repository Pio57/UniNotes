<%--
  Created by IntelliJ IDEA.
  User: piosantosuosso
  Date: 30/12/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>visualizzaTutti</title>
</head>
<body>


<table >
    <caption><h1 > </h1></caption>

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
            Nome Professore
        </th>



    </tr>
    </thead>

    <tbody>
    <form method="post" action="/PlanetPlants_war_exploded/Account/update">
        <c:forEach items="${corsi}" var="c">

            <tr>
                <td data-head="Id">
                        ${c.getId()}
                </td>
                <td data-head="Nome">
                        ${c.getNome()}
                </td>
                <td data-head="Descrizione">
                        ${c.getDescrizione()}
                </td>
                <td data-head="Nome Professore">
                        ${c.getNomeProfessore()}
                </td>
            </tr>

        </c:forEach>
    </form>

    </tbody>

</table>

</body>
</html>
