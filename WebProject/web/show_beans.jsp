<%@page import="java.util.Map"%>
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
                    <a href="<% out.print(request.getAttribute("servletName") + "?action=edit&id=-1");%>"><img src="image/new.png" title="Novo"/></a>
                    <a href="control_panel.jsp"><img src="image/control_panel.png" title="Painel de controle"/></a>
                </td>
            </tr>
        </table>
        
        <table>
        <%
        List<Bean> beans = (List<Bean>) request.getAttribute("list");
        
        for (Bean bean : beans)
        {
            int count = 5;
            
            out.print("<tr><td>" + bean.getId() + "</td>");
            
            for (Map.Entry<Bean.Attribute, String> entry : bean.getAttributes().entrySet())
            {
                String method = entry.getValue();
                Object value = bean.getClass().getMethod(method).invoke(bean);
                
                if (count-- == 5)
                    continue;
                
                out.print("<td class=\"Right\">" + value.toString() + "</td>");
                
                if (count < 0)
                    break;
            }
            
            out.print("<td>...</td>");
            out.print("<td style=\"text-align: right;\">");
            out.print("<a href=\"" + request.getAttribute("servletName") + "?action=view&id=" + bean.getId() + "\"><img src=\"image/view.png\" title=\"Visualizar\"/>\n<a href=\"" + request.getAttribute("servletName") + "?action=delete&id=" + bean.getId() + "\"><img src=\"image/delete.png\" title=\"Remover\"/>");
            out.print("</td>");
            out.print("</tr>\n");
        }
        %>
        </table>
    </body>
</html>
