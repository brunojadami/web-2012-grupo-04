<%@page import="webproject.bean.Bean"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.Util"%>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Forma��o complementar"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js" charset="utf-8"></script>
        <script type="text/javascript" src="script/complementary.js" charset="utf-8"></script>
        
        <h1>Forma��o complementar</h1>
        
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
	
        <form name="form" method="POST" action="./Complementary" onsubmit="return validateForm();">
            
            <h3>Dados gerais</h3>
            <label>N�vel:</label>    
            <select name="generalLevel">
                <%
                List<String> levelNames = Util.getComplementaryLevelNames();
                for (String levelName : levelNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", levelName));
                }
                %>
            </select>
	    <label class="Small">Escolha uma op��o</label>
            <label>Institui��o:</label>
            <input type="text" name="generalInstitution"/> 
	    <label class="Small">Aceita letras e espa�os. Tamanho de 4 a 40</label>
	    <label>Curso:</label>
            <input type="text" name="generalCourse"/> 
	    <label class="Small">Aceita letras e espa�os. Tamanho de 4 a 40</label>
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
	    <label class="Small">Escolha uma op��o</label>
            <label>Carga hor�ria:</label>
            <input type="text" name="generalTime"/> 
	    <label class="Small">Em horas semanais. Exemplo: 8</label>
            
            <h3>Per�odo</h3>
            <label>Ano de in�cio:</label>
            <input type="text" name="periodBegin"/>
	    <label class="Small">Exemplo: 2010</label>
            <label>Ano de t�rmino:</label>
            <input type="text" name="periodEnd"/>
	    <label class="Small">Exemplo: 2012</label>
            
            <h3>Bolsa</h3>
            <label>Com bolsa?</label>
            <select name="scholarshipPresence">
                <option value="no">N�o</option>
                <option value="yes">Sim</option>
            </select> 
	    <label class="Small">Selecione uma op��o</label>
            <label>Ag�ncia financiadora:</label>
            <input type="text" name="scholarshipAgency"/> 
	    <label class="Small">Aceita letras e espa�os. Tamanho de 4 a 40</label>
            
            <%
            Bean bean = (Bean) request.getAttribute("bean");
            %>
            
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="<% out.print(bean.getId()); %>"/>
            <input type="submit" value="Confirmar"/>
            
        </form>
    </body>
</html>
