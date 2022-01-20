<%@ page import="Storage.Libretto.LibrettoBean" %>
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

    <link id="pagestyle" href="../assets/css/material-dashboard.min.css?v=3.0.0" rel="stylesheet">

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





        .btn-primary{
            color: #fff;
            background-color: #4f4f4f;
        }

        .btn-primary:hover {
            color: #fff;
            background-color: #a7a7a7;
            border-color: #bdbdbd;
        }

        .btn-primary:focus {
            color: #fff;
            background-color: #646464;
            border-color: #606060;
            box-shadow: 0 0 0 0.25rem, 0 0 0 0.25rem;
        }


        .row{
            padding: 3px;
        }




        #buttonRotondo{
              border: none;
              border-radius: 100%;
              background-color: #4a4a4a;
              color: white;
          }

        #buttonElimina{
            border: none;
            border-radius: 100%;
        }


        .modal-content{
            border-radius:  30px;
        }

        .modal-header{
            border-top-left-radius: 30px;
            border-top-right-radius: 30px;
            background-image: linear-gradient(
                    195deg,#878787,#000000);
            color: white;
        }


        .modal-footer > button{
            background-image: linear-gradient(
                    195deg,#878787,#000000);
            color: white;
            border: none;

        }


        .modal-footer{
            border-bottom-left-radius: 30px;
            border-bottom-right-radius: 30px;
        }



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

        .px-md-4 {
            width: 100%;
        }

        .libretto{
            border-radius: 20px;
            width: auto;
            margin-left: 45%;
        }


    </style>


    </style>


    <link href="dashboard.css" rel="stylesheet">
</head>
<body>



<%@include file="/WEB-INF/interface/partials/header.jsp"%>

<div class="container-fluid">
    <div class="row">


        <div class="grey-bg container-fluid">
            <section id="minimal-statistics">
                <div class="row" style="justify-content: center">
                    <div class="col-xl-3 col-sm-6 col-12">
                        <div class="card">
                            <div class="card-content">
                                <div class="card-body">
                                        <div class="media d-flex">
                                            <div class="align-self-center">
                                                <i class="icon-bar-chart primary font-large-2 float-left"></i>
                                            </div>
                                            <div class="media-body text-right">
                                                <h3>${libretto.getMedia()}</h3>
                                                <span>Media</span>
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
                                            <div class="media d-flex">
                                                <div class="align-self-center">
                                                    <i class="icon-graduation warning font-large-2 float-left"></i>
                                                </div>
                                                <div class="media-body text-right">
                                                    <h3>${libretto.getCfuCrediti()}/180</h3>
                                                    <span>Crediti acquisiti</span>
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
                                        <div class="media d-flex">
                                            <div class="align-self-center">
                                                <i class="icon-notebook success font-large-2 float-left"></i>
                                            </div>
                                            <div class="media-body text-right">
                                                    <h3>${libretto.getNunEsami()}</h3>
                                                    <span>Numero di esami</span>
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

        <button class="libretto" id="viewBotton" name="viewEsame" onclick="viewEsame()">Nascondi libretto </button>


        <form action="/UniNotes_war_exploded/Esame/crea" method="post">



            <div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalToggleLabel">Esame</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <input name="Nome" class="form-control" type="text" placeholder="Name"> </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <div class="input-group"> <input name="Voto" class="form-control" type="text" placeholder="Voto"> </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <div class="input-group"> <input name="Cfu" class="form-control" type="text" placeholder="Cfu"> </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <div class="input-group"> <input name="Data" class="form-control" type="date" placeholder="Data"> </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="form-group">
                                        <div class="input-group"> <input name="NomeProfessore" class="form-control" type="text" placeholder="Nome professore"> </div>
                                    </div>
                                </div>
                            </div>






                        </div>
                        <div class="modal-footer justify-content-center">
                            <button type="submit" class="btn btn-primary" data-bs-toggle="modal">Crea</button>
                        </div>
                    </div>
                </div>
            </div>
            <a id="buttonRotondo" class="btn" data-bs-toggle="modal" href="#exampleModalToggle"  role="button">+</a>





            <!-- FORM TABELLA -->
        </form>


        <main id = "viewEsami" class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

            <div class="row">
                <div class="col-12">
                    <div class="card my-4">
                        <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                            <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3 justify-content-center">
                                <h6 class="text-white text-capitalize ps-3">MY LIBRETTO</h6>
                            </div>
                        </div>
                        <div class="card-body px-0 pb-2">
                            <div class="table-responsive p-0">
                                <table class="table align-items-center mb-0">
                                    <thead>
                                    <tr>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Esame</th>
                                        <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Voto</th>
                                        <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">CFU</th>
                                        <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Data</th>
                                        <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Docente</th>
                                        <th class="text-secondary opacity-7"></th>
                                        <th class="text-secondary opacity-7"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:if test="${libretto != null}">
                                    <c:forEach items="${libretto.getListaEsami()}" var="p">
                                        <tr>
                                            <td>
                                                <span class="text-secondary text-xs font-weight-bold">${p.getNome()}</span>
                                            </td>
                                            <td>
                                                <span class="text-secondary text-xs font-weight-bold">${p.getVoto()}</span>
                                            </td>
                                            <td>
                                                <span class="text-secondary text-xs font-weight-bold">${p.getCfu()}</span>
                                            </td>
                                            <td class="align-middle text-center">
                                                <span class="text-secondary text-xs font-weight-bold">${p.getData()}</span>
                                            </td>
                                            <td class="align-middle text-center">
                                                <span class="text-secondary text-xs font-weight-bold">${p.getNomeProfessore()}</span>
                                            </td>





                                            <td class="align-middle">

                                                <form action="/UniNotes_war_exploded/Esame/modifica" method="post">


                                                    <div class="modal fade" id="editModal${p.getId()}" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
                                                        <div class="modal-dialog modal-dialog-centered">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title" id="editModalLabel">Edit esame</h5>
                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                </div>
                                                                <div class="modal-body">

                                                                    <input type="hidden" name="id" value="${p.getId()}">

                                                                    <div class="row">
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                 <input name="Nome" class="form-control" type="text" placeholder="Name" value="${p.getNome()}"> </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <div class="input-group"> <input name="Voto" class="form-control" type="text" placeholder="Voto" value="${p.getVoto()}" > </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <div class="input-group"> <input name="Cfu" class="form-control" type="text" placeholder="Cfu" value="${p.getCfu()}"> </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <div class="input-group"> <input name="Data" class="form-control" type="date" placeholder="Data" value="${p.getData()}" > </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-sm-12">
                                                                            <div class="form-group">
                                                                                <div class="input-group"> <input name="NomeProfessore" class="form-control" type="text" placeholder="Nome professore" value="${p.getNomeProfessore()}"> </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>



                                                                </div>
                                                                <div class="modal-footer justify-content-center">
                                                                    <button type="submit" class="btn btn-primary" data-bs-toggle="modal">Modifica</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <a style="color: gray" href="#editModal${p.getId()}" data-bs-toggle="modal"  role="button">Edit
                                                    </a>
                                                </form>
                                            </td>
                                            <form action="/UniNotes_war_exploded/Esame/elimina" method="get">
                                                <td class="align-middle text-center">
                                                    <input type="hidden" name="id" value="${p.getId()}">
                                                    <button id="buttonElimina">X</button>
                                                </td>
                                            </form>


                                        </tr>
                                    </c:forEach>
                                    </c:if>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>




<!-- FOOTER -->
    <%@include file="/WEB-INF/interface/partials/footer.jsp"%>



</main>



</body>

<script>
    var myModal = document.getElementById('myModal')
    var myInput = document.getElementById('myInput')

    myModal.addEventListener('shown.bs.modal', function () {
        myInput.focus()
    })

</script>



<script>

    function viewEsame(){
        var x= document.getElementById("viewEsami");
        var y= document.getElementById("viewBotton");
        if (x.style.display === "none") {
            x.style.display = "block";
            y.innerHTML="Nascondi libretto";
        } else {
            x.style.display = "none";
            y.innerHTML="Visualizza il libretto";
        }
    }
</script>
</html>
