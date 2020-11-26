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
@Table(name = "Usuario")
public class Usuario {
    
    @Id
    private String username;
    private String nombre;
    private String apellido;
    private String email;
    private String celular;
    private String clave;
    
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    public Usuario(String username, String nombre, String apellido, String email, String celular, String clave, String fechaNacimiento) {
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario() {
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    @Override
    public String toString() {
        return "{" + "Username= " + username + 
                ", Nombre= " + nombre+
                ", Apellido= " + apellido +
                ", Email= " + email +
                ", Celular= " + celular +
                ", Clave= "+ clave +"}";
    }
}
