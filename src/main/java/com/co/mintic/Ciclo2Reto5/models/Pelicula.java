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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Pelicula")
public class Pelicula{
    
    @Id
    @Column(name = "id_pelicula")
    //@OneToOne
    //@JoinColumn(name = "id_pelicula")
    private long id;    
    
    private String resumen;    
    
    private int anio;
    
    @ManyToOne
    @JoinColumn(name = "dir_id")
    private Director director;

    public Pelicula(long id, String resumen, int anio, Director director) {
        this.id = id;
        this.resumen = resumen;
        this.anio = anio;
        this.director = director;
    }

    public Pelicula() {
    }   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }    
    
    @Override
    public String toString() {
        return "Pelicula{" + "Id= " + id + 
                ", Resumen= " + resumen+
                ", Año= " + anio +
                ", Director= "+ director.getNombre() +"}";
    }
}
