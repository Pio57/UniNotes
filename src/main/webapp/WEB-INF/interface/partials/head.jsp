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
<!--
<link href = "${context}/css/bootstrap.min.css" rel="stylesheet">
<link href = "${context}/css/bootstrap.css" rel = "stylesheet">
-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/carosel.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


<c:if test = "${not empty param.style}">
    <c:forTokens items="${param.style}" delims="," var="style">
        <link rel = "stylesheet" href = "${context}/css/${style}.css">
    </c:forTokens>

</c:if>
<!--
<script src = "${context}/js/bootstrap.min.js" defer></script>
<script src = "${context}/js/bootstrap.js" defer></script>
<script src = "${context}/js/bootstrap.bundle.js" defer></script>
-->
<c:if test = "${not empty param.script}">
    <c:forTokens items="${param.script}" delims="," var="script">
    <script src = "${context}/js/${script}.js" defer></script>
    </c:forTokens>
</c:if>