/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import net.vz.mongodb.jackson.Id;

import java.util.Date;
import java.util.List;

/**
 *
 * @author guilherme
 */
@JsonAutoDetect
public class Pedido {

    @Id
    public String id;
    public int codCliente;
    public Date horario;
    public int status;


    public List<Produto> produtos;
    
}
