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
<% pageContext.setAttribute("pageType", PageType.SESSION); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <h1><%=(String) request.getAttribute("message")%></h1>
        
        <%
        Bean bean = (Bean) request.getAttribute("bean");
        %>
        
        <table id="optionsTable">
            <tr>
                <td>Op��es</td>
                <td class="Right">
                    <a href="<% out.print(request.getAttribute("servletName") + "?action=delete&id=" + bean.getId()); %>"><img src="image/delete.png" title="Remover"/></a>
                    <a href="<% out.print(request.getAttribute("servletName") + "?action=edit&id=" + bean.getId());%>"><img src="image/edit.png" title="Modificar"/></a>
                    <a href="control_panel.jsp"><img src="image/control_panel.png" title="Painel de controle"/></a>
                </td>
            </tr>
        </table>
                
        <table>
            <%
            for (Map.Entry<Bean.Attribute, String> entry : bean.getAttributes().entrySet())
            {
                String method = entry.getValue();
                Bean.Attribute attribute = entry.getKey();
                Object value = bean.getClass().getMethod(method).invoke(bean);
                
                out.print("<tr>");

                out.print("<td>" + attribute.getShowingName() + "</td>");
                out.print("<td class=\"Right\">" + value.toString() + "</td>");

                out.print("</tr>\n");
            }
            %>
        </table>
    </body>
</html>
