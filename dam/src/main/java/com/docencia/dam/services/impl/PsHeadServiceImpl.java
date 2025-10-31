/**
 * Servicio para ejecutar y procesar el comando 'ps aux | head'
 * 
 * Esta clase hereda de ComandService y define el comportamiento específico para el comando 'ps'
 * 
 * @author JVC0
 * @version 1.0
 */
package com.docencia.dam.services.impl;
import org.springframework.stereotype.Service;
import com.docencia.dam.domain.Job;
import com.docencia.dam.services.interfaces.ComandService;
@Service
public class PsHeadServiceImpl extends ComandService {
    public PsHeadServiceImpl() {
        this.setTipo(Job.PS);
        this.setExpresionRegular("^\\s*(-?(aux|xa|a)(\\s*\\|\\s*head)?)?\\s*$");
    }
}
