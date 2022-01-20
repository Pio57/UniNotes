
<!doctype html>


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

    <style>
        body {
            margin-top: 30px;
            background-color: #eee;
        }

        .faq-nav {
            flex-direction: column;
            margin: 0 0 32px;
            border-radius: 2px;
            border: 1px solid #ddd;
            box-shadow: 0 1px 5px rgba(85, 85, 85, 0.15);
        }
        .faq-nav .nav-link {
            position: relative;
            display: block;
            margin: 0;
            padding: 13px 16px;
            background-color: #fff;
            border: 0;
            border-bottom: 1px solid #ddd;
            border-radius: 0;
            color: #616161;
            transition: background-color 0.2s ease;
        }
        .faq-nav .nav-link:hover {
            background-color: #f6f6f6;
        }
        .faq-nav .nav-link.active {
            background-color: #f6f6f6;
            font-weight: 700;
            color: rgba(0, 0, 0, 0.87);
        }
        .faq-nav .nav-link:last-of-type {
            border-bottom-left-radius: 2px;
            border-bottom-right-radius: 2px;
            border-bottom: 0;
        }
        .faq-nav .nav-link i.mdi {
            margin-right: 5px;
            font-size: 18px;
            position: relative;
        }

        .tab-content {
            box-shadow: 0 1px 5px rgba(85, 85, 85, 0.15);
        }
        .tab-content .card {
            border-radius: 0;
        }
        .tab-content .card-header {
            padding: 15px 16px;
            border-radius: 0;
            background-color: #f6f6f6;
        }
        .tab-content .card-header h5 {
            margin: 0;
        }
        .tab-content .card-header h5 button {
            display: block;
            width: 100%;
            padding: 0;
            border: 0;
            font-weight: 700;
            color: rgba(0, 0, 0, 0.87);
            text-align: left;
            white-space: normal;
        }
        .tab-content .card-header h5 button:hover, .tab-content .card-header h5 button:focus, .tab-content .card-header h5 button:active, .tab-content .card-header h5 button:hover:active {
            text-decoration: none;
        }
        .tab-content .card-body p {
            color: #616161;
        }
        .tab-content .card-body p:last-of-type {
            margin: 0;
        }

        .accordion > .card:not(:first-child) {
            border-top: 0;
        }

        .collapse.show .card-body {
            border-bottom: 1px solid rgba(0, 0, 0, 0.125);
        }
    </style>

</head>

