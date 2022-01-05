
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


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

        <li class="tag__item play red">
            <a href="/UniNotes_war_exploded/ListaPrferiti/aggiungi">
                <span data-feather="heart"></span>
                Aggiungi ai preferiti</a>
        </li>


        <li class="tag__item play red">
            <a href="/UniNotes_war_exploded/Materiale/inserireMateriale">
                <span data-feather="folder-plus"></span>
                Inserisci materiale</a>
        </li>


        <li class="tag__item play red">
            <a href="/UniNotes_war_exploded/Materiale/visualizza">
                <span data-feather="folder"></span>
                Visualizza materiale</a>
        </li>
    </ul>
</div>

</body>
</html>





