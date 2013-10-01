/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sdb1web;


import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import com.mycompany.resource.PedidoResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.GrizzlyHttpServerFactory;
import org.glassfish.jersey.media.json.JsonJacksonModule;
import org.glassfish.jersey.server.Application;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Server {

    public static DB mongoDB;

    public static String contentUrl;

    private static final String CONTENT_PATH = "/content";

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        final int port = System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 8082;
        final URI baseUri = UriBuilder.fromUri("http://0.0.0.0/").port(port).build();

        //final Application application = Application.builder(ResourceConfig.builder().packages(ProdutoResource.class.getPackage().getName()).build()).build();
        final Application application2 = Application.builder(ResourceConfig.builder().packages(PedidoResource.class.getPackage().getName()).build()).build();
        //final Application application3 = Application.builder(ResourceConfig.builder().packages(CategoriaResource.class.getPackage().getName()).build()).build();
 

        //application.addModules(new JsonJacksonModule());
        application2.addModules(new JsonJacksonModule());
        //application3.addModules(new JsonJacksonModule());
     

        final HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, application2);
        httpServer.getServerConfiguration().addHttpHandler(new StaticHttpHandler("src/main/webapp"), CONTENT_PATH);




        for (NetworkListener networkListener : httpServer.getListeners()) {
            if (System.getenv("FILE_CACHE_ENABLED") == null) {
                networkListener.getFileCache().setEnabled(false); 
            }
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                httpServer.stop();

            }
        });

        MongoURI mongolabUri = new MongoURI(System.getenv("MONGOLAB_URI") != null ? System.getenv("MONGOLAB_URI") : "mongodb://127.0.0.1:27017/sdb1");
       

        Mongo m = new Mongo(mongolabUri);
        mongoDB = m.getDB(mongolabUri.getDatabase());
        if ((mongolabUri.getUsername() != null) && (mongolabUri.getPassword() != null)) {
            mongoDB.authenticate(mongolabUri.getUsername(), mongolabUri.getPassword());
        }

        contentUrl = System.getenv("CONTENT_URL") != null ? System.getenv("CONTENT_URL") : CONTENT_PATH;

        Thread.currentThread().join();
    }
}