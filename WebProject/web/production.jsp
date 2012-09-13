<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.Util"%>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Producões bibliográficas"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js" charset="utf-8"></script>
        <script type="text/javascript" src="script/production.js" charset="utf-8"></script>
        
        <h1>Produções bibliográficas</h1>
        
	<label class="Error" id="errorLabel">
        <%
        String message = (String) request.getAttribute("message");
        if (message != null)
        {
            out.println(message);
        }
        %>
	</label>
        
        <br/><br/><br/>
        
	<h1>Artigos completos publicados em periódicos</h1>
	
        <form name="publishedForm" method="POST" action="./Production" onsubmit="return validatePublishedForm();">
            
	    <h3>Geral</h3>
            <label>Informe o DOI, ISSN ou parte do nome do periódico:</label>
            <input type="text" name="completeName"/> 
	    <label class="Small">Aceita letras, números e espaços. Tamanho de 4 a 40</label>
            <input type="hidden" name="formType" value="published">
            <input type="submit" value="Adicionar"/>
            
        </form>
        
	<h1>Artigos aceitos para publicação</h1>
        <form name="acceptedForm" method="POST" action="./Production" onsubmit="return validateAcceptedForm();">
            
            <h3>Geral</h3>
            <label>Título:</label>
            <input type="text" name="generalTitle"/> 
	    <label class="Small">Aceita letras e espaços. Tamanho de 4 a 40</label>
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
	    <label class="Small">Escolha uma opção</label>
            <label>Ano previsto para publicação:</label>
            <input type="text" name="generalYear"/>
	    <label class="Small">Ex: 2012</label>
            
            <h3>Detalhamento</h3>
            <label>Título do periódico/revista em que o artigo será publicado:</label>
            <input type="text" name="detailedTitle"/> 
	    <label class="Small">Aceita letras e espaços. Tamanho de 4 a 40</label>
            <label>ISSN:</label>
            <input type="text" name="detailedISSN"/> 
	    <label class="Small">Aceita letras, números e espaços. Tamanho de 4 a 40</label>
            
            <h3>Outras informações</h3>
            <textarea name="otherInfo"></textarea> 
	    <label class="Small">Aceita todos os caracteres. Tamanho até 300</label>
            <input type="hidden" name="formType" value="accepted">
            <input type="submit" value="Adicionar"/>
            
        </form>
        
	<h1>Livro ou capítulo de livro</h1>
        <form name="bookForm" method="POST" action="./Production" onsubmit="return validateBookForm();">

	    <h3>Geral</h3>
            <label>Tipo de produção:</label>
            <select name="bookType">
                <%
                List<String> productions = Util.getProductionTypes();
                for (String statusName : productions)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", statusName));
                }
                %>
            </select> 
	    <label class="Small">Escolha uma opção</label>
            <label>Informe o DOI ou ISSN:</label>
            <input type="text" name="bookISSN"/> 
	    <label class="Small">Aceita letras, números e espaços. Tamanho de 4 a 40</label>
            <input type="hidden" name="formType" value="book">
            <input type="submit" value="Adicionar"/>
            
        </form>
        
    </body>
</html>
