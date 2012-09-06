<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="webproject.*" %>
<% pageContext.setAttribute("pageTitle", "Entrar"); %>
<% pageContext.setAttribute("pageType", PageType.INDEX); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js"></script>
        <script type="text/javascript" src="script/index.js"></script>
        
        <h1>Entrar</h1>
        
        <form name="form" method="POST" action="./Login" onsubmit="return validateForm();">
            Email:
            <input type="text" name="email"/><br/>
            Senha:
            <input type="password" name="password"/><br/>
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
