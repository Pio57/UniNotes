<%--
  Created by IntelliJ IDEA.
  User: piosantosuosso
  Date: 30/12/21
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <form name ="piantaForm" method="post" action="/UniNotes_war_exploded/Materiale/inserireMateriale" enctype="multipart/form-data">
        <fieldset class="grid-y cell product-form">
            <legend>
                Crea prodotto
            </legend>

            <input required id="idCorso" name="idCorso" placeholder="idCorso">
            <input required id="idUtente" name="idUtente" placeholder="idUtente">
            <input required id="Nome" name="Nome" placeholder="Nome">

            <label for="Immagine" class="field cell w50">
                <input required type="file" id="File" name="File" placeholder="Numero piante disponibili">
            </label>

            <button type="submit">Crea</button>
        </fieldset>
    </form>


</body>
</html>
