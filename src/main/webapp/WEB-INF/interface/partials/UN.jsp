
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
        <jsp:param name="style" value="un"/>
        <jsp:param name="script" value=""/>
    </jsp:include>



</head>
<body>
<main>
    <div class="container">
        <div id="demo" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="card">
                        <div class="row">
                            <div class="col-md-6 text-center align-self-center"> <img class="img-fluid" src="../img/logo.png"> </div>
                            <div class="col-md-6 info">
                                <div class="row title">
                                    <div class="col">
                                        <h1 style="color: #e1853f" >La storia di UniNotes</h1>
                                    </div>
                                </div>
                                <p>UniNotes e' una piataforma ideata da tre studenti del dipartimento di informatica dell'universita' degli studi di Salerno.</p>
                                <p>L'idea alla basa era creare una dispensa online di appunti universitari, il cui unico obiettivo e' agevolare lo studio, rendendo disponibili gratuitamente appunti delle varie lezioni e informazioni su tutti corsi della laura triennale in informatica.</p>
                                <p>Come tutte le idee e' stato difficile renderla concreta e far in modo che rispecchiasse tutte le aspettaitve ma con dedizione e impegno l'idea è diventata realta'.</p>
                                <p></p>
                                <p></p>
                                <p></p>
                                <p></p>
                                <p>''Io so con assoluta certezza di non possedere un talento speciale; la curiosita', l'ossessione e l'ostinata resistenza, unita all'autocritica, mi hanno portato alle mie idee.''<strong> <em style="color: #e1853f">Albert Einstein</em></strong></p>
                                <p></p>
                                <p></p>
                                <p></p>
                                <p><a href="/UniNotes_war_exploded/Utente/home">TORNA ALLA HOME</a></p>
                                <p></p>
                                <p></p>
                                <p></p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- FOOTER -->
    <%@include file="/WEB-INF/interface/partials/footer.jsp"%>


</main>

</body>

</html>
