package webproject.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Classe útil.
 */
public class Util
{
    /**
     * @return Uma lista com os tipos de estados de um curso acadêmico.
     */
    public static List<String> getAcademicStatusNames()
    {
        return Arrays.asList(new String[] { 
            "Completo", "Em Andamento", "Incompleto"});
    }
    
    /**
     * @return Uma lista com os níveis acadêmicos.
     */
    public static List<String> getAcademicLevelNames()
    {
        return Arrays.asList(new String[] { 
            "Aperfeiçoamento", "Primeiro Grau", "Segundo Grau", "Ensino Técnico",
            "Graduação", "Especialização", "Mestrado Profissionalizante", "Mestrado",
            "Doutorado"});
    }
    
    /**
     * @return Uma lista com os níveis de formação complementares.
     */
    public static List<String> getComplementaryLevelNames()
    {
        return Arrays.asList(new String[] { 
            "Curso De Curta Duração", "Extensão Universitária", "MBA", "Outros"});
    }
    
    /**
     * @return Uma lista com os estados brasileiros.
     */
    public static List<String> getStateNames()
    {
        return Arrays.asList(new String[] { 
            "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", 
            "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", 
            "SE", "SP", "TO" });
    }
    
    /**
     * @return Uma lista com os países.
     */
    public static List<String> getCountryNames()
    {
        Set<String> countryNames = new HashSet<String>();
        
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales)
        {
            String name = locale.getDisplayCountry();

            if (!name.isEmpty())
            {
                countryNames.add(name);
            }
        }
        
        List<String> countryNames_ = 
                new ArrayList<String>(Arrays.asList(countryNames.toArray(new String[0])));
        Collections.sort(countryNames_);
        
        return countryNames_;
    }
    
    /**
     * @return Uma lista com os idiomas disponíveis.
     */
    public static List<String> getLanguages()
    {
        return Arrays.asList(new String[] { 
            "Português"});
    }
}
