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
        String generalName = (String) request.getParameter("generalName");
        String generalCitationName = (String) request.getParameter("generalCitationName");
        String generalCountry = (String) request.getParameter("generalCountry");
        String generalCpf = (String) request.getParameter("generalCpf");
        String generalSex = (String) request.getParameter("generalSex");
        String idNumber = (String) request.getParameter("idNumber");
        String idEmissioner = (String) request.getParameter("idEmissioner");
        String idState = (String) request.getParameter("idState");
        String idEmissionDate = (String) request.getParameter("idEmissionDate");
        String birthCountry = (String) request.getParameter("birthCountry");
        String birthState = (String) request.getParameter("birthState");
        String birthCity = (String) request.getParameter("birthCity");
        String birthDate = (String) request.getParameter("birthDate");
        String passportNumber = (String) request.getParameter("passportNumber");
        String passportValidityDate = (String) request.getParameter("passportValidityDate");
        String passportEmissionDate = (String) request.getParameter("passportEmissionDate");
        String passportCountry = (String) request.getParameter("passportCountry");
        String filiationFatherName = (String) request.getParameter("filiationFatherName");
        String filiationMotherName = (String) request.getParameter("filiationMotherName");
        String addressStreet = (String) request.getParameter("addressStreet");
        String addressZipCode = (String) request.getParameter("addressZipCode");
        String addressCity = (String) request.getParameter("addressCity");
        String addressCountry = (String) request.getParameter("addressCountry");
        String addressDistrict = (String) request.getParameter("addressDistrict");
        String addressState = (String) request.getParameter("addressState");
        String addressPhone = (String) request.getParameter("addressPhone");
        String professionalAddressCompany = (String) request.getParameter("professionalAddressCompany");
        String professionalAddressUnit = (String) request.getParameter("professionalAddressUnit");
        String professionalAddressStreet = (String) request.getParameter("professionalAddressStreet");
        String professionalAddressZipCode = (String) request.getParameter("professionalAddressZipCode");
        String professionalAddressCity = (String) request.getParameter("professionalAddressCity");
        String professionalAddressCountry = (String) request.getParameter("professionalAddressCountry");
        String professionalAddressDistrict = (String) request.getParameter("professionalAddressDistrict");
        String professionalAddressState = (String) request.getParameter("professionalAddressState");
        String professionalAddressPhone = (String) request.getParameter("professionalAddressPhone");
        String miscEmail = (String) request.getParameter("miscEmail");
        
        // Nota: a validação no servidor ainda não é feita nessa parte do trabalho.
        // A única coisa validada aqui são os combo boxes.
        Validator validator = new Validator();
        
        String validatorMessage = validator.validateCountry(generalCountry, "País inválido.");
        validatorMessage = validatorMessage == null 
                ? validator.validateSex(generalSex, "Sexo inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(idState, "Estado da identidade inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(birthCountry, "País de nascimento inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(birthState, "Estado de nascimento inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(passportCountry, "País do passaporte inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(addressCountry, "País do endereço inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(addressState, "Estado do endereço inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(professionalAddressCountry, "País do endereço profissional inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(professionalAddressState, "Estado do endereço profissional inválido.") : validatorMessage;
        
        RequestDispatcher dispatcher;
        
        // OBS: há uma certa 'repetição' de comandos. Isso será removido quando o 'Model' for implementado.
        if (validatorMessage == null)
        {
            dispatcher = request.getRequestDispatcher("show_operation.jsp");
            request.setAttribute("Attribute:00.Nome", generalName);
            request.setAttribute("Attribute:01.Nome de CItação", generalCitationName);
            request.setAttribute("Attribute:02.País", generalCountry);
            request.setAttribute("Attribute:03.CPF", generalCpf);
            request.setAttribute("Attribute:04.Sexo", generalSex);
            request.setAttribute("Attribute:05.Número", idNumber);
            request.setAttribute("Attribute:06.Emissor", idEmissioner);
            request.setAttribute("Attribute:07.Estado", idState);
            request.setAttribute("Attribute:08.Data de Emissão", idEmissionDate);
            request.setAttribute("Attribute:09.País", birthCountry);
            request.setAttribute("Attribute:10.Estado", birthState);
            request.setAttribute("Attribute:11.Cidade", birthCity);
            request.setAttribute("Attribute:12.Data de Aniversário", birthDate);
            request.setAttribute("Attribute:13.Número do Passaporte", passportNumber);
            request.setAttribute("Attribute:14.Data de Validade", passportValidityDate);
            request.setAttribute("Attribute:15.Data de Emissão", passportEmissionDate);
            request.setAttribute("Attribute:16.País", passportCountry);
            request.setAttribute("Attribute:17.Nome do Pai", filiationFatherName);
            request.setAttribute("Attribute:18.Nome da Mãe", filiationMotherName);
            request.setAttribute("Attribute:19.Logradouro", addressStreet);
            request.setAttribute("Attribute:20.CEP", addressZipCode);
            request.setAttribute("Attribute:21.Cidade", addressCity);
            request.setAttribute("Attribute:22.País", addressCountry);
            request.setAttribute("Attribute:23.Bairro", addressDistrict);
            request.setAttribute("Attribute:24.Estado", addressState);
            request.setAttribute("Attribute:25.Telefone", addressPhone);
            request.setAttribute("Attribute:26.Empresa", professionalAddressCompany);
            request.setAttribute("Attribute:27.Unidade", professionalAddressUnit);
            request.setAttribute("Attribute:28.Logradouro", professionalAddressStreet);
            request.setAttribute("Attribute:29.CEP", professionalAddressZipCode);
            request.setAttribute("Attribute:30.Cidade", professionalAddressCity);
            request.setAttribute("Attribute:31.País", professionalAddressCountry);
            request.setAttribute("Attribute:32.Bairro", professionalAddressDistrict);
            request.setAttribute("Attribute:33.Estado", professionalAddressState);
            request.setAttribute("Attribute:34.Telefone", professionalAddressPhone);
            request.setAttribute("Attribute:35.Email", miscEmail);
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
