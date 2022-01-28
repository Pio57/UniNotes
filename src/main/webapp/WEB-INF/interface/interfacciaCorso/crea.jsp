
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>crea</title>
</head>
<body>
<c:if test="${errors != null}">
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <c:forEach items="${errors}" var="e">
            <p><strong>Error: </strong>${e}</p>
        </c:forEach>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<form method="post" action="/UniNotes_war_exploded/Corso/crea">
    <input required id="Nome" name="Nome" placeholder="Nome">
    <input required id="Descrizione" name="Descrizione" placeholder="Descrizione">
    <input required id="NomeProfessore" name="NomeProfessore" placeholder="Nome professore">
    <button type="submit" >Crea corso</button>

</form>

</body>
</html>
