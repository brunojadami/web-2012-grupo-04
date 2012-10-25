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
 * Book servlet.
 */
@WebServlet(name = "Book", urlPatterns =
{
    "/Book"
})
public class Book extends HttpServlet
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
	webproject.bean.Book book = new webproject.bean.Book();
	book.setId(Integer.parseInt(request.getParameter("id")));

	if (action.equals("edit"))
	{
	    dispatcher = request.getRequestDispatcher("book.jsp");
	    request.setAttribute("bean", book);
	}
	else if (action.equals("update"))
	{
	    book.setBookType(Bean.createField("Tipo de produção", 0, request.getParameter("bookType")));
	    book.setBookISSN(Bean.createField("DOI ou ISSN", 1, request.getParameter("bookISSN")));

	    Validator validator = new Validator();
	    String validatorMessage = validator.validateListOption(Bean.getFieldValue(book.getBookType()), Util.getProductionTypes(), "Tipo de produção inválido.");

	    request.setAttribute("bean", book);
	    if (validatorMessage == null)
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("servletName", "Book");
		request.setAttribute("message", "Operação realizada com sucesso");

		try
		{
		    BeanIO.getInstance().save(book);
		}
		catch (Exception ex)
		{
		    throw new ServletException(ex);
		}
	    }
	    else
	    {
		dispatcher = request.getRequestDispatcher("book.jsp");
		request.setAttribute("errorMessage", validatorMessage);
	    }
	}
	else if (action.equals("view"))
	{
	    try
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("bean", BeanIO.getInstance().load(book));
		request.setAttribute("message", "Visualizar produção bibliográfica");
		// O nome do servlet é passado para o JSP para criar possíveis ações.
		request.setAttribute("servletName", "Book");
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
		request.setAttribute("list", BeanIO.getInstance().loadAll(book.getClass()));
		request.setAttribute("message", "Visualizar produções bibliográficas");
		// O nome do servlet é passado para o JSP para criar possíveis ações.
		request.setAttribute("servletName", "Book");
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
