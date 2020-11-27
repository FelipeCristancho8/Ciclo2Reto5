/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.mintic.Ciclo2Reto5;


import com.co.mintic.Ciclo2Reto5.models.Contenido;
import com.co.mintic.Ciclo2Reto5.models.Director;
import com.co.mintic.Ciclo2Reto5.models.Pelicula;
import com.co.mintic.Ciclo2Reto5.models.Serie;
import com.co.mintic.Ciclo2Reto5.models.Transmision;
import com.co.mintic.Ciclo2Reto5.models.Usuario;
import com.co.mintic.Ciclo2Reto5.repositorios.ContenidoRepository;
import com.co.mintic.Ciclo2Reto5.repositorios.DirectorRepository;
import com.co.mintic.Ciclo2Reto5.repositorios.PeliculaRepository;
import com.co.mintic.Ciclo2Reto5.repositorios.SerieRepository;
import com.co.mintic.Ciclo2Reto5.repositorios.TransmisionRepository;
import com.co.mintic.Ciclo2Reto5.repositorios.UsuarioRepository;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Optional;
import org.springframework.lang.NonNull;

/**
 *
 * @author joag
 */
@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private DirectorRepository directorRepository;
    
    @Autowired
    private ContenidoRepository contenidoRepository;
    
    @Autowired
    private PeliculaRepository peliculaRepository;
    
    @Autowired
    private SerieRepository serieRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private TransmisionRepository transmisionRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Logger logger = LoggerFactory.getLogger(MyRunner.class);
        
        imprimirDirectores();
        logger.error("*****************************************************");
        List<Contenido> contenidos = contenidoRepository.findAll();
        
        for(Contenido contenido : contenidos){
            logger.info("Contenido: {}", contenido);
        }
        
        logger.error("*****************************************************");
        List<Pelicula> peliculas = peliculaRepository.findAll();
        
        for(Pelicula pelicula : peliculas){
            logger.info("Pelicula: {}", pelicula);
        }
        
        logger.error("*****************************************************");
        List<Serie> series = serieRepository.findAll();
        
        for(Serie serie : series){
            logger.info("Serie: {}", serie);
        }
        
        logger.error("*****************************************************");
        List<Usuario> usuarios = usuarioRepository.findAll();
        
        for(Usuario usuario : usuarios){
            logger.info("Usuario: {}", usuario);
        }
        
        logger.error("*****************************************************");
        List<Transmision> transmisiones = transmisionRepository.findAll();
        
        for(Transmision transmision : transmisiones){
            logger.info("Transmision: {}", transmision);
        }
        logger.error("*****************************************************");
        //crearUsuario("Sparrow", "Johnny", "Depp");
        logger.error("*****************************************************");
        //crearPelicula("Guasón", "Pelicula de suspenso basada en el personaje de DC Comics Joker que se remonta a los orígenes del personaje con profundo análisis social.", 2019, "Todd","Phillips");
        //crearSerie("DARK", 3, 26);
        buscarSerie("DARK");
        logger.error("*****************************************************");
        eliminarPelicula("Los Vengadores");
        logger.error("*****************************************************");
        //Editar el usuario Johnny Depp cambiar el nombre a Jack Sparrow
        editarUsuario("Johnny", "Depp", "Jack", "Sparrow");
    }
    
    //punto 1 y 8   
    private void crearUsuario(String username,String nombre, String apellido){
        if(!buscarUsername(username)){
            Usuario usuario = new Usuario(username, nombre, apellido, "", "", "", "1997-08-08");
            usuarioRepository.save(usuario);
            System.out.println("Se registró exitosamente el usuario "+ username);
        }else{
            System.out.println("Lo sentimos el usuario no se encuentra disponible");
        }            
    }
    
    // punto 2
    private void crearPelicula(String titulo, String resumen, int anio, String nombreDirector,String apellidoDirector){
        crearContenido(titulo); 
        long idContenido = buscarPorTitulo(titulo);
        Director director = buscarDirector(nombreDirector, apellidoDirector);
        Pelicula pelicula = new Pelicula(idContenido, resumen, anio, director);
        peliculaRepository.save(pelicula);
    }
    
    //punto 3
    private void crearSerie(String titulo, int temporadas, int episodios){
        crearContenido(titulo);
        long idContenido = buscarPorTitulo(titulo);
        Serie serie = new Serie(idContenido, temporadas, episodios);
        serieRepository.save(serie);
    }
    
    //punto 4 y 5
    private void buscarSerie(String titulo){
        Contenido contenido = buscarContenido(titulo);
        if(contenido != null){
            Optional<Serie> serie = serieRepository.findById(contenido.getId());
            if (serie.isPresent()) {
                System.out.println("Serie disponible: "+titulo+" consta de "+serie.get().getEpisodios()+" episodios en "+
                                   serie.get().getTemporadas()+" temporadas");
                return;
                }
        }
        System.out.println("La serie que busca no fue encontrada");        
    }
    
    //punto 6
    private void eliminarPelicula(String titulo){
        Contenido contenido = buscarContenido(titulo);
        if(contenido != null){
            Optional<Pelicula> pelicula = peliculaRepository.findById(contenido.getId());
            if (pelicula.isPresent()) {
                peliculaRepository.deleteById(pelicula.get().getId());
                contenidoRepository.deleteById(contenido.getId());
                System.out.println("Se eliminó exitosamente la pelicula "+ titulo);
            }
        }
    }
    
    // punto 7
    private void editarUsuario(String nombreBuscado, String apellidoBuscado,String nNombre, String nApellido){
        Optional<Usuario> usuario = usuarioRepository.findByNombreAndApellido(nombreBuscado, apellidoBuscado);
        System.out.println("--------"+ usuario.get().getUsername());
        if (usuario.isPresent()) {
            usuario.get().setNombre(nNombre);
            usuario.get().setApellido(nApellido);
            usuarioRepository.save(usuario.get());
            System.out.println("Se actualizó correctamente el usuario "+usuario.get().getUsername());
        }
    }
    
    private Contenido buscarContenido(String titulo){
        Optional<Contenido> contenido = contenidoRepository.findByTitulo(titulo);
        if(contenido.isPresent())
            return contenido.get();
        return null;
    }
    private void crearContenido(String titulo){
        Contenido contenido = new Contenido(titulo);
        contenidoRepository.save(contenido);
    }
    
    private long buscarPorTitulo(String titulo){
        Optional<Contenido> contenido = contenidoRepository.findByTitulo(titulo);
        if(contenido.isPresent())
            return contenido.get().getId();
        return -1;
    }
    
    private Director buscarDirector(String nombre, String apellido){
        Optional<Director> director = directorRepository.findByNombreAndApellido(nombre, apellido);
        if(director.isPresent()){
            return director.get();
        }
        return null;
    }
    
    private boolean buscarUsername(String username){
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        return (usuario.isPresent());       
    }
    
    private void imprimirDirectores(){
        List<Director> directores = directorRepository.findAll();        
        for(Director director : directores){
            logger.info("Director: {}", director);
        }
    }    
}
