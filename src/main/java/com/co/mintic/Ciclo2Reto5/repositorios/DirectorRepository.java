/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.mintic.Ciclo2Reto5.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.co.mintic.Ciclo2Reto5.models.Director;
import java.util.Optional;

/**
 *
 * @author Felipe
 */
@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{
    Optional<Director> findByNombreAndApellido(String nombre, String apellido);
}
