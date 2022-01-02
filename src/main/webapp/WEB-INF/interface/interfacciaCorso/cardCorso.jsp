<%--
  Created by IntelliJ IDEA.
  User: alessandraparziale
  Date: 02/01/22
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<div>
            <img src="../img/corsi.jpg">
                </div>

                <a class="card-action" href="#"><i class="fa fa-heart"></i></a>
                <div class="card-heading">
                    ${param.nome}
                </div>
                <div class="card-text">
                    ${param.descrizione}
                </div>
                <div class="card-text">
                    ${param.nomeProf}
                </div>
                <a href="/UniNotes_war_exploded/Corso/visualizza" class="card-button"> Visualizza </a>



</body>
</html>
