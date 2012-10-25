package webproject.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webproject.bean.Bean;
import webproject.misc.BeanIO;
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
        String action = request.getParameter("action");
        
        RequestDispatcher dispatcher = null;
        
        // Nota: toda a parte de Bean, IO e suas respectivas decisões de projeto
        // estão descritas nas classes Bean.java e BeanIO.java.
        webproject.bean.PersonalInfo personalInfo = new webproject.bean.PersonalInfo();
        personalInfo.setId(Integer.parseInt(request.getParameter("id")));
        
        if (action.equals("edit"))
        {
            dispatcher = request.getRequestDispatcher("personal_info.jsp");
            request.setAttribute("bean", personalInfo);
        }
        else if (action.equals("update"))
        {
            personalInfo.setGeneralName(Bean.createField("Nome", 0, (String) request.getParameter("generalName")));
            personalInfo.setGeneralCitationName(Bean.createField("Nome de citação", 1, (String) request.getParameter("generalCitationName")));
            personalInfo.setGeneralCountry(Bean.createField("País", 2, (String) request.getParameter("generalCountry")));
            personalInfo.setGeneralCpf(Bean.createField("CPF", 3, (String) request.getParameter("generalCpf")));
            personalInfo.setGeneralSex(Bean.createField("Sexo", 4, (String) request.getParameter("generalSex")));
            personalInfo.setIdNumber(Bean.createField("Número", 5, (String) request.getParameter("idNumber")));
            personalInfo.setIdEmissioner(Bean.createField("Emissor", 6, (String) request.getParameter("idEmissioner")));
            personalInfo.setIdState(Bean.createField("Estado", 7, (String) request.getParameter("idState")));
            personalInfo.setIdEmissionDate(Bean.createField("Data de emissão", 8, (String) request.getParameter("idEmissionDate")));
            personalInfo.setBirthCountry(Bean.createField("País", 9, (String) request.getParameter("birthCountry")));
            personalInfo.setBirthState(Bean.createField("Estado", 10, (String) request.getParameter("birthState")));
            personalInfo.setBirthCity(Bean.createField("Cidade", 11, (String) request.getParameter("birthCity")));
            personalInfo.setBirthDate(Bean.createField("Data de aniversário", 12, (String) request.getParameter("birthDate")));
            personalInfo.setPassportNumber(Bean.createField("Passaporte", 13, (String) request.getParameter("passportNumber")));
            personalInfo.setPassportValidityDate(Bean.createField("Data de validade", 14, (String) request.getParameter("passportValidityDate")));
            personalInfo.setPassportEmissionDate(Bean.createField("Data de emissão", 15, (String) request.getParameter("passportEmissionDate")));
            personalInfo.setPassportCountry(Bean.createField("País", 16, (String) request.getParameter("passportCountry")));
            personalInfo.setFiliationFatherName(Bean.createField("Nome do pai", 17, (String) request.getParameter("filiationFatherName")));
            personalInfo.setFiliationMotherName(Bean.createField("Nome da mãe", 18, (String) request.getParameter("filiationMotherName")));
            personalInfo.setAddressStreet(Bean.createField("Logradouro", 19, (String) request.getParameter("addressStreet")));
            personalInfo.setAddressZipCode(Bean.createField("CEP", 20, (String) request.getParameter("addressZipCode")));
            personalInfo.setAddressCity(Bean.createField("Cidade", 21, (String) request.getParameter("addressCity")));
            personalInfo.setAddressCountry(Bean.createField("País", 22, (String) request.getParameter("addressCountry")));
            personalInfo.setAddressDistrict(Bean.createField("Bairro", 23, (String) request.getParameter("addressDistrict")));
            personalInfo.setAddressState(Bean.createField("Estado", 24, (String) request.getParameter("addressState")));
            personalInfo.setAddressPhone(Bean.createField("Telefone", 25, (String) request.getParameter("addressPhone")));
            personalInfo.setProfessionalAddressCompany(Bean.createField("Empresa", 26, (String) request.getParameter("professionalAddressCompany")));
            personalInfo.setProfessionalAddressUnit(Bean.createField("Unidade", 27, (String) request.getParameter("professionalAddressUnit")));
            personalInfo.setProfessionalAddressStreet(Bean.createField("Logradouro", 28, (String) request.getParameter("professionalAddressStreet")));
            personalInfo.setProfessionalAddressZipCode(Bean.createField("CEP", 29, (String) request.getParameter("professionalAddressZipCode")));
            personalInfo.setProfessionalAddressCity(Bean.createField("Cidade", 30, (String) request.getParameter("professionalAddressCity")));
            personalInfo.setProfessionalAddressCountry(Bean.createField("País", 31, (String) request.getParameter("professionalAddressCountry")));
            personalInfo.setProfessionalAddressDistrict(Bean.createField("Bairro", 32, (String) request.getParameter("professionalAddressDistrict")));
            personalInfo.setProfessionalAddressState(Bean.createField("Estado", 33, (String) request.getParameter("professionalAddressState")));
            personalInfo.setProfessionalAddressPhone(Bean.createField("Telefone", 34, (String) request.getParameter("professionalAddressPhone")));
            personalInfo.setMiscEmail(Bean.createField("Email", 35, (String) request.getParameter("miscEmail")));

            // Nota: a validação no servidor ainda não é feita nessa parte do trabalho.
            // A única coisa validada aqui são os combo boxes.
            Validator validator = new Validator();

            String validatorMessage = validator.validateCountry(Bean.getFieldValue(personalInfo.getGeneralCountry()), "País inválido.");
            validatorMessage = validatorMessage == null 
                    ? validator.validateSex(Bean.getFieldValue(personalInfo.getGeneralSex()), "Sexo inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateState(Bean.getFieldValue(personalInfo.getIdState()), "Estado da identidade inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateCountry(Bean.getFieldValue(personalInfo.getBirthCountry()), "País de nascimento inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateState(Bean.getFieldValue(personalInfo.getBirthState()), "Estado de nascimento inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateCountry(Bean.getFieldValue(personalInfo.getPassportCountry()), "País do passaporte inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateCountry(Bean.getFieldValue(personalInfo.getAddressCountry()), "País do endereço inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateState(Bean.getFieldValue(personalInfo.getAddressState()), "Estado do endereço inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateCountry(Bean.getFieldValue(personalInfo.getProfessionalAddressCountry()), "País do endereço profissional inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateState(Bean.getFieldValue(personalInfo.getProfessionalAddressState()), "Estado do endereço profissional inválido.") : validatorMessage;

            if (validatorMessage == null)
            {
                dispatcher = request.getRequestDispatcher("show_bean.jsp");
                request.setAttribute("bean", personalInfo);
                request.setAttribute("message", "Informações atualizadas com sucesso");
                request.setAttribute("servletName", "PersonalInfo");

                try
                {
                    BeanIO.getInstance().save(personalInfo);
                }
                catch (Exception ex)
                {
                    throw new ServletException(ex);
                }
            }
            else
            {
                dispatcher = request.getRequestDispatcher("personal_info.jsp");
                request.setAttribute("bean", personalInfo);
                request.setAttribute("errorMessage", validatorMessage);
            }
        }
        else if (action.equals("view"))
        {
            try
            {
                dispatcher = request.getRequestDispatcher("show_bean.jsp");
                request.setAttribute("bean", BeanIO.getInstance().load(personalInfo));
                request.setAttribute("message", "Visualizar informações pessoais");
                request.setAttribute("servletName", "PersonalInfo");
            }
            catch (Exception ex)
            {
                throw new ServletException(ex);
            }
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
