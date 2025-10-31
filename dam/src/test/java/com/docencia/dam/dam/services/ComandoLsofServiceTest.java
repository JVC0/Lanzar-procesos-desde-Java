package com.docencia.dam.dam.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.dam.services.impl.LsofServiceImpl;

public class ComandoLsofServiceTest {

    LsofServiceImpl lsofServiceImpl;

    @BeforeEach
    void before(){
        lsofServiceImpl = new LsofServiceImpl();
        lsofServiceImpl.setComando("lsof");
    }
    @Test
    void validarTest(){
        String [] arrayComando = {"lsof","-i"};
        boolean valida =lsofServiceImpl.validar(arrayComando);
        Assertions.assertTrue(valida,"Se a producido un error de validacion");
    }
    @Test
    void validarprocessidTest(){
        String [] arrayComando = {"lsof","-R"};
        boolean valida =lsofServiceImpl.validar(arrayComando);
        Assertions.assertTrue(valida,"Se a producido un error de validacion");
    }
    @Test
    void validarvacioTest(){
        String [] arrayComando = {"lsof",""};
        boolean valida =lsofServiceImpl.validar(arrayComando);
        Assertions.assertTrue(valida,"Se a producido un error de validacion");
    }
    @Test
    void validarfalseTest(){
        String [] arrayComando = {"lsof","apodwpd"};
        boolean valida =lsofServiceImpl.validar(arrayComando);
        Assertions.assertFalse(valida,"hola esto");
    }

}