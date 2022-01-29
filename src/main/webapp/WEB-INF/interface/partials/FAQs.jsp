

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <jsp:param name="title" value="UniNotes-FAQS"/>
        <jsp:param name="style" value=""/>
        <jsp:param name="script" value=""/>
    </jsp:include>



</head>


<body>
<main>

    <%@include file="/WEB-INF/interface/partials/header.jsp"%>


    <div class="container">
        <p></p>
        <h1 class="section__headline" style="color: red">FAQs</h1>
        <p></p>
        <p></p>
        <p></p>
        <h2 class="c-faqs__headline">UniNotes</h2>
        <ul class="c-faqs">
            <li class="c-faq c-faq--active">
                <span class="c-faq__title">Chi gestisce UniNotes ?</span>
                <div class="c-faq__answer">UniNotes è gestito completamante da studenti.</div>
            </li>
            <p></p>
            <p></p>
            <li class="c-faq">
                <span class="c-faq__title">Cosa posso fare all'interno di UniNotes?</span>
                <div class="c-faq__answer">Iscrivendoti alla piattaforma di UniNotes hai la possibilta' di visionare i corsi della laura triennale di informatica accedendo ad appunti e mateiale inseirito da altri studenti.</div>
                <div class="c-faq__answer">Potrai inserire i corsi che ti interessano in una lista di preferiti in modo da ricevere un e-mail ogni volta che altri iscirtti caricano nuovi contenuti.</div>
                <div class="c-faq__answer">Avrai a disposizione una tua area personale con un libretto dove potrai inserire tutti i tuoi voti e verificare la tua media.</div>
                <div class="c-faq__answer">Inoltre potrai compilare un questioniario creato da noi per indirizzarti ad una futura scelta magistrale.</div>
            </li>
        </ul>  <!-- /end c-faqs -->

        <h2 class="c-faqs__headline">Dati personali</h2>
        <ul class="c-faqs">
            <li class="c-faq">
                <span class="c-faq__title">Chi puo accedere alla mia pagina personale ?</span>
                <div class="c-faq__answer">Nessuno puo accedere ai tuoi dati personali</div>
            </li>
            <p></p>
            <p></p>
            <li class="c-faq">
                <span class="c-faq__title">La mia media sarà visibile ad altri scritti ?</span>
                <div class="c-faq__answer">No, il tuo libretto con la relativa media sarà visibile solo a te.</div>
            </li>
        </ul>  <!-- /end c-faqs -->

        <h2 class="c-faqs__headline">Materiale e questionario</h2>
        <ul class="c-faqs">
            <li class="c-faq">
                <span class="c-faq__title">Posso inserire tutto il materiale desiderato ?</span>
                <div class="c-faq__answer">Si, è possibile inserire tutto il materiale che si desidera in tutti i formati disponibili (es .pdf, .docx, ecc..).</div>
                <div class="c-faq__answer">Ovviamente tutto il materiale inserito sarà visionato da uno degli amministratori di UniNotes e se ritenuto non idoneo sara' rimosso.</div>
            </li>
            <p></p>
            <p></p>
            <li class="c-faq">
                <span class="c-faq__title">Posso accedere a tutto il materiale presente sulla piattaforma ?</span>
                <div class="c-faq__answer">Si, è possibile accedere a tutto il materiale presente.</div>
            </li>
            <p></p>
            <p></p>
            <li class="c-faq">
                <span class="c-faq__title">Il risultato del questionario è vincolante ?</span>
                <div class="c-faq__answer">No, non ha nessun tipo di vincolo, è stato ideato da noi studenti sulla base di dati forniti da ex-studenti del dipartimento di informatica dell'univerità di Salerno, per consigliare e guidare al meglio la scelta di una futura magistrale.</div>
            </li>
            <p></p>
            <p></p>
            <li class="c-faq">
                <span class="c-faq__title">Il risultato questionario sarà visibile ad altri  iscritti ?</span>
                <div class="c-faq__answer">No, sarà visibili solo all'interno della tua pagina personale.</div>
            </li>
            <p></p>
            <p></p>
            <p></p>
        </ul>  <!-- /end c-faqs -->

    </div>



    <!-- FOOTER -->
    <%@include file="/WEB-INF/interface/partials/footer.jsp"%>


</main>

<script>

    $("body").delegate(".c-faq", "click", function () {
        $(".c-faq").removeClass("c-faq--active");
        $(this).addClass("c-faq--active");
    });

</script>

</body>
</html>

