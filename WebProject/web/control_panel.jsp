<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="webproject.misc.PageType"%>
<% pageContext.setAttribute("pageTitle", "Painel de Controle"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <h1>Painel de controle</h1>
        <ul>
            <li><a href="personal_info.jsp">Informações pessoais e endereço</a></li>
            <li><a href="academic.jsp">Formação acadêmica</a></li>
        </ul>
    </body>
</html>
