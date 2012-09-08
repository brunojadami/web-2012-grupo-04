<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="webproject.misc.Util"%>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Formação acadêmica"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js"></script>
        <script type="text/javascript" src="script/academic.js"></script>
        
        <h1>Formação acadêmica</h1>
        
        <form name="form" method="POST" action="./PersonalInfo" onsubmit="return validateForm();">
            
            <h3>Geral</h3>
            Nível:
            <select name="generalLevel">
                <%
                List<String> levelNames = Util.getAcademicLevelNames();
                for (String levelName : levelNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", levelName));
                }
                %>
            </select><br/>
            Tipo:
            <input type="text" name="generalType"/><br/>
            Instituto:
            <input type="text" name="generalInstitute"/><br/>
            Curso:
            <input type="text" name="generalCourse"/><br/>
            Estado:
            <select name="generalStatus">
                <%
                List<String> statusNames = Util.getAcademicStatusNames();
                for (String statusName : statusNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", statusName));
                }
                %>
            </select><br/>
            
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
            
            <input type="submit" value="Adicionar"/>
            
        </form>
    </body>
</html>
