<%@page import="java.util.LinkedList"%>
<%@page import="webproject.bean.Bean"%>
<%@page import="java.lang.reflect.Method"%>
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
        Object object = request.getAttribute("object");
        List<String> fields = new LinkedList<String>();
        
        for (Method method : object.getClass().getDeclaredMethods())
        {
            if (method.getParameterTypes().length == 0)
            {
                String field = (String) method.invoke(object);
                fields.add(field);
            }
        }
        
        Collections.sort(fields, new Bean.FieldComparator());
        
        for (String field : fields)
        {
            out.print("<tr>");

            out.print("<td>" + Bean.getFieldName(field) + "</td>");
            out.print("<td>" + Bean.getFieldValue(field) + "</td>");

            out.print("</tr>\n");
        }
        %>
        </table>
        <a href="control_panel.jsp">Painel de controle</a>
    </body>
</html>
