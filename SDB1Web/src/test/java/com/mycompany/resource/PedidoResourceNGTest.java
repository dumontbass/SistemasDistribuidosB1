/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resource;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 *
 * @author guilherme
 */
public class PedidoResourceNGTest {

   
    @Test
    public void testCreate() throws  IOException, JSONException, URISyntaxException, HttpException {



        // path
        String path = "/pedidos";

        System.out.println("Criando pedido ...");

        System.out.println("path = " + path);

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://localhost:8082/pedidos");
        //StringEntity input = new StringEntity("product");


        JSONObject json = new JSONObject();
        json.put("codCliente", 1234);

        json.put("status", 2);
        /*
        JSONObject json = new JSONObject();
        json.put("codCliente", 1234);

        JSONArray prod = new JSONArray();

        JSONObject pp = new JSONObject();
        pp.put("descricao","kjhkjhkj");

        prod.put(pp);



        json.put("produtos", prod);
        */


        StringEntity se = new StringEntity(json.toString());
        se.setContentType("application/json");
        post.setEntity(se);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Test
    public void testRead() throws IOException, URISyntaxException, HttpException {

        System.out.println("Lendo pedidos ...");

        // path
        String path = "/pedidos";

        System.out.println("path = " + path);

        assert (path.length() > 0);

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:8082/pedidos");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";

        while ((line = rd.readLine()) != null) {

            System.out.println(line);
        }

        rd.close();


    }


}