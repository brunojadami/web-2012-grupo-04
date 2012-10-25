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
import webproject.misc.Util;
import webproject.validation.Validator;

/**
 * Accepted servlet.
 */
@WebServlet(name = "Accepted", urlPatterns =
{
    "/Accepted"
})
public class Accepted extends HttpServlet
{

    /**
     * Processa a requisição.
     *
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
	webproject.bean.Accepted accepted = new webproject.bean.Accepted();
	accepted.setId(Integer.parseInt(request.getParameter("id")));

	if (action.equals("edit"))
	{
	    dispatcher = request.getRequestDispatcher("accepted.jsp");
	    request.setAttribute("bean", accepted);
	}
	else if (action.equals("update"))
	{
	    accepted.setGeneralTitle(Bean.createField("Título", 0, request.getParameter("generalTitle")));
	    accepted.setGeneralLanguage(Bean.createField("Idioma", 1, request.getParameter("generalLanguage")));
	    accepted.setGeneralYear(Bean.createField("Ano previsto para publicação", 2, request.getParameter("generalYear")));
	    accepted.setDetailedTitle(Bean.createField("Título do periódico/revista em que o artigo será publicado", 3, request.getParameter("detailedTitle")));
	    accepted.setDetailedISSN(Bean.createField("ISSN", 4, request.getParameter("detailedISSN")));
	    accepted.setOtherInfo(Bean.createField("Outras informações", 5, request.getParameter("otherInfo")));

	    Validator validator = new Validator();

	    String validatorMessage = validator.validateListOption(Bean.getFieldValue(accepted.getGeneralLanguage()), Util.getLanguages(), "Idioma inválido.");

	    request.setAttribute("bean", accepted);
	    if (validatorMessage == null)
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("servletName", "Accepted");
		request.setAttribute("message", "Operação realizada com sucesso");

		try
		{
		    BeanIO.getInstance().save(accepted);
		}
		catch (Exception ex)
		{
		    throw new ServletException(ex);
		}
	    }
	    else
	    {
		dispatcher = request.getRequestDispatcher("accepted.jsp");
		request.setAttribute("errorMessage", validatorMessage);
	    }
	}
	else if (action.equals("view"))
	{
	    try
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("bean", BeanIO.getInstance().load(accepted));
		request.setAttribute("message", "Visualizar artigo aceito para publicação");
		// O nome do servlet é passado para o JSP para criar possíveis ações.
		request.setAttribute("servletName", "Accepted");
	    }
	    catch (Exception ex)
	    {
		throw new ServletException(ex);
	    }
	}
	else if (action.equals("list_view"))
	{
	    try
	    {
		dispatcher = request.getRequestDispatcher("show_beans.jsp");
		request.setAttribute("list", BeanIO.getInstance().loadAll(accepted.getClass()));
		request.setAttribute("message", "Visualizar artigos aceitos para publicação");
		// O nome do servlet é passado para o JSP para criar possíveis ações.
		request.setAttribute("servletName", "Accepted");
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
     *
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
     *
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
