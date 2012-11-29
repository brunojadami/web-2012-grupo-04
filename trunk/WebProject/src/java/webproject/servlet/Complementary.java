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
import webproject.misc.HibernateUtil;
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
	webproject.bean.Complementary complementary = new webproject.bean.Complementary();
	complementary.setId(Integer.parseInt(request.getParameter("id")));
	complementary.setLogin((webproject.bean.Login) request.getSession().getAttribute("login"));

	if (action.equals("edit"))
	{
	    dispatcher = request.getRequestDispatcher("complementary.jsp");
	    request.setAttribute("bean", complementary);
	}
	else if (action.equals("update"))
	{
	    complementary.setGeneralLevel(request.getParameter("generalLevel"));
	    complementary.setGeneralInstitution(request.getParameter("generalInstitution"));
	    complementary.setGeneralCourse (request.getParameter("generalCourse"));
	    complementary.setGeneralStatus(request.getParameter("generalStatus"));
	    complementary.setGeneralTime(request.getParameter("generalTime"));
	    complementary.setPeriodBegin(request.getParameter("periodBegin"));
	    complementary.setPeriodEnd(request.getParameter("periodEnd"));
	    complementary.setScholarshipPresence(request.getParameter("scholarshipPresence"));
	    complementary.setScholarshipAgency(request.getParameter("scholarshipAgency"));
	    // Nota: a validação no servidor ainda não é feita nessa parte do trabalho.
	    // A única coisa validada aqui são os combo boxes.
	    Validator validator = new Validator();

	    String validatorMessage = validator.validateListOption(complementary.getGeneralLevel(), Util.getComplementaryLevelNames(), "Nível inválido.");
	    validatorMessage = validatorMessage == null
		    ? validator.validateListOption(complementary.getGeneralStatus(), Util.getAcademicStatusNames(), "Estado inválido.") : validatorMessage;
	    validatorMessage = validatorMessage == null
		    ? validator.validateYesNoOption(complementary.getScholarshipPresence(), "Com bolsa? inválido.") : validatorMessage;

	    request.setAttribute("bean", complementary);
	    if (validatorMessage == null)
            {
                dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("servletName", "Complementary");
                request.setAttribute("message", "Operação realizada com sucesso");

                Transaction transaction = session.beginTransaction();
                session.save(complementary);
                transaction.commit();
            }
            else
            {
                dispatcher = request.getRequestDispatcher("complementary.jsp");
                request.setAttribute("errorMessage", validatorMessage);
            }
	}
	else if (action.equals("view"))
	{
	    dispatcher = request.getRequestDispatcher("show_bean.jsp");
	    request.setAttribute("bean", session.load(webproject.bean.Complementary.class, complementary.getId()));
	    request.setAttribute("message", "Visualizar formação complementar");
	    // O nome do servlet é passado para o JSP para criar possíveis ações.
	    request.setAttribute("servletName", "Complementary");
	}
	else if (action.equals("delete"))
        {
            Transaction transaction = session.beginTransaction();
            session.delete(complementary);
            transaction.commit();
            
            List<webproject.bean.Complementary> complementaries = session.createQuery("from Complementary complementary where complementary.login.id = " + complementary.getLogin().getId()).list();
            dispatcher = request.getRequestDispatcher("show_beans.jsp");
            request.setAttribute("list", complementaries);
            request.setAttribute("message", "Visualizar formações complementares");
            request.setAttribute("servletName", "Complementary");
        }
	else if (action.equals("list_view"))
	{
	    List<webproject.bean.Complementary> complementaries = session.createQuery("from Complementary complementary where complementary.login.id = " + complementary.getLogin().getId()).list();
            dispatcher = request.getRequestDispatcher("show_beans.jsp");
            request.setAttribute("list", complementaries);
            request.setAttribute("message", "Visualizar formações complementares");
            request.setAttribute("servletName", "Complementary");
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
