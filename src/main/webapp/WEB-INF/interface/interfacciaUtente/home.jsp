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
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner  " >
            <div class="carousel-item active" data-bs-interval="10000">
                <img src="../../../img/5272.jpg" class="img-thumbnail" alt="...">
                <div class="carousel-caption d-none d-md-block text-start">
                    <h5>Scopri i nostri corsi</h5>
                    <p>Dai un occhiata ai corsi con i loro relativi materiali!</p>
                    <p><a class="btn btn-lg btn-primary" href="#">Visita</a></p>
                </div>
            </div>
            <div class="carousel-item" data-bs-interval="2000">
                <img src="../../../img/5272.jpg" class="d-block w-80" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Aggiungili alla tua favorite list .</h5>
                    <p>Aggiungendoli alla tua favorite liste riceverai notifiche sull'aggiunta di materiale didattico.</p>
                </div>
            </div>
            <div class="carousel-item" style="width: auto">
                <img src="..." class="d-block w-80 " alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Aggiorna il tuo libretto.</h5>
                    <p>Aggiorna il tuo libretto con gli ultimi esami che hai sostenuto..</p>
                </div>
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

        <!-- Three columns of text below the carousel -->
        <div class="row">
            <div class="col-lg-4">
                <svg class="bd-placeholder-img  rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>

                <h2>Corsi primo anno</h2>
                <p>In questa sezione ci sono i corsi del primo anno.</p>
                <p><a class="btn btn-secondary" href="#">View details &raquo;</a></p>
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>

                <h2>Corsi secondo anno</h2>
                <p>In questa sezione ci sono i corsi del secondo anno.</p>
                <p><a class="btn btn-secondary" href="#">View details &raquo;</a></p>
            </div><!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/><text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>

                <h2>Corsi terzo anno</h2>
                <p>In questa sezione ci sono i corsi del terzo anno.</p>
                <p><a class="btn btn-secondary" href="#">View details &raquo;</a></p>
            </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->


        <!-- START THE FEATURETTES -->

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">Scambiarsi gli appunti. </h2>
                <p class="lead text-muted">UniNotes permette agli studenti di scambiarsi gli appunti, e di ritrovarli nei appositi corsi</p>
            </div>
            <div class="col-md-5">
                <img class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" src="../../../img/appunti2.jpg" >

            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7 order-md-2">
                <h2 class="featurette-heading">Ricevi news sui tuoi corsi preferiti.</h2>
                <p class="lead text-muted ">UniNotes ti avvisa su tutte le news dei tuoi corsi preferiti, in modo che non ti perderai nessun appunto! .</p>
            </div>
            <div class="col-md-5 order-md-1">
                <img class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" src="./img/newsImg.jpg" >

            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
                <p class="lead">And yes, this is the last block of representative placeholder content. Again, not really intended to be actually read, simply here to give you a better view of what this would look like with some actual content. Your content.</p>
            </div>
            <div class="col-md-5">
                <svg class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 500x500" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#eee"/><text x="50%" y="50%" fill="#aaa" dy=".3em">500x500</text></svg>

            </div>
        </div>

        <hr class="featurette-divider">

        <!-- /END THE FEATURETTES -->

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