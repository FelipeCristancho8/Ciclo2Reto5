/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.mintic.Ciclo2Reto5.repositorios;
import com.co.mintic.Ciclo2Reto5.models.TransmisionId;
import org.springframework.data.jpa.repository.JpaRepository;
import com.co.mintic.Ciclo2Reto5.models.Transmision;
/**
 *
 * @author Felipe
 */
public interface TransmisionRepository extends JpaRepository<Transmision, TransmisionId>{
    
}
