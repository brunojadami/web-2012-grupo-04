package webproject.bean;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * A classe Bean pai. Todos os beans são filhos dela. 
 * Note que todo atributo do Bean (com exceção do id) é do tipo String.
 * Isso foi feito para simplificar a codificação (e não utilizar datas, ou outras
 * estruturas).
 */
public abstract class Bean implements Serializable
{
    public static class Attribute implements Comparable<Attribute>
    {
        private String name;
        private int showingOrder;
        private String showingName;
        
        public Attribute(String name, int showingOrder, String showingName)
        {
            this.name = name;
            this.showingOrder = showingOrder;
            this.showingName = showingName;
        }

        @Override
        public int compareTo(Attribute a)
        {
            return showingOrder - a.showingOrder;
        }

        public String getShowingName()
        {
            return showingName;
        }
    }
    
    protected Map<Attribute, String> attributes;
    
    /**
     * Id do Bean. Quando vale -1, significa que o id é desconhecido. Usado quando
     * um novo Bean é criado. Assim, um id válido será atribuido a ele na operação
     * de salvar.
     */
    private int id;
    
    public Bean()
    {
        attributes = new TreeMap<Attribute, String>();
        attributes.put(new Attribute("id", 0, "ID"), "getId");
    }
    
    public Map<Attribute, String> getAttributes()
    {
        return attributes;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
