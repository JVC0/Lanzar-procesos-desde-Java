/**
 * Servicio para ejecutar y procesar el comando 'top'
 * 
 * Esta clase hereda de ComandService y define el comportamiento específico para el comando 'top'
 * 
 * @author JVC0
 * @version 1.0
 */
package com.docencia.dam.services.impl;
import com.docencia.dam.services.interfaces.ComandService;
import org.springframework.stereotype.Service;
import com.docencia.dam.domain.Job;
@Service
public class TopServiceImpl extends ComandService {
    public TopServiceImpl(){
        this.setTipo(Job.TOP);
        this.setExpresionRegular("^(-bn1)?$");
    }
}