/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resource;




import com.mycompany.facade.AbstractFacade;
import com.mycompany.models.Categoria;
import com.mycompany.sdb1web.Server;
import net.vz.mongodb.jackson.JacksonDBCollection;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("categorias")
public class CategoriaResource extends AbstractFacade<Categoria> {

    static final JacksonDBCollection<Categoria, String> jacksonDB = JacksonDBCollection.wrap(Server.mongoDB.getCollection(Categoria.class.getSimpleName().toLowerCase()), Categoria.class, String.class);




    public CategoriaResource() {
        super(Categoria.class, jacksonDB);
    }

    @Override
    protected EntityManager getEntityManager() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Categoria create(Categoria categoria){


        Categoria ret = super.create(categoria);
       
       
        return ret;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> findAll() {


        List<Categoria> categorias = super.findAll();

        return categorias;
    }

    @Path("readCategoria")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Categoria> readCategoria(String id) {

        return null;
    }

    @Path("updateCategoria")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void edit(Categoria categoria) {
   


    }


    @Path("deleteCategoria")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria delete(Categoria categoria) {
        System.out.println(categoria);



        return null;
    }


    @Path("countCategoria")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public int countCategoria() {
        //return getJacksonDBCollectionCategoria().find().count();
        return 1;
    }

}






