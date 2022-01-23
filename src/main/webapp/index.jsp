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
        <jsp:param name="title" value="UniNotes-Home"/>
        <jsp:param name="style" value="home"/>
        <jsp:param name="script" value=""/>
    </jsp:include>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="fonts,_icomoon,_style.css+css,_owl.carousel.min.css+css,_bootstrap.min.css+css,_style.css.pagespeed.cc.Gajl4v2LrE.css" />


    <title>Login</title>
    <script>(function(w,d){!function(a,e,t,r,z){a.zarazData=a.zarazData||{},a.zarazData.executed=[],a.zarazData.tracks=[],a.zaraz={deferred:[]};var s=e.getElementsByTagName("title")[0];a.zarazData.c=e.cookie,s&&(a.zarazData.t=e.getElementsByTagName("title")[0].text),a.zarazData.w=a.screen.width,a.zarazData.h=a.screen.height,a.zarazData.j=a.innerHeight,a.zarazData.e=a.innerWidth,a.zarazData.l=a.location.href,a.zarazData.r=e.referrer,a.zarazData.k=a.screen.colorDepth,a.zarazData.n=e.characterSet,a.zarazData.o=(new Date).getTimezoneOffset(),//
        a.dataLayer=a.dataLayer||[],a.zaraz.track=(e,t)=>{for(key in a.zarazData.tracks.push(e),t)a.zarazData["z_"+key]=t[key]},a.zaraz._preSet=[],a.zaraz.set=(e,t,r)=>{a.zarazData["z_"+e]=t,a.zaraz._preSet.push([e,t,r])},a.dataLayer.push({"zaraz.start":(new Date).getTime()}),a.addEventListener("DOMContentLoaded",(()=>{var t=e.getElementsByTagName(r)[0],z=e.createElement(r);z.defer=!0,z.src="/cdn-cgi/zaraz/s.js?z="+btoa(encodeURIComponent(JSON.stringify(a.zarazData))),t.parentNode.insertBefore(z,t)}))}(w,d,0,"script");})(window,document);</script></head>


<body>
<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="undraw_remotely_2j6y.svg" alt="Image" class="img-fluid">
            </div>
            <div class="col-md-6 contents">
                <div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="mb-4">
                            <h3>Benvenuto su UniNotes!</h3>
                            <p class="mb-4">Sign In</p>
                        </div>

                        <c:if test="${errors != null}">
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                <c:forEach items="${errors}" var="e">
                                    <p><strong>Error: </strong>${e}</p>
                                </c:forEach>
                                    ${errors = null}
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>


                        <form action="/UniNotes_war_exploded/Utente/login" method="post">
                            <div class="form-group first">

                                <input placeholder="E-mail" name = "email" type="text" class="form-control" id="username" value="${email}">
                            </div>

                            <div class="form-group last mb-4">
                                <input placeholder="Password" name = "password" type="password" class="form-control" id="password" value="${password}">
                          </div>

                            <div class="d-flex mb-5 align-items-center">
                                <span class="ml-auto"><a href="/UniNotes_war_exploded/Utente/registrazione" class="forgot-pass">Non sei ancora registrato? Registrati!</a></span>
                            </div>
                            <input type="submit" value="Accedi" class="btn btn-block btn-primary">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/popper.min.js+bootstrap.min.js+main.js.pagespeed.jc.9rL6_qf-nt.js"></script><script>eval(mod_pagespeed_$$cYUBAGVu);</script>
<script>eval(mod_pagespeed_MR4O_w3mta);</script>
<script>eval(mod_pagespeed_DPOuBfjpPE);</script>
<script defer src="https://static.cloudflareinsights.com/beacon.min.js/v652eace1692a40cfa3763df669d7439c1639079717194" integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw==" data-cf-beacon='{"rayId":"6d1b61356d323746","token":"cd0b4b3a733644fc843ef0b185f98241","version":"2021.12.0","si":100}' crossorigin="anonymous"></script>
</body>
</html>