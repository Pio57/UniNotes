<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var = "context" value = "${pageContext.request.contextPath}"/>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">
<title>${param.title}</title>
<meta name = "description" content="Ecommerce Piante">
<link rel = "icon" type="image/png" href="img/logo.png">
<meta name = "apple-mobile-web-app-capable" content="yes">
<meta name = "format-detection" content="telephone-on">
<meta name = "apple-mobile-web-app-title" content="PlanetPlants">
<meta name = "apple-mobile-web-app-status-bar-style" content="default">
<link rel = "apple-touch-icon" href="img/logo.png">
<link rel = "apple-touch-startup-image" href="img/logo.png">
<meta name = "theme-color" content="#6A8C20">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/carousel.css">


<c:if test = "${not empty param.style}">
    <c:forTokens items="${param.style}" delims="," var="style">
        <link rel = "stylesheet" href = "${context}/css/${style}.css">
    </c:forTokens>

</c:if>
<!-- Con questa libreria non funziona il menù
<script src="./webapp/js/bootstrap.bundle.min.js"></script>
-->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>


<c:if test = "${not empty param.script}">
    <c:forTokens items="${param.script}" delims="," var="script">
    <script src = "${context}/js/${script}.js" defer></script>
    </c:forTokens>
</c:if>

<!-- sono da rivedere -->

<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

<link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!--
<link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext" rel="stylesheet">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesoeet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
-->