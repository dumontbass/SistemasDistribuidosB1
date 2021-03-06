package facade;




import com.mongodb.Mongo;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.WriteResult;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 8/21/13
 * Time: 2:47 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractFacade<T> {

    private Mongo  mongoDB;
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass, Mongo  mongoDB) {
        this.entityClass = entityClass;
        this.mongoDB = mongoDB;
    }

    public AbstractFacade(Class<T> entityClass) {

        this.entityClass = entityClass;
        //To change body of created methods use File | Settings | File Templates.
    }

    protected AbstractFacade() {
    }

    protected abstract EntityManager getEntityManager();


    public String create(T entity) {
       
        return "";
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {

        List<T> lista = new ArrayList<T>();
        
       

    

        return lista;

    }

    public List<T> findRange(int[] range) {

        return null;
    }

    public int count() {



        return  findAll().size();
    }

}
