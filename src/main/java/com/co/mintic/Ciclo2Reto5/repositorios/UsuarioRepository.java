/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.mintic.Ciclo2Reto5.repositorios;

import com.co.mintic.Ciclo2Reto5.models.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Felipe
 */
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByNombreAndApellido(String nombre, String apellido);
}
