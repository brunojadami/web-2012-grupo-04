<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="webproject.*" %>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Informações pessoais"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js"></script>
        
        <h1>Informações pessoais e endereço</h1>
        
        <form name="form" method="POST" action="./PersonalInfo">
            
            <h3>Geral</h3>
            Nome:
            <input type="text" name="generalName"/><br/>
            Nome de citação:
            <input type="text" name="generalCitationName"/><br/>
            País:
            <select name="generalCountry">
                <%
                List<String> countryNames = Util.getCountryNames();
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select><br/>
            CPF:
            <input type="text" name="generalCpf"/><br/>
            Sexo:
            <select name="generalSex">
                <option value="male">Homem</option>
                <option value="female">Mulher</option>
            </select><br/>
            
            <h3>Identidade</h3>
            Número:
            <input type="text" name="idNumber"/><br/>
            Emissor:
            <input type="text" name="idEmissioner"/><br/>
            Estado:
            <select name="idState">
            <%
                List<String> stateNames = Util.getStateNames();
                for (String stateName : stateNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                }
            %>
            </select><br/>
            Data de emissão:
            <input type="text" name="idEmissionDate"/><br/>
            
            <h3>Nascimento</h3>
            País:
            <select name="birthCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select><br/>
            Estado:
            <select name="birthState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select><br/>
            Cidade:
            <input type="text" name="birthCity"/><br/>
            Data:
            <input type="text" name="birthDate"/><br/>
            
            <h3>Passaporte</h3>
            Número:
            <input type="text" name="passportNumber"/><br/>
            Data de validade:
            <input type="text" name="passportValidityDate"/><br/>
            Data de emissão:
            <input type="text" name="passportEmissionDate"/><br/>
            País:
            <select name="passportCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select><br/>
            
            <h3>Filiação</h3>
            Pai:
            <input type="text" name="filiationFatherName"/><br/>
            Mãe:
            <input type="text" name="filiationMotherName"/><br/>
            
            <h3>Endereço</h3>
            Logradouro:
            <input type="text" name="addressStreet"/><br/>
            CEP:
            <input type="text" name="addressZipCode"/><br/>
            Cidade:
            <input type="text" name="addressCity"/><br/>
            País:
            <select name="addressCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select><br/>
            Bairro:
            <input type="text" name="addressDistrict"/><br/>
            Estado:
            <select name="addressState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select><br/>
            Telefone:
            <input type="text" name="addressPhone"/><br/>
            
            <h3>Endereço Profissional</h3>
            Empresa:
            <input type="text" name="professionalAddressCompany"/><br/>
            Unidade:
            <input type="text" name="professionalAddressUnit"/><br/>
            Rua:
            <input type="text" name="professionalAddressStreet"/><br/>
            CEP:
            <input type="text" name="professionalAddressZipCode"/><br/>
            Cidade:
            <input type="text" name="professionalAddressCity"/><br/>
            País:
            <select name="professionalAddressCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select><br/>
            Bairro:
            <input type="text" name="professionalAddressDistrict"/><br/>
            Estado:
            <select name="professionalAddressState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select><br/>
            Telefone:
            <input type="text" name="professionalAddressPhone"/><br/>
            
            <h3>Outros</h3>
            Email:
            <input type="text" name="miscEmail"/><br/>
            
            <input type="submit" value="Enviar"/>
            
        </form>
    </body>
</html>
