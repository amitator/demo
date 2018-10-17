<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp"%>
        <h1>This is MAIN page</h1>
        <div><strong>Page URL: </strong><%=request.getRequestURI()%></div>
        <div><strong>Sission ID: </strong><%=session.getId()%></div>
        <%
            session.setAttribute("hello", "HELLO");
        %>
    </body>
</html>
