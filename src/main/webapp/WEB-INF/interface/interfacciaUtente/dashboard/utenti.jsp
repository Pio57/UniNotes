<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/dashboard/">

    <link id="pagestyle" href="../assets/css/material-dashboard.min.css?v=3.0.0" rel="stylesheet">

    <jsp:include page="/WEB-INF/interface/partials/head.jsp">
        <jsp:param name="title" value="UniNotes-Utenti"/>
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


    <style>

        .mt-n4 {
            margin-top: -1.5rem!important;
        }

        .card {
            box-shadow: 0 4px 6px -1px , 0 2px 4px -1px ;
        }


        .card {
            position: relative;
            display: flex; !important;
            flex-direction: column;
            /* min-width: 0; */
            word-wrap: break-word;
            background-color: #fff;
            background-clip: border-box;
            border: 0 solid rgba(0,0,0,.125);
            border-radius: 0.75rem;
        }

        .bg-gradient-secondary {
            background-image: linear-gradient(
                    195deg,#747b8a,#495361);
        }

        .bg-gradient-success {
            background-image: linear-gradient(
                    195deg,#66bb6a,#43a047);
        }

        .badge, .btn {
            text-transform: uppercase;
        }

        .border-radius-lg {
            border-radius: 0.5rem;
        }
        .bg-gradient-primary {
            background-image: linear-gradient(
                    195deg, #0c0c0c, #343434);
        }

        .shadow-primary {
            box-shadow: 0 4px 20px 0 rgba(0, 0, 0, 0.14),0 7px 10px -5px rgba(203, 203, 203, 0.4) !important;
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


        #buttonElimina{
            border: none;
            border-radius: 20px;
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
            <jsp:param name="sezione" value="Utenti"/>
        </jsp:include>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Utenti</h1>
            </div>




            <div class="row">
                <div class="col-12">
                    <div class="card my-4">
                        <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                            <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                                <h6 class="text-white text-capitalize ps-3">Lista utenti</h6>
                            </div>
                        </div>
                        <div class="card-body px-0 pb-2">
                            <div class="table-responsive p-0">
                                <table class="table align-items-center mb-0">
                                    <thead>
                                    <tr>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Id</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">User</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Ruolo</th>
                                        <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Cf</th>
                                        <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Data di nascita</th>
                                        <th class="text-secondary opacity-7"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${utenti}" var="u">

                                    <tr>
                                        <td>
                                            <div class="d-flex px-2 py-1">
                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="mb-0 text-sm">${u.getIdUtente()}</h6>
                                                </div>
                                            </div>
                                        </td>

                                        <td>
                                            <div class="d-flex px-2 py-1">
                                                <div class="d-flex flex-column justify-content-center">
                                                    <h6 class="mb-0 text-sm">${u.getNome()} ${u.getCognome()}</h6>
                                                    <p class="text-xs text-secondary mb-0">${u.getEmail()}</p>
                                                </div>
                                            </div>
                                        </td>

                                        <td>
                                            <c:if test="${u.isTipo()}">
                                            <p class="text-xs font-weight-bold mb-0">Amministratore</p>
                                            </c:if>
                                            <c:if test="${!u.isTipo()}">
                                                <p class="text-xs font-weight-bold mb-0">Studente</p>
                                            </c:if>

                                        </td>

                                        <td class="align-middle text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${u.getCf()}</span>
                                        </td>

                                        <td class="align-middle text-center">
                                            <span class="text-secondary text-xs font-weight-bold">${u.getDdn()}</span>
                                        </td>


                                        <form action="/UniNotes_war_exploded/Utente/toggleRuolo" method="post">

                                            <td>
                                                <input type="hidden" name="id" value="${u.getIdUtente()}">
                                                <c:if test="${!u.isTipo()}">
                                                    <button id="buttonElimina">Rendi amministratore</button>
                                                </c:if>
                                                <c:if test="${u.isTipo()}">
                                                    <button id="buttonElimina">Rendi studente</button>
                                                </c:if>

                                            </td>
                                        </form>

                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>






            <!--    TABELLA CLASSICA
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Cognome</th>
                        <th scope="col">Cf</th>
                        <th scope="col">Email</th>
                        <th scope="col">Data di nascita</th>
                        <th scope="col">Ruolo</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${utenti}" var="u">
                        <tr>
                            <td>${u.getIdUtente()}</td>
                            <td>${u.getNome()}</td>
                            <td>${u.getCognome()}</td>
                            <td>${u.getCf()}</td>
                            <td>${u.getEmail()}</td>
                            <td>${u.getDdn()}</td>
                            <c:if test="${u.isTipo()}">
                                <td>Amministratore</td>
                            </c:if>
                            <c:if test="${!u.isTipo()}">
                                <td>Studente</td>
                            </c:if>
                        </tr>

                    </c:forEach>

                    <tr>

                    </tr>
                    </tbody>
                </table>

            </div>
             -->
        </main>
    </div>
</div>

<%@include file="../../partials/footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
