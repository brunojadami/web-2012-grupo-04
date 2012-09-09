package webproject.page;

import java.io.IOException;
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
        
        String validatorMessage = validator.validate(generalName, null, 0, 0, "");
        validatorMessage = validatorMessage == null 
                ? validator.validate(generalCitationName, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(generalCountry, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(generalCpf, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateSex(generalSex, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(idNumber, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(idEmissioner, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(idState, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(idEmissionDate, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(birthCountry, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(birthState, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(birthCity, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(birthDate, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(passportNumber, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(passportValidityDate, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(passportEmissionDate, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(passportCountry, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(filiationFatherName, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(filiationMotherName, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(addressStreet, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(addressZipCode, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(addressCity, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(addressCountry, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(addressDistrict, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(addressState, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(addressPhone, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressCompany, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressUnit, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressStreet, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressZipCode, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressCity, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateCountry(professionalAddressCountry, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressDistrict, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateState(professionalAddressState, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(professionalAddressPhone, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateEmail(miscEmail, "") : validatorMessage;
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
