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
                <td>Informações pessoais e endereço</td>
                <td class="Right">
                    <a href="PersonalInfo?action=edit&amp;id=0"><img src="image/edit.png" title="Modificar"/></a>
                    <a href="PersonalInfo?action=view&amp;id=0"><img src="image/view.png" title="Visualizar"/></a>
                </td>
            </tr>
            <tr>
                <td>Formação acadêmica</td>
                <td class="Right">
                    <a href="Academic?action=edit&amp;id=-1"><img src="image/new.png" title="Novo"/></a>
                    <a href="Academic?action=list_view&amp;id=-1"><img src="image/list.png" title="Lista"/></a>
                </td>
            </tr>
            <tr>
                <td>Formação complementar</td>
                <td class="Right">
                    <a href="Complementary?action=edit&amp;id=-1"><img src="image/new.png" title="Novo"/></a>
                    <a href="Complementary?action=list_view&amp;id=-1"><img src="image/list.png" title="Lista"/></a>
                </td>
            </tr>
            <tr>
                <td>Atuação profissional</td>
                <td class="Right">
                    <a href="Experience?action=edit&amp;id=-1"><img src="image/new.png" title="Novo"/></a>
                    <a href="Experience?action=list_view&amp;id=-1"><img src="image/list.png" title="Lista"/></a>
                </td>
            </tr>
	    <tr>
                <td>Artigos completos publicados em periódicos</td>
                <td class="Right">
                    <a href="Published?action=edit&amp;id=-1"><img src="image/new.png" title="Novo"/></a>
                    <a href="Published?action=list_view&amp;id=-1"><img src="image/list.png" title="Lista"/></a>
                </td>
            </tr>
            <tr>
                <td>Artigos aceitos para publicação</td>
                <td class="Right">
                    <a href="Accepted?action=edit&amp;id=-1"><img src="image/new.png" title="Novo"/></a>
                    <a href="Accepted?action=list_view&amp;id=-1"><img src="image/list.png" title="Lista"/></a>
                </td>
            </tr>
	    <tr>
                <td>Livro ou capítulo de livro</td>
                <td class="Right">
                    <a href="Book?action=edit&amp;id=-1"><img src="image/new.png" title="Novo"/></a>
                    <a href="Book?action=list_view&amp;id=-1"><img src="image/list.png" title="Lista"/></a>
                </td>
            </tr>
        </table>
    </body>
</html>
