<%@ page import="java.util.ArrayList" %>
<%@ page import="Storage.ListaPreferiti.ListaPreferitiBean" %>
<%@ page import="Storage.Corso.CorsoBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>



        .button {
            margin-right: 10px;
            border-radius: 20px;
            transition-duration: 0.4s;
        }

        .button:hover {
            background-color: #6b6b6b;
            color: white;
        }





    </style>

</head>
<body>

<!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">


<a class="postcard__img_link">
    <img class="postcard__img" src="../img/card.png"  alt="Image Title" />
</a>



<div class="postcard__text t-dark">

    <h1 class="postcard__title red">${param.nome}</h1>
    <div class="postcard__subtitle small">
        <time datetime="2020-05-25 12:00:00">
            <div class="postcard__preview-txt">${param.nomeProf}</div>
        </time>
    </div>

    <div class="postcard__bar"></div>
    <div class="postcard__preview-txt">${param.descrizione}</div>
    <ul class="postcard__tagbox">
        <form action="/UniNotes_war_exploded/ListaPreferiti/toggle" method="get" >
            <input type="hidden" name="idCorso" value="${param.id}">
            <button type="submit " class="button">
                <a><span data-feather="folder-plus"></span>${param.toggle}</a>
            </button>
        </form>
        <form action="/UniNotes_war_exploded/Corso/visualizza" method="get" >
            <input type="hidden" name="idCorso" value="${param.id}">
            <button type="submit " class="button">
                <a><span data-feather="folder-plus"></span>Visualizza corso</a>
            </button>
        </form>
    </ul>
</div>

</body>
</html>





