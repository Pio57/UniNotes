<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Dashboard Template · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/dashboard/">

    <jsp:include page="/WEB-INF/interface/partials/head.jsp">
        <jsp:param name="title" value="UniNotes-Home"/>
        <jsp:param name="style" value="dashboard"/>
        <jsp:param name="script" value="dashboard"/>
    </jsp:include>


    <!-- Bootstrap core CSS
    <link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
-->
    <!-- Favicons -->
    <link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
    <link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
    <meta name="theme-color" content="#7952b3">

    <!--stat card -->


    <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
    <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
    <link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">



    <style>

        .text-right {
            text-align: right!important;
        }

        .media-body {
            flex: 1;
        }

        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        @media (max-width: 767.98px){
            .sidebar {
                top: 0rem;
            }
        }


    </style>


    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
</head>
<body>


<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="/UniNotes_war_exploded/Utente/home"><img src="../img/scrittalogo.png" width="100" height="30"></a>
    <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</header>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="../../partials/sidebarDashboard.jsp">
            <jsp:param name="sezione" value="Dashboard"/>
        </jsp:include>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Dashboard</h1>
            </div>



                    <div class="grey-bg container-fluid">
                        <section id="minimal-statistics">
                            <c:if test="${utente.isTipo()}">
                            <div class="row">
                                <div class="col-xl-3 col-sm-6 col-12">
                                    <div class="card">
                                        <div class="card-content">
                                            <div class="card-body">
                                                <a href="/UniNotes_war_exploded/Corso/visualizzaTutti" style="text-decoration: none; color:inherit;" >
                                                    <div class="media d-flex">
                                                        <div class="align-self-center">
                                                            <i class="icon-book-open primary font-large-2 float-left"></i>
                                                        </div>
                                                        <div class="media-body text-right">
                                                            <h3>${totCorsi}</h3>
                                                            <span>Corsi</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                </c:if>
                                <c:if test="${utente.isTipo()}">
                                <div class="col-xl-3 col-sm-6 col-12">
                                    <div class="card">
                                        <div class="card-content">
                                            <div class="card-body">
                                                <a href="/UniNotes_war_exploded/Utente/visualizzaUtenti" style="text-decoration: none; color:inherit;" >
                                                    <div class="media d-flex">
                                                        <div class="align-self-center">
                                                            <i class="icon-users warning font-large-2 float-left"></i>
                                                        </div>
                                                        <div class="media-body text-right">
                                                            <h3>${totUtenti}</h3>
                                                            <span>Utenti</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                </c:if>
                                <div class="col-xl-3 col-sm-6 col-12">
                                    <div class="card">
                                        <div class="card-content">
                                            <div class="card-body">
                                                <a href="/UniNotes_war_exploded/Materiale/visualizzaTutti" style="text-decoration: none; color:inherit;" >
                                                    <div class="media d-flex">
                                                        <div class="align-self-center">
                                                            <i class="icon-doc success font-large-2 float-left"></i>
                                                        </div>
                                                        <div class="media-body text-right">
                                                            <c:if test="${utente.isTipo()}">
                                                            <h3>${totMateriale}</h3>
                                                            <span>Materiale</span>
                                                            </c:if>
                                                            <c:if test="${!utente.isTipo()}">
                                                                <h3>${utente.getMateriale().size()}</h3>
                                                                <span>Materiale</span>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-sm-6 col-12">

                                    <div class="card">
                                        <div class="card-content">
                                            <div class="card-body">
                                                <a href="/UniNotes_war_exploded/Utente/visualizzaPaginaPersonale" style="text-decoration: none; color:inherit;" >
                                                    <div class="media d-flex">
                                                        <div class="align-self-center">
                                                            <i class="icon-user danger font-large-2 float-left"></i>
                                                        </div>
                                                        <div class="media-body text-right">
                                                            <h3>Pagina personale</h3>
                                                            <span>La tua pagina personale</span>
                                                        </div>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                </section>
            </div>
        </main>
    </div>
</div>

<%@include file="../../partials/footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
