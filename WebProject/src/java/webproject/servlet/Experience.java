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
	webproject.bean.Experience experience = new webproject.bean.Experience();
	experience.setId(Integer.parseInt(request.getParameter("id")));
	experience.setLogin((webproject.bean.Login) request.getSession().getAttribute("login"));

	if (action.equals("edit"))
	{
	    dispatcher = request.getRequestDispatcher("experience.jsp");
	    request.setAttribute("bean", experience);
	}
	else if (action.equals("update"))
	{
	    experience.setProfInstitution(request.getParameter("profInstitution"));
	    experience.setBondType(request.getParameter("bondType"));
	    experience.setBondEmployment(request.getParameter("bondEmployment"));
	    experience.setBondFunctional(request.getParameter("bondFunctional"));
	    experience.setBondTime(request.getParameter("bondTime"));
	    experience.setBondExclusive(request.getParameter("bondExclusive"));
	    experience.setPeriodMonth(request.getParameter("periodMonth"));
	    experience.setPeriodYear(request.getParameter("periodYear"));
	    experience.setPeriodFinished(request.getParameter("periodFinished"));
	    experience.setOtherInfo(request.getParameter("otherInfo"));

	    // Nota: a validação no servidor ainda não é feita nessa parte do trabalho.
	    // A única coisa validada aqui são os combo boxes.
	    Validator validator = new Validator();

	    String validatorMessage = validator.validateYesNoOption(experience.getBondEmployment(), "Possui vínculo empregatício? inválido.");
	    validatorMessage = validatorMessage == null
		    ? validator.validateYesNoOption(experience.getBondExclusive(), "Dedicação exclusiva inválida.") : validatorMessage;
	    validatorMessage = validatorMessage == null
		    ? validator.validateYesNoOption(experience.getPeriodFinished(), "Estado do período inválido.") : validatorMessage;

	    request.setAttribute("bean", experience);
	    if (validatorMessage == null)
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("servletName", "Experience");
		request.setAttribute("message", "Operação realizada com sucesso");

		Transaction transaction = session.beginTransaction();
                session.save(experience);
                transaction.commit();
	    }
	    else
	    {
		dispatcher = request.getRequestDispatcher("experience.jsp");
		request.setAttribute("errorMessage", validatorMessage);
	    }
	}
	else if (action.equals("view"))
	{
	    dispatcher = request.getRequestDispatcher("show_bean.jsp");
	    request.setAttribute("bean", session.load(webproject.bean.Experience.class, experience.getId()));
	    request.setAttribute("message", "Visualizar atuação profissional");
	    // O nome do servlet é passado para o JSP para criar possíveis ações.
	    request.setAttribute("servletName", "Experience");
	}
	else if (action.equals("delete"))
        {
            Transaction transaction = session.beginTransaction();
            session.delete(experience);
            transaction.commit();
            
            List<webproject.bean.Experience> experiences = session.createQuery("from Experience exp where exp.login.id = " + experience.getLogin().getId()).list();
            dispatcher = request.getRequestDispatcher("show_beans.jsp");
            request.setAttribute("list", experiences);
            request.setAttribute("message", "Visualizar atuações profissionais");
            request.setAttribute("servletName", "Experience");
        }
	else if (action.equals("list_view"))
	{
	    List<webproject.bean.Experience> experiences = session.createQuery("from Experience exp where exp.login.id = " + experience.getLogin().getId()).list();
            dispatcher = request.getRequestDispatcher("show_beans.jsp");
            request.setAttribute("list", experiences);
            request.setAttribute("message", "Visualizar atuações profissionais");
            request.setAttribute("servletName", "Experience");
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
