<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.Util"%>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Atua��o profissional"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js" charset="utf-8"></script>
        <script type="text/javascript" src="script/experience.js" charset="utf-8"></script>
        
        <h1>Atua��o profissional</h1>
        
	<label class="Error" id="errorLabel">
        <%
        String message = (String) request.getAttribute("message");
        if (message != null)
        {
            out.println(message);
        }
        %>
	</label>
        
        <form name="form" method="POST" action="./Experience" onsubmit="return validateForm();">
            
            <h3>Institui��o</h3>
            <label>Nome da institui��o:</label>
            <input type="text" name="profInstitution"/> 
	    <label class="Small">Aceita letras e espa�os. Tamanho de 4 a 40</label>
            
            <h3>V�nculo</h3>
            <label>Tipo do v�nculo:</label>
            <input type="text" name="bondType"/> 
	    <label class="Small">Aceita letras e espa�os. Tamanho de 4 a 40</label>
            <label>Possui v�nculo empregat�cio?</label>
            <select name="bondEmployment">
                <option value="no">N�o</option>
                <option value="yes">Sim</option>
            </select> 
	    <label class="Small">Selecione uma op��o.</label>
            <label>Enquadramento funcional:</label>
            <input type="text" name="bondFunctional"/> 
	    <label class="Small">Aceita letras e espa�os. Tamanho de 4 a 40</label>
            <label>Carga hor�ria:</label>
            <input type="text" name="bondTime"/> 
	    <label class="Small">Em horas semanais (ex: 8).</label>
            <label>Dedica��o exclusiva:</label>
            <select name="bondExclusive">
                <option value="no">N�o</option>
                <option value="yes">Sim</option>
            </select> 
	    <label class="Small">Selecione uma op��o.</label>
            
            <h3>Per�odo</h3>
            <label>In�cio:</label>
            <label>M�s:</label>
	    <input type="text" name="periodMonth"/>
	    <label class="Small">Use n�meros. Ex: 08 (agosto)</label>
            <label>Ano:</label>
	    <input type="text" name="periodYear"/>
	    <label class="Small">Ex: 2012</label>
	    <label>Finalizado?</label>
            <select name="periodFinished">
                <option value="no">Atual (n�o finalizado)</option>
                <option value="yes">Anterior (finalizado)</option>
            </select> 
	    <label class="Small">Selecione uma op��o.</label>
            
            <h3>Outras informa��es</h3>
            <textarea name="otherInfo"></textarea> 
	    <label class="Small">Aceita todos os caracteres. Tamanho at� 300</label>
            
            <input type="submit" value="Adicionar"/>
            
        </form>
    </body>
</html>
