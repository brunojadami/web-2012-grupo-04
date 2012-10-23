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
        <table>
            <tr>
                <td>Informa��es pessoais e endere�o</td>
                <td class="Right">
                    <a href="PersonalInfo?action=edit&amp;id=0"><img src="image/edit.png" title="Modificar"/></a>
                    <a href="PersonalInfo?action=view&amp;id=0"><img src="image/view.png" title="Visualizar"/></a>
                </td>
            </tr>
            <tr>
                <td>Forma��o acad�mica</td>
                <td class="Right">
                    <a href="Academic?action=edit&amp;id=-1"><img src="image/new.png" title="Novo"/></a>
                    <a href="Academic?action=list_view&amp;id=-1"><img src="image/list.png" title="Lista"/></a>
                </td>
            </tr>
            <tr>
                <td>Forma��o complementar</td>
                <td class="Right">
                    <a href="complementary.jsp?id=-1"><img src="image/new.png" title="Novo"/></a>
                    <a href=""><img src="image/list.png" title="Lista"/></a>
                </td>
            </tr>
            <tr>
                <td>Atua��o profissional</td>
                <td class="Right">
                    <a href="experience.jsp?id=-1"><img src="image/new.png" title="Novo"/></a>
                    <a href=""><img src="image/list.png" title="Lista"/></a>
                </td>
            </tr>
            <tr>
                <td>Produ��o bibliogr�fica</td>
                <td class="Right">
                    <a href="production.jsp?id=-1"><img src="image/new.png" title="Novo"/></a>
                    <a href=""><img src="image/list.png" title="Lista"/></a>
                </td>
            </tr>
        </table>
    </body>
</html>
