<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.PageType"%>
<% pageContext.setAttribute("pageTitle", "Entrar"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <h1>Operação realizada com sucesso</h1>
        
        <%
        Enumeration<String> names = request.getAttributeNames();
        while (names.hasMoreElements())
        {
            System.out.println(names.nextElement());
        }
        %>
    </body>
</html>
