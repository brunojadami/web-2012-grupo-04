<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.Util"%>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Atuação profissional"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js" charset="utf-8"></script>
        <script type="text/javascript" src="script/experience.js" charset="utf-8"></script>
        
        <h1>Atuação profissional</h1>
        
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
            
            <h3>Instituição</h3>
            <label>Nome da instituição:</label>
            <input type="text" name="profInstitution"/> 
	    <label class="Small">Aceita letras e espaços. Tamanho de 4 a 40</label>
            
            <h3>Vínculo</h3>
            <label>Tipo do vínculo:</label>
            <input type="text" name="bondType"/> 
	    <label class="Small">Aceita letras e espaços. Tamanho de 4 a 40</label>
            <label>Possui vínculo empregatício?</label>
            <select name="bondEmployment">
                <option value="no">Não</option>
                <option value="yes">Sim</option>
            </select> 
	    <label class="Small">Selecione uma opção.</label>
            <label>Enquadramento funcional:</label>
            <input type="text" name="bondFunctional"/> 
	    <label class="Small">Aceita letras e espaços. Tamanho de 4 a 40</label>
            <label>Carga horária:</label>
            <input type="text" name="bondTime"/> 
	    <label class="Small">Em horas semanais (ex: 8).</label>
            <label>Dedicação exclusiva:</label>
            <select name="bondExclusive">
                <option value="no">Não</option>
                <option value="yes">Sim</option>
            </select> 
	    <label class="Small">Selecione uma opção.</label>
            
            <h3>Período</h3>
            <label>Início:</label>
            <label>Mês:</label>
	    <input type="text" name="periodMonth"/>
	    <label class="Small">Use números. Ex: 08 (agosto)</label>
            <label>Ano:</label>
	    <input type="text" name="periodYear"/>
	    <label class="Small">Ex: 2012</label>
	    <label>Finalizado?</label>
            <select name="periodFinished">
                <option value="no">Atual (não finalizado)</option>
                <option value="yes">Anterior (finalizado)</option>
            </select> 
	    <label class="Small">Selecione uma opção.</label>
            
            <h3>Outras informações</h3>
            <textarea name="otherInfo"></textarea> 
	    <label class="Small">Aceita todos os caracteres. Tamanho até 300</label>
            
            <input type="submit" value="Adicionar"/>
            
        </form>
    </body>
</html>
