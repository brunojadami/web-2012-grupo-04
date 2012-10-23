package webproject.bean;

import java.io.Serializable;
import java.util.Comparator;

/**
 * A classe Bean pai. Todos os beans são filhos dela. Toda a parte de IO
 * foi abstraída para a classe BeanIO. Portanto o Bean é só um modelo "burro".
 * Note que todo atributo do Bean (com exceção do id) é do tipo String e segue
 * a regra "<nome>::<ordem de exibição>;;<valor>". Esse padrão foi criado para
 * facilitar a codificação do projeto. Além disso, essa abordagem não afeta a
 * performance nem fere os princípios MVC.
 */
public abstract class Bean implements Serializable
{
    /**
     * Classe que compara os campos do Bean. Usada na ordenação para exibição.
     */
    public static class FieldComparator implements Comparator<String>
    {
        @Override
        public int compare(String a, String b)
        {
            return getFieldShowingOrder(a) - getFieldShowingOrder(b);
        } 
    }
    
    /**
     * Cria o atributo do Bean.
     * @param name Nome do atributo.
     * @param showingOrder Ordem de exibição.
     * @param value Valor do atributo.
     * @return A String que representa o atributo.
     */
    public static String createField(String name, int showingOrder, String value)
    {
        return name + "::" + showingOrder + ";;" + value;
    }
    
    /**
     * @param field Atributo.
     * @return O valor do atributo.
     */
    public static String getFieldValue(String field)
    {
        return field.substring(field.indexOf(";;") + 2);
    }
    
    /**
     * @param field Atributo.
     * @return O nome do atributo.
     */
    public static String getFieldName(String field)
    {
        return field.substring(0, field.indexOf("::"));
    }
    
    /**
     * @param field Atributo.
     * @return A ordem de exibição do atributo.
     */
    public static int getFieldShowingOrder(String field)
    {
        return Integer.parseInt(field.substring(field.indexOf("::") + 2, field.indexOf(";;")));
    }
    
    /**
     * Id do Bean. Quando vale -1, significa que o id é desconhecido. Usado quando
     * um novo Bean é criado. Assim, um id válido será atribuido a ele na operação
     * de salvar.
     */
    private int id;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
