<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.Util"%>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Formação complementar"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js" charset="utf-8"></script>
        <script type="text/javascript" src="script/complementary.js" charset="utf-8"></script>
        
        <h1>Formação complementar</h1>
        
	<label class="Error" id="errorLabel">
        <%
        String message = (String) request.getAttribute("message");
        if (message != null)
        {
            out.println(message);
        }
        %>
        </label>
	
        <form name="form" method="POST" action="./Complementary" onsubmit="return validateForm();">
            
            <h3>Dados gerais</h3>
            <label>Nível:</label>    
            <select name="generalLevel">
                <%
                List<String> levelNames = Util.getComplementaryLevelNames();
                for (String levelName : levelNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", levelName));
                }
                %>
            </select>
	    <label class="Small">Escolha uma opção</label>
            <label>Instituição:</label>
            <input type="text" name="generalInstitution"/> 
	    <label class="Small">Aceita letras e espaços. Tamanho de 4 a 40</label>
	    <label>Curso:</label>
            <input type="text" name="generalCourse"/> 
	    <label class="Small">Aceita letras e espaços. Tamanho de 4 a 40</label>
            <label>Estado:</label>
            <select name="generalStatus">
                <%
                List<String> statusNames = Util.getAcademicStatusNames();
                for (String statusName : statusNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", statusName));
                }
                %>
            </select> 
	    <label class="Small">Escolha uma opção</label>
            <label>Carga horária:</label>
            <input type="text" name="generalTime"/> 
	    <label class="Small">Em horas semanais. Exemplo: 8</label>
            
            <h3>Período</h3>
            <label>Ano de início:</label>
            <input type="text" name="periodBegin"/>
	    <label class="Small">Exemplo: 2010</label>
            <label>Ano de término:</label>
            <input type="text" name="periodEnd"/>
	    <label class="Small">Exemplo: 2012</label>
            
            <h3>Bolsa</h3>
            <label>Com bolsa?</label>
            <select name="scholarshipPresence">
                <option value="no">Não</option>
                <option value="yes">Sim</option>
            </select> 
	    <label class="Small">Selecione uma opção</label>
            <label>Agência financiadora:</label>
            <input type="text" name="scholarshipAgency"/> 
	    <label class="Small">Aceita letras e espaços. Tamanho de 4 a 40</label>
            
            <input type="submit" value="Adicionar"/>
            
        </form>
    </body>
</html>
