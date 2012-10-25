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
 * Academic servlet.
 */
@WebServlet(name = "Academic", urlPatterns =
{
    "/Academic"
})
public class Academic extends HttpServlet
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
        webproject.bean.Academic academic = new webproject.bean.Academic();
        academic.setId(Integer.parseInt(request.getParameter("id")));
        
        if (action.equals("edit"))
        {
            dispatcher = request.getRequestDispatcher("academic.jsp");
            request.setAttribute("bean", academic);
        }
        else if (action.equals("update"))
        {
            academic.setGeneralLevel(Bean.createField("Nível", 0, request.getParameter("generalLevel")));
            academic.setGeneralType(Bean.createField("Tipo", 1, request.getParameter("generalType")));
            academic.setGeneralInstitute(Bean.createField("Instituto", 2, request.getParameter("generalInstitute")));
            academic.setGeneralCourse(Bean.createField("Curso", 3, request.getParameter("generalCourse")));
            academic.setGeneralStatus(Bean.createField("Estado", 4, request.getParameter("generalStatus")));
            academic.setPeriodStartDate(Bean.createField("Data de início", 5, request.getParameter("periodStartDate")));
            academic.setPeriodEndDate(Bean.createField("Data de término", 6, request.getParameter("periodEndDate")));
            academic.setScholarshipPresence(Bean.createField("Com bolsa?", 7, request.getParameter("scholarshipPresence")));
            academic.setScholarshipAgency(Bean.createField("Agência", 8, request.getParameter("scholarshipAgency")));
            academic.setMiscInfo(Bean.createField("Outros", 9, request.getParameter("miscInfo")));

            // Nota: a validação no servidor ainda não é feita nessa parte do trabalho.
            // A única coisa validada aqui são os combo boxes.
            Validator validator = new Validator();

            String validatorMessage = validator.validateListOption(Bean.getFieldValue(academic.getGeneralLevel()), Util.getAcademicLevelNames(), "Nível inválido.");
            validatorMessage = validatorMessage == null 
                    ? validator.validateListOption(Bean.getFieldValue(academic.getGeneralStatus()), Util.getAcademicStatusNames(), "Estado inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateYesNoOption(Bean.getFieldValue(academic.getScholarshipPresence()), "Com bolsa? inválida.") : validatorMessage; 

            if (validatorMessage == null)
            {
                dispatcher = request.getRequestDispatcher("show_bean.jsp");
                request.setAttribute("bean", academic);
                request.setAttribute("message", "Operação realizada com sucesso");
                request.setAttribute("servletName", "Academic");

                try
                {
                    BeanIO.getInstance().save(academic);
                }
                catch (Exception ex)
                {
                    throw new ServletException(ex);
                }
            }
            else
            {
                dispatcher = request.getRequestDispatcher("academic.jsp");
                request.setAttribute("bean", academic);
                request.setAttribute("errorMessage", validatorMessage);
            }
        }
        else if (action.equals("view"))
        {
            try
            {
                dispatcher = request.getRequestDispatcher("show_bean.jsp");
                request.setAttribute("bean", BeanIO.getInstance().load(academic));
                request.setAttribute("message", "Visualizar registro acadêmico");
                request.setAttribute("servletName", "Academic");
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
                request.setAttribute("list", BeanIO.getInstance().loadAll(academic.getClass()));
                request.setAttribute("message", "Visualizar registros acadêmicos");
                request.setAttribute("servletName", "Academic");
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
