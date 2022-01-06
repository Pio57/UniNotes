
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

    <link rel="stylesheet" href="../../../css/libretto.css" type = "text/css">

    <title>Visualizza tutti gli esami</title>
</head>
<body>

<main>
    <%@include file="/WEB-INF/interface/partials/header.jsp"%>


    <div class="container text-center" >
        <h1 style="color: black">MY LIBRETTO</h1>
        <div class="row">
            <div class="card">
                <h3>Media</h3>
                <h1>27.09</h1>
            </div>
            <div class="card">
                <h3>Cfu Accumulati</h3>
                <h1>108/150</h1>
            </div>
            <div class="card">
                <h3>Numero esami sostenuti</h3>
                <h1>13</h1>
            </div>
        </div>

        <h1 style="color: black" >Funzioni del libetto</h1>

        <button class="libretto" name="viewEsame" onclick="viewEsame()"> Visualizza il libretto </button> <br>
        <div id="viewEsami" style="display: none">
            <h4>Nome esame</h4>
            <h4>Voto</h4>
            <h4>Cfu relativi all esame sostenuto</h4>
            <h4>Data del esame</h4>
            <h4>Nome Professore</h4>
            <!--
            <form action="AdminProdotto" method="get">
                <label class="codP" for="cod">Codice Prodotto:</label>
                <input type="number" id="codP" name="cod"><br><br>
                <input type="hidden" id="rimuovi" name="rimuovi" value="true" >
                <input  type="submit" value="Submit">
            </form>-->
        </div>
    </div>


    <!-- FOOTER -->
    <%@include file="/WEB-INF/interface/partials/footer.jsp"%>


    <script>

        function viewEsame(){
            var x= document.getElementById("viewEsami");
            if (x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }
        }
    </script>

</main>



</body>
</html>
