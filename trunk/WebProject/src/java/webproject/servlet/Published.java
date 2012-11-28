package webproject.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import webproject.bean.Bean;
import webproject.misc.BeanIO;
import webproject.misc.HibernateUtil;
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
	Session session = HibernateUtil.getSessionFactory().openSession();

	// Nota: toda a parte de Bean, IO e suas respectivas decisões de projeto
	// estão descritas nas classes Bean.java e BeanIO.java.
	webproject.bean.Published published = new webproject.bean.Published();
	published.setId(Integer.parseInt(request.getParameter("id")));
	published.setLogin((webproject.bean.Login) request.getSession().getAttribute("login"));

	if (action.equals("edit"))
	{
	    dispatcher = request.getRequestDispatcher("published.jsp");
	    request.setAttribute("bean", published);
	}
	else if (action.equals("update"))
	{
	    published.setCompleteName(request.getParameter("completeName"));

	    String validatorMessage = null;

	    request.setAttribute("bean", published);
	    if (validatorMessage == null)
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("servletName", "Published");
		request.setAttribute("message", "Operação realizada com sucesso");

		Transaction transaction = session.beginTransaction();
		session.save(published);
		transaction.commit();
	    }
	    else
	    {
		dispatcher = request.getRequestDispatcher("published.jsp");
		request.setAttribute("errorMessage", validatorMessage);
	    }
	}
	else if (action.equals("view"))
	{
	    dispatcher = request.getRequestDispatcher("show_bean.jsp");
	    request.setAttribute("bean", session.load(webproject.bean.Published.class, published.getId()));
	    request.setAttribute("message", "Visualizar produção bibliográfica");
	    // O nome do servlet é passado para o JSP para criar possíveis ações.
	    request.setAttribute("servletName", "Published");
	}
	else if (action.equals("delete"))
	{
	    Transaction transaction = session.beginTransaction();
	    session.delete(published);
	    transaction.commit();

	    List<webproject.bean.Published> publisheds = session.createQuery("from Published pub where pub.login.id = " + published.getLogin().getId()).list();
	    dispatcher = request.getRequestDispatcher("show_beans.jsp");
	    request.setAttribute("list", publisheds);
	    request.setAttribute("message", "Visualizar produções bibliográficas");
	    request.setAttribute("servletName", "Published");
	}
	else if (action.equals("list_view"))
	{
	    List<webproject.bean.Published> publisheds = session.createQuery("from Published pub where pub.login.id = " + published.getLogin().getId()).list();
	    dispatcher = request.getRequestDispatcher("show_beans.jsp");
	    request.setAttribute("list", publisheds);
	    request.setAttribute("message", "Visualizar produções bibliográficas");
	    request.setAttribute("servletName", "Published");
	}

	dispatcher.forward(request, response);
	session.close();
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
