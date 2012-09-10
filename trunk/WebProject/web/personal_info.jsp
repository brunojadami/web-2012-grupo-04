<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.PageType"%>
<%@page import="webproject.misc.Util"%>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Informações pessoais"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js"></script>
        <script type="text/javascript" src="script/personal_info.js"></script>
        
        <h1>Informações pessoais e endereço</h1>
        
        <%
        String message = (String) request.getAttribute("message");
        if (message != null)
        {
            out.println(message);
        }
        %>
        
        <form name="form" method="POST" action="./PersonalInfo" onsubmit="return validateForm();">
            
            <h3>Geral</h3>
            Nome:
            <input type="text" name="generalName"/> Aceita letras e espaços. Tamanho de 2 a 30<br/>
            Nome de citação:
            <input type="text" name="generalCitationName"/> Aceita letras, espaços e pontos. Tamanho de 2 a 30<br/>
            País:
            <select name="generalCountry">
                <%
                List<String> countryNames = Util.getCountryNames();
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> Escolha uma opção<br/>
            CPF:
            <input type="text" name="generalCpf"/> Exemplo: 111.222.333-44<br/>
            Sexo:
            <select name="generalSex">
                <option value="male">Homem</option>
                <option value="female">Mulher</option>
            </select> Escolha uma opção<br/>
            
            <h3>Identidade</h3>
            Número:
            <input type="text" name="idNumber"/> Exemplo: 123456789 ou 12345678<br/>
            Emissor:
            <input type="text" name="idEmissioner"/> Aceita letras e espaços. Tamanho de 2 a 10<br/>
            Estado:
            <select name="idState">
            <%
                List<String> stateNames = Util.getStateNames();
                for (String stateName : stateNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                }
            %>
            </select> Escolha uma opção<br/>
            Data de emissão:
            <input type="text" name="idEmissionDate"/> Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90<br/>
            
            <h3>Nascimento</h3>
            País:
            <select name="birthCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> Escolha uma opção<br/>
            Estado:
            <select name="birthState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select> Escolha uma opção<br/>
            Cidade:
            <input type="text" name="birthCity"/> Aceita letras e espaços. Tamanho de 2 a 40<br/>
            Data:
            <input type="text" name="birthDate"/> Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90<br/>
            
            <h3>Passaporte</h3>
            Número:
            <input type="text" name="passportNumber"/> Segue o modelo XXxxxxxx. Exemplo: AB123456<br/>
            Data de validade:
            <input type="text" name="passportValidityDate"/> Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90<br/>
            Data de emissão:
            <input type="text" name="passportEmissionDate"/> Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90<br/>
            País:
            <select name="passportCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> Escolha uma opção<br/>
            
            <h3>Filiação</h3>
            Pai:
            <input type="text" name="filiationFatherName"/> Aceita letras e espaços. Tamanho de 2 a 30<br/>
            Mãe:
            <input type="text" name="filiationMotherName"/> Aceita letras e espaços. Tamanho de 2 a 30<br/>
            
            <h3>Endereço</h3>
            Logradouro:
            <input type="text" name="addressStreet"/> Aceita letras, espaços e números. Tamanho de 4 a 50<br/>
            CEP:
            <input type="text" name="addressZipCode"/> Aceita números. Tamanho de 6 a 30<br/>
            Cidade:
            <input type="text" name="addressCity"/> Aceita letras e espaços. Tamanho de 2 a 40<br/>
            País:
            <select name="addressCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> Escolha uma opção<br/>
            Bairro:
            <input type="text" name="addressDistrict"/> Aceita letras e espaços. Tamanho de 2 a 40<br/>
            Estado:
            <select name="addressState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select> Escolha uma opção<br/>
            Telefone:
            <input type="text" name="addressPhone"/> Aceita números. Tamanho de 6 a 30<br/>
            
            <h3>Endereço Profissional</h3>
            Empresa:
            <input type="text" name="professionalAddressCompany"/> Aceita letras e espaços. Tamanho de 2 a 40<br/>
            Unidade:
            <input type="text" name="professionalAddressUnit"/> Aceita letras, espaços e números. Tamanho de 2 a 30<br/>
            Rua:
            <input type="text" name="professionalAddressStreet"/> Aceita letras, espaços e números. Tamanho de 4 a 50<br/>
            CEP:
            <input type="text" name="professionalAddressZipCode"/> Aceita números. Tamanho de 6 a 30<br/>
            Cidade:
            <input type="text" name="professionalAddressCity"/> Aceita letras e espaços. Tamanho de 2 a 40<br/>
            País:
            <select name="professionalAddressCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> Escolha uma opção<br/>
            Bairro:
            <input type="text" name="professionalAddressDistrict"/> Aceita letras e espaços. Tamanho de 2 a 40<br/>
            Estado:
            <select name="professionalAddressState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select> Escolha uma opção<br/>
            Telefone:
            <input type="text" name="professionalAddressPhone"/> Aceita números. Tamanho de 6 a 30<br/>
            
            <h3>Outros</h3>
            Email:
            <input type="text" name="miscEmail"/> Qualquer email válido. Exemplo: test@test.com<br/>
            
            <input type="submit" value="Enviar"/>
            
        </form>
    </body>
</html>
