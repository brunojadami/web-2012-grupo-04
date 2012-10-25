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
 * Published servlet.
 */
@WebServlet(name = "Published", urlPatterns =
{
    "/Published"
})
public class Published extends HttpServlet
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
	webproject.bean.Published published = new webproject.bean.Published();
	published.setId(Integer.parseInt(request.getParameter("id")));

	if (action.equals("edit"))
	{
	    dispatcher = request.getRequestDispatcher("published.jsp");
	    request.setAttribute("bean", published);
	}
	else if (action.equals("update"))
	{
	    published.setCompleteName(Bean.createField("DOI, ISSN ou parte do nome do periódico", 0, request.getParameter("completeName")));

	    String validatorMessage = null;

	    request.setAttribute("bean", published);
	    if (validatorMessage == null)
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("servletName", "Published");
		request.setAttribute("message", "Operação realizada com sucesso");

		try
		{
		    BeanIO.getInstance().save(published);
		}
		catch (Exception ex)
		{
		    throw new ServletException(ex);
		}
	    }
	    else
	    {
		dispatcher = request.getRequestDispatcher("published.jsp");
		request.setAttribute("errorMessage", validatorMessage);
	    }
	}
	else if (action.equals("view"))
	{
	    try
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("bean", BeanIO.getInstance().load(published));
		request.setAttribute("message", "Visualizar produção bibliográfica");
		// O nome do servlet é passado para o JSP para criar possíveis ações.
		request.setAttribute("servletName", "Published");
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
		request.setAttribute("list", BeanIO.getInstance().loadAll(published.getClass()));
		request.setAttribute("message", "Visualizar produções bibliográficas");
		// O nome do servlet é passado para o JSP para criar possíveis ações.
		request.setAttribute("servletName", "Published");
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
