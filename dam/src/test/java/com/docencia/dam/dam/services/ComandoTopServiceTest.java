package com.docencia.dam.dam.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.docencia.dam.services.impl.TopServiceImpl;

public class ComandoTopServiceTest {

    TopServiceImpl topServiceImpl;

    @BeforeEach
    void before(){
        topServiceImpl = new TopServiceImpl();
        topServiceImpl.setComando("top");
    }
    @Test
    void validarTest(){
        String [] arrayComando = {"top","-bn1"};
        boolean valida =topServiceImpl.validar(arrayComando);
        Assertions.assertTrue(valida,"Se a producido un error de validacion");
    }
    @Test
    void validarvacioTest(){
        String [] arrayComando = {"top",""};
        boolean valida =topServiceImpl.validar(arrayComando);
        Assertions.assertTrue(valida,"Se a producido un error de validacion");
    }
    @Test
    void validarvmenosTest(){
        String [] arrayComando = {"top","-3323d"};
        boolean valida =topServiceImpl.validar(arrayComando);
        Assertions.assertFalse(valida,"Se a producido un error de validacion");
    }
    @Test
    void validarComandoCorrectoTest() {
        topServiceImpl.setComando("top");
        boolean valida = topServiceImpl.validarComando();
        Assertions.assertTrue(valida, "El comando top deberia ser valido");
    }
    
    @Test
    void validarComandoIncorrectoTest() {
        topServiceImpl.setComando("ps");
        boolean valida = topServiceImpl.validarComando();
        Assertions.assertFalse(valida, "El comando ps no deberia ser valido para TopService");
    }
    
    @Test
    void validarSoloTopTest(){
        String [] arrayComando = {"top"};
        boolean valida = topServiceImpl.validar(arrayComando);
        Assertions.assertTrue(valida,"Top sin parametros deberia ser valido");
    }

}