<body>
<main>
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <div class="nav nav-pills faq-nav" id="faq-tabs" role="tablist" aria-orientation="vertical">
                    <a href="#tab1" class="nav-link active" data-toggle="pill" role="tab" aria-controls="tab1" aria-selected="true">
                        <i class="mdi mdi-help-circle"></i>Domande frequanti
                    </a>
                    <a href="#tab2" class="nav-link" data-toggle="pill" role="tab" aria-controls="tab2" aria-selected="false">
                        <i class="mdi mdi-account"></i>UniNotes
                    </a>
                    <a href="#tab3" class="nav-link" data-toggle="pill" role="tab" aria-controls="tab3" aria-selected="false">
                        <i class="mdi mdi-account-settings"></i>Dati personali
                    </a>
                    <a href="#tab4" class="nav-link" data-toggle="pill" role="tab" aria-controls="tab4" aria-selected="false">
                        <i class="mdi mdi-heart"></i>Materiale
                    </a>
                    <a href="#tab5" class="nav-link" data-toggle="pill" role="tab" aria-controls="tab5" aria-selected="false">
                        <i class="mdi mdi-coin"></i>Questionario
                    </a>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="tab-content" id="faq-tab-content">
                    <div class="tab-pane show active" id="tab1" role="tabpanel" aria-labelledby="tab1">
                        <div class="accordion" id="accordion-tab-1">
                            <div class="card">
                                <div class="card-header" id="accordion-tab-1-heading-1">
                                    <h5>
                                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-1-content-1" aria-expanded="false" aria-controls="accordion-tab-1-content-1">Cos'e' UniNotes?</button>
                                    </h5>
                                </div>
                                <div class="collapse show" id="accordion-tab-1-content-1" aria-labelledby="accordion-tab-1-heading-1" data-parent="#accordion-tab-1">
                                    <div class="card-body">
                                        <p>Uninotes e' una piattaforma creata per aiutare gli studenti a recuperare appunti o generico meteriale di uno specifico corso del dipartimento di Informatica dell'università degli studi di Salerno.</p>
                                        <p>Tutti gli studenti iscitti hanno la possibilità di condividere il proprio mateirale,scaricare quello inserito da altri utenti, di visionare tutti i corsi presenti e inseirli o rimuoverli dalla propia lista preferiti.</p>
                                        <p>Ogni iscritto ha a disposizione una propria area personale dove poter registrare i propri esami e visualizzare la sua media.</p>
                                        <p>Inoltre ogni studente iscritto ha la possibilità di compilare un questionario ed in base alle risposte fornite riceverà un consiglio su una futura scelta magistrale.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="accordion-tab-1-heading-2">
                                    <h5>
                                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-1-content-2" aria-expanded="false" aria-controls="accordion-tab-1-content-2"> Chi gestisce UniNotes?</button>
                                    </h5>
                                </div>
                                <div class="collapse" id="accordion-tab-1-content-2" aria-labelledby="accordion-tab-1-heading-2" data-parent="#accordion-tab-1">
                                    <div class="card-body">
                                        <p>UniNotes è gestito completamante da studenti del dipartiamnto di Informatica dell'univesità degli studi di Salerno.</p></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab2" role="tabpanel" aria-labelledby="tab2">
                        <div class="accordion" id="accordion-tab-2">
                            <div class="card">
                                <div class="card-header" id="accordion-tab-2-heading-1">
                                    <h5>
                                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-2-content-1" aria-expanded="false" aria-controls="accordion-tab-2-content-1">Qualcuno puo accedere al mio libretto?</button>
                                    </h5>
                                </div>
                                <div class="collapse show" id="accordion-tab-2-content-1" aria-labelledby="accordion-tab-2-heading-1" data-parent="#accordion-tab-2">
                                    <div class="card-body">
                                        <p>No, non e' consentito a nessuno accedere alla tua area personale e al tuo libretto.</p></div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="accordion-tab-2-heading-2">
                                    <h5>
                                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-2-content-2" aria-expanded="false" aria-controls="accordion-tab-2-content-2">Posso eliminare un esame una volta inserito?</button>
                                    </h5>
                                </div>
                                <div class="collapse" id="accordion-tab-2-content-2" aria-labelledby="accordion-tab-2-heading-2" data-parent="#accordion-tab-2">
                                    <div class="card-body">
                                        <p>Si, e' possibile procedere all'eliminazione di un esame anche se lo hai gia inserito all'interno del tuo libretto personale.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab3" role="tabpanel" aria-labelledby="tab3">
                        <div class="accordion" id="accordion-tab-3">
                            <div class="card">
                                <div class="card-header" id="accordion-tab-3-heading-1">
                                    <h5>
                                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-3-content-1" aria-expanded="false" aria-controls="accordion-tab-3-content-1">Posso inserire del nuovo materiale riguardante un corso?</button>
                                    </h5>
                                </div>
                                <div class="collapse show" id="accordion-tab-3-content-1" aria-labelledby="accordion-tab-3-heading-1" data-parent="#accordion-tab-3">
                                    <div class="card-body">
                                        <p>Si, e' possiblie inserire tutto il materiale che si desidera.</p>
                                        <p>Questo sarà visibilie a tutti gli utenti iscritti ad UniNotes</p></div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="accordion-tab-3-heading-2">
                                    <h5>
                                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-3-content-2" aria-expanded="false" aria-controls="accordion-tab-3-content-2">Posso eliminare del materiale dopo averlo inserito?</button>
                                    </h5>
                                </div>
                                <div class="collapse" id="accordion-tab-3-content-2" aria-labelledby="accordion-tab-3-heading-2" data-parent="#accordion-tab-3">
                                    <div class="card-body">
                                        <p>Si, e' possiblie eliminare il materiale che non si vuole piu condividere.</p></div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="accordion-tab-3-heading-3">
                                    <h5>
                                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-3-content-3" aria-expanded="false" aria-controls="accordion-tab-3-content-3">Posso scaricare o elimniare il materiale inserito da altri?</button>
                                    </h5>
                                </div>
                                <div class="collapse" id="accordion-tab-3-content-3" aria-labelledby="accordion-tab-3-heading-3" data-parent="#accordion-tab-3">
                                    <div class="card-body">
                                        Posso scaricare o elimniare il materiale inserito da altri?
                                        <p>E' possibilie scaricare tutto il materiale presente sulla piattaforma, tuttavia non si puo eliminare il materiale inserito da altri.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="accordion-tab-3-heading-4">
                                    <h5>
                                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-3-content-4" aria-expanded="false" aria-controls="accordion-tab-3-content-4">Posso inserire tutti i tipi di documenti che voglio?</button>
                                    </h5>
                                </div>
                                <div class="collapse" id="accordion-tab-3-content-4" aria-labelledby="accordion-tab-3-heading-4" data-parent="#accordion-tab-3">
                                    <div class="card-body">
                                        <p>E' possibile inserire qualsiasi tipo di formato (.zip, .pdf ..) desiderato, tuttavia il materiale inserito sarà controllato da uno degli amministratori di UniNotes e se risulterà essere non idoneo potrà essere eliminato.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab4" role="tabpanel" aria-labelledby="tab4">
                        <div class="accordion" id="accordion-tab-4">
                            <div class="card">
                                <div class="card-header" id="accordion-tab-4-heading-1">
                                    <h5>
                                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-4-content-1" aria-expanded="false" aria-controls="accordion-tab-4-content-1">Il questionario relativo alla scelta magistrale comporta qualche vincolo?</button>
                                    </h5>
                                </div>
                                <div class="collapse show" id="accordion-tab-4-content-1" aria-labelledby="accordion-tab-4-heading-1" data-parent="#accordion-tab-4">
                                    <div class="card-body">
                                        <p>No, il questionario e' stato ideato da noi studenti amministratori di UniNotes sulla base di dati raccolti da ex-studenti per indirizzare al meglio la scelta di una futura magistrale.</p>
                                        <p>Pertanto il questionario non ha alcun tipo di vincolo.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-header" id="accordion-tab-4-heading-2">
                                    <h5>
                                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#accordion-tab-4-content-2" aria-expanded="false" aria-controls="accordion-tab-4-content-2">Qualcuno puo accedere al risulttao del mio questionario?</button>
                                    </h5>
                                </div>
                                <div class="collapse" id="accordion-tab-4-content-2" aria-labelledby="accordion-tab-4-heading-2" data-parent="#accordion-tab-4">
                                    <div class="card-body">
                                        Qualcuno puo accedere al risulttao del mio questionario?
                                        <p>No, il questionario e' personale e solo tu attraverso la tua area personale puo accedere al risultato.</p></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div><p><a style="color: blue" href="/UniNotes_war_exploded/Utente/home">TORNA ALLA HOME</a></p></div>


    <!-- FOOTER -->
        <%@include file="/WEB-INF/interface/partials/footer.jsp"%>


</main>

</body>

</html>


