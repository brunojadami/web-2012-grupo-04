package webproject.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import webproject.bean.Bean;

/**
 * Classe que cuida de toda parte de IO dos Beans.
 */
public class BeanIO
{
    /**
     * Diretório que armazena os Beans. 
     * OBS: os Beans serão salvos na pasta bin do Tomcat.
     */
    private static final String DATA_PATH = "data/";
    
    /**
     * O BeanIO é global, algo análogo ao ImageIO do Java.
     */
    private static BeanIO beanIO = new BeanIO();
    
    public static BeanIO getInstance()
    {
        return beanIO;
    }
    
    /**
     * Construtor privado!
     */
    private BeanIO()
    {

    }
    
    /**
     * @param bean Bean a ser salvo.
     * @throws Exception 
     */
    public void save(Bean bean) throws Exception
    {
        File folder = getBeanFolder(bean);
        
        // Verifica se o id do Bean é desconhecido. Caso verdade, atribui um id a ele.
        if (bean.getId() == -1)
        {
            bean.setId(folder.listFiles().length);
        }
        
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(
                folder.toString() + getBeanFileName(bean)));
        stream.writeObject(bean);
        stream.close();
    }
    
    /**
     * @param beanClass Classe do Bean.
     * @return Uma lista com todos os Beans salvos do mesmo tipo passado ao método.
     * @throws Exception 
     */
    public List<Bean> loadAll(Class beanClass) throws Exception
    {
        List<Bean> beans = new LinkedList<Bean>();
        
        File folder = getBeanFolder((Bean) beanClass.newInstance());
        
        for (int id = 0; id < folder.listFiles().length; ++id)
        {
            Bean bean = (Bean) beanClass.newInstance();
            bean.setId(id);
            beans.add(load(bean));
        }
        
        return beans;
    }
    
    /**
     * Carrega o Bean.
     * @param bean Bean a ser carregado. O id do objeto será usado para carregá-lo.
     * @return O Bean carregado. Note que não é o mesmo objeto passado por parâmetro!
     * @throws Exception 
     */
    public Bean load(Bean bean) throws Exception
    {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(
                getBeanFolder(bean).toString() + getBeanFileName(bean)));
        bean = (Bean) stream.readObject();
        stream.close();
        
        return bean;
    }
    
    /**
     * @param bean Bean.
     * @return O diretório de armazenamento do Bean.
     */
    private File getBeanFolder(Bean bean)
    {
        String path = DATA_PATH + bean.getClass().getName().replaceAll("[.]", "/");
        File folder = new File(path);
        folder.mkdirs();
        return folder;
    }
    
    /**
     * @param bean O Bean.
     * @return O nome do arquivo que contém os dados do Bean.
     */
    private String getBeanFileName(Bean bean)
    {
        return "/" + bean.getId() + ".data";
    }
}
