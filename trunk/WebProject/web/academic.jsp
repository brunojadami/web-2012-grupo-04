<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
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
        
        <%
        String message = (String) request.getAttribute("message");
        if (message != null)
        {
            out.println(message);
        }
        %>
        
        <form name="form" method="POST" action="./Academic" onsubmit="return validateForm();">
            
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
            </select> Escolha uma opção<br/>
            Tipo:
            <input type="text" name="generalType"/> Aceita letras e espaços. Tamanho de 5 a 50<br/>
            Instituto:
            <input type="text" name="generalInstitute"/> Aceita letras e espaços. Tamanho de 2 a 30<br/>
            Curso:
            <input type="text" name="generalCourse"/> Aceita letras e espaços. Tamanho de 4 a 40<br/>
            Estado:
            <select name="generalStatus">
                <%
                List<String> statusNames = Util.getAcademicStatusNames();
                for (String statusName : statusNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", statusName));
                }
                %>
            </select> Escolha uma opção<br/>
            
            <h3>Período</h3>
            Início:
            <input type="text" name="periodStartDate"/> Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90<br/>
            Término:
            <input type="text" name="periodEndDate"/> Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90<br/>
            
            <h3>Bolsa</h3>
            Com bolsa?
            <select name="scholarshipPresence">
                <option value="no">Não</option>
                <option value="yes">Sim</option>
            </select> Escolha uma opção<br/>
            Agência financiadora:
            <input type="text" name="scholarshipAgency"/> Aceita letras e espaços. Tamanho de 2 a 30<br/>
            
            Informações adicionais:
            <textarea name="miscInfo"></textarea> Aceita todos os caracteres. Tamanho até 300<br/>
            
            <input type="submit" value="Adicionar"/>
            
        </form>
    </body>
</html>
