package webproject.page;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        login.setEmail((String) request.getParameter("email"));
        login.setPassword((String) request.getParameter("password"));
        
        // Nota: a validação no servidor ainda não é feita nessa parte do trabalho.
        // A única coisa validada aqui são os combo boxes.
        RequestDispatcher dispatcher = request.getRequestDispatcher("control_panel.jsp");
        
        request.getSession().setAttribute("login", login);
        
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
