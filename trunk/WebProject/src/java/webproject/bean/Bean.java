package webproject.bean;

import java.io.Serializable;
import java.util.Comparator;

/**
 * A classe bean pai. Todos os beans são filhos dela.
 */
public abstract class Bean implements Serializable
{
    public static class FieldComparator implements Comparator<String>
    {
        @Override
        public int compare(String a, String b)
        {
            return getFieldShowingOrder(a) - getFieldShowingOrder(b);
        } 
    }
    
    public static String createField(String name, int showingOrder, String value)
    {
        return name + "::" + showingOrder + ";;" + value;
    }
    
    public static String getFieldValue(String field)
    {
        return field.substring(field.indexOf(";;") + 2);
    }
    
    public static String getFieldName(String field)
    {
        return field.substring(0, field.indexOf("::"));
    }
    
    public static int getFieldShowingOrder(String field)
    {
        return Integer.parseInt(field.substring(field.indexOf("::") + 2, field.indexOf(";;")));
    }
}
