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

	// Nota: toda a parte de Bean, IO e suas respectivas decisões de projeto
	// estão descritas nas classes Bean.java e BeanIO.java.
	webproject.bean.Complementary complementary = new webproject.bean.Complementary();
	complementary.setId(Integer.parseInt(request.getParameter("id")));

	if (action.equals("edit"))
	{
	    dispatcher = request.getRequestDispatcher("complementary.jsp");
	    request.setAttribute("bean", complementary);
	}
	else if (action.equals("update"))
	{
	    complementary.setGeneralLevel(Bean.createField("Nível", 0, request.getParameter("generalLevel")));
	    complementary.setGeneralInstitution(Bean.createField("Instituição", 1, request.getParameter("generalInstitution")));
	    complementary.setGeneralCourse (Bean.createField("Curso", 2, request.getParameter("generalCourse")));
	    complementary.setGeneralStatus(Bean.createField("Estado", 3, request.getParameter("generalStatus")));
	    complementary.setGeneralTime(Bean.createField("Carga horária", 4, request.getParameter("generalTime")));
	    complementary.setPeriodBegin(Bean.createField("Ano de início", 5, request.getParameter("periodBegin")));
	    complementary.setPeriodEnd(Bean.createField("Ano de término", 6, request.getParameter("periodEnd")));
	    complementary.setScholarshipPresence(Bean.createField("Com bolsa?", 7, request.getParameter("scholarshipPresence")));
	    complementary.setScholarshipAgency(Bean.createField("Agência", 8, request.getParameter("scholarshipAgency")));
	    // Nota: a validação no servidor ainda não é feita nessa parte do trabalho.
	    // A única coisa validada aqui são os combo boxes.
	    Validator validator = new Validator();

	    String validatorMessage = validator.validateListOption(Bean.getFieldValue(complementary.getGeneralLevel()), Util.getComplementaryLevelNames(), "Nível inválido.");
	    validatorMessage = validatorMessage == null
		    ? validator.validateListOption(Bean.getFieldValue(complementary.getGeneralStatus()), Util.getAcademicStatusNames(), "Estado inválido.") : validatorMessage;
	    validatorMessage = validatorMessage == null
		    ? validator.validateYesNoOption(Bean.getFieldValue(complementary.getScholarshipPresence()), "Com bolsa? inválido.") : validatorMessage;

	    request.setAttribute("bean", complementary);
	    if (validatorMessage == null)
            {
                dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("servletName", "Complementary");
                request.setAttribute("message", "Operação realizada com sucesso");

                try
                {
                    BeanIO.getInstance().save(complementary);
                }
                catch (Exception ex)
                {
                    throw new ServletException(ex);
                }
            }
            else
            {
                dispatcher = request.getRequestDispatcher("complementary.jsp");
                request.setAttribute("errorMessage", validatorMessage);
            }
	}
	else if (action.equals("view"))
	{
	    try
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("bean", BeanIO.getInstance().load(complementary));
		request.setAttribute("message", "Visualizar formação complementar");
		// O nome do servlet é passado para o JSP para criar possíveis ações.
		request.setAttribute("servletName", "Complementary");
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
		request.setAttribute("list", BeanIO.getInstance().loadAll(complementary.getClass()));
		request.setAttribute("message", "Visualizar formações complementares");
		// O nome do servlet é passado para o JSP para criar possíveis ações.
		request.setAttribute("servletName", "Complementary");
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
