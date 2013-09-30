/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import net.vz.mongodb.jackson.Id;


/**
 *
 * @author guilherme
 */

@JsonAutoDetect
public class Produto {

    @Id
    public String id;
    public String descricao;
    public float preco;
    public boolean ativo;
    public Categoria categoria;

    public Produto(String descricao) {

        this.descricao = descricao;
    }
}
