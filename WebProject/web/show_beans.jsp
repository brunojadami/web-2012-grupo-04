<%@page import="java.util.LinkedList"%>
<%@page import="webproject.bean.Bean"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Enumeration"%>
<%@page import="webproject.misc.PageType"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<% pageContext.setAttribute("pageTitle", "Entrar"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <h1><%=(String) request.getAttribute("message")%></h1>
        
        <table id="optionsTable">
            <tr>
                <td>Opções</td>
                <td style="text-align: right;">
                    <a href="<% out.print((String) request.getAttribute("servletName") + "?action=update&id=-1");%>"><img src="image/new.png" title="Novo"/></a>
                    <a href="control_panel.jsp"><img src="image/control_panel.png" title="Painel de controle"/></a>
                </td>
            </tr>
        </table>
        
        <table>
        <%
        List<Bean> beans = (List<Bean>) request.getAttribute("list");
        
        int id = 0;
        for (Bean bean : beans)
        {
            List<String> fields = new LinkedList<String>();
            
            for (Method method : bean.getClass().getDeclaredMethods())
            {
                if (method.getParameterTypes().length == 0 && method.getReturnType() == String.class)
                {
                    String field = (String) method.invoke(bean);
                    fields.add(field);
                }
            }

            Collections.sort(fields, new Bean.FieldComparator());
            fields = fields.subList(0, Math.min(4, fields.size()));

            out.print("<tr><td>" + (id) + "</td>");
            
            for (String field : fields)
            {
                out.print("<td>" + Bean.getFieldValue(field) + "</td>");
            }
            
            out.print("<td>...</td>");
            out.print("<td style=\"text-align: right;\"><a href=\"" + request.getAttribute("servletName") + "?action=view&id=" + id + "\"><img src=\"image/view.png\" title=\"Visualizar\"/></td>");
            out.print("</tr>\n");
            
            id++;
        }
        %>
        </table>
    </body>
</html>
