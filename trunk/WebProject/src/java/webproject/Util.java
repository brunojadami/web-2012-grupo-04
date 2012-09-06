package webproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Util
{
    public static List<String> getStateNames()
    {
        return Arrays.asList(new String[] { 
            "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", 
            "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", 
            "SE", "SP", "TO" });
    }
    
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
}
