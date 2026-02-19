package com.calabozo.mapa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot del proyecto Calabozo.
 * 
 * @SpringBootApplication es una anotación que combina tres anotaciones:
 *                        - @Configuration: Marca la clase como fuente de
 *                        definiciones de beans
 *                        - @EnableAutoConfiguration: Habilita la configuración
 *                        automática de Spring Boot
 *                        - @ComponentScan: Permite a Spring buscar otros
 *                        componentes y configuraciones
 * 
 *                        Este es el punto de entrada principal de nuestra
 *                        aplicación web de gestión de mazmorras.
 */
@SpringBootApplication
public class MapaApplication {

	/**
	 * Método principal que inicia la aplicación Spring Boot.
	 * 
	 * @param args Argumentos de línea de comandos (no utilizados en esta
	 *             aplicación)
	 * 
	 *             SpringApplication.run() hace lo siguiente:
	 *             1. Configura la aplicación según el classpath
	 *             2. Inicia un servidor web embebido (Tomcat por defecto)
	 *             3. Escanea y registra todos los componentes de Spring
	 *             (@Controller, @Service, etc.)
	 *             4. Inicializa la base de datos y otros recursos necesarios
	 */
	public static void main(String[] args) {
		SpringApplication.run(MapaApplication.class, args);
	}

}
