/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resource;


import com.mycompany.facade.AbstractFacade;
import com.mycompany.models.Pedido;
import com.mycompany.sdb1web.Server;
import net.vz.mongodb.jackson.JacksonDBCollection;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("pedidos")
public class PedidoResource extends AbstractFacade<Pedido> {

    static final JacksonDBCollection<Pedido, String> jacksonDB = JacksonDBCollection.wrap(Server.mongoDB.getCollection(Pedido.class.getSimpleName().toLowerCase()), Pedido.class, String.class);


    public PedidoResource() {
        super(Pedido.class, jacksonDB);
    }

    @Override
    protected EntityManager getEntityManager() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Pedido create(Pedido pedido) {


        //pedido.horario = new Date();

        super.create(pedido);


        return pedido;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> findAll() {


        List<Pedido> pedidos = super.findAll();

        return pedidos;
    }

    @Path("readPedido")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Pedido> readPedido(String id) {

        return null;
    }

    @Path("updatePedido")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void edit(Pedido pedido) {


    }


    @Path("deletePedido")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido delete(Pedido pedido) {

        System.out.println(pedido);


        return pedido;
    }


    @Path("countPedido")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public int countPedido() {
        //return getJacksonDBCollectionPedido().find().count();
        return 1;
    }

}






