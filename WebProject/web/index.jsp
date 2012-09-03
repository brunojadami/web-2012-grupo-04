<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="webproject.*" %>
<% pageContext.setAttribute("pageTitle", "Entrar"); %>
<% pageContext.setAttribute("pageType", PageType.INDEX); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <h1>Entrar</h1>
        
        <form method="POST" action="./Login">
            <label for="email">Email:</label>
            <input type="text" name="email" id="email"/><br/>
            <label for="password">Senha:</label>
            <input type="password" name="password" id="password"/><br/>
            <input type="submit" value="Entrar"/><br/>
        </form>
        <%
        String message = (String) request.getAttribute("message");
        if (message != null)
        {
            out.println(message);
        }
        %>
    </body>
</html>
