
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">


    <jsp:include page="/WEB-INF/interface/partials/head.jsp">
        <jsp:param name="title" value="UniNotes-Home"/>
        <jsp:param name="style" value="cards"/>
        <jsp:param name="script" value=""/>
    </jsp:include>

    <title>Visualizza tutti i corsi</title>
<body>

<main>
    <%@include file="/WEB-INF/interface/partials/header.jsp"%>


    <div class="container embed-responsive" style="margin-top:50px;">

        <div class="row">
            <div class="col-md-3">
                <c:forEach items="${corsi}" var="c">
                <div class="card-sl">


                        <jsp:include page="/WEB-INF/interface/interfacciaCorso/cardCorso.jsp">
                            <jsp:param name="id" value="${c.getId()}"/>
                            <jsp:param name="nome" value="${c.getNome()}"/>
                            <jsp:param name="descrizione" value="${c.getDescrizione()}"/>
                            <jsp:param name="nomeProf" value="${c.getNomeProfessore()}"/>
                        </jsp:include>


                </div>
                </c:forEach>
            </div>
        </div>

    </div>


        <!-- FOOTER -->
    <%@include file="/WEB-INF/interface/partials/footer.jsp"%>

</main>

</body>
</html>