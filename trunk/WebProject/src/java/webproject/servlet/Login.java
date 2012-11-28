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

/**
 * Login servlet.
 */
@WebServlet(name = "Login", urlPatterns =
{
    "/Login"
})
public class Login extends HttpServlet
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
        
        webproject.bean.Login login = new webproject.bean.Login();
        login.setEmail(request.getParameter("email"));
        login.setPassword(request.getParameter("password"));
        
        webproject.bean.Login loginCheck;
        
        RequestDispatcher dispatcher = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        if (action.equals("login"))
        {
            // Nota: assume-se que o email é único para cada usuário.
            List logins = session.createQuery("from Login login where login.email like '" + login.getEmail() + "'").list();

            loginCheck = logins.isEmpty() ? null : (webproject.bean.Login) logins.get(0);

            

            if (loginCheck == null 
                    || !login.getEmail().equals(loginCheck.getEmail())
                    || !login.getPassword().equals(loginCheck.getPassword()))
            {
                dispatcher = request.getRequestDispatcher("index.jsp");
                request.setAttribute("errorMessage", "Usuário/senha incorreto.");
            }
            else
            {
                dispatcher = request.getRequestDispatcher("control_panel.jsp"); 
                request.getSession().setAttribute("login", loginCheck);
            }
        }
        else if (action.equals("logout"))
        {
            dispatcher = request.getRequestDispatcher("index.jsp");
            request.getSession().removeAttribute("login");
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
