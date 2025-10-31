package com.docencia.dam.services.impl;

import org.springframework.stereotype.Service;

import com.docencia.dam.domain.Job;
import com.docencia.dam.services.interfaces.ComandService;

@Service
public class LsofServiceImpl extends ComandService {
    public LsofServiceImpl() {
        this.setTipo(Job.LSOF);
        this.setExpresionRegular("^(-[iR])?$");
    }
}
