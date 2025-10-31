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
