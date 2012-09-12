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
        <script type="text/javascript" src="script/validation.js" charset="utf-8"></script>
        <script type="text/javascript" src="script/personal_info.js" charset="utf-8"></script>
        
        <h1>Informações pessoais e endereço</h1>
        
        <label class="Error" id="errorLabel"><%
        String message = (String) request.getAttribute("message");
        if (message != null)
        {
            out.println(message);
        }
        %></label>
        
        <form name="form" method="POST" action="./PersonalInfo" onsubmit="return validateForm();">
            
            <h3>Geral</h3>
            <label>Nome:</label>
            <input type="text" name="generalName"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 30</label>
            <label>Nome de citação:</label>
            <input type="text" name="generalCitationName"/> 
            <label class="Small">Aceita letras, espaços e pontos. Tamanho de 2 a 30</label>
            <label>País:</label>
            <select name="generalCountry">
                <%
                List<String> countryNames = Util.getCountryNames();
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> 
            <label class="Small">Escolha uma opção</label>
            <label>CPF:</label>
            <input type="text" name="generalCpf"/> 
            <label class="Small">Exemplo: 111.222.333-44</label>
            <label>Sexo:</label>
            <select name="generalSex">
                <option value="male">Homem</option>
                <option value="female">Mulher</option>
            </select> 
            <label class="Small">Escolha uma opção</label>
            
            <h3>Identidade</h3>
            <label>Número:</label>
            <input type="text" name="idNumber"/> 
            <label class="Small">Exemplo: 123456789 ou 12345678</label>
            <label>Emissor:</label>
            <input type="text" name="idEmissioner"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 10</label>
            <label>Estado:</label>
            <select name="idState">
            <%
                List<String> stateNames = Util.getStateNames();
                for (String stateName : stateNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                }
            %>
            </select> 
            <label class="Small">Escolha uma opção</label>
            <label>Data de emissão:</label>
            <input type="text" name="idEmissionDate"/> 
            <label class="Small">Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90</label>
            
            <h3>Nascimento</h3>
            <label>País:</label>
            <select name="birthCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> 
            <label class="Small">Escolha uma opção</label>
            <label>Estado:</label>
            <select name="birthState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select> 
            <label class="Small">Escolha uma opção</label>
            <label>Cidade:</label>
            <input type="text" name="birthCity"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 40</label>
            <label>Data:</label>
            <input type="text" name="birthDate"/> 
            <label class="Small">Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90</label>
            
            <h3>Passaporte</h3>
            <label>Número:</label>
            <input type="text" name="passportNumber"/> 
            <label class="Small">Segue o modelo XXxxxxxx. Exemplo: AB123456</label>
            <label>Data de validade:</label>
            <input type="text" name="passportValidityDate"/> 
            <label class="Small">Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90</label>
            <label>Data de emissão:</label>
            <input type="text" name="passportEmissionDate"/> 
            <label class="Small">Exemplo: 25/05/1990 ou 25/5/1990 ou 25/05/90</label>
            <label>País:</label>
            <select name="passportCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> 
            <label class="Small">Escolha uma opção</label>
            
            <h3>Filiação</h3>
            <label>Pai:</label>
            <input type="text" name="filiationFatherName"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 30</label>
            <label>Mãe:</label>
            <input type="text" name="filiationMotherName"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 30</label>
            
            <h3>Endereço</h3>
            <label>Logradouro:</label>
            <input type="text" name="addressStreet"/> 
            <label class="Small">Aceita letras, espaços e números. Tamanho de 4 a 50</label>
            <label>CEP:</label>
            <input type="text" name="addressZipCode"/> 
            <label class="Small">Aceita números. Tamanho de 6 a 30</label>
            <label>Cidade:</label>
            <input type="text" name="addressCity"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 40</label>
            <label>País:</label>
            <select name="addressCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> 
            <label class="Small">Escolha uma opção</label>
            <label>Bairro:</label>
            <input type="text" name="addressDistrict"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 40</label>
            <label>Estado:</label>
            <select name="addressState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select> 
            <label class="Small">Escolha uma opção</label>
            <label>Telefone:</label>
            <input type="text" name="addressPhone"/> 
            <label class="Small">Aceita números. Tamanho de 6 a 30</label>
            
            <h3>Endereço Profissional</h3>
            <label>Empresa:</label>
            <input type="text" name="professionalAddressCompany"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 40</label>
            <label>Unidade:</label>
            <input type="text" name="professionalAddressUnit"/> 
            <label class="Small">Aceita letras, espaços e números. Tamanho de 2 a 30</label>
            <label>Rua:</label>
            <input type="text" name="professionalAddressStreet"/> 
            <label class="Small">Aceita letras, espaços e números. Tamanho de 4 a 50</label>
            <label>CEP:</label>
            <input type="text" name="professionalAddressZipCode"/> 
            <label class="Small">Aceita números. Tamanho de 6 a 30</label>
            <label>Cidade:</label>
            <input type="text" name="professionalAddressCity"/> 
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 40</label>
            <label>País:</label>
            <select name="professionalAddressCountry">
                <%
                for (String countryName : countryNames)
                {
                    out.println("<option value='#'>#</option>".replaceAll("#", countryName));
                }
                %>
            </select> 
            <label class="Small">Escolha uma opção</label>
            <label>Bairro:</label>
            <input type="text" name="professionalAddressDistrict"/>
            <label class="Small">Aceita letras e espaços. Tamanho de 2 a 40</label>
            <label>Estado:</label>
            <select name="professionalAddressState">
                <%
                    for (String stateName : stateNames)
                    {
                        out.println("<option value='#'>#</option>".replaceAll("#", stateName));
                    }
                %>
            </select> 
            <label class="Small">Escolha uma opção</label>
            <label>Telefone:</label>
            <input type="text" name="professionalAddressPhone"/> 
            <label class="Small">Aceita números. Tamanho de 6 a 30</label>
            
            <h3>Outros</h3>
            <label>Email:</label>
            <input type="text" name="miscEmail"/> 
            <label class="Small">Qualquer email válido. Exemplo: test@test.com</label>
            
            <input type="submit" value="Enviar"/>
            
        </form>
    </body>
</html>
