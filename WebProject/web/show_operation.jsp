<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Enumeration"%>
<%@page import="webproject.misc.PageType"%>
<% pageContext.setAttribute("pageTitle", "Entrar"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <h1>Operação realizada com sucesso</h1>
        
        <table>
        <%
        Enumeration<String> eNames = request.getAttributeNames();
        List<String> names = Collections.list(eNames);
        Collections.sort(names);
        
        for (String name : names)
        {
            if (name.startsWith("Attribute:"))
            {
                out.print("<tr>");
                
                String attributeValue = (String) request.getAttribute(name);
                String attributeName = name.substring("Attribute:xx.".length());

                out.print("<td>" + attributeName + "</td>");
                out.print("<td>" + attributeValue + "</td>");

                out.print("</tr>\n");
            }
        }
        %>
        </table>
    </body>
</html>
