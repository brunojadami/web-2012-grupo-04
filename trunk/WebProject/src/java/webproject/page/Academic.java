package webproject.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webproject.validation.AcademicValidator;

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
        
        AcademicValidator validator = new AcademicValidator();
        
        String validatorMessage = validator.validateAcademicLevel(generalLevel, "");
        validatorMessage = validatorMessage == null 
                ? validator.validateAcademicLevel(generalLevel, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(generalType, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(generalInstitute, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(generalCourse, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateAcademicStatus(generalStatus, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(periodStartDate, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateDate(periodEndDate, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateYesNoOption(scholarshipPresence, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(scholarshipAgency, null, 0, 0, "") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validate(miscInfo, null, 0, 0, "") : validatorMessage;
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
