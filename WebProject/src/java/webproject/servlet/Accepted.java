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

	Session session = HibernateUtil.getSessionFactory().openSession();
	RequestDispatcher dispatcher = null;

	// Nota: toda a parte de Bean, IO e suas respectivas decisões de projeto
	// estão descritas nas classes Bean.java e BeanIO.java.
	webproject.bean.Accepted accepted = new webproject.bean.Accepted();
	accepted.setId(Integer.parseInt(request.getParameter("id")));
	accepted.setLogin((webproject.bean.Login) request.getSession().getAttribute("login"));

	if (action.equals("edit"))
	{
	    dispatcher = request.getRequestDispatcher("accepted.jsp");
	    request.setAttribute("bean", accepted);
	}
	else if (action.equals("update"))
	{
	    accepted.setGeneralTitle(request.getParameter("generalTitle"));
	    accepted.setGeneralLanguage(request.getParameter("generalLanguage"));
	    accepted.setGeneralYear(request.getParameter("generalYear"));
	    accepted.setDetailedTitle(request.getParameter("detailedTitle"));
	    accepted.setDetailedISSN(request.getParameter("detailedISSN"));
	    accepted.setOtherInfo(request.getParameter("otherInfo"));

	    Validator validator = new Validator();

	    String validatorMessage = validator.validateListOption(accepted.getGeneralLanguage(), Util.getLanguages(), "Idioma inválido.");

	    request.setAttribute("bean", accepted);
	    if (validatorMessage == null)
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("servletName", "Accepted");
		request.setAttribute("message", "Operação realizada com sucesso");

		Transaction transaction = session.beginTransaction();
                session.save(accepted);
                transaction.commit();
	    }
	    else
	    {
		dispatcher = request.getRequestDispatcher("accepted.jsp");
		request.setAttribute("errorMessage", validatorMessage);
	    }
	}
	else if (action.equals("view"))
	{
	    dispatcher = request.getRequestDispatcher("show_bean.jsp");
	    request.setAttribute("bean", session.load(webproject.bean.Accepted.class, accepted.getId()));
	    request.setAttribute("message", "Visualizar artigo aceito para publicação");
	    // O nome do servlet é passado para o JSP para criar possíveis ações.
	    request.setAttribute("servletName", "Accepted");
	}
	else if (action.equals("delete"))
        {
            Transaction transaction = session.beginTransaction();
            session.delete(accepted);
            transaction.commit();
            
            List<webproject.bean.Accepted> accepteds = session.createQuery("from Accepted accepted where accepted.login.id = " + accepted.getLogin().getId()).list();
            dispatcher = request.getRequestDispatcher("show_beans.jsp");
            request.setAttribute("list", accepteds);
            request.setAttribute("message", "Visualizar artigos aceitos para publicação");
            request.setAttribute("servletName", "Accepted");
        }
	else if (action.equals("list_view"))
	{
	    List<webproject.bean.Accepted> accepteds = session.createQuery("from Accepted accepted where accepted.login.id = " + accepted.getLogin().getId()).list();
            dispatcher = request.getRequestDispatcher("show_beans.jsp");
            request.setAttribute("list", accepteds);
            request.setAttribute("message", "Visualizar artigos aceitos para publicação");
            request.setAttribute("servletName", "Accepted");
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
