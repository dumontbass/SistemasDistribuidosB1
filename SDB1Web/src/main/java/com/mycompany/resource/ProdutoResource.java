/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resource;




import com.mycompany.facade.AbstractFacade;
import com.mycompany.models.Produto;
import com.mycompany.sdb1web.Server;
import net.vz.mongodb.jackson.JacksonDBCollection;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("produtos")
public class ProdutoResource extends AbstractFacade<Produto> {

    static final JacksonDBCollection<Produto, String> jacksonDB = JacksonDBCollection.wrap(Server.mongoDB.getCollection(Produto.class.getSimpleName().toLowerCase()), Produto.class, String.class);




    public ProdutoResource() {
        super(Produto.class, jacksonDB);
    }

    @Override
    protected EntityManager getEntityManager() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Produto create(Produto produto){


        Produto ret = super.create(produto);
       
       
        return ret;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> findAll() {


        List<Produto> produtos = super.findAll();

        return produtos;
    }

    @Path("readProduto")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Produto> readProduto(String id) {

        return null;
    }

    @Path("updateProduto")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void edit(Produto produto) {
   


    }


    @Path("deleteProduto")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Produto delete(Produto produto) {
        System.out.println(produto);



        return null;
    }


    @Path("countProduto")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public int countProduto() {
        //return getJacksonDBCollectionProduto().find().count();
        return 1;
    }

}






