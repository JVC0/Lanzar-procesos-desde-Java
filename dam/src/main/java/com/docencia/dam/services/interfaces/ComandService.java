/**
 * Clase abstracta que define el comportamiento base para los servicios de comandos
 * 
 * Esta clase proporciona métodos para procesar líneas de comandos, validar comandos etc
 * 
 * @author JVC0
 * @version 1.0
 */
package com.docencia.dam.services.interfaces;
import java.util.regex.*;
import com.docencia.dam.domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import com.docencia.dam.repositories.interfaces.JobRepository;
import java.util.Arrays;
public abstract class ComandService {
    private String comando;
    private Job tipo;
    private String expresionRegular;

    JobRepository fileRepository;

    public JobRepository getFileRepository() {
        return fileRepository;
    }
    /*  
    * Inyección de dependencia para el repositorio de trabajos
     */
    @Autowired
    public void setFileRepository(JobRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
    /*  
    * Getters y Setters
     */
    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getComando() {
        return comando;
    }

    public void setTipo(Job tipo) {
        this.tipo = tipo;
    }

    public String getTipoToString() {
        return tipo.toString();
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expesionRegular) {
        this.expresionRegular = expesionRegular;
    }
    /*  
    * Método para procesar una línea de comando
     */
    public void porcesarLinear(String linea) {
        String[] arraycomando = linea.split("\s+");
        this.setComando(arraycomando[0]);
        System.out.println("Comando: " + getComando());
        if (arraycomando.length == 1 && arraycomando[0].equalsIgnoreCase("top")) {
            linea = linea + " -bn1";
        }
        arraycomando = linea.split("\s+");
        if (!validar(arraycomando)) {
            System.out.println("El comando es invalido");
        }
        Process proceso;
        try {
            proceso = new ProcessBuilder("sh", "-c", linea + " > mis_procesos.txt")
                    .start();
            ejecutarProceso(proceso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    * Método para ejecutar el proceso del sistema
     */
    public boolean ejecutarProceso(Process proceso) {
        try {
            proceso.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }
    /*  
    * Método para validar el comando y sus parámetros
     */
    public boolean validar(String[] arraycomando) {
        if (!validarComando()) {
            return false;
        }

        String parametros = "";
        if (arraycomando.length > 1) {
            parametros = String.join(" ", Arrays.copyOfRange(arraycomando, 1, arraycomando.length));
        }
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(parametros);

        if (!matcher.find()) {
            System.out.println("NO cumple");
            return false;
        }
        return true;
    }
    /*
    * Método para validar solo el comando principal
     */
    public boolean validarComando() {
        if (!this.getComando().toUpperCase().equals(getTipoToString())) {
            return false;
        }
        return true;
    }
}
