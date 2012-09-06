<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="webproject.*" %>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Formação acadêmica"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js"></script>
        
        <h1>Formação acadêmica</h1>
        
        <form name="form" method="POST" action="./PersonalInfo">
            
            <h3>Geral</h3>
            Nível:
            <input type="text" name="generalLevel"/><br/>
            Tipo:
            <input type="text" name="generalType"/><br/>
            Instituto:
            <input type="text" name="generalInstitute"/><br/>
            Curso:
            <input type="text" name="generalCourse"/><br/>
            Estado:
            <input type="text" name="generalStatus"/><br/>
            
            <h3>Período</h3>
            Início:
            <input type="text" name="periodStartDate"/><br/>
            Término:
            <input type="text" name="periodEndDate"/><br/>
            
            <h3>Bolsa</h3>
            Com bolsa?
            <select name="scholarshipPresence">
                <option value="0">Não</option>
                <option value="1">Sim</option>
            </select><br/>
            Agência financiadora:
            <input type="text" name="scholarshipAgency"/><br/>
            
            Informações adicionais:
            <textarea name="miscInfo"></textarea><br/>
            
            <input type="submit" value="Enviar"/>
            
        </form>
    </body>
</html>
