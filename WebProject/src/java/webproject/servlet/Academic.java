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
import webproject.misc.HibernateUtil;
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        webproject.bean.Academic academic = new webproject.bean.Academic();
        academic.setId(Integer.parseInt(request.getParameter("id")));
        
        if (action.equals("edit"))
        {
            dispatcher = request.getRequestDispatcher("academic.jsp");
            request.setAttribute("bean", academic);
        }
        else if (action.equals("update"))
        {
            academic.setGeneralLevel(request.getParameter("generalLevel"));
            academic.setGeneralType(request.getParameter("generalType"));
            academic.setGeneralInstitute(request.getParameter("generalInstitute"));
            academic.setGeneralCourse(request.getParameter("generalCourse"));
            academic.setGeneralStatus(request.getParameter("generalStatus"));
            academic.setPeriodStartDate(request.getParameter("periodStartDate"));
            academic.setPeriodEndDate(request.getParameter("periodEndDate"));
            academic.setScholarshipPresence(request.getParameter("scholarshipPresence"));
            academic.setScholarshipAgency(request.getParameter("scholarshipAgency"));
            academic.setMiscInfo(request.getParameter("miscInfo"));

            Validator validator = new Validator();

            String validatorMessage = validator.validateListOption(academic.getGeneralLevel(), Util.getAcademicLevelNames(), "Nível inválido.");
            validatorMessage = validatorMessage == null 
                    ? validator.validateListOption(academic.getGeneralStatus(), Util.getAcademicStatusNames(), "Estado inválido.") : validatorMessage;
            validatorMessage = validatorMessage == null 
                    ? validator.validateYesNoOption(academic.getScholarshipPresence(), "Com bolsa? inválida.") : validatorMessage; 

            if (validatorMessage == null)
            {
                dispatcher = request.getRequestDispatcher("show_bean.jsp");
                request.setAttribute("bean", academic);
                request.setAttribute("message", "Operação realizada com sucesso");
                request.setAttribute("servletName", "Academic");

                session.save(academic);
                session.close();
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
            dispatcher = request.getRequestDispatcher("show_bean.jsp");
            request.setAttribute("bean", session.load(webproject.bean.Academic.class, academic.getId()));
            request.setAttribute("message", "Visualizar registro acadêmico");
            request.setAttribute("servletName", "Academic");
        }
        else if (action.equals("list_view"))
        {
            List<webproject.bean.Academic> academics = session.createQuery("from Academic").list();
            session.close();
            
            dispatcher = request.getRequestDispatcher("show_beans.jsp");
            request.setAttribute("list", academics);
            request.setAttribute("message", "Visualizar registros acadêmicos");
            request.setAttribute("servletName", "Academic");
        }
        
        dispatcher.forward(request, response);
        session.close();
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
