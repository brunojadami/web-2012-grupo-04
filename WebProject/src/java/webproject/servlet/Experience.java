package webproject.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webproject.validation.Validator;

/**
 * Experience servlet.
 */
@WebServlet(name = "Experience", urlPatterns =
{
    "/Experience"
})
public class Experience extends HttpServlet
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
        String profInstitution = (String) request.getParameter("profInstitution");
        String bondType = (String) request.getParameter("bondType");
        String bondEmployment = (String) request.getParameter("bondEmployment");
        String bondFunctional = (String) request.getParameter("bondFunctional");
        String bondTime = (String) request.getParameter("bondTime");
        String bondExclusive = (String) request.getParameter("bondExclusive");
        String periodMonth = (String) request.getParameter("periodMonth");
	String periodFinished = (String) request.getParameter("periodFinished");
        String periodYear = (String) request.getParameter("periodYear");
        String otherInfo = (String) request.getParameter("otherInfo");
        
        // Nota: a validação no servidor ainda não é feita nessa parte do trabalho.
        // A única coisa validada aqui são os combo boxes.
        Validator validator = new Validator();
        
        String validatorMessage = validator.validateYesNoOption(bondEmployment, "Possui vínculo empregatício? inválido.");
	validatorMessage = validatorMessage == null 
                ? validator.validateYesNoOption(bondExclusive, "Dedicação exclusiva inválida.") : validatorMessage;
        validatorMessage = validatorMessage == null 
                ? validator.validateYesNoOption(periodFinished, "Estado do período inválido.") : validatorMessage;
    
        RequestDispatcher dispatcher;
        
        // OBS: há uma certa 'repetição' de comandos. Isso será removido quando o 'Model' for implementado.
        if (validatorMessage == null)
        {
            dispatcher = request.getRequestDispatcher("show_operation.jsp");
            request.setAttribute("Attribute:00.instituição", profInstitution);
            request.setAttribute("Attribute:01.Tipo do vínculo", bondType);
            request.setAttribute("Attribute:02.Vínculo empregatício?", bondEmployment);
            request.setAttribute("Attribute:03.Enquadramento funcional", bondFunctional);
	    request.setAttribute("Attribute:04.Carga horária", bondTime);
            request.setAttribute("Attribute:05.Dedicação exclusiva?", bondExclusive);
            request.setAttribute("Attribute:06.Mês de início", periodMonth);
	    request.setAttribute("Attribute:07.Ano de início", periodYear);
            request.setAttribute("Attribute:08.Finalizado?", periodFinished);
	    request.setAttribute("Attribute:09.Outras informações", otherInfo);
        }
        else
        {
            dispatcher = request.getRequestDispatcher("experience.jsp");
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
