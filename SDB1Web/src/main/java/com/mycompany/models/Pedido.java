/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.ObjectId;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author guilherme
 */
@JsonAutoDetect
public class Pedido {



    @Id
    public String id;
    public String codCliente;
    public String horario;
    public String status;


    //public List<Produto> produtos;

    @ObjectId
    @JsonProperty("_id")
    public String getId() {
        return id;
    }
    @ObjectId
    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }
    
}
