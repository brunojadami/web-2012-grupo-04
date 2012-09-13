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
 * Complementary servlet.
 */
@WebServlet(name = "Complementary", urlPatterns =
{
    "/Complementary"
})
public class Complementary extends HttpServlet
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
        String generalInstitution = (String) request.getParameter("generalInstitution");
        String generalCourse = (String) request.getParameter("generalCourse");
        String generalStatus = (String) request.getParameter("generalStatus");
	String generalTime = (String) request.getParameter("generalTime");
        String periodBegin = (String) request.getParameter("periodBegin");
        String periodEnd = (String) request.getParameter("periodEnd");
        String scholarshipPresence = (String) request.getParameter("scholarshipPresence");
        String scholarshipAgency = (String) request.getParameter("scholarshipAgency");
        
        Validator validator = new Validator();
        
        String validatorMessage = validator.validateListOption(generalLevel, Util.getComplementaryLevelNames(), "Nível inválido.");
        validatorMessage = validatorMessage == null 
                ? validator.validateListOption(generalStatus, Util.getAcademicStatusNames(), "Estado inválido.") : validatorMessage;
    
        RequestDispatcher dispatcher;
        // OBS: há uma certa 'repetição' de comandos. Isso será removido quando o 'Model' for implementado.
        if (validatorMessage == null)
        {
            dispatcher = request.getRequestDispatcher("show_operation.jsp");
            request.setAttribute("Attribute:00.Nível", generalLevel);
            request.setAttribute("Attribute:01.Instituição", generalInstitution);
            request.setAttribute("Attribute:02.Curso", generalCourse);
            request.setAttribute("Attribute:03.Estado", generalStatus);
	    request.setAttribute("Attribute:04.Carga Horária", generalTime);
            request.setAttribute("Attribute:05.Ano de Início", periodBegin);
            request.setAttribute("Attribute:06.Ano de Término", periodEnd);
            request.setAttribute("Attribute:07.Com Bolsa?", scholarshipPresence);
            request.setAttribute("Attribute:08.Agência", scholarshipAgency);
        }
        else
        {
            dispatcher = request.getRequestDispatcher("complementary.jsp");
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
