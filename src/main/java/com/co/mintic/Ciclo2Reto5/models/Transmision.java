/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.mintic.Ciclo2Reto5.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "Transmision")
public class Transmision {
    
    @EmbeddedId
    private TransmisionId transmisionId;

    public Transmision() {}   
    
    public TransmisionId getTransmisionId() {
        return transmisionId;
    }

    public void setTransmisionId(TransmisionId transmisionId) {
        this.transmisionId = transmisionId;
    }
    
    @Override
    public String toString() {
        return "{" + "Usuario= " + transmisionId.getUsuario().getUsername() + 
                ", Contenido= " + transmisionId.getContenido().getTitulo()+
                ", Fecha= " + transmisionId.getFecha() + "}";
    }
}
