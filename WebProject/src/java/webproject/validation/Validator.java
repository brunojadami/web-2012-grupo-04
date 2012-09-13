package webproject.validation;

import java.util.List;
import webproject.misc.Util;

/**
 * Validador.
 */
public class Validator
{  
    /**
     * @param string String a validar.
     * @param regex Regex para checar. Se nulo, não será checado.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validate(String string, String regex, String errorMessage)
    {
        boolean result = string != null;
        
        if (regex != null)
        {
            result = result && string.toLowerCase().matches(regex);
        }
        
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
        return date.toString().matches("^[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{2,4}")
                ? null : errorMessage;
    }
    
    /**
     * @param yesNo Opção sim/não.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validateYesNoOption(String yesNo, String errorMessage)
    {
        return yesNo.toLowerCase().matches("yes|no")
                ? null : errorMessage;
    }
    
    /**
     * @param email Email.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validateEmail(String email, String errorMessage)
    {
        return validate(email, "^.*\\@.*\\..{2,4}$", errorMessage);
    }
    
    /**
     * @param state Estado.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validateState(String state, String errorMessage)
    {
        return Util.getStateNames().contains(state)
                ? null : errorMessage;
    }
    
    /**
     * @param country País.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validateCountry(String country, String errorMessage)
    {
        return Util.getCountryNames().contains(country)
                ? null : errorMessage;
    }
    
    /**
     * @param sex Sexo.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validateSex(String sex, String errorMessage)
    {
        return sex.toLowerCase().matches("male|female")
                ? null : errorMessage;
    }

    /**
     * 
     * @param formType A string do tipo do form a ser validado.
     * @param errorMessage Mensagem de erro.
     * @return Nulo se sucesso, a mensagem de erro caso erro.
     */
    public String validateProductionFormType(String formType, String errorMessage)
    {
	return (formType.equals("published") || formType.equals("accepted") || formType.equals("book"))
		? null : errorMessage;
    }
}
