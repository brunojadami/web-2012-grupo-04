package webproject.managedbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;
import webproject.bean.Login;
import webproject.misc.HibernateUtil;

/**
 * Managed bean do Login.
 */
@ManagedBean(name="loginManager")
@SessionScoped
public class LoginManager
{
    private List<Login> logins;
    
    public LoginManager()
    {
        retrieveLogins();
    }

    public List<Login> getLogins()
    {
        return logins;
    }
    
    public String updateLogin(int id, boolean enabled)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        Login login = (Login) session.get(Login.class, id);
        login.setEnabled(enabled);
        
        transaction.commit();
        session.close();
        
        retrieveLogins();
        
        return "ok";
    }
    
    public String deleteLogin(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        Login login = (Login) session.get(Login.class, id);
        session.delete(login);
        
        transaction.commit();
        session.close();
        
        retrieveLogins();
        
        return "ok";
    }
    
    private void retrieveLogins()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        logins = session.createQuery("from Login login order by login.id").list();
        session.close();
    }
}
