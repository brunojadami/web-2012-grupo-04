package webproject;

/**
 * Validador.
 */
public class Validator
{
    /**
     * Tamanho máximo do email.
     */
    private static final int EMAIL_MAX_LENGTH = 50;
    
    /**
     * Tamanho mínimo do email.
     */
    private static final int EMAIL_MIN_LENGTH = 5;
    
    /**
     * Tamanho máximo da senha.
     */
    private static final int PASSWORD_MAX_LENGTH = 30;
    
    /**
     * Tamanho mínimo da senha.
     */
    private static final int PASSWORD_MIN_LENGTH = 6;
    
    /**
     * @param email Email a ser validado.
     * @return True se o email é válido.
     */
    public boolean validateEmail(String email)
    {
        return email.length() >= EMAIL_MIN_LENGTH && email.length() <= EMAIL_MAX_LENGTH
                && email.matches(".*\\@.*\\..{2,4}");
    }
    
    /**
     * @param password Senha a ser validada.
     * @return True se a senha é válida.
     */
    public boolean validatePassword(String password)
    {
        return password.length() >= PASSWORD_MIN_LENGTH && password.length() <= PASSWORD_MAX_LENGTH;
    }
}
