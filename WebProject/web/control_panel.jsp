<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
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
            <li><a href="personal_info.jsp">Informa��es pessoais e endere�o</a></li>
            <li><a href="academic.jsp">Forma��o acad�mica</a></li>
	    <li><a href="complementary.jsp">Forma��o complementar</a></li>
	    <li><a href="experience.jsp">Atua��o profissional</a></li>
	    <li><a href="production.jsp">Produ��o bibliogr�fica</a></li>
        </ul>
    </body>
</html>
