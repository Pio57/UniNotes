
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/libretto.css">

    <jsp:include page="/WEB-INF/interface/partials/head.jsp">
        <jsp:param name="title" value="UniNotes-Libretto"/>
        <jsp:param name="style" value="cards"/>
        <jsp:param name="script" value=""/>
    </jsp:include>

    <title>Visualizza tutti gli esami</title>
<body>

<main>
    <%@include file="/WEB-INF/interface/partials/header.jsp"%>

        <div class="jumbotron">
            <div class="container text-center">
                <h1>My Libretto</h1>
                <div class="card">
                    <p>Media</p>
                </div>
                <div class="card">
                    <p>CFU ottenuti </p>
                </div>
                <div class="card">
                    <p>Numero di esami superati </p>
                </div>
            </div>
        </div>

        <div class="container-fluid bg-3 text-center">
            <h3>Some of my Work</h3><br>
            <div class="row">
                <p>Nome dello Studente </p>

                <div class="col-sm-3">
                    <p>Materia Esame</p>
                    <p>Voto</p>
                    <p>CFU</p>
                    <p>Nome professore</p>
                    <p>Data Esame</p>
                </div>

            </div>
        </div><br>

          <!-- FOOTER -->
    <%@include file="/WEB-INF/interface/partials/footer.jsp"%>

</main>

</body>
</html>
