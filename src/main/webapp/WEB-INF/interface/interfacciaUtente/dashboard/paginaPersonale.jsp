<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


    <style>


        .row{
            justify-content: space-around;
        }


        .rounded {
            box-shadow: 0 4px 6px -1px, 0 2px 4px -1px;
            border-radius: 0.25rem!important;
        }

        .form-control:focus {
            box-shadow: none;
            border-color: #6b6b6b
        }

        .profile-button {
            background: rgb(105, 105, 105);
            box-shadow: none;
            border: none
        }

        .profile-button:hover {
            background: #6B6B6B
        }

        .profile-button:focus {
            background: #6B6B6B;
            box-shadow: none
        }

        .profile-button:active {
            background: #6B6B6B;
            box-shadow: none
        }

        .back:hover {
            color: #6B6B6B;
            cursor: pointer
        }

        .labels {
            font-size: 11px
        }

        .add-experience:hover {
            background: #6b6b6b;
            color: #fff;
            cursor: pointer;
            border: solid 1px #6B6B6B
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
            <jsp:param name="sezione" value="Pagina personale"/>
        </jsp:include>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Pagina personale</h1>
            </div>


            <c:if test="${errors != null}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <c:forEach items="${errors}" var="er">
                        <p><strong>Error: </strong>${er}</p>
                    </c:forEach>
                        ${errors=null}
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <form action="/UniNotes_war_exploded/Utente/modifica" method="post">

                <div class="container rounded bg-white mt-5 mb-5">
                    <div class="row">
                        <div class="col-md-3 border-right" >
                            <div class="d-flex flex-column align-items-center border-right text-center p-3 py-5" >
                                <img class="rounded-circle mt-5" width="150px" src="../img/nofoto.png">
                                <span class="font-weight-bold">${utente.getNome()} ${utente.getCognome()}</span>
                                <span class="text-black-50">${utente.getEmail()}</span>
                                <span> </span>
                            </div>
                        </div>
                        <div class="col-md-5 border-right">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h4 class="text-right">Impostazioni del profilo</h4>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-md-6"><label class="labels">Nome</label><input name="Nome"  type="text" class="form-control" placeholder="first name" value="${utente.getNome()}"></div>
                                    <div class="col-md-6"><label class="labels">Cognome</label><input name="Cognome" type="text" class="form-control" value="${utente.getCognome()}" placeholder="surname"></div>
                                </div>
                                <div class="row mt-3">
                                        <div class="col-md-12"><label class="labels">Codice Fiscale</label><input  name="CF" type="text" class="form-control" placeholder="Codice Fiscale" value="${utente.getCf()}"></div>
                                    <div class="col-md-12"><label class="labels">Email</label><input name="Email" type="text" class="form-control" placeholder="Email" value="${utente.getEmail()}"></div>
                                    <div class="col-md-12"><label class="labels">Data di nascita</label><input  name="DataDiNascita" type="date" class="form-control" placeholder="enter address line 2" value="${utente.getDdn()}"></div>
                                </div>

                                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Save Profile</button></div>
                            </div>
                        </div>
                    </div>
                </div>


            </form>
        </main>
</div>

        </main>
    </div>
</div>

<%@include file="../../partials/footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
