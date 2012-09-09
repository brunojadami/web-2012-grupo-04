package webproject.validation;

import java.util.List;

/**
 * Validador.
 */
public class Validator
{  
    /**
     * @param string String a validar.
     * @param regex Regex para checar. Se nulo, não será checado.
     * @param minLength Tamanho mínimo.
     * @param maxLength Tamanho máximo.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validate(String string, String regex, int minLength, int maxLength, 
            String errorMessage)
    {
        boolean result = string != null;
        
        if (regex != null)
        {
            result = result && string.matches(regex);
        }
        
        result = result && string.length() >= minLength && string.length() <= maxLength;
        
        return result ? null : errorMessage;
    }
    
    public String validateListOption(String string, List<String> list, String errorMessage)
    {
        return list.contains(string) ? null : errorMessage;
    }
    
    /**
     * @param date Data a ser validada.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validateDate(String date, String errorMessage)
    {
        return null;
    }
    
    /**
     * @param yesNo Opção sim/não.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validateYesNoOption(String yesNo, String errorMessage)
    {
        return null;
    }
    
    /**
     * @param email Email.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validateEmail(String email, String errorMessage)
    {
        return validate(email, ".*\\@.*\\..{2,4}", 
                Size.EMAIL.getMinLength(), Size.EMAIL.getMaxLength(), errorMessage);
    }
    
    public String validateState(String state, String errorMessage)
    {
        return null;
    }
    
    public String validateCountry(String country, String errorMessage)
    {
        return null;
    }
    
    public String validateSex(String sex, String errorMessage)
    {
        return null;
    }
}
