/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.mintic.Ciclo2Reto5.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "director")
public class Director {
    
    @Id
    @Column(name = "dir_id")
    private long id;
    
    @Column(name = "dir_nombre")
    private String nombre;
    
    @Column(name = "dir_apellido")
    private String apellido;
    
    @Column(name = "dir_nacionalidad")
    private String nacionalidad;

    public Director() {}    

    public Director(long id, String nombre, String apellido, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    @Override
    public String toString() {
        return "Director{" + "Id= " + id + 
                ", Nombre= " + nombre+
                ", Apellido= " + apellido + 
                ", Nacionalidad= " + nacionalidad + "}";
    }
}
