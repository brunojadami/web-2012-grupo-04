<%@page import="webproject.bean.Bean"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.Util"%>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Produc�es bibliogr�ficas");%>
<% pageContext.setAttribute("pageType", PageType.SESSION);%>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js" charset="utf-8"></script>
        <script type="text/javascript" src="script/accepted.js" charset="utf-8"></script>

	<h1>Artigos aceitos para publica��o</h1>

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
                <td>Op��es</td>
                <td class="Right"><a href="control_panel.jsp"><img src="image/control_panel.png" title="Painel de controle"/></a></td>
            </tr>
        </table>

        <form name="form" method="POST" action="./Accepted" onsubmit="return validateForm();">

            <h3>Geral</h3>
            <label>T�tulo:</label>
            <input type="text" name="generalTitle"/> 
	    <label class="Small">Aceita letras e espa�os. Tamanho de 4 a 40</label>
            <label>Idioma:</label>
            <select name="generalLanguage">
                <%
		    List<String> statusNames = Util.getLanguages();
		    for (String statusName : statusNames)
		    {
			out.println("<option value='#'>#</option>".replaceAll("#", statusName));
		    }
                %>
            </select> 
	    <label class="Small">Escolha uma op��o</label>
            <label>Ano previsto para publica��o:</label>
            <input type="text" name="generalYear"/>
	    <label class="Small">Ex: 2012</label>

            <h3>Detalhamento</h3>
            <label>T�tulo do peri�dico/revista em que o artigo ser� publicado:</label>
            <input type="text" name="detailedTitle"/> 
	    <label class="Small">Aceita letras e espa�os. Tamanho de 4 a 40</label>
            <label>ISSN:</label>
            <input type="text" name="detailedISSN"/> 
	    <label class="Small">Aceita letras, n�meros e espa�os. Tamanho de 4 a 40</label>

            <h3>Outras informa��es</h3>
            <textarea name="otherInfo"></textarea> 
	    <label class="Small">Aceita todos os caracteres. Tamanho at� 300</label>

	    <%
		Bean bean = (Bean) request.getAttribute("bean");
	    %>

            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="<% out.print(bean.getId());%>"/>
            <input type="submit" value="Confirmar"/>

        </form>

    </body>
</html>
