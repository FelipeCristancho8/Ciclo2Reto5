package com.co.mintic.Ciclo2Reto5;

import com.co.mintic.Ciclo2Reto5.vista.PruebaVista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ciclo2Reto5Application {

	public static void main(String[] args) {
		new PruebaVista().setVisible(true);
	}
        
        public static void runSpringServer(String[] args) {
            /*
            ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class)
                    .headless(false).run(args);
            */
            SpringApplication.run(Ciclo2Reto5Application.class, args);
        }
}
