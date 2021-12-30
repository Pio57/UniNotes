<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <jsp:include page="WEB-INF/interface/partials/head.jsp">
        <jsp:param name="title" value="UniNotes-Home"/>
        <jsp:param name="style" value=""/>
        <jsp:param name="script" value=""/>
    </jsp:include>

</head>
<body >
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
</html>