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
	String action = request.getParameter("action");

	RequestDispatcher dispatcher = null;

	// Nota: toda a parte de Bean, IO e suas respectivas decisões de projeto
	// estão descritas nas classes Bean.java e BeanIO.java.
	webproject.bean.Experience experience = new webproject.bean.Experience();
	experience.setId(Integer.parseInt(request.getParameter("id")));

	if (action.equals("edit"))
	{
	    dispatcher = request.getRequestDispatcher("experience.jsp");
	    request.setAttribute("bean", experience);
	}
	else if (action.equals("update"))
	{
	    experience.setProfInstitution(Bean.createField("Instituição", 0,request.getParameter("profInstitution")));
	    experience.setBondType(Bean.createField("Tipo do vínculo", 1, request.getParameter("bondType")));
	    experience.setBondEmployment(Bean.createField("Vínculo empregatício?", 2, request.getParameter("bondEmployment")));
	    experience.setBondFunctional(Bean.createField("Enquadramento funcional", 3, request.getParameter("bondFunctional")));
	    experience.setBondTime(Bean.createField("Carga horária", 4, request.getParameter("bondTime")));
	    experience.setBondExclusive(Bean.createField("Dedicação exclusiva?", 5, request.getParameter("bondExclusive")));
	    experience.setPeriodMonth(Bean.createField("Mês de início", 6, request.getParameter("periodMonth")));
	    experience.setPeriodYear(Bean.createField("Ano de início", 7, request.getParameter("periodYear")));
	    experience.setPeriodFinished(Bean.createField("Finalizado?", 8, request.getParameter("periodFinished")));
	    experience.setOtherInfo(Bean.createField("Outras informações", 9, request.getParameter("otherInfo")));

	    // Nota: a validação no servidor ainda não é feita nessa parte do trabalho.
	    // A única coisa validada aqui são os combo boxes.
	    Validator validator = new Validator();

	    String validatorMessage = validator.validateYesNoOption(Bean.getFieldValue(experience.getBondEmployment()), "Possui vínculo empregatício? inválido.");
	    validatorMessage = validatorMessage == null 
		    ? validator.validateYesNoOption(Bean.getFieldValue(experience.getBondExclusive()), "Dedicação exclusiva inválida.") : validatorMessage;
	    validatorMessage = validatorMessage == null 
		    ? validator.validateYesNoOption(Bean.getFieldValue(experience.getPeriodFinished()), "Estado do período inválido.") : validatorMessage;

	    request.setAttribute("bean", experience);
	    if (validatorMessage == null)
            {
                dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("servletName", "Experience");
                request.setAttribute("message", "Operação realizada com sucesso");

                try
                {
                    BeanIO.getInstance().save(experience);
                }
                catch (Exception ex)
                {
                    throw new ServletException(ex);
                }
            }
            else
            {
                dispatcher = request.getRequestDispatcher("experience.jsp");
                request.setAttribute("errorMessage", validatorMessage);
            }
	}
	else if (action.equals("view"))
	{
	    try
	    {
		dispatcher = request.getRequestDispatcher("show_bean.jsp");
		request.setAttribute("bean", BeanIO.getInstance().load(experience));
		request.setAttribute("message", "Visualizar atuação profissional");
		// O nome do servlet é passado para o JSP para criar possíveis ações.
		request.setAttribute("servletName", "Experience");
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
		request.setAttribute("list", BeanIO.getInstance().loadAll(experience.getClass()));
		request.setAttribute("message", "Visualizar atuações profissionais");
		// O nome do servlet é passado para o JSP para criar possíveis ações.
		request.setAttribute("servletName", "Experience");
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
