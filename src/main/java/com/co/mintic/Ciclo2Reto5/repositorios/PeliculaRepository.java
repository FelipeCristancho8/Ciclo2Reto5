/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.mintic.Ciclo2Reto5.repositorios;

import com.co.mintic.Ciclo2Reto5.models.Contenido;
import com.co.mintic.Ciclo2Reto5.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import com.co.mintic.Ciclo2Reto5.models.Pelicula;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Felipe
 */
public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
    
    Optional<List<Pelicula>> findByAnio(int anio);
    Optional<List<Pelicula>> findByDirector(Director director);
    
    @Transactional
    Optional<List<Pelicula>> deleteByAnio(int anio);
    
    @Transactional
    Optional<List<Pelicula>> deleteByDirector(Director director);
}
