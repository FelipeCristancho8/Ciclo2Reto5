/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.mintic.Ciclo2Reto5.repositorios;

import com.co.mintic.Ciclo2Reto5.models.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import com.co.mintic.Ciclo2Reto5.models.Pelicula;
import java.util.Optional;

/**
 *
 * @author Felipe
 */
public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
    
}
