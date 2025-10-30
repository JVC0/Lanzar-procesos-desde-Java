package com.docencia.dam.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Scanner;

import com.docencia.dam.repositories.interfaces.JobRepository;
import com.docencia.dam.services.impl.LsofServiceImpl;
import com.docencia.dam.services.impl.PsHeadServiceImpl;
import com.docencia.dam.services.impl.TopServiceImpl;

@Service
public class CliController {
    private static Logger logger = LoggerFactory.getLogger(JobRepository.class);
    @Autowired
    PsHeadServiceImpl psHeadServiceImpl;
    @Autowired
    TopServiceImpl topServiceImpl;
    @Autowired
    LsofServiceImpl lsofServiceImpl;

    public void menuConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al Lanzador de Procesos (CLI) Linux");
        System.out.println("=== Lanzador de Procesos (CLI) Linux ===\n" +
                "Comandos:\n" +
                "  lsof -i\n" +
                "  top\n" +
                "  ps aux | head \n");
        String linea = scanner.nextLine();
        if (linea.toUpperCase().startsWith("PS")) {
            psHeadServiceImpl.porcesarLinear(linea);
        } else if (linea.toUpperCase().startsWith("LSOF")) {
            topServiceImpl.porcesarLinear(linea);
        } else if (linea.toUpperCase().startsWith("TOP")) {
            lsofServiceImpl.porcesarLinear(linea);
        } else {
            logger.info("Comando no reconocido");
        }
    }
}
