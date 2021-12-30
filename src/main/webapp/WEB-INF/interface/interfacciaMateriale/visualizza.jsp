<%--
  Created by IntelliJ IDEA.
  User: piosantosuosso
  Date: 30/12/21
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/UniNotes_war_exploded/covers/${materiale.getPathFile()}"  download="${materiale.getPathFile()}">
    ${materiale.getPathFile()}
</a>


</body>
</html>
