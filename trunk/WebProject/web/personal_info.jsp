<%@page contentType="text/html" pageEncoding="ISO-8859-15"%>
<%@page import="webproject.misc.PageType"%>
<%@page import="webproject.misc.Util"%>
<%@page import="java.util.List"%>
<% pageContext.setAttribute("pageTitle", "Informa��es pessoais"); %>
<% pageContext.setAttribute("pageType", PageType.ANY); %>
<%@ include file="session.jsp" %>
<!DOCTYPE html>
<html>
    <%@ include file="head.jsp" %>
    <body>
        <script type="text/javascript" src="script/validation.js"></script>
        <script type="text/javascript" src="script/personal_info.js"></script>
        
        <h1>Informa��es pessoais e endere�o</h1>
        
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
            <input type="text" name="generalName"/> Aceita letras e espa�os. Tamanho de 2 a 30<br/>
            Nome de cita��o:
            <input type="text" name="generalCitationName"/> Aceita letras, espa�os e pontos. Tamanho de 2 a 30<br/>
            Pa�s:
            <select name="generalCountry">
                <%
                List<String> countryNames = Util.getCountryNames();
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> Escolha uma op��o<br/>
            CPF:
            <input type="text" name="generalCpf"/> Exemplo: 111.222.333-44<br/>
            Sexo:
            <select name="generalSex">
                <option value="male">Homem</option>
                <option value="female">Mulher</option>
            </select> Escolha uma op��o<br/>
            
            <h3>Identidade</h3>
            N�mero:
            <input type="text" name="idNumber"/> Exemplo: 123456789 ou 12345678<br/>
            Emissor:
            <input type="text" name="idEmissioner"/> Aceita letras e espa�os. Tamanho de 2 a 10<br/>
            Estado:
            <select name="idState">
            <%
                List<String> stateNames = Util.getStateNames();
                for (String stateName : stateNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                }
            %>
            </select> Escolha uma op��o<br/>
            Data de emiss�o:
            <input type="text" name="idEmissionDate"/> Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90<br/>
            
            <h3>Nascimento</h3>
            Pa�s:
            <select name="birthCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> Escolha uma op��o<br/>
            Estado:
            <select name="birthState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select> Escolha uma op��o<br/>
            Cidade:
            <input type="text" name="birthCity"/> Aceita letras e espa�os. Tamanho de 2 a 40<br/>
            Data:
            <input type="text" name="birthDate"/> Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90<br/>
            
            <h3>Passaporte</h3>
            N�mero:
            <input type="text" name="passportNumber"/> Segue o modelo XXxxxxxx. Exemplo: AB123456<br/>
            Data de validade:
            <input type="text" name="passportValidityDate"/> Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90<br/>
            Data de emiss�o:
            <input type="text" name="passportEmissionDate"/> Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90<br/>
            Pa�s:
            <select name="passportCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> Escolha uma op��o<br/>
            
            <h3>Filia��o</h3>
            Pai:
            <input type="text" name="filiationFatherName"/> Aceita letras e espa�os. Tamanho de 2 a 30<br/>
            M�e:
            <input type="text" name="filiationMotherName"/> Aceita letras e espa�os. Tamanho de 2 a 30<br/>
            
            <h3>Endere�o</h3>
            Logradouro:
            <input type="text" name="addressStreet"/> Aceita letras, espa�os e n�meros. Tamanho de 4 a 50<br/>
            CEP:
            <input type="text" name="addressZipCode"/> Aceita n�meros. Tamanho de 6 a 30<br/>
            Cidade:
            <input type="text" name="addressCity"/> Aceita letras e espa�os. Tamanho de 2 a 40<br/>
            Pa�s:
            <select name="addressCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> Escolha uma op��o<br/>
            Bairro:
            <input type="text" name="addressDistrict"/> Aceita letras e espa�os. Tamanho de 2 a 40<br/>
            Estado:
            <select name="addressState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select> Escolha uma op��o<br/>
            Telefone:
            <input type="text" name="addressPhone"/> Aceita n�meros. Tamanho de 6 a 30<br/>
            
            <h3>Endere�o Profissional</h3>
            Empresa:
            <input type="text" name="professionalAddressCompany"/> Aceita letras e espa�os. Tamanho de 2 a 40<br/>
            Unidade:
            <input type="text" name="professionalAddressUnit"/> Aceita letras, espa�os e n�meros. Tamanho de 2 a 30<br/>
            Rua:
            <input type="text" name="professionalAddressStreet"/> Aceita letras, espa�os e n�meros. Tamanho de 4 a 50<br/>
            CEP:
            <input type="text" name="professionalAddressZipCode"/> Aceita n�meros. Tamanho de 6 a 30<br/>
            Cidade:
            <input type="text" name="professionalAddressCity"/> Aceita letras e espa�os. Tamanho de 2 a 40<br/>
            Pa�s:
            <select name="professionalAddressCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> Escolha uma op��o<br/>
            Bairro:
            <input type="text" name="professionalAddressDistrict"/> Aceita letras e espa�os. Tamanho de 2 a 40<br/>
            Estado:
            <select name="professionalAddressState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select> Escolha uma op��o<br/>
            Telefone:
            <input type="text" name="professionalAddressPhone"/> Aceita n�meros. Tamanho de 6 a 30<br/>
            
            <h3>Outros</h3>
            Email:
            <input type="text" name="miscEmail"/> Qualquer email v�lido. Exemplo: test@test.com<br/>
            
            <input type="submit" value="Enviar"/>
            
        </form>
    </body>
</html>
