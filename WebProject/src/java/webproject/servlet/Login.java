package webproject.servlet;

import java.io.IOException;
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
        webproject.bean.Login login = new webproject.bean.Login();
        // Nota: o único login criado é o de administrador, cujo id é 1.
        login.setId(1);
        login.setEmail((String) request.getParameter("email"));
        login.setPassword((String) request.getParameter("password"));
        
        webproject.bean.Login loginCheck;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        loginCheck = (webproject.bean.Login) session.get(webproject.bean.Login.class, login.getId());
        
        RequestDispatcher dispatcher;
        
        if (!login.getEmail().equals(loginCheck.getEmail())
            || !login.getPassword().equals(loginCheck.getPassword()))
        {
            dispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("errorMessage", "Usuário/senha incorreto.");
        }
        else
        {
            dispatcher = request.getRequestDispatcher("control_panel.jsp"); 
            request.getSession().setAttribute("login", login);
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
