package webproject.page;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webproject.misc.Util;
import webproject.validation.Validator;

/**
 * Academic servlet.
 */
@WebServlet(name = "Academic", urlPatterns =
{
    "/Academic"
})
public class Academic extends HttpServlet
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
        String generalLevel = (String) request.getParameter("generalLevel");
        String generalType = (String) request.getParameter("generalType");
        String generalInstitute = (String) request.getParameter("generalInstitute");
        String generalCourse = (String) request.getParameter("generalCourse");
        String generalStatus = (String) request.getParameter("generalStatus");
        String periodStartDate = (String) request.getParameter("periodStartDate");
        String periodEndDate = (String) request.getParameter("periodEndDate");
        String scholarshipPresence = (String) request.getParameter("scholarshipPresence");
        String scholarshipAgency = (String) request.getParameter("scholarshipAgency");
        String miscInfo = (String) request.getParameter("miscInfo");
        
        Validator validator = new Validator();
        
        String validatorMessage = validator.validateListOption(generalLevel, Util.getAcademicLevelNames(), "Nível inválido.");
        validatorMessage = validatorMessage == null 
                ? validator.validate(generalType, "[a-z ]{5,50}", "Tipo inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(generalInstitute, "[a-z ]{2,30}", "Instituto inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(generalCourse, "[a-z ]{4,40}", "Curso inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateListOption(generalStatus, Util.getAcademicStatusNames(), "Estado inválido.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(periodStartDate, "Data de início inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(periodEndDate, "Data de término inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateYesNoOption(scholarshipPresence, "Com bolsa? inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(scholarshipAgency, "[a-z ]{2,30}", "Agência inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(miscInfo, ".{0,300}", "Informações adicionais inválidas.") : validatorMessage;
    
        RequestDispatcher dispatcher;
        if (validatorMessage == null)
        {
            dispatcher = request.getRequestDispatcher("show_operation.jsp");
        }
        else
        {
            dispatcher = request.getRequestDispatcher("academic.jsp");
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
