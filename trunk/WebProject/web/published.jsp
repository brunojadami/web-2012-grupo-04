<%@page import="webproject.bean.Bean"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.Util"%>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Producões bibliográficas");%>
<% pageContext.setAttribute("pageType", PageType.ANY);%>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js" charset="utf-8"></script>
        <script type="text/javascript" src="script/published.js" charset="utf-8"></script>

	<h1>Artigos completos publicados em periódicos</h1>

	<label class="Error" id="errorLabel">
	    <%
		String message = (String) request.getAttribute("errorMessage");
		if (message != null)
		{
		    out.println(message);
		}
	    %>
	</label>
	
	<table id="optionsTable">
            <tr>
                <td>Opções</td>
                <td class="Right"><a href="control_panel.jsp"><img src="image/control_panel.png" title="Painel de controle"/></a></td>
            </tr>
        </table>

        <form name="form" method="POST" action="./Published" onsubmit="return validateForm();">

	    <h3>Geral</h3>
            <label>Informe o DOI, ISSN ou parte do nome do periódico:</label>
            <input type="text" name="completeName"/> 
	    <label class="Small">Aceita letras, números e espaços. Tamanho de 4 a 40</label>

	    <%
		Bean bean = (Bean) request.getAttribute("bean");
	    %>

            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="<% out.print(bean.getId());%>"/>
            <input type="submit" value="Confirmar"/>

        </form>

    </body>
</html>
