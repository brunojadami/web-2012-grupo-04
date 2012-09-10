package webproject.page;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webproject.validation.Validator;

/**
 * PersonalInfo servlet.
 */
@WebServlet(name = "PersonalInfo", urlPatterns =
{
    "/PersonalInfo"
})
public class PersonalInfo extends HttpServlet
{
    /**
     * Processa a requisição.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String generalName = (String) request.getAttribute("generalName");
        String generalCitationName = (String) request.getAttribute("generalCitationName");
        String generalCountry = (String) request.getAttribute("generalCountry");
        String generalCpf = (String) request.getAttribute("generalCpf");
        String generalSex = (String) request.getAttribute("generalSex");
        String idNumber = (String) request.getAttribute("idNumber");
        String idEmissioner = (String) request.getAttribute("idEmissioner");
        String idState = (String) request.getAttribute("idState");
        String idEmissionDate = (String) request.getAttribute("idEmissionDate");
        String birthCountry = (String) request.getAttribute("birthCountry");
        String birthState = (String) request.getAttribute("birthState");
        String birthCity = (String) request.getAttribute("birthCity");
        String birthDate = (String) request.getAttribute("birthDate");
        String passportNumber = (String) request.getAttribute("passportNumber");
        String passportValidityDate = (String) request.getAttribute("passportValidityDate");
        String passportEmissionDate = (String) request.getAttribute("passportEmissionDate");
        String passportCountry = (String) request.getAttribute("passportCountry");
        String filiationFatherName = (String) request.getAttribute("filiationFatherName");
        String filiationMotherName = (String) request.getAttribute("filiationMotherName");
        String addressStreet = (String) request.getAttribute("addressStreet");
        String addressZipCode = (String) request.getAttribute("addressZipCode");
        String addressCity = (String) request.getAttribute("addressCity");
        String addressCountry = (String) request.getAttribute("addressCountry");
        String addressDistrict = (String) request.getAttribute("addressDistrict");
        String addressState = (String) request.getAttribute("addressState");
        String addressPhone = (String) request.getAttribute("addressPhone");
        String professionalAddressCompany = (String) request.getAttribute("professionalAddressCompany");
        String professionalAddressUnit = (String) request.getAttribute("professionalAddressUnit");
        String professionalAddressStreet = (String) request.getAttribute("professionalAddressStreet");
        String professionalAddressZipCode = (String) request.getAttribute("professionalAddressZipCode");
        String professionalAddressCity = (String) request.getAttribute("professionalAddressCity");
        String professionalAddressCountry = (String) request.getAttribute("professionalAddressCountry");
        String professionalAddressDistrict = (String) request.getAttribute("professionalAddressDistrict");
        String professionalAddressState = (String) request.getAttribute("professionalAddressState");
        String professionalAddressPhone = (String) request.getAttribute("professionalAddressPhone");
        String miscEmail = (String) request.getAttribute("miscEmail");
        
        Validator validator = new Validator();
        
        String validatorMessage = validator.validate(generalName, "[a-z ]{2,30}", "Nome inválido.");
        validatorMessage = validatorMessage == null 
                ? validator.validate(generalCitationName, "[a-z. ]{2,30}", "Nome de citação inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(generalCountry, "País inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(generalCpf, "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}", "CPF inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateSex(generalSex, "Sexo inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(idNumber, "[0-9]{8,9}", "Número da identidade inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(idEmissioner, "[a-z ]{2,10}", "Emissor da identidade inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(idState, "Estado da identidade inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(idEmissionDate, "Data de emissão da identidade inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(birthCountry, "País de nascimento inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(birthState, "Estado de nascimento inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(birthCity, "[a-z ]{2,40}", "Cidade de nascimento inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(birthDate, "Data de nascimento inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(passportNumber, "[a-z]{2}[0-9]{6}", "Número do passaporte inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(passportValidityDate, "Data de validade do passaporte inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(passportEmissionDate, "Data de emissão do passaporte inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(passportCountry, "País do passaporte inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(filiationFatherName, "[a-z ]{2,30}", "Nome do pai inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(filiationMotherName, "[a-z ]{2,30}", "Nome da mãe inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(addressStreet, "[a-z0-9 ]{4,50}", "Rua do endereço inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(addressZipCode, "[0-9]{6,30}", "CEP do endereço inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(addressCity, "[a-z ]{2,40}", "Cidade do endereço inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(addressCountry, "País do endereço inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(addressDistrict, "[a-z ]{2,40}", "Bairro do endereço inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(addressState, "Estado do endereço inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(addressPhone, "[0-9]{6,30}", "Telefone do endereço inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressCompany, "[a-z ]{2,40}", "Empresa do endereço profissional inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressUnit, "[a-z0-9 ]{2,30}", "Unidade do endereço profissional inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressStreet, "[a-z0-9 ]{4,50}", "Rua do endereço profissional inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressZipCode, "[0-9]{6,30}", "CEP do endereço profissional inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressCity, "[a-z ]{2,40}", "Cidade do endereço profissional inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(professionalAddressCountry, "País do endereço profissional inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressDistrict, "[a-z ]{2,40}", "Bairro do endereço profissional inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(professionalAddressState, "Estado do endereço profissional inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressPhone, "[0-9]{6,30}", "Telefone do endereço profissional inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateEmail(miscEmail, "Email inválido.") : validatorMessage;
        
        RequestDispatcher dispatcher;
        if (validatorMessage == null)
        {
            dispatcher = request.getRequestDispatcher("show_operation.jsp");
        }
        else
        {
            dispatcher = request.getRequestDispatcher("personal_info.jsp");
            request.setAttribute("message", validatorMessage);
        }
        
        dispatcher.forward(request, response);
    }

    /**
     * Método GET.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Método POST.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }
}
