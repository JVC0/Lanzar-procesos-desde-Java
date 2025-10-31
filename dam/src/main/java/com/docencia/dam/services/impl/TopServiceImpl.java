package com.docencia.dam.services.impl;

import com.docencia.dam.services.interfaces.ComandService;

import org.springframework.stereotype.Service;

import com.docencia.dam.domain.Job;
@Service
public class TopServiceImpl extends ComandService {
    public TopServiceImpl(){
        this.setTipo(Job.TOP);
        this.setExpresionRegular("^((-b\\s+-n\\d+)|(-b)|(-n\\d+))?$");

    }
}
