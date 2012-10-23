<%@page import="webproject.bean.Bean"%>
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
        <script type="text/javascript" src="script/validation.js" charset="utf-8"></script>
        <script type="text/javascript" src="script/academic.js" charset="utf-8"></script>
        
        <h1>Formação acadêmica</h1>
        
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
                
        <form name="form" method="POST" action="./Academic" onsubmit="return validateForm();">
            
            <h3>Geral</h3>
            <label>Nível:</label>
            <select name="generalLevel">
                <%
                List<String> levelNames = Util.getAcademicLevelNames();
                for (String levelName : levelNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", levelName));
                }
                %>
            </select> 
            <label class="Small"> Escolha uma opção</label>
            <label>Tipo:</label>
            <input type="text" name="generalType"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 5 a 50</label>
            <label>Instituto:</label>
            <input type="text" name="generalInstitute"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 30</label>
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
            
            <h3>Período</h3>
            <label>Início:</label>
            <input type="text" name="periodStartDate"/> 
            <label class="Small">Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90</label>
            <label>Término:</label>
            <input type="text" name="periodEndDate"/> 
            <label class="Small">Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90</label>
            
            <h3>Bolsa</h3>
            <label>Com bolsa?</label>
            <select name="scholarshipPresence">
                <option value="no">Não</option>
                <option value="yes">Sim</option>
            </select> 
            <label class="Small">Escolha uma opção</label>
            <label>Agência financiadora:</label>
            <input type="text" name="scholarshipAgency"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 30</label>
            
            <h3>Outros</h3>
            <label>Informações adicionais:</label>
            <textarea name="miscInfo"></textarea> 
            <label class="Small">Aceita todos os caracteres. Tamanho até 300</label>
            
            <%
            Bean bean = (Bean) request.getAttribute("bean");
            %>
            
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="<% out.print(bean.getId()); %>"/>
            <input type="submit" value="Confirmar"/>
            
        </form>
    </body>
</html>
