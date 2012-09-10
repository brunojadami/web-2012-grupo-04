package webproject.page;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webproject.validation.Validator;

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
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        
        Validator validator = new Validator();
        
        String validatorMessage = validator.validateEmail(email, "Email e senha incorretos.");
        validatorMessage = validatorMessage == null
                ? validator.validate(password, ".{6,30}", "Email e senha incorretos") : validatorMessage;
        
        RequestDispatcher dispatcher;
        if (validatorMessage == null)
        {
            dispatcher = request.getRequestDispatcher("control_panel.jsp");
            request.getSession().setAttribute("email", email);
        }
        else
        {
            dispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("message", validatorMessage);
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
