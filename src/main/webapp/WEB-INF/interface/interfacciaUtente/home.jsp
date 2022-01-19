<!doctype html>
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
        <jsp:param name="style" value=""/>
        <jsp:param name="script" value=""/>
    </jsp:include>



</head>

<body>
<main>
    <%@include file="/WEB-INF/interface/partials/header.jsp"%>

    <!-- carosello -->

    <div id="carouselExampleDark" class="carousel carousel-dark slide " data-bs-ride="carousel">
        <div class="carousel-inner  " >
            <div class="carousel-item active" data-bs-interval="10000">
                <img src="../img/fotocorso.jpg" class="img-thumbnail" alt="...">
                <div class="carousel-caption d-none d-md-block" style="border-radius: 20px; background-color: rgba(155,152,152,0.4)">
                    <h2 style="color: white"><strong>SCOPRI TUTTI I CORSI CON IL RELATIVO MATERIALE!!</strong></h2>
                    <p></p>
                    <p style="color: #be2a2a"><a class="btn btn-lg btn-primary" href="/UniNotes_war_exploded/Corso/visualizzaTuttiUtente"><strong>VAI</strong></a></p>
                </div>
            </div>
            <div class="carousel-item" data-bs-interval="2000">
                <img src="../img/prefe.jpg" class="d-block w-80" alt="...">
                <div class="carousel-caption d-none d-md-block" style="border-radius: 20px; background-color: rgba(155,152,152,0.4)">
                    <h2 style="color: white"><strong>AGGIUNGI I CORSI CHE PREFERISCI ALLA TUA FAVORITE LIST!!</strong></h2>
                    <p></p>
                    <p style="color: #be2a2a"><a class="btn btn-lg btn-primary" href="/UniNotes_war_exploded/ListaPreferiti/visualizza"><strong>VAI</strong></a></p>
                </div>
            </div>
            <div class="carousel-item" data-bs-interval="2000">
                <img src="../img/lib.jpg" class="d-block w-80" alt="...">
                <div class="carousel-caption d-none d-md-block" style="border-radius: 20px; background-color: rgba(155,152,152,0.4)">
                    <h2 style="color: white"><strong>MANTIENI AGGIORNATO IL TUO LIBRETTO CON TUTTI I TUOI ESAMI!!</strong></h2>
                    <p></p>
                    <p style="color: #be2a2a" ><a class="btn btn-lg btn-primary" href="/UniNotes_war_exploded/Libretto/visualizzaLibretto"><strong>VAI</strong></a></p>
                </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>



    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing text-black">



        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">CARICA I TUOI APPUNTI.</h2>
                <p class="lead text-muted">UniNotes ti permette di condividere il tuo materiale con tutti gli utenti iscritti!</p>
            </div>
            <div class="col-md-5">
                <img class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" src="../img/appunti2.jpg" >

            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7 order-md-2">
                <h2 class="featurette-heading">SCARICA TUTTO IL MATERIALE DI CUI HAI BISOGNO.</h2>
                <p class="lead text-muted ">UniNotes ti permette di accedere al materiale di ogni corso in qualsiasi momento!</p>
            </div>
            <div class="col-md-5 order-md-1">
                <img class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" src="../img/appunti1.jpg" >

            </div>
        </div>

        <hr class="featurette-divider">

    </div><!-- /.container -->


    <!-- FOOTER -->
    <%@include file="/WEB-INF/interface/partials/footer.jsp"%>


</main>






</body>



<!--
<a href="/UniNotes_war_exploded/Utente/registazione">Registrazione</a>


<b>Corso servlet</b>
<a href="/UniNotes_war_exploded/Corso/crea">Inserimento</a>
<a href="/UniNotes_war_exploded/Corso/elimina">Elimina</a>
<a href="/UniNotes_war_exploded/Corso/modifica">Modifica</a>
<a href="/UniNotes_war_exploded/Corso/visualizza">Visualizza</a>
<a href="/UniNotes_war_exploded/Corso/visualizzaTutti">Visualizza tutti</a>



<b>Corso servlet</b>
<a href="/UniNotes_war_exploded/Materiale/inserireMateriale">Inserimento</a>
<a href="/UniNotes_war_exploded/Materiale/elimina">Elimina</a>
<a href="/UniNotes_war_exploded/Materiale/modifica">Modifica</a>
<a href="/UniNotes_war_exploded/Materiale/visualizza">Visualizza</a>
<a href="/UniNotes_war_exploded/Materiale/visualizzaTutti">Visualizza tutti</a>
</body>

-->
</html>