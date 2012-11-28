package webproject.bean;

/**
 * User é o tipo de Bean que está ligado a um login.
 */
public class User extends Bean
{
    private Login login;

    public Login getLogin()
    {
        return login;
    }

    public void setLogin(Login login)
    {
        this.login = login;
    }
}
