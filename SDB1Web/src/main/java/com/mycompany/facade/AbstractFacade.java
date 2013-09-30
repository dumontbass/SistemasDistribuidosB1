/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;


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

    private JacksonDBCollection<T,String> jacksonDB;
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass, JacksonDBCollection<T, String> jacksonDB) {
        this.entityClass = entityClass;
        this.jacksonDB = jacksonDB;
    }

    public AbstractFacade(Class<T> entityClass) {

        this.entityClass = entityClass;
        //To change body of created methods use File | Settings | File Templates.
    }

    protected AbstractFacade() {
    }

    protected abstract EntityManager getEntityManager();


    public T create(T entity) {
        WriteResult<? extends Object, String> result = jacksonDB.insert(entity);
        return (T) result.getSavedObject();
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
        DBCursor<T> cursor =  jacksonDB.find();

        while(cursor.hasNext()){
            lista.add(cursor.next());
        }


        return lista;

    }

    public List<T> findRange(int[] range) {

        return null;
    }

    public int count() {



        return  findAll().size();
    }


}

