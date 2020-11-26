/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.mintic.Ciclo2Reto5.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "Serie")
public class Serie {
    
    @Id
    @Column(name = "id_serie")
    //@OneToOne
    //@JoinColumn(name = "id_serie")
    private long id;
    
    @Column(name = "numero_temporadas")
    private int temporadas;
    
    @Column(name = "numero_episodios")
    private int episodios;

    public Serie() {}    

    public Serie(long id, int temporadas, int episodios) {
        this.id = id;
        this.temporadas = temporadas;
        this.episodios = episodios;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }  
    
    @Override
    public String toString() {
        return "Serie{" + "Id= " + id + 
                ", Temporadas= " + temporadas+
                ", Episodios= "+ episodios +"}";
    }
}
