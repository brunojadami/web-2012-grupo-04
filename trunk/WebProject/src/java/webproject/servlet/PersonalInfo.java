package webproject.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import webproject.bean.Bean;
import webproject.misc.HibernateUtil;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        webproject.bean.PersonalInfo personalInfo = new webproject.bean.PersonalInfo();
        // Para cada usuário, há um único 'personalInfo'. Por isso, o id é sempre igual ao
        // loginId. Deviamos ter feito uma PK-FK única. Mas estava dando alguns problemas
        // e não deu tempo de solucionar o erro :)
        personalInfo.setId(Integer.parseInt(request.getParameter("id")));
        personalInfo.setLogin((webproject.bean.Login) request.getSession().getAttribute("login"));
        
        if (action.equals("edit"))
        {
            dispatcher = request.getRequestDispatcher("personal_info.jsp");
            request.setAttribute("bean", personalInfo);
        }
        else if (action.equals("update"))
        {
            personalInfo.setGeneralName(request.getParameter("generalName"));
            personalInfo.setGeneralCitationName(request.getParameter("generalCitationName"));
            personalInfo.setGeneralCountry(request.getParameter("generalCountry"));
            personalInfo.setGeneralCpf(request.getParameter("generalCpf"));
            personalInfo.setGeneralSex(request.getParameter("generalSex"));
            personalInfo.setIdNumber(request.getParameter("idNumber"));
            personalInfo.setIdEmissioner(request.getParameter("idEmissioner"));
            personalInfo.setIdState(request.getParameter("idState"));
            personalInfo.setIdEmissionDate(request.getParameter("idEmissionDate"));
            personalInfo.setBirthCountry(request.getParameter("birthCountry"));
            personalInfo.setBirthState(request.getParameter("birthState"));
            personalInfo.setBirthCity(request.getParameter("birthCity"));
            personalInfo.setBirthDate(request.getParameter("birthDate"));
            personalInfo.setPassportNumber(request.getParameter("passportNumber"));
            personalInfo.setPassportValidityDate(request.getParameter("passportValidityDate"));
            personalInfo.setPassportEmissionDate(request.getParameter("passportEmissionDate"));
            personalInfo.setPassportCountry(request.getParameter("passportCountry"));
            personalInfo.setFiliationFatherName(request.getParameter("filiationFatherName"));
            personalInfo.setFiliationMotherName(request.getParameter("filiationMotherName"));
            personalInfo.setAddressStreet(request.getParameter("addressStreet"));
            personalInfo.setAddressZipCode(request.getParameter("addressZipCode"));
            personalInfo.setAddressCity(request.getParameter("addressCity"));
            personalInfo.setAddressCountry(request.getParameter("addressCountry"));
            personalInfo.setAddressDistrict(request.getParameter("addressDistrict"));
            personalInfo.setAddressState(request.getParameter("addressState"));
            personalInfo.setAddressPhone(request.getParameter("addressPhone"));
            personalInfo.setProfessionalAddressCompany(request.getParameter("professionalAddressCompany"));
            personalInfo.setProfessionalAddressUnit(request.getParameter("professionalAddressUnit"));
            personalInfo.setProfessionalAddressStreet(request.getParameter("professionalAddressStreet"));
            personalInfo.setProfessionalAddressZipCode(request.getParameter("professionalAddressZipCode"));
            personalInfo.setProfessionalAddressCity(request.getParameter("professionalAddressCity"));
            personalInfo.setProfessionalAddressCountry(request.getParameter("professionalAddressCountry"));
            personalInfo.setProfessionalAddressDistrict(request.getParameter("professionalAddressDistrict"));
            personalInfo.setProfessionalAddressState(request.getParameter("professionalAddressState"));
            personalInfo.setProfessionalAddressPhone(request.getParameter("professionalAddressPhone"));
            personalInfo.setMiscEmail(request.getParameter("miscEmail"));

            Validator validator = new Validator();

            String validatorMessage = validator.validateCountry(personalInfo.getGeneralCountry(), "País inválido.");
            validatorMessage = validatorMessage == null 
                    ? validator.validateSex(personalInfo.getGeneralSex(), "Sexo inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateState(personalInfo.getIdState(), "Estado da identidade inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateCountry(personalInfo.getBirthCountry(), "País de nascimento inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateState(personalInfo.getBirthState(), "Estado de nascimento inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateCountry(personalInfo.getPassportCountry(), "País do passaporte inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateCountry(personalInfo.getAddressCountry(), "País do endereço inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateState(personalInfo.getAddressState(), "Estado do endereço inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateCountry(personalInfo.getProfessionalAddressCountry(), "País do endereço profissional inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateState(personalInfo.getProfessionalAddressState(), "Estado do endereço profissional inválido.") : validatorMessage;

            if (validatorMessage == null)
            {
                dispatcher = request.getRequestDispatcher("show_bean.jsp");
                request.setAttribute("bean", personalInfo);
                request.setAttribute("message", "Informações atualizadas com sucesso");
                request.setAttribute("servletName", "PersonalInfo");

                Transaction transaction = session.beginTransaction();
                session.save(personalInfo);
                transaction.commit();
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
            Bean bean = (Bean) session.get(webproject.bean.PersonalInfo.class, personalInfo.getId());
            if (bean != null)
            {
                dispatcher = request.getRequestDispatcher("show_bean.jsp");
                request.setAttribute("bean", bean);
                request.setAttribute("message", "Visualizar informações pessoais");
                request.setAttribute("servletName", "PersonalInfo");
            }
            else
            {
                // Nenhuma informação pessoal foi gravada ainda.
                dispatcher = request.getRequestDispatcher("control_panel.jsp");
            }
        }
        
        dispatcher.forward(request, response);
        session.close();
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
