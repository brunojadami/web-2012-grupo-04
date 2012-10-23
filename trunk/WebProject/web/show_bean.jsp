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
        
        <%
        Bean bean = (Bean) request.getAttribute("bean");
        %>
        
        <table id="optionsTable">
            <tr>
                <td>Op��es</td>
                <td class="Right">
                    <a style="margin: auto;" href="<% out.print((String) request.getAttribute("servletName") + "?action=edit&id=" + bean.getId());%>"><img src="image/edit.png" title="Modificar"/></a>
                    <a href="control_panel.jsp"><img src="image/control_panel.png" title="Painel de controle"/></a>
                </td>
            </tr>
        </table>
                
        <table>
            <%
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

            for (String field : fields)
            {
                out.print("<tr>");

                out.print("<td>" + Bean.getFieldName(field) + "</td>");
                out.print("<td class=\"Right\">" + Bean.getFieldValue(field) + "</td>");

                out.print("</tr>\n");
            }
            %>
        </table>
    </body>
</html>
