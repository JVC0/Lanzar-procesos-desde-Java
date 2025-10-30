package com.docencia.dam.services.interfaces;

import java.util.regex.*;
import com.docencia.dam.domain.Job;
import org.springframework.beans.factory.annotation.Autowired;
import com.docencia.dam.repositories.interfaces.JobRepository;

public abstract class ComandService {
    private String comando;
    private Job tipo;
    private String expresionRegular;

    JobRepository fileRepository;

    public JobRepository getFileRepository() {
        return fileRepository;
    }

    @Autowired
    public void setFileRepository(JobRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

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

    public void porcesarLinear(String linea) {
        String[] arraycomando = linea.split("\s+");
        this.setComando(arraycomando[0]);
        System.out.println("Comando: " + getComando());
        if (!validar(arraycomando)) {
            System.out.println("El comando es invalido");
        }
        Process proceso;
        // linea =ps aux | grep java
        try {
            proceso = new ProcessBuilder("sh", "-c", linea + " > mis_procesos.txt")
                    .start();
            ejecutarProceso(proceso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean ejecutarProceso(Process proceso) {
        try {
            proceso.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public boolean validar(String[] arraycomando) {
        if (!validarComando()) {
            return false;
        }
        String parametro = arraycomando[1];
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(parametro);
        if (!matcher.find()) {
            System.out.println("NO cumple");
            return false;
        }
        return true;
    }

    public boolean validarComando() {
        if (!this.getComando().toUpperCase().equals(getTipoToString())) {
            return false;
        }
        return true;
    }
}
