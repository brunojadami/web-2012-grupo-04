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
 * Production servlet.
 */
@WebServlet(name = "Production", urlPatterns =
{
    "/Production"
})
public class Production extends HttpServlet
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
        String completeName = (String) request.getParameter("completeName");
        String generalTitle = (String) request.getParameter("generalTitle");
        String generalLanguage = (String) request.getParameter("generalLanguage");
        String generalYear = (String) request.getParameter("generalYear");
        String detailedTitle = (String) request.getParameter("detailedTitle");
        String detailedISSN = (String) request.getParameter("detailedISSN");
        String otherInfo = (String) request.getParameter("otherInfo");
        String bookType = (String) request.getParameter("bookType");
        String bookISSN = (String) request.getParameter("bookISSN");
        String formType = (String) request.getParameter("formType");
        
        Validator validator = new Validator();
	String validatorMessage = validator.validateProductionFormType(formType, "Tipo do formulário inválido.");
    
        RequestDispatcher dispatcher;
        if (validatorMessage == null)
        {
            dispatcher = request.getRequestDispatcher("show_operation.jsp");
	    if (formType.equals("published"))
	    {
		request.setAttribute("Attribute:00.DOI, ISSN ou parte do nome do periódico", completeName);
	    }
	    else if (formType.equals("accepted"))
	    {
		request.setAttribute("Attribute:00.Título", generalTitle);
		request.setAttribute("Attribute:01.Idioma", generalLanguage);
		request.setAttribute("Attribute:02.Ano previsto para publicação", generalYear);
		request.setAttribute("Attribute:03.Título do periódico/revista em que o artigo será publicado", detailedTitle);
		request.setAttribute("Attribute:04.ISSN", detailedISSN);
		request.setAttribute("Attribute:05.Outras informações", otherInfo);
	    }
	    else if (formType.equals("book"))
	    {
		request.setAttribute("Attribute:00.Tipo de produção", bookType);
		request.setAttribute("Attribute:01.DOI ou ISSN", bookISSN);
	    }
        }
        else
        {
            dispatcher = request.getRequestDispatcher("production.jsp");
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
