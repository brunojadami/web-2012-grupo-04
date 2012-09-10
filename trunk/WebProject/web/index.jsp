<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.PageType"%>
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
        
        <%
        String message = (String) request.getAttribute("message");
        if (message != null)
        {
            out.println(message);
        }
        %>
        
        <form name="form" method="POST" action="./Login" onsubmit="return validateForm();">
            Email:
            <input type="text" name="email"/> Qualquer email válido. Exemplo: test@test.com<br/>
            Senha:
            <input type="password" name="password"/> Aceita todos os tipos de caracteres. Tamanho de 6 a 30<br/>
            <input type="submit" value="Entrar"/><br/>
        </form>
    </body>
</html>
